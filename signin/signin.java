package com.example.signup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    EditText euername,epwd;
    Button login;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        euername=(EditText) findViewById(R.id.loginuser);
        epwd=(EditText) findViewById(R.id.loginpswd);
        login=(Button) findViewById(R.id.login);
        String regemail=getIntent().getStringExtra("email");
        String regpwd=getIntent().getStringExtra("userpwd");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newemail=euername.getText().toString();
                String newpwd=epwd.getText().toString();
                if(regemail.equals(newemail) && regpwd.equals(newpwd)){
                    Toast.makeText(login.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(login.this, homepage.class);
                    startActivity(intent);
                    euername.setText("");
                    epwd.setText("");
                }
                else{
                    count++;
                    Toast.makeText(login.this,"Login Failed "+count,Toast.LENGTH_LONG).show();
                    if(count==3){
                        login.setEnabled(false);
                        Toast.makeText(login.this,"Login Failed "+count,Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
