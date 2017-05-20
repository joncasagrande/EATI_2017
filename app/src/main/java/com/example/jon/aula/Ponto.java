package com.example.jon.aula;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 * Created by jon on 17/05/17.
 */

public class Ponto {

    public static final int ENTRADA = 0;
    public static final int SAIDA = 1;
    private int id;
    private int acao;
    private Date dia;
    private Time hora;

    public Ponto() {
    }

    public Ponto(int acao, Date dia, Time hora) {
        this.acao = acao;
        this.dia = dia;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    public void setHora(long hora){
        if(this.hora == null){
            this.hora = new Time(hora);
        }else{
            this.hora.setTime(hora);
        }
    }


    @Override
    public String toString() {
        return hora.toString();
    }
}
