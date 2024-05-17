package com.example.calculadornpi;

import android.util.Log;

//Clase que funciona como stack en el proyecto
public class pila {
    //Atributos
    public csNodo top;

    //Constructor
    public pila() {
    }
    public pila(csNodo top) {
        this.top = top;
    }

    //Metodos
    public pila insertarTop(String dato) {
        csNodo nuevo = new csNodo(dato, this.top);
        this.top = nuevo;
        Log.println(Log.INFO, "CaluladoraNPI.pila", "Nodo ingresado: "+dato);
        return this;
    }

    public csNodo eliminarTop(){
        csNodo n = this.top;
        this.top = n.puntero;
        Log.println(Log.INFO, "CaluladoraNPI.pila", "Nodo eliminado: "+n.dato);
        return n;
    }

    public int cantidadDeDatos(){
        int datosEnPila = 0;
        csNodo n = this.top;
        while(n != null){
            datosEnPila++;
            n = n.puntero;
        }
        return datosEnPila;
    }
}
