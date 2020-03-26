package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import static android.icu.lang.UCharacter.toUpperCase;

public class MainActivity extends AppCompatActivity {

        int state;
        int counter = 0;
        String num;
        ConstraintLayout cl;
        TableLayout tableLayout;
        private Button thirysec;
        private Button fortysec;
        private Button sixtysex;
        private long Start_Time_In_Milis = 31000;
        private TextView mTextviewcountdown;
        private TextView fTextviewcountdown;
        private Button mButtonStart;
        private Button mButtonReset;
        private CountDownTimer fCountdowntimer;
        private CountDownTimer mCountdowntimer;
        private boolean mTimerRunning = false;
        private boolean fTimerRunning = false;
        private long mTimeLeftInMilis = Start_Time_In_Milis;
        private long fTimeLeftInMilis = 6000;


    public void PriceActivity1 (View v){
        Intent i = new Intent(this,PriceActivity1.class);
        startActivity(i);
    }

    public void PriceActivity2 (View v){
        Intent i = new Intent(this,PriceActivity2.class);
        startActivity(i);
    }

    public void PriceActivity3 (View v){
        Intent i = new Intent(this,PriceActivity3.class);
        startActivity(i);
    }

    public void PriceActivity4 (View v){
        Intent i = new Intent(this,PriceActivity4.class);
        startActivity(i);
    }

    public void PriceActivity5 (View v){
        Intent i = new Intent(this,PriceActivity5.class);
        startActivity(i);
    }

    public void PriceActivity6 (View v){
        Intent i = new Intent(this,PriceActivity6.class);
        startActivity(i);
    }

    public void blink() {
        ConstraintLayout cl =  findViewById(R.id.myview);
        final TransitionDrawable background = (TransitionDrawable) cl.getBackground();
        background.startTransition(700);
    }

    public void revblink() {
        ConstraintLayout cl =  findViewById(R.id.myview);
        final TransitionDrawable background = (TransitionDrawable) cl.getBackground();
        background.reverseTransition(700);
    }



    public void thirty(View view) {
        String time="00:30";
        mButtonReset =  findViewById(R.id.NewGameButton);
        thirysec =  findViewById(R.id.thirty);
        fortysec= findViewById(R.id.forty);
        sixtysex= findViewById(R.id.sixty);
        tableLayout= findViewById(R.id.tableLayout);
        if (!mTimerRunning &&!fTimerRunning ) {
            mButtonReset.setTag(1);
            cl =  findViewById(R.id.myview);
            cl.setBackgroundResource(R.drawable.background);
            cl.setBackgroundResource(R.drawable.backroundtransition);
            Start_Time_In_Milis = 31000;
            mTimeLeftInMilis = 31000;
            mTextviewcountdown.setText(time);
            tableLayout.setVisibility(View.VISIBLE);
            mTextviewcountdown.setVisibility(View.INVISIBLE);
            mTextviewcountdown.setAlpha(0);
            mTextviewcountdown.setTextColor(Color.parseColor("#F5DC49"));
            mButtonStart.setVisibility(View.VISIBLE);
            thirysec.setBackgroundResource(R.drawable.selectedtimebuttondesign);
            fortysec.setBackgroundResource(R.drawable.timebuttondesign);
            sixtysex.setBackgroundResource(R.drawable.timebuttondesign);
            Resethighlights();
            resetballs();

        }
    }

    public void fortyfive(View view) {
        String time="00:45";
        mButtonReset =  findViewById(R.id.NewGameButton);
        thirysec =  findViewById(R.id.thirty);
        fortysec= findViewById(R.id.forty);
        sixtysex= findViewById(R.id.sixty);
        tableLayout= findViewById(R.id.tableLayout);
        if (!mTimerRunning &&!fTimerRunning) {
            mButtonReset.setTag(1);
            cl =  findViewById(R.id.myview);
            cl.setBackgroundResource(R.drawable.background);
            cl.setBackgroundResource(R.drawable.backroundtransition);
            Start_Time_In_Milis = 46000;
            mTimeLeftInMilis = 46000;
            mTextviewcountdown.setText(time);
            tableLayout.setVisibility(View.VISIBLE);
            mTextviewcountdown.setVisibility(View.INVISIBLE);
            mTextviewcountdown.setAlpha(0);
            mTextviewcountdown.setTextColor(Color.parseColor("#F5DC49"));
            mButtonStart.setVisibility(View.VISIBLE);
            thirysec.setBackgroundResource(R.drawable.timebuttondesign);
            fortysec.setBackgroundResource(R.drawable.selectedtimebuttondesign);
            sixtysex.setBackgroundResource(R.drawable.timebuttondesign);
            Resethighlights();
            resetballs();

        }
    }

