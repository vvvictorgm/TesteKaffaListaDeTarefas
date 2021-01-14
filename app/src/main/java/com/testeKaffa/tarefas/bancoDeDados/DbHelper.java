package com.testeKaffa.tarefas.bancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String NOME_DB = "DB_EXERCICIO_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";
    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create a SQL table at first use and create a ID with auto increment
        String sql ="CREATE TABLE IF NOT EXISTS "+TABELA_TAREFAS+" (id INTEGER PRIMARY KEY AUTO INCREMENT, nome TEXT NOT NULL); ";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}