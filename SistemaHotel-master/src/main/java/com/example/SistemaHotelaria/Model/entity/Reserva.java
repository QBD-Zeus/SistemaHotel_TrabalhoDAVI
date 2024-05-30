// model, ficarao as regras de negócio.

package com.example.SistemaHotelaria.Model.entity;

import java.sql.Date;

public class Reserva extends Abstrata {

    private String responsavel;
    private Date checkinDate;
    private Date checkoutDate;
    private int qtdPessoas;

    public Reserva() {

    }

    public Reserva(String nome, String checkinDate, String checkoutDate, int qtdPessoas) {
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

}
