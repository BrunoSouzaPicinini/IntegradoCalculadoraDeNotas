package br.com.bspicinini.calculadoradenotas.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.bspicinini.calculadoradenotas.R;


public class SingUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
    }

    public void onClickSingUp(View v){
        if(v.getId() == R.id.login_in_button){
            EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);

        }

    }
}
