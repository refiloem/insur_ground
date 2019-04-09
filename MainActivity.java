package com.financialfitnessbunnies.zakayaka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.InjectView;

/**
 * Created by matlapeng on 2018/04/13.
 */

public class MainActivity extends AppCompatActivity {


    private android.content.Intent intent;
    @InjectView(R.id.loginbtn)

    Button loginbtn;
    Button registerbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button loginButton = (Button) findViewById(R.id.loginbtn);
        final Button registerButton = (Button) findViewById(R.id.registerbtn);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

                registerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, register.class));
                    }
                });
            }
        });

    }
}



