package com.smart.coffee.module;

import com.smart.coffee.model.Pump;
import com.smart.coffee.model.Thermosiphon;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PumpModule {
    @Singleton
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
