package com.example.tlenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tlenguajes2023.configuracion.SQLiteConexion;
import com.example.tlenguajes2023.configuracion.Transacciones;
import com.example.tlenguajes2023.tablas.Personas;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones. NameDatabase, null, 1);
        listapersonas = (ListView) findViewById(R.id.listapersonas);
        ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this,  android.R.layout.simple_list_item_1,ArregloPersonas );
        listapersonas.setAdapter(adp);

        listapersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),lista.get(position).getCorreo().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ObtenerListaPersonas()
    {

        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas persona = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db. rawQuery("SELECT * FROM " + Transacciones. tablaperson, null);

        while(cursor. moveToNext())
        {
            persona = new  Personas();
            persona. setId(cursor.getInt(0));
            persona. setNombres(cursor.getString(1));
            persona. setApellidos(cursor.getString(2));
            persona. setEdad(cursor.getInt(3));
            persona. setCorreo(cursor.getString(4));

            lista.add(persona);
        }

        cursor.close();
        fillLiist();


    }

    private void fillLiist() {
        ArregloPersonas = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++) {
            ArregloPersonas.add(lista.get(i).getId() + " | " +
                    lista.get(i).getNombres() + " | " +
                    lista.get(i).getId() + " | ");
        }
    }
}