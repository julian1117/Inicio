package com.example.camilo.inicio.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.camilo.inicio.helpers.DaraBaseHelper;
import com.example.camilo.inicio.modelos.Contacto;


public class DbManagerContacto  {

    // creamos variables que definen el nombre de la base ddatos con sus campos
    public static final String TABLE_NAME = "contactos";
    public static final String ID_CONTACTO = "_id";
    public static final String NOMBRE_CONTACTO = "nombre";
    public static final String TELEFONO_CONTACTO = "telefono";
    // creamos la variable con sentencia Sql para crear una tabla
    public static final String CREATE_TABLE = "create table "+TABLE_NAME+"("
            +ID_CONTACTO+" integer primary key autoincrement, "
            +NOMBRE_CONTACTO+" text not null,"
            +TELEFONO_CONTACTO+" text);";

    private DaraBaseHelper helper;
    private SQLiteDatabase db;

    public DbManagerContacto(Context contexto) {
        helper = new DaraBaseHelper(contexto);
    }

    public DbManagerContacto abrir() throws SQLException{
        db = helper.getWritableDatabase();
        return this;
    }

    public void cerrar(){
        helper.close();;
    }

    public long insertar(Contacto contacto){

        ContentValues valores = new ContentValues();
        valores.put(NOMBRE_CONTACTO,contacto.getNombre());
        valores.put(TELEFONO_CONTACTO,contacto.getTelefono());
        long insertado = db.insert(TABLE_NAME,null,valores);
        Log.e("insert:"," "+insertado);
        return insertado;

    }

    public boolean eliminarContacto (long id){

        boolean eliminado;
        eliminado=db.delete(TABLE_NAME,ID_CONTACTO +"="+ id,null)>0;
        Log.e("eliminado: ",""+eliminado);
        return eliminado;
    }

    public boolean actualizarContacto(long id,String telefono){

        boolean actualizado;
        ContentValues valores = new ContentValues();
        valores.put(TELEFONO_CONTACTO,telefono);
        actualizado = db.update(TABLE_NAME,valores,ID_CONTACTO +"="+ id,null)>0;
        Log.e("actualizado: ",""+actualizado);
        return actualizado;

    }

    public Cursor listarContactos(){

        Cursor c;
        String[] columnas = new String[]{ID_CONTACTO,NOMBRE_CONTACTO,TELEFONO_CONTACTO};
        // query (String table, String[] columns, String selection, String[] selectArgs,String groupBy,String having, String orderBy)
        c = db.query(TABLE_NAME,columnas,null,null,null,null,null);
        return c;
    }

    public Cursor buscarContacto(long id){
        String[] columnas = new String[]{ID_CONTACTO,NOMBRE_CONTACTO,TELEFONO_CONTACTO};
        // query (String table, String[] columns, String selection, String[] selectArgs,String groupBy,String having, String orderBy)
        return db.query(TABLE_NAME,columnas,ID_CONTACTO+"="+id,null,null,null,null);
    }

    public Cursor consultarContacto(String nombre){
        String[] columnas = new String[]{ID_CONTACTO,NOMBRE_CONTACTO,TELEFONO_CONTACTO};
        // query (String table, String[] columns, String selection, String[] selectArgs,String groupBy,String having, String orderBy)
        return db.query(TABLE_NAME,columnas,NOMBRE_CONTACTO+"=?",new String[]{nombre},null,null,null);
    }

}
