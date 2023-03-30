package com.example.labx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtNumber; // to show number of characters selected with the seekBar
    private SeekBar seekNumber;
    private CheckBox chkSpecials;
    private CheckBox digits;
    private CheckBox chkCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = findViewById(R.id.txtNumber);
        seekNumber = findViewById(R.id.seekNumber);
        seekNumber.setMax(8);
        seekNumber.setProgress(0);

        seekNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtNumber.setText(Integer.toString(progress + 8));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        chkSpecials = findViewById(R.id.chkSpecials);
        chkCapital = findViewById(R.id.chkCapital);
        digits = findViewById(R.id.digits);
    }

    public void generate(View view) {
        // create an Intent for PasswordActivity
        Intent s = new Intent();   // new ...
        s.putExtra("lunghezza", txtNumber.getText().toString());
        s.putExtra("special", chkSpecials.isChecked());
        s.putExtra("digits", digits.isChecked());
        s.putExtra("maiuscolo", chkCapital.isChecked());
        s.setClass(this, PasswordActivity.class);
        // start PasswordActivity
        startActivity(s);
    }
}