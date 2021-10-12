package com.example.mytelegram.Contact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytelegram.CallsActivity;
import com.example.mytelegram.Chats.ChatsActivity;
import com.example.mytelegram.R;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    private List<Contact> Contacts;
    private ContactsAdapter ContactsAdapter;

    private char[] charForSearch = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private final int COUNT_CHARACTERS = 26;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Contacts = new ArrayList<>();
        FillContacts();
        ContactsAdapter = new ContactsAdapter(this, Contacts);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvContacts);
        recyclerView.setAdapter(ContactsAdapter);

        TextView tv = findViewById(R.id.tvSymbolsForSort);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int buf = tv.getWidth() / (tv.getText().length() / 2);
//                Toast.makeText(ContactsActivity.this, String.valueOf(charForSearch[(int)event.getX()/buf]), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    private void FillContacts() {
        Contact contact = new Contact();
        contact.setName("Вася");
        contact.setImage("R.drawable.icon_meme.jpg");
        Contacts.add(contact);
        Contacts.add(contact);
        Contacts.add(contact);
        Contacts.add(contact);
        Contacts.add(contact);
        Contacts.add(contact);
    }

    public void OnClickChangeNavigation(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.ibCalls:
                intent = new Intent(this, CallsActivity.class);
                break;
            case R.id.ibChats:
                intent = new Intent(this, ChatsActivity.class);
                break;
            case R.id.ibContacts:
                intent = new Intent(this, ContactsActivity.class);
                break;
        }
        startActivity(intent);
    }
}