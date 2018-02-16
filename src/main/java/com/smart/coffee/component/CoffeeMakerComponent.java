package com.smart.coffee.component;

import com.smart.coffee.CoffeeMaker;
import com.smart.coffee.module.HeaterModule;
import com.smart.coffee.module.PumpModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        //DripCoffeeModule.class
        HeaterModule.class, PumpModule.class
})
public interface CoffeeMakerComponent {
    CoffeeMaker maker();
}
