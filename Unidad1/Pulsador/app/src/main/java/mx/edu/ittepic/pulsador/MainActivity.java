package mx.edu.ittepic.pulsador;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button boton, boton2, reiniciado;
    TextView numero;
    float random, nfinal, avance, cap;
    String bien, bien2, bien3;
    CountDownTimer timer;
    MediaPlayer inicio;
    int numero2 = 0, numero3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.btn1);
        numero = findViewById(R.id.txtnumero);
        boton2 = findViewById(R.id.btn2);
        reiniciado = findViewById(R.id.reincio);
        avance = 0;
        boton2.setEnabled(false);
        reiniciado.setVisibility(View.GONE);
        final DecimalFormat df = new DecimalFormat("#.0");
        random = (float) (Math.random() * 3);
        bien = df.format(random);
        numero.setText("" + bien);
        nfinal = Float.parseFloat(bien);

        timer = new CountDownTimer(10000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                avance = (float) (avance + 0.1);
                bien2 = df.format(avance);
                boton.setText("" + bien2);

                if (avance >= 2.9) {
                    avance = (float) 0.0;
                }

            }

            @Override
            public void onFinish() {
                timer.start();

            }
        };
        timer.start();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bien3 = bien2;
                cap = Float.parseFloat(bien3);
                if (nfinal == cap) {
                    Toast.makeText(MainActivity.this, "Buen trabajo " + "\n" + "Salvaste a la Humanidad", Toast.LENGTH_SHORT).show();
                    timer.cancel();
                    boton2.setVisibility(View.VISIBLE);
                    boton2.setEnabled(true);
                    boton.setEnabled(false);
                    inicio = MediaPlayer.create(MainActivity.this, R.raw.cumplido);
                    inicio.start();


                } else {
                    numero3 = numero3 - 1;
                    Toast.makeText(MainActivity.this, "Sigue intentando" + "\n" + "Te quedan:" + numero3 + "intentos", Toast.LENGTH_SHORT).show();
                    boton2.setEnabled(false);
                    numero2 = numero2 + 1;
                    if (numero2 == 3) {

                        numero3 = 3;
                        numero2 = 0;
                        Toast.makeText(MainActivity.this, "Perdiste :(", Toast.LENGTH_SHORT).show();
                        reiniciado.setVisibility(View.VISIBLE);
                        timer.cancel();
                        boton.setEnabled(false);
                        inicio = MediaPlayer.create(MainActivity.this, R.raw.gameover);
                        inicio.start();
                    }
                }


            }
        });

        reiniciado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciado.setVisibility(View.GONE);
                boton2.setEnabled(true);


            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = (float) (Math.random() * 3);
                bien = df.format(random);
                numero.setText("" + bien);
                nfinal = Float.parseFloat(bien);
                timer.start();
                //boton2.setVisibility(View.GONE);
                boton2.setEnabled(false);
                boton.setEnabled(true);
                inicio.stop();

            }
        });
    }
}