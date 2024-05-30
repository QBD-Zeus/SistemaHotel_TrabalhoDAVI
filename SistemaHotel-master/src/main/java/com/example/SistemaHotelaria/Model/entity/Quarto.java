package com.example.SistemaHotelaria.Model.entity;

public class Quarto extends TipoQuarto {

        private int numero;
        private boolean disponivel;
        private int maxPessoas;
        private int andar;

        public Quarto(int numero, boolean disponivel, int maxPessoas, int andar) {

                this.numero = numero;
                this.disponivel = disponivel;
                this.maxPessoas = maxPessoas;
                this.andar = andar;
        }
        public Quarto(){}

        public int getAndar() {
                return andar;
        }

        public void setAndar(int andar) {
                this.andar = andar;
        }

        public int getmaxPessoas() {
                return maxPessoas;
        }

        public void setmaxPessoas(int maxPessoas) {
                this.maxPessoas = maxPessoas;
        }

        public int getNumero() {
                return numero;
        }

        public void setNumero(int numero) {
                this.numero = numero;
        } 
        
        public boolean isDisponivel() {
                return disponivel;
        }
        public void setDisponivel(boolean disponivel) {
                this.disponivel = disponivel;
        }
}

