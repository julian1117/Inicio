package com.example.camilo.inicio.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.camilo.inicio.database.DbManagerContacto;


/**
 * Created by CAMILO on 29/03/2017.
 */

public class DaraBaseHelper extends SQLiteOpenHelper {

    //base de datos
    private static final String DB_NAME = "contactos.sqlite";
    //version o estructura de la base de datos
    private static final int DB_VERSION = 1;

    public DaraBaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    /**
     * metodo que permite crear la base de datos con sus tablas
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbManagerContacto.CREATE_TABLE);
    }

    /**
     * Metodo encargado de actualziar la base de datos siempre y cuando haya una nueva version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("", "Actualizando base de datos de version "+oldVersion+" a "+newVersion
                +" , lo que eliminara todos los datos viejos");
        db.execSQL("DROP TABLE IF EXISTS contactos");
        onCreate(db);
    }

}
