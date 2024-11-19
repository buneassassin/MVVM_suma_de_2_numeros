package com.primerp.varibales;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private EditText etNumber1, etNumber2;
    private Button btnCalculate;
    private TextView tvResult;
    private SumViewModel sumViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enlazar vistas
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Inicializar ViewModel
        sumViewModel = new ViewModelProvider(this).get(SumViewModel.class);

        // Observador para el resultado
        sumViewModel.getResultLiveData().observe(this, result ->
                tvResult.setText("Resultado: " + result)
        );

        // Acción del botón
        btnCalculate.setOnClickListener(v -> {
            String num1Text = etNumber1.getText().toString();
            String num2Text = etNumber2.getText().toString();

            if (!TextUtils.isEmpty(num1Text) && !TextUtils.isEmpty(num2Text)) {
                int num1 = Integer.parseInt(num1Text);
                int num2 = Integer.parseInt(num2Text);
                sumViewModel.calculateSum(num1, num2);
            } else {
                tvResult.setText("Por favor, ingrese ambos números.");
            }
        });
    }
}