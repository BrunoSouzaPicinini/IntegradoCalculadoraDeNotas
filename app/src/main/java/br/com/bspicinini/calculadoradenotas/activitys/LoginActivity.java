package br.com.bspicinini.calculadoradenotas.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import br.com.bspicinini.calculadoradenotas.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onClickSingUp(View v){
            if(v.getId() == R.id.login_in_button){
                EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
                EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

            }

    }

}
