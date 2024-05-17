package com.example.calculadornpi;

public class csNodo {
    //atributos
    public String dato;
    public csNodo puntero;

    //Constructores
    public csNodo(csNodo puntero) {
        this.puntero = puntero;
    }

    public csNodo(String dato, csNodo puntero) {
        this.dato = dato;
        this.puntero = puntero;
    }

    public csNodo() {
    }

    //Metodos
    public String getDato(){
        return this.dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public csNodo getPuntero() {
        return this.puntero;
    }

    public void setPunter(csNodo puntero) {
        this.puntero = puntero;
    }
}
