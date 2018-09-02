package com.example.jayand_zuch569.srmhack;

import android.content.Intent;
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
                    Toast.makeText(getApplicationContext(), "wrong USERNAME",Toast.LENGTH_LONG).show();
                }
                if(!password.getText().toString().equals("rockers") && !password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "wrong PASSWORD",Toast.LENGTH_LONG).show();
                }
                if(username.getText().toString().equals("") || username.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all needed entities",Toast.LENGTH_LONG).show();
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
