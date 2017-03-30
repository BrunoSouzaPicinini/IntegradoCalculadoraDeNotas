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
    private static final String COLUMN_COD = "codusuario";
    private static final String COLUMN_NAME = "desusuario";
    private static final String COLUMN_LOGIN = "deslogin";
    private static final String COLUMN_SENHA = "dessenha";
    private static final String COLUMN_EMAIL = "desemail";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table if not exists cadusuario (codusuario integer primary key autoincrement, "+
            "desusuario text not null, deslogin text not null, dessenha text not null,desemail text not null)";

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
        db = this.getWritableDatabase();
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
        sql.append(COLUMN_COD).append(" FROM ");
        sql.append(TABLE_NAME).append(" WHERE ");
        sql.append(COLUMN_LOGIN).append(" = '").append(modeloUsuario.getDescLogin()).append("' ");
        sql.append(" AND ").append(COLUMN_SENHA).append(" = '").append(modeloUsuario.getDescPassword()).append("'");
        try {
        Cursor cursor = db.rawQuery(sql.toString(),null);
            if(cursor == null) {
                return false;

            }
                cursor.moveToFirst();
                String posicaoUm = cursor.getString(0);
                String posicaoDois = cursor.getString(1);
                modeloUsuario.setCodUsuario(cursor.getInt(2));
                cursor.close();
                return true;


        }catch (Exception e){
            return false;
        }

    }

}
