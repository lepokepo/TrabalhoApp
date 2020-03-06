package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;


public class Eventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapta;
        ListView listaEvento;
        setContentView(R.layout.activity_eventos);
        listaEvento = findViewById(R.id.listaTop);
        adapta = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listaEvento.setAdapter(adapta);
        try {
            String json = new HttpInfo().execute().get();
            JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
            System.out.println(jsonArray.size());
            for (int c = 0; c < jsonArray.size(); c++) {
                String nome = jsonArray.get(c).getAsJsonObject().get("nome").toString();
                String dataString = jsonArray.get(c).getAsJsonObject().get("date_hora").toString();
                String ano = dataString.substring(1, 5);
                String mes = dataString.substring(6, 8);
                String dia = dataString.substring(9, 11);
                String data =dia+"/"+mes+"/"+ano;
                nome = nome.replace("\"", "");
                adapta.add(nome+"\n"+data);
                System.out.println(nome + data);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
