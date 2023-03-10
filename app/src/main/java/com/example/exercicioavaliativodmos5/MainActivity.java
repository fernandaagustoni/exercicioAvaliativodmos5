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
    private Button celsiusButton;
    private Button fahrenheitButton;
    private Button kelvinFahrenheitButton;
    private Button kelvinCelsiusButton;
    private TextView saidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperaturaEditText = findViewById(R.id.edittext_value);
        celsiusButton = findViewById(R.id.button_celsius);
        saidaTextView = findViewById(R.id.textview_value_converted);
        fahrenheitButton = findViewById(R.id.button_fahrenheit);
        kelvinCelsiusButton = findViewById(R.id.button_kelvinCelsius);
        kelvinFahrenheitButton = findViewById(R.id.button_kelvinFahrenheit);

        celsiusButton.setOnClickListener(this);
        fahrenheitButton.setOnClickListener(this);
        kelvinCelsiusButton.setOnClickListener(this);
        kelvinFahrenheitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double entrada, saida=0;
        String saidaFormatada;
        saidaFormatada = "%.2f º";
        if(v == celsiusButton){
            entrada = getTemperatura();
            saida = paraCelsius(entrada);
            saidaFormatada += "C ";
        }
        if(v == fahrenheitButton){
            entrada = getTemperatura();
            saida = paraFahrenheit(entrada);
            saidaFormatada += "F ";
        }
        if(v == kelvinFahrenheitButton){
            entrada = getTemperatura();
            saida = fahrenheitParaKelvin(entrada);
            saidaFormatada += "K ";
        }
        if(v == kelvinCelsiusButton){
            entrada = getTemperatura();
            saida = celsiusParaKelvin(entrada);
            saidaFormatada += "K ";
        }
        saidaTextView.setText(String.format(saidaFormatada, saida));
    }


    private void mostraMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private double paraCelsius(double temperatura){

        double celsius;
        celsius = (temperatura - 32) / 1.8;
        return celsius;
    }
    private double paraFahrenheit(double temperatura){
        return 1.8 * temperatura + 32;
    }

    private double fahrenheitParaKelvin(double temperatura){

        double kelvin;
        kelvin = (temperatura - 32) * 5/9 + 273.15;
        return kelvin;
    }

    private double celsiusParaKelvin(double temperatura){
        return temperatura + 273.15;
    }
    private double getTemperatura(){
        double temperatura;
        try{
            temperatura = Double.valueOf(temperaturaEditText.getText().toString());
        }catch (NumberFormatException nfe){
            temperatura = 0;
            mostraMensagem(getString(R.string.temperatura_invalida));
        }catch (Exception e){
            temperatura = 0;
            mostraMensagem(getString(R.string.erro_entrada));
        }
        return temperatura;
    }
}