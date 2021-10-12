package com.example.mytelegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mytelegram.Contact.ContactsActivity;

public class LogInActivity extends AppCompatActivity {

    private EditText Login;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Login = findViewById(R.id.etLogin);
        Password = findViewById(R.id.etPassword);
        findViewById(R.id.bSignIn).setOnClickListener(v -> StartContactActivity());

        int i = 0;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
        i++;
    }

    private void StartContactActivity(){
//        if () {
            Intent data = new Intent(this, ContactsActivity.class);
            startActivity(data);
            finish();
//        }
    }
}