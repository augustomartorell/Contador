package com.exemplo.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static String NOME_SHAREDPREFERENCES = "contador";

    //Componentes a serem manipulados
    private Button buttonFechar;

    private SharedPreferences bdPrefs;
    private TextView ViewContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewContador = findViewById(R.id.ViewContador);

        buttonFechar = findViewById(R.id.buttonFechar);
        bdPrefs = getSharedPreferences(MainActivity.NOME_SHAREDPREFERENCES, MODE_PRIVATE);
        atualizaAcessos();
    }

    public void onClickBotaoFechar(View v) {
        System.exit(0);
    }

    public void atualizaAcessos() {
        int conta = bdPrefs.getInt("contador", 0);
        SharedPreferences.Editor editor = bdPrefs.edit();
        conta++;
        editor.putInt("contador", conta);
        editor.apply();
        ViewContador.setText("Acessos: " + String.valueOf(conta));
    }
}