package com.example.mytelegram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytelegram.CallsFavorites.CallFavorite;
import com.example.mytelegram.CallsFavorites.CallsFavoritesAdapter;
import com.example.mytelegram.Chats.ChatsActivity;
import com.example.mytelegram.Contact.ContactsActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CallsActivity extends AppCompatActivity {

    private TabLayout Mode;
    private RecyclerView calls;
    private List<CallFavorite> callsList;
    private CallsFavoritesAdapter favoritesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);
        calls = findViewById(R.id.rvCalls);
        Mode = findViewById(R.id.tlMode);
        Mode.addOnTabSelectedListener(ChangeTabListener());
        TabLayout.Tab Tab = Mode.getTabAt(1);
        Tab.select();
    }

    private TabLayout.OnTabSelectedListener ChangeTabListener() {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //@TODO загружать разный контент на разные вкладки


                //имеется проблема tab.getId() - возвращает -1
                //скорее всего tab - не создаётся
                switch (tab.getText().toString()) {
                    case "All":
                        FillCalls();
                        favoritesAdapter = new CallsFavoritesAdapter(getApplicationContext(), callsList);
                        calls.setAdapter(favoritesAdapter);
                        break;
                    case "Favorites":

                        break;
                    case "Missed":

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

    private void FillCalls() {
        callsList = new ArrayList<>();
        CallFavorite cf = new CallFavorite();
        cf.setName("Петя петрович");
        cf.setCallDuration(5);
        cf.setImageLink("R.id.icon_meme.jpg");
        cf.setTypeResponse(CallFavorite.ACCEPT_CALL);
        cf.setTimeCall(new GregorianCalendar());

        callsList.add(cf);
        callsList.add(cf);
        callsList.add(cf);
        callsList.add(cf);
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