package com.smart.coffee.component;

import com.smart.coffee.model.ElectricHeater;
import com.smart.coffee.model.Heater;
import com.smart.coffee.module.HeaterModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = HeaterModule.class)
public interface HeaterComponent {
    Heater heat();
}
