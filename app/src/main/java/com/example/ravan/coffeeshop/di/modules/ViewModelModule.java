package com.example.ravan.coffeeshop.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.ravan.coffeeshop.di.key.ViewModelKey;
import com.example.ravan.coffeeshop.viewmodels.CoffeeViewModel;
import com.example.ravan.coffeeshop.viewmodels.FactoryViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoffeeViewModel.class)
    abstract ViewModel bindCoffeeViewModel(CoffeeViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
