package com.notascolegio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonCalcular = findViewById(R.id.btnCalcular);
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizacionCalculo();
            }
        });
    }

    //logica para el calculo de estudiantes que ganaron o perdieron la materia
    private void realizacionCalculo() {

        //llamamos los campos que creamos con nombre nota y numero para diferenciarlos
        EditText campoNombre = findViewById(R.id.idNombreTxt);
        EditText nota1 = findViewById(R.id.idnota1Txt);
        EditText nota2 = findViewById(R.id.idnota2Txt);
        EditText nota3 = findViewById(R.id.idnota3Txt);
        EditText nota4 = findViewById(R.id.idnota4Txt);
        TextView resultado = findViewById(R.id.TxtResultado);

        String nombre = campoNombre.getText().toString();
        double nota1Val = Double.parseDouble(nota1.getText().toString());
        double nota2Val = Double.parseDouble(nota2.getText().toString());
        double nota3Val = Double.parseDouble(nota3.getText().toString());
        double nota4Val = Double.parseDouble(nota4.getText().toString());

        double promedio = (nota1Val + nota2Val + nota3Val + nota4Val) / 4;
        Log.i("salida", "El promedio de " + nombre + " es " + promedio);

        //Condicional if para definir con cuanto gana la materia y si la pierde o la gana
        if (promedio >= 3.0) {
            Toast.makeText(this, "Aprobó la Materia", Toast.LENGTH_LONG).show();
            resultado.setText("El estudiante " + nombre + " aprobó la materia con un promedio de " + promedio);
        } else {
            Toast.makeText(this, "Perdió la Materia", Toast.LENGTH_LONG).show();
            resultado.setText("El estudiante " + nombre + " perdió la materia con un promedio de " + promedio);
        }
    }
}
