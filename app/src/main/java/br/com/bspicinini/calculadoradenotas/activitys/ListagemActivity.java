package br.com.bspicinini.calculadoradenotas.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.bspicinini.calculadoradenotas.R;

public class ListagemActivity extends AppCompatActivity {
     TextView tvUsuario ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        tvUsuario = (TextView) findViewById(R.id.tVUsuario);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        tvUsuario.setText((String)bundle.get("Login"));

    }
}
