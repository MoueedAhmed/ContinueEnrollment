package com.amoueedned.continueenrollment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageView titleImage;
    private SplashHandler mSplashHandler = new SplashHandler();
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);

        titleImage = findViewById(R.id.imageViewTitle);
        Glide.with(this).load(R.drawable.title_logo).into(titleImage);
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        titleImage.startAnimation(startAnimation);


        mSplashHandler.sendEmptyMessageDelayed(SplashHandler.TIMER_EXPIRED, 3000);
    }

    class SplashHandler extends Handler {
        static final int TIMER_EXPIRED = 100;
        @Override
        public void handleMessage(Message msg) {
            titleImage.setAnimation(null);
            switch (msg.what) {
                case TIMER_EXPIRED:
                    if(mAuth.getCurrentUser()!=null){
                        Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(in);
                        finish();
                    }else{
                        Intent in = new Intent(MainActivity.this, EnrollmentActivity.class);
                        startActivity(in);
                        finish();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        mSplashHandler = null;
        super.onDestroy();
    }
}
