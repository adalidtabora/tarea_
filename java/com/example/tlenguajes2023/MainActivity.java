package com.example.tlenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //PUsh DE NUEVO
    EditText txtnombre, txtapellido;
    Button btnmostrar;

    // Este es una prueba.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtapellido = (EditText) findViewById(R.id.txtapellido);

        btnmostrar = (Button) findViewById(R.id.btnMostrar);

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, txtnombre.getText() + "" + txtapellido.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}