package com.example.mytelegram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mytelegram.Chats.Chat;
import com.example.mytelegram.Chats.ChatsAdapter;
import com.example.mytelegram.Contact.ContactsActivity;
import com.example.mytelegram.R;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}