package com.smart.coffee.module;

import com.smart.coffee.model.ElectricHeater;
import com.smart.coffee.model.Heater;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class HeaterModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
