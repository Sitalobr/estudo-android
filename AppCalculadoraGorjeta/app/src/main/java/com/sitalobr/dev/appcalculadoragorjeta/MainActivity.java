package com.sitalobr.dev.appcalculadoragorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etBillValue;
    private SeekBar sbTip;
    private TextView tvPercentage;
    private TextView tvResultTip;
    private TextView tvResultTotal;
    private final String monetarySymbol = "R$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etBillValue = findViewById(R.id.etBillValue);
        this.sbTip = findViewById(R.id.sbTip);
        this.tvPercentage = findViewById(R.id.tvPercentage);
        this.tvResultTip = findViewById(R.id.tvResultTip);
        this.tvResultTotal = findViewById(R.id.tvResultTotal);

        this.seekBarListener();
        this.editTextListener();
    }

    private void seekBarListener() {
        this.sbTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                calculatePercentage();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                validateTextValue();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void editTextListener() {
        this.etBillValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePercentage();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void calculatePercentage() {
        if (validateTextValue()) {
            // creating DecimalFormat to help with the decimal numbers
            DecimalFormat df = new DecimalFormat("0.00");

            // calculating the tip amount
            Double billValue = Double.parseDouble(this.etBillValue.getText().toString());
            Double tipResult = (billValue * this.sbTip.getProgress()) / 100;
            Double totalResult = billValue + tipResult;

            // setting values into TextView
            this.tvPercentage.setText(getString(R.string.percentage_value, this.sbTip.getProgress()));
            this.tvResultTip.setText(getString(R.string.result_monetary, this.monetarySymbol, df.format(tipResult)));
            this.tvResultTotal.setText(getString(R.string.result_monetary, this.monetarySymbol, df.format(totalResult)));
        }
    }

    private Boolean validateTextValue() {
        if (etBillValue.getText().toString().trim().equals("")) {
            this.sbTip.setProgress(0);
            this.tvResultTip.setText(getString(R.string.result_monetary, this.monetarySymbol, "0.00"));
            this.tvResultTotal.setText(getString(R.string.result_monetary, this.monetarySymbol, "0.00"));
            this.tvPercentage.setText(getString(R.string.percentage_value, this.sbTip.getProgress()));
            this.showToast(R.string.bill_value_required, Toast.LENGTH_SHORT);

            return false;
        } else return this.sbTip.getProgress() != 0;

    }

    private void showToast(int stringResource, int duration) {
        Toast.makeText(this, stringResource, duration).show();
    }

}
