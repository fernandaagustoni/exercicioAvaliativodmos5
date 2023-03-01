package com.example.exercicioavaliativodmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText temperaturaEditText;
    private Button paraCelsiusButton;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperaturaEditText = findViewById(R.id.edittext_value);
        paraCelsiusButton = findViewById(R.id.button_celsius);
        saidaTextView = findViewById(R.id.textview_value_converted);

        paraCelsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == paraCelsiusButton){
            double entrada;
            try{
                entrada = Double.valueOf(temperaturaEditText.getText().toString());
            }catch (NumberFormatException nfe){
                entrada = 0;
                mostraMensagem("Temperatura de entrada inválida!");
            }catch (Exception e){
                entrada = 0;
                mostraMensagem("Erro na entrada de dados!");
            }
            saidaTextView.setText(String.format("%.2f ºC", paraCelsius(entrada)));
        }
    }

    private void mostraMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private double paraCelsius(double temperatura){

        double celsius;
        celsius = (temperatura - 32) / 1.8;
        return celsius;
    }
}