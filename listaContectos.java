package com.example.camilo.inicio;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.camilo.inicio.database.DbManagerContacto;

public class listaContectos extends AppCompatActivity {

    private ListView listaContat;

    private Cursor c;

    private SimpleCursorAdapter adapter;

    private DbManagerContacto managerContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contectos);

        managerContacto = new DbManagerContacto(this);


        listaContat = (ListView) findViewById(R.id.lvContactos);

        String[] from = new String[]{managerContacto.NOMBRE_CONTACTO, managerContacto.TELEFONO_CONTACTO};
        //relacionamos en donde se va a mostrar los daots
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};

        managerContacto.abrir();
        c = managerContacto.listarContactos();

        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, c, from, to, 0);

        listaContat.setAdapter(adapter);
        managerContacto.cerrar();


    }
}
