package com.sitalobr.dev.appalcoolgasolina;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etPrecoAlcool;
    private EditText etPrecoGasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etPrecoAlcool = findViewById(R.id.etPrecoAlcool);
        this.etPrecoGasolina = findViewById(R.id.etPrecoGasolina);
        this.tvResultado = findViewById(R.id.tvResultado);
    }

    public void calcularPreco(View view) {
        String precoAlcool = this.etPrecoAlcool.getText().toString();
        String precoGasolina = this.etPrecoGasolina.getText().toString();

        if (this.validaCampos(precoAlcool, precoGasolina))
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        else
            this.showToast("Informe todos os campos corretamente...", Toast.LENGTH_LONG);
    }

    private void calcularMelhorPreco(String precoAlcool, String precoGasolina) {
        Double pAlcool = Double.parseDouble(precoAlcool);
        Double pGasolina= Double.parseDouble(precoGasolina);

        if ((pAlcool / pGasolina) >= 0.7)
            this.setResultado("Gasolina é a melhor opção!", R.color.colorSuccess);
        else
            this.setResultado("Álcool é a melhor opção!", R.color.colorPrimary);
    }

    private Boolean validaCampos(String precoAlcool, String precoGasolina) {
        return precoAlcool != null && !precoAlcool.equals("") && precoGasolina != null && !precoGasolina.equals("");
    }

    private void setResultado(String text, int color) {
        this.tvResultado.setTextColor(ContextCompat.getColor(this, color));
        this.tvResultado.setText(text);
    }

    private void showToast(String text, int duration) {
        Toast.makeText(this, text, duration).show();
    }
}
