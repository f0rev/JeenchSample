package com.example.ravan.coffeeshop.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ravan.coffeeshop.database.dao.CoffeeDao;
import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;

@Database(entities = {CoffeeEntity.class}, version = 1)
public abstract class CoffeeDatabase extends RoomDatabase{

    //singleton
    private static volatile CoffeeDatabase INSTANCE;

    //dao
    public abstract CoffeeDao coffeeDao();
}
