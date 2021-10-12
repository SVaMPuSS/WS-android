package com.example.mytelegram.Chats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mytelegram.CallsActivity;
import com.example.mytelegram.Contact.ContactsActivity;
import com.example.mytelegram.R;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ChatsActivity extends AppCompatActivity {

    private List<Chat> chats;
    private ChatsAdapter adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("asdasdasd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        FillList();

        adapter = new ChatsAdapter(this,chats);

        ((RecyclerView)findViewById(R.id.rvChats)).setAdapter(adapter);

        myRef.setValue("Hello");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(ChatsActivity.this, "Value is: " + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }



    private void FillList() {
        chats = new ArrayList<>();
        Chat chat = new Chat();
        chat.setImageLink("R.drawable.meme");
        chat.setLastMessage("last message1");
        chat.setLastSender("Anton");
        chat.setMessageTime(new GregorianCalendar());
        chat.setName("Chat1");
        chat.setStatus(Chat.DELIVERED);
        chats.add(chat);
        chat = new Chat();
        chat.setImageLink("R.drawable.meme");
        chat.setLastMessage("last message1");
        chat.setLastSender("Anton");
        chat.setMessageTime(new GregorianCalendar());
        chat.setName("Chat1");
        chat.setStatus(Chat.DELIVERED_AND_READ);
        chats.add(chat);
        chat = new Chat();
        chat.setImageLink("R.drawable.meme");
        chat.setLastMessage("last message1");
        chat.setLastSender("Anton");
        chat.setMessageTime(new GregorianCalendar());
        chat.setName("Chat1");
        chat.setLastMessage("last last last last last last last last last last last last last last last last last  message2");
        chats.add(chat);
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