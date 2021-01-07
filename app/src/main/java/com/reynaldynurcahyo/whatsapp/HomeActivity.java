package com.reynaldynurcahyo.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvwa;
    private ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvwa = findViewById(R.id.recview);
        rvwa.setHasFixedSize(true);

        list.addAll(UserData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvwa.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(list);
        rvwa.setAdapter(userAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMenu(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMenu(int itemId) {
        switch (itemId) {
            case R.id.menu_new_group:
                break;
            case R.id.menu_broadcast:
                break;
            case R.id.menu_web:
                break;
            case R.id.menu_starred:
                break;
            case R.id.menu_pref:
                break;
        }
    }
}