package com.igor.gaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.igor.gaseta.R;
import com.igor.gaseta.controller.Controller;
import com.igor.gaseta.model.Combustivel;

public class MainActivity extends AppCompatActivity {

    EditText Gasolina, Etanol;
    TextView Result;
    Button btnComparar, btnSalvar, btnLimpar, btnFinalizar;
    double textoGas,textoEta;
    Controller controller;
    Combustivel combustivel;
    String stnGas, stnEta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        controller = new Controller(this);
        combustivel = new Combustivel();

        controller.Buscar(combustivel);

        Gasolina = findViewById(R.id.editTextGas);
        Etanol = findViewById(R.id.editTextEtanol);
        btnComparar = findViewById(R.id.button2);
        btnSalvar = findViewById(R.id.button3);
        btnLimpar = findViewById(R.id.button4);
        btnFinalizar = findViewById(R.id.button5);
        Result = findViewById(R.id.textResult);

        Gasolina.setText(combustivel.getTextoGas());
        Etanol.setText(combustivel.getTextoEta());
        Result.setText(combustivel.getComparacao());

        btnComparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoGas = Double.parseDouble(Gasolina.getText().toString());
                textoEta = Double.parseDouble(Etanol.getText().toString());
                stnGas = Gasolina.getText().toString();
                stnEta = Etanol.getText().toString();
                combustivel = new Combustivel(textoGas,textoEta,stnGas,stnEta);
                Result.setText(controller.CalcularPrecos(combustivel));
                combustivel.setComparacao(Result.getText().toString());
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gasolina.setText("");
                Etanol.setText("");
                Result.setText("");
                controller.Limpar();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.Salvar(combustivel);
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}