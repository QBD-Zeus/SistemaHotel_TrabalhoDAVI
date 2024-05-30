package com.example.SistemaHotelaria.Model.entity;

public class TipoQuarto extends Abstrata {

    private int idTipoQuarto;
    private String categoria;

    /*public TipoQuarto(int id,int idTipoQuarto, String categoria) {;
        this.idTipoQuarto = idTipoQuarto;
        this.categoria = categoria;
        super.setId(id);
    }*/

    public TipoQuarto(){};

    public int getIdTipoQuarto() {
        return idTipoQuarto;
    }

    public void setIdTipoQuarto(int idTipoQuarto) {
        this.idTipoQuarto = idTipoQuarto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

 }
