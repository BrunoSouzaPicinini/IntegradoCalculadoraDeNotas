package br.com.bspicinini.calculadoradenotas.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

import br.com.bspicinini.calculadoradenotas.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLoginUp(View v){
            EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
            String  usuario = edtUsuario.getText().toString();
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
            Intent intent = new Intent(getApplicationContext(), ListagemActivity.class);
            intent.putExtra("Login",usuario);
            startActivity(intent);


    }


    public void onClickSingUp(View v){
            EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
            String  usuario = edtUsuario.getText().toString();
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

            Intent intent = new Intent(getApplicationContext(), SingUpActivity.class);
            intent.putExtra("Login",usuario);
            startActivity(intent);


    }

}
