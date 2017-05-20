package com.example.jon.aula;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.zip.Inflater;

public class RelatorioActivity extends AppCompatActivity {

    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        calendarView =(CalendarView) findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                PontoDAO pontoDAO = new PontoDAO(RelatorioActivity.this);
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,dayOfMonth);
                List<Ponto> pontos = pontoDAO.getPontosByDate(new Date(calendar.getTimeInMillis()));
                showDialog(pontos);
            }
        });
    }


    private void showDialog(List<Ponto> pontos){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.relatorio_dialog, null);

        ListView list =(ListView) view.findViewById(R.id.list_item);
        list.setAdapter(new ArrayAdapter<Ponto>(RelatorioActivity.this,
                                                    android.R.layout.simple_list_item_1,
                                                    pontos));

        AlertDialog.Builder builder = new AlertDialog.Builder(RelatorioActivity.this);
        builder.setTitle(R.string.relatorio);
        builder.setView(view);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}
