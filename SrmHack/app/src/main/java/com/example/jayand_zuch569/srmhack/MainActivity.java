package com.example.jayand_zuch569.srmhack;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText username, password;
    TextView newUser;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = findViewById(R.id.imageButton);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        newUser = findViewById(R.id.newUser);

        newUser.setPaintFlags(newUser.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        loginButton = findViewById(R.id.loginbutton);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("rockers") && password.getText().toString().equals("rockers")){
                    Intent intent = new Intent(getApplicationContext(),DashBoard.class);
                    startActivity(intent);
                }
                if(!username.getText().toString().equals("rockers") && !username.getText().toString().equals("")){
                    if (username.getText().toString().trim().equalsIgnoreCase("")) {
                        username.setError("wrong USERNAME");
                    }
                }
                if(!password.getText().toString().equals("rockers") && !password.getText().toString().equals("")){
                    if (password.getText().toString().trim().equalsIgnoreCase("")) {
                        password.setError("wrong PASSWORD");
                    }
                }
                if(username.getText().toString().equals("") || password.getText().toString().equals("")){
                    if (username.getText().toString().trim().equalsIgnoreCase("")) {
                        username.setError("please give your username");
                    }
                    if (password.getText().toString().trim().equalsIgnoreCase("")) {
                        password.setError("please give your password");
                    }
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), newUser.class);
                startActivity(intent);
            }
        });
    }
}
