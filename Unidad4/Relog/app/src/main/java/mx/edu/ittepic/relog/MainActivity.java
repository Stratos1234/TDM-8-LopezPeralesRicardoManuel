package mx.edu.ittepic.relog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String mensaje;
    MediaPlayer inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Relog(this));
        inicio = MediaPlayer.create(this, R.raw.reloj);
        inicio.start();

    }



    public class Relog extends View {
        private final long TIEMPO_REFRESCO = 20; // 20 o 1000 velocidad de refresco
        private Paint ColorFondoPintura;
        private Paint ManesillaPintura;
        private Paint Letrass;
        private Paint fondo1;
        private Paint bola;

        public Relog(Context context) {
            super(context);
            init(context, null);
            mensaje = "12";


        }

        public Relog(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context, attrs);

        }

        public Relog(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context, attrs);
        }

        private void init(Context context, AttributeSet attrs) {
            ColorFondoPintura = new Paint();
            ColorFondoPintura.setColor(Color.rgb(47, 79, 79));
            ColorFondoPintura.setAntiAlias(true);
            ManesillaPintura = new Paint();
            ManesillaPintura.setColor(Color.rgb(25, 25, 112));
            ManesillaPintura.setAntiAlias(true);
            Letrass = new Paint();
            Letrass.setColor(Color.rgb(0, 128, 128));
            Letrass.setTextSize(60);
            fondo1=new Paint();
            bola=new Paint();
            bola.setColor(Color.WHITE);


        }


        private Runnable invalidator = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            Paint p = new Paint();
            canvas.drawText(mensaje, 100, 100, p);

            canvas.drawRGB(0,0,200);
            fondo2(canvas);
            dibujarFondo(canvas);
            dibjarManecillaHora(canvas);
            dibjarManecillaMinutos(canvas);
            dibjarManecillaSegundos(canvas);
            dibujarUna(canvas);
            letra(canvas);
            letra2(canvas);
            letra3(canvas);
            letra4(canvas);
            letra5(canvas);
            letra6(canvas);
            letra7(canvas);
            letra8(canvas);
            letra9(canvas);
            letra10(canvas);
            letra11(canvas);
            letra12(canvas);
            letra13(canvas);
            postDelayed(invalidator, TIEMPO_REFRESCO);
        }

        private void letra(Canvas canvas) {
            canvas.drawText("12", 500, 180, Letrass);
        }

        private void letra2(Canvas canvas) {
            canvas.drawText("1", 700, 250, Letrass);
        }

        private void letra3(Canvas canvas) {
            canvas.drawText("2", 810, 370, Letrass);
        }

        private void letra4(Canvas canvas) {
            canvas.drawText("3", 890, 550, Letrass);
        }

        private void letra5(Canvas canvas) {
            canvas.drawText("4", 810, 720, Letrass);
        }

        private void letra6(Canvas canvas) {
            canvas.drawText("5", 720, 850, Letrass);
        }

        private void letra7(Canvas canvas) {
            canvas.drawText("6", 540, 920, Letrass);
        }

        private void letra8(Canvas canvas) {
            canvas.drawText("7", 360, 850, Letrass);
        }

        private void letra9(Canvas canvas) {
            canvas.drawText("8", 220, 700, Letrass);
        }

        private void letra10(Canvas canvas) {
            canvas.drawText("9", 180, 520, Letrass);
        }

        private void letra11(Canvas canvas) {
            canvas.drawText("10", 170, 360, Letrass);
        }

        private void letra12(Canvas canvas) {
            canvas.drawText("11", 260, 240, Letrass);
        }
        private void letra13(Canvas canvas) {
            canvas.drawText("ROLEX", 450, 270, Letrass);
        }
        private void fondo2(Canvas canvas) {
            Bitmap fondoportada= BitmapFactory.decodeResource(getResources(),R.drawable.fondo9);
            canvas.drawBitmap(fondoportada,0,0,null);
        }


        private void dibjarManecillaHora(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.2f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloHora();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibujarFondo(Canvas canvas) {
            float circuloFondo = getHeight() / 4f;
            canvas.drawCircle(545, 530, 440, ColorFondoPintura);
        }

        private void dibjarManecillaMinutos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.3f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloMinutos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibjarManecillaSegundos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.4f;
            float espesor = getWidth() * 0.005f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloSegundos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private float getX(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio + manoRadio * Math.sin(angulo));
        }

        private float getY(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio - manoRadio * Math.cos(angulo));
        }

        private void dibujarUna(Canvas canvas) {

            canvas.drawCircle(550, 540, 40, bola);
        }

        private double getAnguloHora() {
            Calendar c = Calendar.getInstance();
            int horas = c.get(Calendar.HOUR);
            int minutos = c.get(Calendar.MINUTE);
            int minutosInicio = horas * 60 + minutos;
            return (2 * Math.PI * minutosInicio) / 720; //Minutos en 12 horas
        }

        private double getAnguloMinutos() {
            Calendar c = Calendar.getInstance();
            int segundosDesdeElInicio = c.get(Calendar.MINUTE) * 60 + c.get(Calendar.SECOND);
            return (2 * Math.PI * segundosDesdeElInicio) / 3600; // Divide los segundos en una hora
        }

        private double getAnguloSegundos() {
            Calendar c = Calendar.getInstance();
            int millisFromStart = c.get(Calendar.SECOND) * 1000 + c.get(Calendar.MILLISECOND);
            return (2 * Math.PI * millisFromStart) / 60000; // Milisegundos en 1 mnuto
        }
    }


}


