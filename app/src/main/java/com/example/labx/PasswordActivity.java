package com.example.labx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PasswordActivity extends AppCompatActivity {

    // lowercase letters
    private static final String LOWERS = "abcdefghijklmnopqrstuvwxyz";
    // uppercase letters
    private static final String CAPITALS = LOWERS.toUpperCase();
    // special symbols
    private static final String SYMBOLS = "$%£_@#-+?";
    private static final String DIGITS = "1234567890";

    // parameters from starting Intent
    private int numCharacters;  // number of characters (password length)
    private boolean capitals;   // whether uppercase letters can be used
    private boolean symbols;    // whether special symbols can be used
    private boolean digits;

    private final Random generator = new Random();

    private TextView txtPassword;   // to show the generated password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        // initialize txtPassword
        txtPassword = findViewById(R.id.txtPassword);
        // get parameters or default values if absent
        Intent intent = getIntent();
        // generate and show a password with the given length,
        numCharacters = Integer.parseInt(intent.getStringExtra("lunghezza"));
        capitals = intent.getBooleanExtra("maiuscolo", false);
        symbols = intent.getBooleanExtra("special", false);
        digits = intent.getBooleanExtra("digits", false);

        generate(txtPassword);
    }

    public void generate(View view) {
        // with/without uppercase letters/digits/special symbols
        String password = "";
        if(capitals){
            password += CAPITALS.charAt(generator.nextInt(CAPITALS.length()));
            password += CAPITALS.charAt(generator.nextInt(CAPITALS.length()));
        }
        if(symbols){
            password += SYMBOLS.charAt(generator.nextInt(SYMBOLS.length()));
            password += SYMBOLS.charAt(generator.nextInt(SYMBOLS.length()));
        }
        if(digits){
            password += DIGITS.charAt(generator.nextInt(DIGITS.length()));
            password += DIGITS.charAt(generator.nextInt(DIGITS.length()));
        }
        for (int i=password.length(); i<numCharacters; i++){    // mette i caratteri rimanenti (lettere minuscole)
            password += LOWERS.charAt(generator.nextInt(LOWERS.length()));
        }
        // show the password in txtPassword
        txtPassword.setText(password);
    }
    public void back(View view) {
        finish();
    }

}