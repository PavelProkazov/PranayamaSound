package com.prokazov.pranayamasound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button stopButton;
    private SoundPool sp;
    private MediaPlayer mp = new MediaPlayer();
    private CountDownTimer countDownTimer;
    private TextView textView;

    private Long ilong = Long.valueOf(10);
    private String text_timer = "";


    private EditText editText;

    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;
    private int i = 1;

    private int itemp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.play);
        stopButton = findViewById(R.id.stop);
        editText = findViewById(R.id.editText);
        editText.setText(ilong.toString());
        textView = findViewById(R.id.textView);

        rb1 = findViewById(R.id.RB1);
        rb2 = findViewById(R.id.RB2);
        rb3 = findViewById(R.id.RB3);
        rb4 = findViewById(R.id.RB4);
        rb5 = findViewById(R.id.RB5);
        rb6 = findViewById(R.id.RB6);
        rb7 = findViewById(R.id.RB7);
        //mp = new SoundPool(4,AudioManager.STREAM_MUSIC,1000);

     // AudioAttributes attributes = new AudioAttributes.Builder()
     //         .setUsage(AudioAttributes.USAGE_GAME)
     //         .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
     //         .build();
     // mp = new SoundPool.Builder()
     //         .setAudioAttributes(attributes)
     //         .build();
        //   mp.load(MainActivity.this,R.raw.sound,0);



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((!editText.getText().toString().trim().equals("")))
                {

                    countDownTimer = new CountDownTimer(Long.valueOf(editText.getText().toString())*1000,1000)
                    {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            textView.setText(Long.toString(millisUntilFinished/1000));

                        }

                        @Override
                        public void onFinish() {
                            textView.setText("time is up");
                            mp.stop();


                        }
                    };




                if(rb1.isChecked()) {
                   //  mp.stop(1);
                   // itemp=1;
                   // mp.play(1,1,1,0,0,itemp);
                    if(mp.isPlaying()) {mp.stop();}

                    mp = MediaPlayer.create(MainActivity.this, R.raw.r4x4);

                    mp.start();
                    mp.setLooping(true);
                    countDownTimer.cancel();
                    countDownTimer.start();


                }
                else if(rb2.isChecked()){

                   // mp.stop(1);
                   // itemp=2/2;
                  // mp.play(1,1,1,0,i,itemp);
                    if (mp.isPlaying()) {mp.stop();}
                    mp = MediaPlayer.create(MainActivity.this, R.raw.r5x5);
                    mp.start();
                    mp.setLooping(true);
                    countDownTimer.cancel();
                    countDownTimer.start();


                }
                else if (rb3.isChecked()){

                  //  mp.stop(1);
                  //  itemp=3/2;
                  //  mp.play(1,1,1,0,i,itemp);
                    if(mp.isPlaying()) {mp.stop();}
                    mp = MediaPlayer.create(MainActivity.this, R.raw.r6x6);

                    mp.start();
                    mp.setLooping(true);
                    countDownTimer.cancel();
                    countDownTimer.start();

                }
                else if (rb4.isChecked()){

                  //  mp.stop(1);
                  //  itemp=4/2;
                  //  mp.play(1,1,1,0,i,itemp);
                    if(mp.isPlaying()) {mp.stop();}

                    mp = MediaPlayer.create(MainActivity.this, R.raw.s7x7);


                    mp.start();
                    mp.setLooping(true);
                   countDownTimer.cancel();
                    countDownTimer.start();

                }
                else if (rb5.isChecked()){

                    if(mp.isPlaying()) {mp.stop();}
                    mp = MediaPlayer.create(MainActivity.this, R.raw.r8x8);

                    mp.start();
                    mp.setLooping(true);
                    countDownTimer.cancel();
                    countDownTimer.start();

                }
                else if (rb6.isChecked()){

                    if(mp.isPlaying()) {mp.stop();}
                    mp = MediaPlayer.create(MainActivity.this, R.raw.s9x9);

                    mp.start();
                    mp.setLooping(true);
                   countDownTimer.cancel();
                    countDownTimer.start();

                }
                else if (rb7.isChecked()){

                    if(mp.isPlaying()) {mp.stop();}

                    mp = MediaPlayer.create(MainActivity.this, R.raw.s10x10);


                    mp.start();
                    mp.setLooping(true);
                    countDownTimer.cancel();
                    countDownTimer.start();
                }
                } else {
                    Toast.makeText(MainActivity.this,text_timer , Toast.LENGTH_LONG).show();
                }


            }
        });
    //  playButton.setOnLongClickListener(new View.OnLongClickListener() {
    //      @Override
    //      public boolean onLongClick(View v) {
    //          if(!mp.equals(null)) {
    //              if (mp.isPlaying()) {
    //                  mp.stop();
    //              }
    //          }
    //          if (!countDownTimer.equals(null)) {
    //              countDownTimer.cancel();
    //          }
    //          return false;
    //      }
    //  });
     stopButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(!mp.equals(null)) {
                   if (mp.isPlaying()) {
                       mp.stop();
                   }
               }
               if (!countDownTimer.equals(null)) {
                   countDownTimer.cancel();
             }

           }

       });



    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp.isPlaying()){mp.stop();}

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying()){mp.stop();}
    }
}