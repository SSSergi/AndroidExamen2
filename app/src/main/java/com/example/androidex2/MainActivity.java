package com.example.androidex2;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView sky1;
    private ImageView sky2;
    private ImageView sky3;
    private ImageView ZaSun;

    //ObjectAnimator -> Proporciona soporte para animar objetos
    private ObjectAnimator animatorY;
    private ObjectAnimator animatorAlpha;

    private long animationDuration=3000;
    private long sky1t=500;
    private long sky2t=3000;
    private long sky3t=5000;

    //AnimatorSet -> Reproduce conjunto de ObjectAnimator en orden específicado. Se puede todas animaciones a la vez.
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZaSun=(ImageView) findViewById(R.id.ivSun);
        sky1=(ImageView) findViewById(R.id.sky1);
        sky2=(ImageView) findViewById(R.id.sky2);
        sky3=(ImageView) findViewById(R.id.sky3);
        sky1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("sun");
                animacion("sky1");
                animacion("sky2");
                animacion("sky3");
            }
        });


    }

    private void animacion(String animacion) {
        switch (animacion) {
            case "sun":
                animatorY = ObjectAnimator.ofFloat(ZaSun, "y", 1000f);
                animatorY.setDuration(animationDuration);
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.play(animatorY);
                animatorSetY.start();
                break;

            case "sky1":
                animatorAlpha = ObjectAnimator.ofFloat(sky1, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(sky1t);
                AnimatorSet animatorSetAlphaS1 = new AnimatorSet();
                animatorSetAlphaS1.play(animatorAlpha);
                animatorSetAlphaS1.start();
                break;

            case "sky2":
                animatorAlpha = ObjectAnimator.ofFloat(sky2, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(sky2t);
                AnimatorSet animatorSetAlphaS2 = new AnimatorSet();
                animatorSetAlphaS2.play(animatorAlpha);
                animatorSetAlphaS2.start();
                break;

            case "sky3":
                animatorAlpha = ObjectAnimator.ofFloat(sky3, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(sky3t);
                AnimatorSet animatorSetAlphaS3 = new AnimatorSet();
                animatorSetAlphaS3.play(animatorAlpha);
                animatorSetAlphaS3.start();
                break;
                
/*           case "sky1":
                TransitionDrawable transition=(TransitionDrawable) getResources().getDrawable(R.drawable.sky1);
                AnimatorSet animatorSetS1=new AnimatorSet();
                transition.startTransition(4000);
                break;
*/
        }
    }
}


//Color Sol : android:color="#FFFFE0"