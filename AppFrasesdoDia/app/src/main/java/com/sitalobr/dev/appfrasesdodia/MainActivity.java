package com.sitalobr.dev.appfrasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();

    private final String[] frases = {
            "Está tão frio, que fui jogar Mortal Kombat e o Sub Zero estava de moletom!",
            "Sou tão nerd, que quando tomo vacina, digo: As definições de vírus foram atualizadas.",
            "Nerd que é nerd come os cookies do navegador.",
            "Há 10 tipos de pessoas neste mundo: aquelas que sabem contas em binário, e aquelas que não..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view) {
        int i = random.nextInt(frases.length);
        TextView txtFrases = findViewById(R.id.txtFrases);
        txtFrases.setText(frases[i]);
    }
}
