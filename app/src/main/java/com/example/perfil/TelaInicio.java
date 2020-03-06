package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }

    public void telaAgenda(View view) {
        Intent intent = new Intent(TelaInicio.this, Eventos.class);
        startActivity(intent);
    }

    public void telaMain(View view) {
        Intent intent = new Intent(TelaInicio.this, MainActivity.class);
        startActivity(intent);
    }
}
