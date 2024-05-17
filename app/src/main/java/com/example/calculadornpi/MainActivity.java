package com.example.calculadornpi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputText;
    TextView pilaDeDatos, label;
    TextView txtBox0, txtBox1, txtBox2, txtBox3, txtBox4;
    pila datos = new pila();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (TextView) findViewById(R.id.input);
        //pilaDeDatos = (TextView) findViewById(R.id.pilaDeDatos1);
        label = (TextView) findViewById(R.id.lblAlert);

        txtBox0 = (TextView) findViewById(R.id.pilaDeDatos0);
        txtBox1 = (TextView) findViewById(R.id.pilaDeDatos1);
        txtBox2 = (TextView) findViewById(R.id.pilaDeDatos2);
        txtBox3 = (TextView) findViewById(R.id.pilaDeDatos3);
        txtBox4 = (TextView) findViewById(R.id.pilaDeDatos4);
    }

    //Funcion para llenar el label y la operacion
    public void llamarOperacion(View view){
        try{
            double resultado = operar(datos.top);
            pilaDeDatos.setText(String.valueOf(resultado));
        } catch (Exception e){
            cleanText(view);
            cleanText(view);
            pilaDeDatos.setText("Error");
        }
    }

    //Función para ejecutar la operación
    public double operar(csNodo Top){
        String op, iz ="", de = "";
        double izq, der;

        if(esOperador(Top.dato)){
            op = Top.dato;
            //Derecho
            if(esOperador(Top.puntero.dato)){
                der = operar(Top.puntero);
            } else {
                de = Top.puntero.dato;
                der = Double.parseDouble(de);
            }
            //Izquierdo
            if(esOperador(Top.puntero.puntero.dato)){
                izq = operar(Top.puntero.puntero);
            } else {
                iz = Top.puntero.puntero.dato;
                izq = Double.parseDouble(iz);
            }

            //1era version que mas o menos funciona
            /*
            op = Top.dato;
            //Derecho
            if(esOperador(Top.puntero.dato)){
                der = operar(Top.puntero);
            } else {
                de = Top.puntero.dato;
                der = Double.parseDouble(de);
            }
            //Izquierdo
            if(esOperador(Top.puntero.puntero.dato)){
                izq = operar(Top.puntero.puntero);
            } else {
                iz = Top.puntero.puntero.dato;
                izq = Double.parseDouble(iz);
            } */

            //ejecución de la operación
            switch (op) {
                case "+":
                    return izq + der;
                case "-":
                    return izq - der;
                case "*":
                    return izq * der;
                case "/":
                    return izq / der;
                default:
                    pilaDeDatos.setText("Error");
                    datos = new pila();
                    return 999.999;
            }
        } else {
            pilaDeDatos.setText("Error");
            datos = new pila();
            Log.println(Log.ERROR, "CaluladoraNPI", "Salio aquí."+Top.dato);
            return 999.999;
        }
    }

    //Función para saber si un dato es operador
    public boolean esOperador(String dato){
        if(dato.equals("+") || dato.equals("-") || dato.equals("*") || dato.equals("/")){
            return true;
        } else {
            return false;
        }
    }

    //Función para insertar a la pila
    public void insertar(View view){
        if (datos.cantidadDeDatos()>=5){
            //No se pueden aceptar más datos
            label.setText("Error: pila llena.");
        } else {
            String dato = inputText.getText().toString();
            datos.insertarTop(dato);
            inputText.setText("");

            //Logica para decidir en que textBox va cada dato
            llenarTextBoxs();

            //Log de la Pila
        /*
        String lista = "Pila: ";
        csNodo n = datos.top;
        while(n != null){
            lista += n.dato + ", ";
            n = n.puntero;
        }
        Log.println(Log.INFO, "CaluladoraNPI", lista);
         */
        }
    }

    //Función para decidir en que textbox va cada dato
    public void llenarTextBoxs(){
        int datosEnPila = datos.cantidadDeDatos();
        switch (datosEnPila){
            case 1:
                mostrarTextBoxs(datos.top.dato, "","","","");
                break;

            case 2:
                mostrarTextBoxs(datos.top.dato,
                        datos.top.puntero.dato, "","","");
                break;

            case 3:
                mostrarTextBoxs(datos.top.dato,
                        datos.top.puntero.dato,
                        datos.top.puntero.puntero.dato, "","");
                break;

            case 4:
                mostrarTextBoxs(datos.top.dato,
                        datos.top.puntero.dato,
                        datos.top.puntero.puntero.dato,
                        datos.top.puntero.puntero.puntero.dato, "");
                break;

            case 5:
                mostrarTextBoxs(datos.top.dato,
                        datos.top.puntero.dato,
                        datos.top.puntero.puntero.dato,
                        datos.top.puntero.puntero.puntero.dato,
                        datos.top.puntero.puntero.puntero.puntero.dato);
                break;

            default:
                //Algo que no tenia que pasar
                break;
        }
    }

    public void mostrarTextBoxs(String txt0, String txt1, String txt2, String txt3, String txt4){
        txtBox0.setText(txt0);
        txtBox1.setText(txt1);
        txtBox2.setText(txt2);
        txtBox3.setText(txt3);
        txtBox4.setText(txt4);
    }

    //Función para limpiar los textbox y la pila
    public void cleanText(View view){
        if (inputText.getText().toString().isEmpty()){
            txtBox0.setText("");
            txtBox1.setText("");
            txtBox2.setText("");
            txtBox3.setText("");
            txtBox4.setText("");
            datos = new pila();
            Log.println(Log.INFO,"CaluladoraNPI", "borrando todos los datos.");
            label.setText("NPI");
        } else {
            inputText.setText("");
            //Mostrando un log para ver en Logcat
            Log.println(Log.INFO,"CaluladoraNPI", "borrando input-label");
        }
    }

    //Funciones para agregar los datos al label
    public void agregarCero(View view){
        inputText.setText(inputText.getText()+"0");
    }

    public void agregarUno(View view){
        inputText.setText(inputText.getText()+"1");
    }

    public void agregarDos(View view){
        inputText.setText(inputText.getText()+"2");
    }

    public void agregarTres(View view){
        inputText.setText(inputText.getText()+"3");
    }

    public void agregarCuatro(View view){
        inputText.setText(inputText.getText()+"4");
    }

    public void agregarCinco(View view){
        inputText.setText(inputText.getText()+"5");
    }

    public void agregarSeis(View view){
        inputText.setText(inputText.getText()+"6");
    }

    public void agregarSiete(View view){
        inputText.setText(inputText.getText()+"7");
    }

    public void agregarOcho(View view){
        inputText.setText(inputText.getText()+"8");
    }

    public void agregarNueve(View view){
        inputText.setText(inputText.getText()+"9");
    }

    public void agregarPunto(View view){
        inputText.setText(inputText.getText()+".");
    }

    public void agregarMas(View view){
        //Validar que pila tenga al menos dos datos
        if(datos.cantidadDeDatos()>=2){
            //Sumar
            Double derecho = Double.parseDouble(datos.eliminarTop().dato);
            Double izquierdo = Double.parseDouble(datos.eliminarTop().dato);
            String resultado = String.valueOf(izquierdo + derecho);
            datos.insertarTop(resultado);
            llenarTextBoxs();
        }else{
            //Tiene menos de dos datos
            label.setText("Se necesitan al menos dos datos.");
        }
    }

    public void agregarMenos(View view){
        //Validar que pila tenga al menos dos datos
        if(datos.cantidadDeDatos()>=2){
            //Restar
            Double derecho = Double.parseDouble(datos.eliminarTop().dato);
            Double izquierdo = Double.parseDouble(datos.eliminarTop().dato);
            String resultado = String.valueOf(izquierdo - derecho);
            datos.insertarTop(resultado);
            llenarTextBoxs();
        }else
        {
            //Tiene menos de dos datos
            label.setText("Se necesitan al menos dos datos.");
        }
    }

    public void agregarMultiplicacion(View view){
        //Validar que pila tenga al menos dos datos
        if(datos.cantidadDeDatos()>=2){
            //Multiplicar
            Double derecho = Double.parseDouble(datos.eliminarTop().dato);
            Double izquierdo = Double.parseDouble(datos.eliminarTop().dato);
            String resultado = String.valueOf(izquierdo * derecho);
            datos.insertarTop(resultado);
            llenarTextBoxs();
        }else{
            //Tiene menos de dos datos
            label.setText("Se necesitan al menos dos datos.");
        }
    }

    public void agregarDivision(View view){
        //Validar que pila tenga al menos dos datos
        if(datos.cantidadDeDatos()>=2){
            //Dividir
            Double derecho = Double.parseDouble(datos.eliminarTop().dato);
            Double izquierdo = Double.parseDouble(datos.eliminarTop().dato);
            String resultado = String.valueOf(izquierdo / derecho);
            datos.insertarTop(resultado);
            llenarTextBoxs();
        }else{
            //Tiene menos de dos datos
            label.setText("Se necesitan al menos dos datos.");
        }
    }
}