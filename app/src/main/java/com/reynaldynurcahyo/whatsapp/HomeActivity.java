package com.reynaldynurcahyo.whatsapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayoutMediator;
import com.reynaldynurcahyo.whatsapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    private String[] titles = {
            "CHATS",
            "STATUS",
            "CALLS"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        getSupportActionBar().setElevation(0);
        binding.viewPager.setAdapter(new ViewPagerFragmentAdapter(this));

        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> tab.setText(titles[position])).attach();
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

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {
        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new ChatFragment();
                case 1:
                    return new StatusFragment();
                case 2:
                    return new CallFragment();
            }
            return new ChatFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}