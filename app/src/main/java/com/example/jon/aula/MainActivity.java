package com.example.jon.aula;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity{

    private Button btnBaterPonto;
    private TextView txtPonto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPonto = (TextView)findViewById(R.id.textView);
        btnBaterPonto = (Button)findViewById(R.id.button);
        btnBaterPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                Ponto ponto = new Ponto(
                        Ponto.ENTRADA,
                        new Date(calendar.getTimeInMillis()),
                        new Time(calendar.getTimeInMillis())
                    );
                txtPonto.setText(ponto.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflate = getMenuInflater();
        menuInflate.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_relatorio:
                Intent intent = new Intent(MainActivity.this, RelatorioActivity.class);
                startActivity(intent);
                break;
            default:
              return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
