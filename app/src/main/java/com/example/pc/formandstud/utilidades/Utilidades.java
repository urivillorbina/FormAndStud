package com.example.pc.formandstud.utilidades;

/**
 * Created by oriol on 05/03/2018.
 */

public class Utilidades {

    //Constantes campos tabla usuarios

    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_ID = "id";
    public static String CAMPO_NOMBRE = "nombre";
    public static String CAMPO_TELEFONO = "telefono";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+
            TABLA_USUARIO+" ("+CAMPO_ID+
            " INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";

}
