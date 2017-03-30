package br.com.bspicinini.calculadoradenotas.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.bspicinini.calculadoradenotas.R;
import br.com.bspicinini.calculadoradenotas.dao.DAOUsuario;
import br.com.bspicinini.calculadoradenotas.modelo.ModUsuario;


public class SingUpActivity extends AppCompatActivity {
    DAOUsuario daoUsuario ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        daoUsuario = new DAOUsuario(this);
    }

    public void onClickCadastrar(View v){
        if(v.getId() == R.id.sing_up_button){
            EditText edtUsuario = (EditText) findViewById(R.id.edtLogin);
            EditText edtNome = (EditText) findViewById(R.id.edtNome);
            EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
            EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
            EditText edtSenhaDois = (EditText) findViewById(R.id.edtSenhaDois);

            String usuarioStr = edtUsuario.getText().toString();
            String nomeStr = edtNome.getText().toString();
            String emailStr = edtEmail.getText().toString();
            String senhaStr = edtSenha.getText().toString();
            String senhaDoisStr = edtSenhaDois.getText().toString();

            if(!senhaStr.equals(senhaDoisStr)){
                //Mensagem popUp
                Toast senha = Toast.makeText(SingUpActivity.this, R.string.senha_nao_confere, Toast.LENGTH_LONG);
                senha.show();
            }else{
                ModUsuario modeloUsuario = new ModUsuario();
                modeloUsuario.setNomUsuario(nomeStr);
                modeloUsuario.setDescEmail(emailStr);
                modeloUsuario.setDescLogin(usuarioStr);
                modeloUsuario.setDescPassword(senhaStr);
                daoUsuario.insert(modeloUsuario);
            }



        }

    }
}
