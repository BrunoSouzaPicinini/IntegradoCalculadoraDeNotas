package br.com.bspicinini.calculadoradenotas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bspicinini on 30/03/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "usuario.db";
    private static final String TABLE_NAME = "cadusuario";
    private static final String COLUMN_ID = "codusuario";
    private static final String COLUMN_NAME = "desusuario";
    private static final String COLUMN_LOGIN = "deslogin";
    private static final String COLUMN_SENHA = "dessenha";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table if not exists cadusuario (codusuario integer primary key  not null autoincrement,"+
            "desusuario text, deslogin text, dessenha text);";

    public DataBase (Context context ){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP  TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
