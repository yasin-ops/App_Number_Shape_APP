package com.muhammadyaseenfatimamazharsarfarz.appnumbershape;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
private AdView adView;

    class Number {
        int num;


        public boolean istri() {

            int sum = 0;

            for (int n = 1; sum <= num; n++) {
                sum = sum + n;
                if (sum == num)
                    return true;
            }

            return false;

        }

        public boolean isSquare() {
            int a = (int) Math.sqrt(num);
            if (a * a == num) {
                return true;
            } else {
                return false;
            }
        }
    }


    public void numberGuess(View view) {
        EditText userguess = (EditText) findViewById(R.id.userguess);
        if (userguess.getText().toString().isEmpty()) {
            Toasty.info(this, "Please enter a number", Toast.LENGTH_SHORT).show();
        } else {
            Number mynumber = new Number();
            mynumber.num = Integer.parseInt(userguess.getText().toString());

            if (mynumber.isSquare()) {
                if (mynumber.istri()) {
                    Toasty.info(this, "both triangular and square number", Toast.LENGTH_SHORT).show();


                } else {
                    Toasty.normal(MainActivity.this,
                            "Square Number",
                            Toast.LENGTH_LONG,
                            ContextCompat.getDrawable(MainActivity.this,
                                    R.drawable.triangle)).show();


                }

            } else if (mynumber.istri()) {
                Toasty.normal(MainActivity.this,
                        "Triangle Number",
                        Toast.LENGTH_LONG,
                        ContextCompat.getDrawable(MainActivity.this,
                                R.drawable.triangle)).show();


            } else {
                Toasty.info(this, "either triangular and square", Toast.LENGTH_SHORT).show();


            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adView=findViewById(R.id.adView);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }
}