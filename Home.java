package com.example.camilo.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.camilo.inicio.database.DbManagerContacto;
import com.example.camilo.inicio.modelos.Contacto;

public class Home extends AppCompatActivity {

    public DbManagerContacto mContacto;

    private EditText edNombre;

    private EditText edTelefono;

    private Button Agregar;

    private Contacto contac;

    private Intent abrirListraContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContacto = new DbManagerContacto(this);

        edNombre = (EditText) findViewById(R.id.edNombre);
        edTelefono = (EditText) findViewById(R.id.edTelefono);

        Agregar = (Button) findViewById(R.id.btAgregar);

    }

    public void agregarContacto(View v) {

        mContacto.abrir();

        String nombre = edNombre.getText().toString();
        String telefono = edTelefono.getText().toString();

        contac = new Contacto();
        contac.setNombre(nombre);
        contac.setTelefono(telefono);

        mContacto.insertar(contac);
        mContacto.cerrar();

    }
    private long id;
    public void eliminarContacto(View v) {

        mContacto.abrir();
        mContacto.eliminarContacto(id);
        mContacto.cerrar();
    }

    public void actualizarContacto(View v) {
        mContacto.abrir();
        mContacto.actualizarContacto(1, "30045010");
        mContacto.cerrar();

    }

    public void listarCon(View v){
        abrirListraContactos = new Intent(this,listaContectos.class);
        startActivity(abrirListraContactos);
    }



}
