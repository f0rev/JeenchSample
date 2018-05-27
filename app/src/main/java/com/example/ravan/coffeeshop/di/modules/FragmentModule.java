package com.example.ravan.coffeeshop.di.modules;

import com.example.ravan.coffeeshop.fragments.CoffeeListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract CoffeeListFragment contributeCoffeeListFragment();
}
