package br.com.bspicinini.calculadoradenotas.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.bspicinini.calculadoradenotas.modelo.ModUsuario;

/**
 * Created by bspicinini on 30/03/2017.
 */

public class DAOUsuario extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "usuario.db";
    private static final String TABLE_NAME = "cadusuario";
    private static final String COLUMN_ID = "codusuario";
    private static final String COLUMN_NAME = "desusuario";
    private static final String COLUMN_LOGIN = "deslogin";
    private static final String COLUMN_SENHA = "dessenha";
    private static final String COLUMN_EMAIL = "email";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table cadusuario (codusuario integer primary key not null auto_increment,"+
            "desusuario text not null, deslogin text not null, dessenha text not null,desemail text not null);";

    private StringBuilder sql = new StringBuilder();

    public DAOUsuario(Context context ){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query  = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insert(ModUsuario usuario) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, usuario.getNomUsuario());
        values.put(COLUMN_LOGIN, usuario.getDescLogin());
        values.put(COLUMN_SENHA,usuario.getDescPassword());
        values.put(COLUMN_EMAIL,usuario.getDescEmail());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }


    public boolean loginUsuarioSenha(ModUsuario modeloUsuario){
        db = this.getReadableDatabase();
        sql.delete(0,sql.length());
        sql.append("SELECT ");
        sql.append(COLUMN_LOGIN).append(",");
        sql.append(COLUMN_SENHA).append(",");
        sql.append(COLUMN_ID).append(" FROM");
        sql.append(TABLE_NAME).append(" WHERE ");
        sql.append(COLUMN_LOGIN).append(" = ").append(modeloUsuario.getDescLogin());
        sql.append(" AND ").append(COLUMN_SENHA).append(" = ").append(modeloUsuario.getDescPassword());

        Cursor cursor = db.rawQuery(sql.toString(),null);
        try {
            cursor.moveToFirst();
            cursor.getString(0);
            cursor.getString(1);
            modeloUsuario.setCodUsuario(cursor.getInt(3));
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
