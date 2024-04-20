package com.example.calculadornpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (TextView) findViewById(R.id.inputText);
    }

    public void cleanText(View view){
        inputText.setText("");
    }

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

    public void agregarMas(View view){
        inputText.setText(inputText.getText()+"+");
    }

    public void agregarMenos(View view){
        inputText.setText(inputText.getText()+"-");
    }

    public void agregarMultiplicacion(View view){
        inputText.setText(inputText.getText()+"*");
    }

    public void agregarDivision(View view){
        inputText.setText(inputText.getText()+"/");
    }
}