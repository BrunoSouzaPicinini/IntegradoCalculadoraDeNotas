package br.com.bspicinini.calculadoradenotas.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import br.com.bspicinini.calculadoradenotas.R;
import br.com.bspicinini.calculadoradenotas.dao.DAOUsuario;
import br.com.bspicinini.calculadoradenotas.modelo.ModUsuario;

public class LoginActivity extends AppCompatActivity {
    DAOUsuario  daoUsuario ;
    ModUsuario modeloUsuario ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        daoUsuario = new DAOUsuario(this);
        modeloUsuario = new ModUsuario();
    }

    public void onClickLogin(View v){
            EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
            modeloUsuario.setDescLogin( edtUsuario.getText().toString());
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
            modeloUsuario.setDescPassword(edtSenha.getText().toString());
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtSenha.getWindowToken(), 0);

            if(daoUsuario.loginUsuarioSenha(modeloUsuario)){
                Intent intent = new Intent(getApplicationContext(), ListagemActivity.class);
                intent.putExtra("Login",modeloUsuario.getCodUsuario()+" - "+modeloUsuario.getDescLogin());
                startActivity(intent);
            }else {
                Toast toast = Toast.makeText(LoginActivity.this, R.string.error_usuario_senha, Toast.LENGTH_LONG);
                toast.show();
            }


    }


    public void onClickSingUp(View v){
            Intent intent = new Intent(getApplicationContext(), SingUpActivity.class);
            startActivity(intent);
    }

}
