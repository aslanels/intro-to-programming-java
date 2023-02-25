package de.tum.in.ase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //TODO: Test your solution here
    public static void main(String[] args) {

     List<String> ingredients = List.of(new String[]{"cheese", "meat", "bread"});
     Burger cheeseBurger = new Burger("CheeseBurger", ingredients);

     List<String> ingredients2 = List.of(new String[]{"cheese", "veggie", "bread"});
     Burger veggie = new Burger("VeggieBurger", ingredients2);

     List<Burger> orders = List.of(new Burger[]{cheeseBurger, veggie});

     StockIngredient cheese = new StockIngredient("cheese", 1, 10);
     StockIngredient meat = new StockIngredient("meat", 2, 10);
     StockIngredient bread = new StockIngredient("bread", 3, 10);

     List<StockIngredient> stockIngredients = List.of(new StockIngredient[]{cheese, meat, bread});

     Stock stock = new Stock();
     stock.setStockIngredients(stockIngredients);

     BurgerShop burgerShop = new BurgerShop();
     burgerShop.setOrders(orders);
     burgerShop.setStock(stock);


     burgerShop.orderBurger(cheeseBurger);



     //System.out.println(burgerShop.calculateTotalPrice(veggie));


     burgerShop.acceptSupplyDelivery("cheese",10,1);
     for(StockIngredient stockIngredient : stock.getStockIngredients() ){
         System.out.println(stockIngredient.getQuantity());
    }

    }






}
