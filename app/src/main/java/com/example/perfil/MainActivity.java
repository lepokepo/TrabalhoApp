package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        edtEmail = findViewById(R.id.edtEmail);
        edtTelefone = findViewById(R.id.edtTel);
        edtNome = findViewById(R.id.edtNome);

        edtNome.setText(sharedPref.getString("nome", ""));
        edtTelefone.setText(sharedPref.getString("telefone", ""));
        edtEmail.setText(sharedPref.getString("email", ""));
    }

    public void salvarBt(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();

        String telefone = edtTelefone.getText().toString();
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();

        editor.putString("nome", nome);
        editor.putString("telefone", telefone);
        editor.putString("email", email);
        editor.apply();
    }

}
