package com.miguel_santos.com.example.lgc_thiengo_copia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null && getIntent() == null
        || getIntent().getFlags() == 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        String rotuloCadastro = "Ainda não tem conta? <font color=\"#1193f5\">CADASTRE-SE</font>";
        TextView tvCadastro = findViewById(R.id.tv_cadastro);
        tvCadastro.setText(Html.fromHtml(rotuloCadastro));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void acessarCadastroActivity(View view) {
        invocaActivity(CadastroActivity.class);
    }

    public void acessarRecuperacaoAcesso (View view) {
       invocaActivity(RecuperarAcessoPassoUmActivity.class);
    }

    private void invocaActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}