    public void oneminute(View view) {
        String time="01:00";
        mButtonReset =  findViewById(R.id.NewGameButton);
        thirysec =  findViewById(R.id.thirty);
        fortysec= findViewById(R.id.forty);
        sixtysex=findViewById(R.id.sixty);
        tableLayout= findViewById(R.id.tableLayout);
        if (!mTimerRunning&&!fTimerRunning) {

            mButtonReset.setTag(1);
            cl =  findViewById(R.id.myview);
            cl.setBackgroundResource(R.drawable.background);
            cl.setBackgroundResource(R.drawable.backroundtransition);
            Start_Time_In_Milis = 61000;
            mTimeLeftInMilis = 61000;
            mTextviewcountdown.setText(time);
            tableLayout.setVisibility(View.VISIBLE);
            mTextviewcountdown.setVisibility(View.INVISIBLE);
            mTextviewcountdown.setAlpha(0);
            mTextviewcountdown.setTextColor(Color.parseColor("#F5DC49"));
            mButtonStart.setVisibility(View.VISIBLE);
            thirysec.setBackgroundResource(R.drawable.timebuttondesign);
            fortysec.setBackgroundResource(R.drawable.timebuttondesign);
            sixtysex.setBackgroundResource(R.drawable.selectedtimebuttondesign);
            Resethighlights();
            resetballs();
        }
    }

    public void clicked(View view) {

        Button button = (Button) view;

        num = button.getText().toString();

        state = Integer.parseInt(button.getTag().toString());
        if (!mTimerRunning && Integer.parseInt(mButtonReset.getTag().toString()) == 1) {
            if (counter <= 5 && state == 1) {
                button.setBackgroundResource(R.drawable.blue);
                button.setTag(2);
                addhighlightball(num);
                //addhighlightball(view, num);

                counter++;
            }
            // else Toast.makeText(this, "thats it!", Toast.LENGTH_SHORT).show();
            if (state == 2) {
                button.setBackgroundResource(R.drawable.yellow);
                button.setTag(1);
                removehighlightball( num);
                counter--;
            }
        }
    }

    public void addhighlightball( String num) {
        Button highlight1 =  findViewById(R.id.highlight1);
        Button highlight2 =  findViewById(R.id.highlight2);
        Button highlight3 =  findViewById(R.id.highlight3);
        Button highlight4 =  findViewById(R.id.highlight4);
        Button highlight5 =  findViewById(R.id.highlight5);
        Button highlight6 =  findViewById(R.id.highlight6);
        if (Integer.parseInt(highlight1.getTag().toString()) == 1) {
            highlight1.setText(num);
            highlight1.setTag(2);
        } else if (Integer.parseInt(highlight2.getTag().toString()) == 1) {
            highlight2.setText(num);
            highlight2.setTag(2);
        } else if (Integer.parseInt(highlight3.getTag().toString()) == 1) {
            highlight3.setText(num);
            highlight3.setTag(2);
        } else if (Integer.parseInt(highlight4.getTag().toString()) == 1) {
            highlight4.setText(num);
            highlight4.setTag(2);
        } else if (Integer.parseInt(highlight5.getTag().toString()) == 1) {
            highlight5.setText(num);
            highlight5.setTag(2);
        } else if (Integer.parseInt(highlight6.getTag().toString()) == 1) {
            highlight6.setText(num);
            highlight6.setTag(2);
        }

    }

