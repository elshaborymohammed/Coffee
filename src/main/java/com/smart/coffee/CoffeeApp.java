package com.smart.coffee;

import com.smart.coffee.component.CoffeeMakerComponent;
import com.smart.coffee.component.HeaterComponent;

public class CoffeeApp {

    public static void main(String[] args) {
        CoffeeMakerComponent coffeeMakerComponent = com.smart.coffee.component.DaggerCoffeeMakerComponent.builder().build();
        coffeeMakerComponent.maker().brew();

        HeaterComponent heaterComponent = com.smart.coffee.component.DaggerHeaterComponent.builder().build();
        heaterComponent.heat().on();
    }
}