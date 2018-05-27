package com.example.ravan.coffeeshop.repositories;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.ravan.coffeeshop.api.CoffeeWebservice;
import com.example.ravan.coffeeshop.database.dao.CoffeeDao;
import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.schedulers.Schedulers;

/**
 * Created by Philippe on 02/03/2018.
 */

@Singleton
public class CoffeeRepository {

    private final CoffeeWebservice mWebservice;
    private final CoffeeDao mCoffeeDao;

    @Inject
    public CoffeeRepository(CoffeeWebservice webservice, CoffeeDao coffeeDao) {
        mWebservice = webservice;
        mCoffeeDao = coffeeDao;
    }

    public LiveData<List<CoffeeEntity>> getCoffeeEntities() {
        refreshData();
        return mCoffeeDao.loadCoffeeEntities();
    }

    @SuppressLint("CheckResult")
    private void refreshData() {
        mWebservice.getSearchItems()
                .subscribeOn(Schedulers.io())
                .subscribe(apiResponse -> {
                    List<CoffeeEntity> coffeeItems = apiResponse.getMessage();
                    mCoffeeDao.saveCoffeeEntities(coffeeItems);
                },
                        throwable -> Log.d("refreshData: ",   throwable.getLocalizedMessage()));
    }
}
