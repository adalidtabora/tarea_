package com.example.tlenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrincipal extends AppCompatActivity {

    Button btnaadd, btnlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnaadd = (Button) findViewById(R.id.btnadd);
        btnlist = (Button) findViewById(R.id.btnlist);

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pagina = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(pagina);

            }
        });

        btnaadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Intent = new Intent(getApplicationContext(), ActivityIngresar.class);
                startActivity(Intent);

            }
        });
    }
}