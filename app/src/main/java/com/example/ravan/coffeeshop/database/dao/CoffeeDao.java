package com.example.ravan.coffeeshop.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ravan.coffeeshop.database.entity.CoffeeEntity;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface CoffeeDao {

    @Insert(onConflict = REPLACE)
    void saveCoffeeEntities(List<CoffeeEntity> coffeeEntities);

    @Query("select * from CoffeeEntity")
    LiveData<List<CoffeeEntity>> loadCoffeeEntities();

    @Query("select * from CoffeeEntity where id = :id")
    CoffeeEntity getItembyId(String id);
}