    public void removehighlightball( String num) {
        Button highlight1 =  findViewById(R.id.highlight1);
        Button highlight2 =  findViewById(R.id.highlight2);
        Button highlight3 =  findViewById(R.id.highlight3);
        Button highlight4 =  findViewById(R.id.highlight4);
        Button highlight5 =  findViewById(R.id.highlight5);
        Button highlight6 =  findViewById(R.id.highlight6);
        if (Integer.parseInt(highlight6.getTag().toString()) == 2 && highlight6.getText().toString().equals(num)) {
            highlight6.setText("");
            highlight6.setTag(1);
        } else if (Integer.parseInt(highlight5.getTag().toString()) == 2 && highlight5.getText().toString().equals(num)) {
            highlight5.setText("");
            highlight5.setTag(1);
        } else if (Integer.parseInt(highlight4.getTag().toString()) == 2 && highlight4.getText().toString().equals(num)) {
            highlight4.setText("");
            highlight4.setTag(1);
        } else if (Integer.parseInt(highlight3.getTag().toString()) == 2 && highlight3.getText().toString().equals(num)) {
            highlight3.setText("");
            highlight3.setTag(1);
        } else if (Integer.parseInt(highlight2.getTag().toString()) == 2 && highlight2.getText().toString().equals(num)) {
            highlight2.setText("");
            highlight2.setTag(1);
        } else if (Integer.parseInt(highlight1.getTag().toString()) == 2 && highlight1.getText().toString().equals(num)) {
            highlight1.setText("");
            highlight1.setTag(1);
        }

    }

    public void Resethighlights() {
        Button highlight1 =  findViewById(R.id.highlight1);
        Button highlight2 =  findViewById(R.id.highlight2);
        Button highlight3 =  findViewById(R.id.highlight3);
        Button highlight4 =  findViewById(R.id.highlight4);
        Button highlight5 =  findViewById(R.id.highlight5);
        Button highlight6 =  findViewById(R.id.highlight6);
        highlight1.setText("");
        highlight2.setText("");
        highlight3.setText("");
        highlight4.setText("");
        highlight5.setText("");
        highlight6.setText("");
        highlight1.setTag("1");
        highlight2.setTag("1");
        highlight3.setTag("1");
        highlight4.setTag("1");
        highlight5.setTag("1");
        highlight6.setTag("1");
    }

