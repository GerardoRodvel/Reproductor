package com.e.reproductorpro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //MediaPlayer miReproductor;
    MediaPlayer mp;
    Button play_pause;
    ImageView iv;
    int posicion = 0;
    TextView txtNombreSong;
    TextView txtAutor;
    MediaPlayer vectormp [] = new MediaPlayer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = (Button)findViewById(R.id.btnPlay);
        final Button btnStop = findViewById(R.id.btnStop);
         iv = (ImageView)findViewById(R.id.imageView);
        final Button btnSiguiente = findViewById(R.id.btnSiguiente);
        txtNombreSong = (TextView) findViewById(R.id.txtNombreSong);
        txtAutor = (TextView) findViewById(R.id.txtAutor);


        vectormp[0] = MediaPlayer.create(MainActivity.this,R.raw.fisher);
        txtNombreSong.setText("Losing it");
        txtAutor.setText("Fisher");
        vectormp[1] = MediaPlayer.create(MainActivity.this,R.raw.tunnel);
        vectormp[2] = MediaPlayer.create(MainActivity.this,R.raw.malaa);
        vectormp[3] = MediaPlayer.create(MainActivity.this,R.raw.kungs);
        vectormp[4] = MediaPlayer.create(MainActivity.this,R.raw.stupead);

        //miReproductor = MediaPlayer.create(MainActivity.this,R.raw.cancion);
    /*
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mensaje = Toast.makeText(getApplicationContext(),"reproduciendo",Toast.LENGTH_SHORT);
                mensaje.show();
                miReproductor.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast mensaje2 = Toast.makeText(getApplicationContext(),"deteniendo",Toast.LENGTH_SHORT);
                mensaje2.show();
                miReproductor.stop();
            }
        });
        */
    }


    //metodo para el boton play_pause
    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this,"pausa",Toast.LENGTH_SHORT).show();

        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }

    } //de metodo

    //metodo para el boton stop
    public void Stop(View view){

        if (vectormp[posicion] != null){
            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(MainActivity.this,R.raw.fisher);
            vectormp[1] = MediaPlayer.create(MainActivity.this,R.raw.tunnel);
            vectormp[2] = MediaPlayer.create(MainActivity.this,R.raw.malaa);
            vectormp[3] = MediaPlayer.create(MainActivity.this,R.raw.kungs);
            vectormp[4] = MediaPlayer.create(MainActivity.this,R.raw.stupead);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            txtNombreSong.setText("Losing it");
            txtAutor.setText("Fisher");
            iv.setImageResource(R.drawable.fisher);

            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        }

    } // de metodo

    //metodo siguiente cancion
    public void Suguiente(View view){
        if (posicion < vectormp.length -1  ){

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();

                if (posicion == 0){
                    iv.setImageResource(R.drawable.fisher);
                }else if (posicion == 1){
                    txtNombreSong.setText("Tunnel vision");
                    txtAutor.setText("Zonderling");
                    iv.setImageResource(R.drawable.tunnel);
                }else if (posicion == 2){
                    txtNombreSong.setText("Notorious");
                    txtAutor.setText("Mala");
                    iv.setImageResource(R.drawable.malaa);
                }else if (posicion == 3){
                    txtNombreSong.setText("I feel so bad");
                    txtAutor.setText("Kungs");
                    iv.setImageResource(R.drawable.kungs);
                }else if (posicion == 4){
                    txtNombreSong.setText("Let me know");
                    txtAutor.setText("Stupead");
                    iv.setImageResource(R.drawable.stupead);
                }


            }else{
                posicion++;
                //cambio de portadas
                if (posicion == 0){
                    iv.setImageResource(R.drawable.fisher);
                }else if (posicion == 1){
                    txtNombreSong.setText("Tunnel vision");
                    txtAutor.setText("Zonderling");
                    iv.setImageResource(R.drawable.tunnel);
                }else if (posicion == 2){
                    txtNombreSong.setText("Notorious");
                    txtAutor.setText("Mala");
                    iv.setImageResource(R.drawable.malaa);
                }else if (posicion == 3){
                    txtNombreSong.setText("I feel so bad");
                    txtAutor.setText("Kungs");
                    iv.setImageResource(R.drawable.kungs);
                }else if (posicion == 4){
                    txtNombreSong.setText("Let me know");
                    txtAutor.setText("Stupead");
                    iv.setImageResource(R.drawable.stupead);
                }

            }

        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
            //vectormp[0] = MediaPlayer.create(MainActivity.this,R.raw.fisher);
            //vectormp[posicion].start();

        }
    }// de metodo


    //metodo cancion anterior
    public void Anterior(View view){
        if (posicion >=1){

            if (vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(MainActivity.this,R.raw.fisher);
                vectormp[1] = MediaPlayer.create(MainActivity.this,R.raw.tunnel);
                vectormp[2] = MediaPlayer.create(MainActivity.this,R.raw.malaa);
                vectormp[3] = MediaPlayer.create(MainActivity.this,R.raw.kungs);
                vectormp[4] = MediaPlayer.create(MainActivity.this,R.raw.stupead);
                posicion--;
                //cambio de portadas
                if (posicion == 0){
                    txtNombreSong.setText("Losing it");
                    txtAutor.setText("Fisher");
                    iv.setImageResource(R.drawable.fisher);
                }else if (posicion == 1){
                    txtNombreSong.setText("Tunnel vision");
                    txtAutor.setText("Zonderling");
                    iv.setImageResource(R.drawable.tunnel);
                }else if (posicion == 2){
                    txtNombreSong.setText("Notorious");
                    txtAutor.setText("Mala");
                    iv.setImageResource(R.drawable.malaa);
                }else if (posicion == 3){
                    txtNombreSong.setText("I feel so bad");
                    txtAutor.setText("Kungs");
                    iv.setImageResource(R.drawable.kungs);
                }else if (posicion == 4){
                    txtNombreSong.setText("Let me know");
                    txtAutor.setText("Stupead");
                    iv.setImageResource(R.drawable.stupead);
                }

                vectormp[posicion].start();

            }else{
                posicion--;
                //cambio de portada
                if (posicion == 0){
                    txtNombreSong.setText("Losing it");
                    txtAutor.setText("Fisher");
                    iv.setImageResource(R.drawable.fisher);
                }else if (posicion == 1){
                    txtNombreSong.setText("Tunnel vision");
                    txtAutor.setText("Zonderling");
                    iv.setImageResource(R.drawable.tunnel);
                }else if (posicion == 2){
                    txtNombreSong.setText("Notorious");
                    txtAutor.setText("Mala");
                    iv.setImageResource(R.drawable.malaa);
                }else if (posicion == 3){
                    txtNombreSong.setText("I feel so bad");
                    txtAutor.setText("Kungs");
                    iv.setImageResource(R.drawable.kungs);
                }else if (posicion == 4){
                    txtNombreSong.setText("Let me know");
                    txtAutor.setText("Stupead");
                    iv.setImageResource(R.drawable.stupead);
                }

            }

        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();

        }

    } //de metodo

} //de cierre
