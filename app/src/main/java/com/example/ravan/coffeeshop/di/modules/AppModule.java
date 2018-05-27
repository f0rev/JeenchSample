package com.example.ravan.coffeeshop.di.modules;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.ravan.coffeeshop.activities.MainActivity;
import com.example.ravan.coffeeshop.api.CoffeeWebservice;
import com.example.ravan.coffeeshop.database.CoffeeDatabase;
import com.example.ravan.coffeeshop.database.dao.CoffeeDao;
import com.example.ravan.coffeeshop.internet.ConnectionLiveData;
import com.example.ravan.coffeeshop.internet.ConnectionModel;
import com.example.ravan.coffeeshop.repositories.CoffeeRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = ViewModelModule.class)
public class AppModule {

    //database injection
    @Provides
    @Singleton
    CoffeeDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                CoffeeDatabase.class, "CoffeeDatabase.db")
                .build();
    }
    @Provides
    @Singleton
    CoffeeDao provideUserDao(CoffeeDatabase database) { return database.coffeeDao(); }

    //repository injection
    @Provides
    @Singleton
    CoffeeRepository provideCoffeeRepository(CoffeeWebservice webservice, CoffeeDao coffeeDao) {
        return new CoffeeRepository(webservice, coffeeDao);
    }

    //network injection
    private static String BASE_URL = "https://api.jeench.com/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    CoffeeWebservice provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(CoffeeWebservice.class);
    }

    @Provides
    @Singleton
    ConnectionLiveData provideConnectionLiveData(Application application){
        return new ConnectionLiveData( application);
    }

}
