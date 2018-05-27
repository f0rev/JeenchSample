package com.example.ravan.coffeeshop.di;

import android.app.Application;

import com.example.ravan.coffeeshop.CoffeeshopApp;
import com.example.ravan.coffeeshop.di.modules.ActivityModule;
import com.example.ravan.coffeeshop.di.modules.AppModule;
import com.example.ravan.coffeeshop.di.modules.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules={ActivityModule.class, FragmentModule.class, AppModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(CoffeeshopApp app);
}
