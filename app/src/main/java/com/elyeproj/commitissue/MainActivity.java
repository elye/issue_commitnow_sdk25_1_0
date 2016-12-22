package com.elyeproj.commitissue;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        loadFragment();

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                            loadFragment();
                        }
                    }
                });
    }

    public void loadSubFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.view_container,
                new FragmentSubOne(), FragmentSubOne.TAG).addToBackStack(FragmentSubOne.TAG).commit();
    }

    public void loadFragment() {
        count++;
        if (count % 2 == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.view_container,
                    new FragmentMainOne(), FragmentMainOne.TAG).commitNow();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.view_container,
                    new FragmentMainTwo(), FragmentMainTwo.TAG).commitNow();
        }
    }
}
