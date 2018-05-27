package com.example.ravan.coffeeshop.activities;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ravan.coffeeshop.R;
import com.example.ravan.coffeeshop.fragments.CoffeeListFragment;
import com.example.ravan.coffeeshop.internet.ConnectionLiveData;
import com.example.ravan.coffeeshop.internet.ConnectionModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureDagger();

        showFragment(savedInstanceState);


    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private void showFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {

            CoffeeListFragment fragment = new CoffeeListFragment();


            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_fragment_container, fragment, null)
                    .commit();
        }
    }


    private void configureDagger() {
        AndroidInjection.inject(this);
    }

}
