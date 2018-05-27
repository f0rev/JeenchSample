package com.example.ravan.coffeeshop.fragments;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravan.coffeeshop.R;
import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;
import com.example.ravan.coffeeshop.internet.ConnectionLiveData;
import com.example.ravan.coffeeshop.viewmodels.CoffeeViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

public class CoffeeListFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    Application mContext;
    @Inject
    ConnectionLiveData mConnectionLiveData;

    @BindView(R.id.coffeelist)
    RecyclerView mCoffeelist;
    Unbinder unbinder;

    private CoffeeViewModel mCoffeeViewModel;
    private CoffeeItemsAdapter mCoffeeItemsAdapter;
    private static final int WifiData = 1;
    private static final int MobileData = 0;

    public CoffeeListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        configureList();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureDagger();
        configureViewModel();
        mConnectionLiveData.observe(this, connection -> {
            if (connection.getIsConnected()) {
                if (mCoffeeViewModel.getCoffeeEntities().getValue() != null) {
                    if (mCoffeeViewModel.getCoffeeEntities().getValue().size() == 0)
                        mCoffeeViewModel.init();
                }
                switch (connection.getType()) {
                    case WifiData:
                        Toast.makeText(mContext, String.format("Wifi turned ON"), Toast.LENGTH_SHORT).show();
                        break;
                    case MobileData:
                        Toast.makeText(mContext, String.format("Mobile data turned ON"), Toast.LENGTH_SHORT).show();
                        break;
                }
            } else {
                Toast.makeText(mContext, String.format("Connection turned OFF"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void configureDagger() {
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel() {
        mCoffeeViewModel = ViewModelProviders.of(this, viewModelFactory).get(CoffeeViewModel.class);
        mCoffeeViewModel.init();
        mCoffeeViewModel.getCoffeeEntities().observe(this, this::updateUI);
    }


    private void configureList() {
        mCoffeelist.setLayoutManager(new LinearLayoutManager(mContext));
        mCoffeeItemsAdapter = new CoffeeItemsAdapter(this);
        mCoffeelist.setAdapter(mCoffeeItemsAdapter);
    }

    private void updateUI(List<CoffeeEntity> coffeeEntities) {
        mCoffeeItemsAdapter.updateData(coffeeEntities);
    }

}
