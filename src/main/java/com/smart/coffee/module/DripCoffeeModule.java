package com.smart.coffee.module;

import com.smart.coffee.model.ElectricHeater;
import com.smart.coffee.model.Heater;
import com.smart.coffee.model.Pump;
import com.smart.coffee.model.Thermosiphon;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class DripCoffeeModule {
    @Provides
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }

    @Singleton
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