    public void resetballs() {
        counter = 0;
        Button ball1 =  findViewById(R.id.ball1);
        Button ball2 =  findViewById(R.id.ball2);
        Button ball3 = findViewById(R.id.ball3);
        Button ball4 =  findViewById(R.id.ball4);
        Button ball5 =  findViewById(R.id.ball5);
        Button ball6 =  findViewById(R.id.ball6);
        Button ball7 =  findViewById(R.id.ball7);
        Button ball8 =  findViewById(R.id.ball8);
        Button ball9 = findViewById(R.id.ball9);
        Button ball10 =  findViewById(R.id.ball10);
        Button ball11 =  findViewById(R.id.ball11);
        Button ball12 =  findViewById(R.id.ball12);
        Button ball13 =  findViewById(R.id.ball13);
        Button ball14 =  findViewById(R.id.ball14);
        Button ball15 =  findViewById(R.id.ball15);
        Button ball16 =  findViewById(R.id.ball16);
        Button ball17 =  findViewById(R.id.ball17);
        Button ball18 =  findViewById(R.id.ball18);
        Button ball19 =  findViewById(R.id.ball19);
        Button ball20 =  findViewById(R.id.ball20);
        Button ball21 =  findViewById(R.id.ball21);
        Button ball22 =  findViewById(R.id.ball22);
        Button ball23 =  findViewById(R.id.ball23);
        Button ball24 =  findViewById(R.id.ball24);
        Button ball25 =  findViewById(R.id.ball25);
        Button ball26 =  findViewById(R.id.ball26);
        Button ball27 =  findViewById(R.id.ball27);
        Button ball28 =  findViewById(R.id.ball28);
        Button ball29 =  findViewById(R.id.ball29);
        Button ball30 =  findViewById(R.id.ball30);
        Button ball31 =  findViewById(R.id.ball31);
        ball1.setBackgroundResource(R.drawable.yellow);
        ball2.setBackgroundResource(R.drawable.yellow);
        ball3.setBackgroundResource(R.drawable.yellow);
        ball4.setBackgroundResource(R.drawable.yellow);
        ball5.setBackgroundResource(R.drawable.yellow);
        ball6.setBackgroundResource(R.drawable.yellow);
        ball7.setBackgroundResource(R.drawable.yellow);
        ball8.setBackgroundResource(R.drawable.yellow);
        ball9.setBackgroundResource(R.drawable.yellow);
        ball10.setBackgroundResource(R.drawable.yellow);
        ball11.setBackgroundResource(R.drawable.yellow);
        ball12.setBackgroundResource(R.drawable.yellow);
        ball13.setBackgroundResource(R.drawable.yellow);
        ball14.setBackgroundResource(R.drawable.yellow);
        ball15.setBackgroundResource(R.drawable.yellow);
        ball16.setBackgroundResource(R.drawable.yellow);
        ball17.setBackgroundResource(R.drawable.yellow);
        ball18.setBackgroundResource(R.drawable.yellow);
        ball19.setBackgroundResource(R.drawable.yellow);
        ball20.setBackgroundResource(R.drawable.yellow);
        ball21.setBackgroundResource(R.drawable.yellow);
        ball22.setBackgroundResource(R.drawable.yellow);
        ball23.setBackgroundResource(R.drawable.yellow);
        ball24.setBackgroundResource(R.drawable.yellow);
        ball25.setBackgroundResource(R.drawable.yellow);
        ball26.setBackgroundResource(R.drawable.yellow);
        ball27.setBackgroundResource(R.drawable.yellow);
        ball28.setBackgroundResource(R.drawable.yellow);
        ball29.setBackgroundResource(R.drawable.yellow);
        ball30.setBackgroundResource(R.drawable.yellow);
        ball31.setBackgroundResource(R.drawable.yellow);
        ball1.setTag(1);
        ball2.setTag(1);
        ball3.setTag(1);
        ball4.setTag(1);
        ball5.setTag(1);
        ball6.setTag(1);
        ball7.setTag(1);
        ball8.setTag(1);
        ball9.setTag(1);
        ball10.setTag(1);
        ball11.setTag(1);
        ball12.setTag(1);
        ball13.setTag(1);
        ball14.setTag(1);
        ball15.setTag(1);
        ball16.setTag(1);
        ball17.setTag(1);
        ball18.setTag(1);
        ball19.setTag(1);
        ball20.setTag(1);
        ball21.setTag(1);
        ball22.setTag(1);
        ball23.setTag(1);
        ball24.setTag(1);
        ball25.setTag(1);
        ball26.setTag(1);
        ball27.setTag(1);
        ball28.setTag(1);
        ball29.setTag(1);
        ball30.setTag(1);
        ball31.setTag(1);

    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button ball31= findViewById(R.id.ball31);
        mTextviewcountdown = findViewById(R.id.textviewcountdown);
        fTextviewcountdown = findViewById(R.id.ftextview);
        mButtonStart = findViewById(R.id.StartButton);
        mButtonReset = findViewById(R.id.NewGameButton);
        tableLayout= findViewById(R.id.tableLayout);


        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 6) {
                    fstartTimer();
                    fTextviewcountdown.setVisibility(View.VISIBLE);
                    mButtonStart.setVisibility(View.INVISIBLE);
                    tableLayout.setVisibility(View.INVISIBLE);
                    ball31.setVisibility(View.INVISIBLE);
                    //mButtonStart.animate().alpha(1).setDuration(3000);
                    mButtonReset.setTag(2);
                } else
                    Toast.makeText(MainActivity.this, "Pick 6 Numbers!", Toast.LENGTH_SHORT).show();
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout cl = findViewById(R.id.myview);
                cl.setBackgroundResource(R.drawable.background);
                cl.setBackgroundResource(R.drawable.backroundtransition);
                resetTimer();
                fresetTimer();
                mTimeLeftInMilis = Start_Time_In_Milis;
                mButtonStart.setVisibility(View.VISIBLE);
                mTextviewcountdown.setVisibility(View.INVISIBLE);
                mTextviewcountdown.setAlpha(0);
                fTextviewcountdown.setVisibility(View.INVISIBLE);
                mButtonStart.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.VISIBLE);
                Resethighlights();
                resetballs();
                mTimerRunning = false;
                fTimerRunning=false;
                mTextviewcountdown.setTextColor(Color.parseColor("#F5DC49"));
                mButtonReset.setTag(1);

            }
        });
        updatecountdowntext();
        fupdatecountdowntext();
    }

    private void startTimer() {
        mTextviewcountdown.setVisibility(View.VISIBLE);
mTextviewcountdown.animate().alpha(1).setDuration(1000);
        final Button BallOne=  findViewById(R.id.ball_oneB);
        final Button BallTwo=  findViewById(R.id.ball_twoB);
        final Button BallThree=  findViewById(R.id.ball_threeB);
        final Button BallFour=  findViewById(R.id.ball_fourB);
        final Button BallFive=  findViewById(R.id.ball_fiveB);
        final Button BallSix=  findViewById(R.id.ball_sixB);
        mCountdowntimer = new CountDownTimer(mTimeLeftInMilis, 1000) {

            @Override

            public void onTick(long millisUntilFinished) {
                mTimeLeftInMilis = millisUntilFinished;



                updatecountdowntext();

                if (millisUntilFinished < 11000 && millisUntilFinished > 10100) {
                    blink();
                    mTextviewcountdown.setTextColor(0xfffc0317);
                }
                if (millisUntilFinished < 10000 && millisUntilFinished > 9100)
                    revblink();
                if (millisUntilFinished < 9000 && millisUntilFinished > 8100)
                    blink();
                if (millisUntilFinished < 8000 && millisUntilFinished > 7100)
                    revblink();
                if (millisUntilFinished < 7000 && millisUntilFinished > 6100)
                    blink();
                if (millisUntilFinished < 6000 && millisUntilFinished > 5100)
                    revblink();
                if (millisUntilFinished < 5000 && millisUntilFinished > 4100)
                    blink();
                if (millisUntilFinished < 4000 && millisUntilFinished > 3100)
                    revblink();
                if (millisUntilFinished < 3000 && millisUntilFinished > 2100)
                    blink();
                if (millisUntilFinished < 2000 && millisUntilFinished > 1100)
                    revblink();
                if (millisUntilFinished < 1000 && millisUntilFinished > 300)
                    blink();


            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                BallOne.setVisibility(View.VISIBLE);
                BallTwo.setVisibility(View.VISIBLE);
                BallThree.setVisibility(View.VISIBLE);
                BallFour.setVisibility(View.VISIBLE);
                BallFive.setVisibility(View.VISIBLE);
                BallSix.setVisibility(View.VISIBLE);
            }
        }.start();
        mTimerRunning = true;

    }

    private void resetTimer() {
        mTimeLeftInMilis = Start_Time_In_Milis;
        updatecountdowntext();
        if (mTimerRunning)
        mCountdowntimer.cancel();
    }

    private void updatecountdowntext() {
        int minutes = (int) (mTimeLeftInMilis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMilis / 1000) % 60;
        String timeLeft = (String.format("%02d:%02d", minutes, seconds));

        mTextviewcountdown.setText(timeLeft);
    }

    private void fstartTimer(){

        fCountdowntimer = new CountDownTimer(fTimeLeftInMilis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                fTimeLeftInMilis=millisUntilFinished;
                fupdatecountdowntext();
            }

            @Override
            public void onFinish() {
                fTextviewcountdown.setVisibility(View.INVISIBLE);

                mTextviewcountdown.setVisibility(View.VISIBLE);

                fTimerRunning=false;

                    startTimer();

            }
        }.start();
fTimerRunning=true;
    }

    private void fupdatecountdowntext() {
        int seconds = (int) (fTimeLeftInMilis / 1000);
        String ready="READY";
        String set = "SET";
        String go= "GO!";
        String ftimeLeft = String.format("%d", seconds);
        if (seconds==2)
            fTextviewcountdown.setText(ready);
        else if (seconds==1)
            fTextviewcountdown.setText(set);
        else if (seconds==0)
            fTextviewcountdown.setText(go);
            else
        fTextviewcountdown.setText(ftimeLeft);
    }

    private void fresetTimer() {

        fTimeLeftInMilis = 6000;
        fupdatecountdowntext();
        if (fTimerRunning)
        fCountdowntimer.cancel();

    }
}
