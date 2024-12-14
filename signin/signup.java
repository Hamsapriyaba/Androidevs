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
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,pwd;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.user);
        pwd=(EditText) findViewById(R.id.pswd);
        signup=(Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=username.getText().toString();
                String userpwd=pwd.getText().toString();
                if(email.matches("")){
                    Toast.makeText(MainActivity.this,"Username cannot be empty",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!isvalidPassword(userpwd)){
                    Toast.makeText(MainActivity.this,"Invalid password",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this, login.class);
                intent.putExtra("email",email);
                intent.putExtra("userpwd",userpwd);
                startActivity(intent);
            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern special=Pattern.compile("^.*[!@#$%^&*(){},.;/].*&");
    private boolean isvalidPassword(String userpwd){
        if(userpwd.length()<8){
            return false;
        }
        if(!lowercase.matcher(userpwd).matches()){
            return false;
        }
        if(!uppercase.matcher(userpwd).matches()){
            return false;
        }
        if(!number.matcher(userpwd).matches()){
            return false;
        }
        if(!special.matcher(userpwd).matches()){
            return false;
        }
        return true;
    }

}
