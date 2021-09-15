package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Random;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewById
    ImageView logo;

    @ViewById
    EditText editNome;

    @ViewById
    TextView labelLetra1;

    @ViewById
    TextView labelLetra2;

    @ViewById
    TextView labelLetra3;

    @ViewById
    TextView labelLetra4;

    @ViewById
    TextView labelLetra5;

    @ViewById
    TextView labelLetra6;

    @ViewById
    TextView labelLetra7;

    @ViewById
    Button btnSelecionar1;

    @ViewById
    Button btnSelecionar2;

    @ViewById
    Button btnSelecionar3;

    @ViewById
    Button btnSelecionar4;

    @ViewById
    Button btnSelecionar5;

    @ViewById
    Button btnSelecionar6;

    @ViewById
    Button btnSelecionar7;

    String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z"};
    String[] consoantes = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "x", "w", "y", "z"};
    String[] vogais = {"a", "e", "i", "o", "u"};
    String silaba = "";

    String letra1, letra2, letra3, letra4, letra5, letra6, letra7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        letra1 = "";
        letra2 = "";
        letra3 = "";
        letra4 = "";
        letra5 = "";
        letra6 = "";
        letra7 = "";
    }

    @AfterViews
    void init() {
        Glide.with(MainActivity.this).load(R.drawable.cadastro).override(700, 700).into(logo);

        Handler timerHandler = new Handler();
        Runnable timerRunnable = new Runnable() {
            @Override
            public void run() {
//                gerarSilabas();
//                labelLetra1.setText(silaba);
                if (letra1.equals("")) {
                    labelLetra1.setText(gerarLetra());
                }
                if (letra2.equals("")) {
                    labelLetra2.setText(gerarLetra());
                }
                if (letra3.equals("")) {
                    labelLetra3.setText(gerarLetra());
                }
                if (letra4.equals("")) {
                    labelLetra4.setText(gerarLetra());
                }
                if (letra5.equals("")) {
                    labelLetra5.setText(gerarLetra());
                }
                if (letra6.equals("")) {
                    labelLetra6.setText(gerarLetra());
                }
                if (letra7.equals("")) {
                    labelLetra7.setText(gerarLetra());
                }

                timerHandler.postDelayed(this, 600);
            }
        };

        timerRunnable.run();
    }

    @Click({R.id.btn_selecionar1, R.id.btn_selecionar2, R.id.btn_selecionar3, R.id.btn_selecionar4, R.id.btn_selecionar5, R.id.btn_selecionar6, R.id.btn_selecionar7})
    void clickParar(Button button) {
        switch (button.getId()) {
            case R.id.btn_selecionar1:
                letra1 = labelLetra1.getText().toString();
                btnSelecionar1.setActivated(true);
                break;
            case R.id.btn_selecionar2:
                letra2 = labelLetra2.getText().toString();
                btnSelecionar2.setActivated(true);
                break;
            case R.id.btn_selecionar3:
                letra3 = labelLetra3.getText().toString();
                btnSelecionar3.setActivated(true);
                break;
            case R.id.btn_selecionar4:
                letra4 = labelLetra4.getText().toString();
                btnSelecionar4.setActivated(true);
                break;
            case R.id.btn_selecionar5:
                letra5 = labelLetra5.getText().toString();
                btnSelecionar5.setActivated(true);
                break;
            case R.id.btn_selecionar6:
                letra6 = labelLetra6.getText().toString();
                btnSelecionar6.setActivated(true);
                break;
            case R.id.btn_selecionar7:
                letra7 = labelLetra7.getText().toString();
                btnSelecionar7.setActivated(true);
                break;
            default:
                break;
        }

        montarNome();
    }

    private void gerarSilabas() {
        silaba = "";
        silaba += consoantes[getRandomNumber(consoantes.length)];
        silaba += vogais[getRandomNumber(vogais.length)];

        int terceiraLetra = getRandomNumber(2);

        if (terceiraLetra == 1) {
            silaba += consoantes[getRandomNumber(consoantes.length)];
        }
    }

    private String gerarLetra() {
        return letras[getRandomNumber(letras.length)];
    }

    private void montarNome() {
        String nome = letra1 + letra2 + letra3 + letra4 + letra5 + letra6 + letra7;
        editNome.setText(nome);
    }

    private int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}