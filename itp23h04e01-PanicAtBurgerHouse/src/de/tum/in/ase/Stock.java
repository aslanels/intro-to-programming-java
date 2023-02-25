package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    //TODO: Implement Part 1
    private List<StockIngredient> stockIngredients;

    public Stock() {
    this.stockIngredients = new ArrayList<StockIngredient>();
    }

    public Stock(List<StockIngredient> stockIngredients){
        this.stockIngredients = stockIngredients;

    }

    public List<StockIngredient> getStockIngredients() {
        return this.stockIngredients;
    }

    public void setStockIngredients(List<StockIngredient> stockIngredients) {
        this.stockIngredients = stockIngredients;
    }

    //TODO: Implement Part 2

    public int add(String name){
        if ( findStockIngredient(name) != null){
            StockIngredient stock = findStockIngredient(name);
            stock.setQuantity(stock.getQuantity() + 1);
            return  stock.getQuantity();
        }
        return -1;
    }

    public int take(String name){
        if( findStockIngredient(name) != null ){
            StockIngredient stock = findStockIngredient(name);
            if (stock.getQuantity() > 0){
                stock.setQuantity(stock.getQuantity() -1);
                return stock.getQuantity();
            }
        }

        return -1;
    }

    public StockIngredient findStockIngredient(String name){
        for (StockIngredient stockIngredient : stockIngredients) {
            if (stockIngredient.getName().equals(name)) {
                return stockIngredient;
            }
        }
        return null;
    }


}
