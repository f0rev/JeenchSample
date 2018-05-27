package com.example.ravan.coffeeshop.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;
import com.example.ravan.coffeeshop.repositories.CoffeeRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Philippe on 02/03/2018.
 */

public class CoffeeViewModel extends ViewModel {

    private LiveData<List<CoffeeEntity>> mCoffeeEntities;
    private CoffeeRepository mCoffeeRepo;

    @Inject
    public CoffeeViewModel(CoffeeRepository coffeeRepo) {
        mCoffeeRepo = coffeeRepo;
    }

    public void init() {
//        if (mCoffeeEntities != null) {
//            return;
//        }

        mCoffeeEntities = mCoffeeRepo.getCoffeeEntities();
    }

    public LiveData<List<CoffeeEntity>> getCoffeeEntities() {
        return mCoffeeEntities;
    }
}
