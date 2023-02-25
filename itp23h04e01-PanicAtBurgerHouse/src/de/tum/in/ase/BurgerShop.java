package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class BurgerShop {
    //attributes, constructor, getters and setters
    private List<Burger> orders;
    private Stock stock;

    public BurgerShop() {
        this.orders = new ArrayList<>();
        this.stock = new Stock();

    }

    public List<Burger> getOrders() {
        return orders;
    }

    public void setOrders(List<Burger> orders) {
        this.orders = orders;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }



    public int calculateTotalPrice(Burger burger){
        List<String> burgerIngredients = burger.getIngredients();
        int totalPrice = 0;
        if (!this.stock.getStockIngredients().isEmpty()){

            for (String burgerIngredient: burgerIngredients){
 // if burgerIngredient not in stockIngredient
                totalPrice += this.stock.findStockIngredient(burgerIngredient).getPrice();
            }
        }
        return totalPrice;

   }


    public void acceptSupplyDelivery(String name, int price, int quantity){
        if (this.stock.findStockIngredient(name) == null){
            
            StockIngredient newStock = new StockIngredient(name, price, quantity);
            List<StockIngredient> newStockIng = this.stock.getStockIngredients();
            newStockIng.add(newStock);
            this.stock.setStockIngredients(newStockIng);

        }else{
            for ( int i = 1; i <= quantity; i++){
                this.stock.add(name);
            }

        }


    }

    public void orderBurger(Burger burger){

        ArrayList<Burger> newOrder = new ArrayList<Burger>();
        for (Burger burgers : this.orders){
            newOrder.add(burgers);
        }
        newOrder.add(burger);
        this.orders = newOrder;
        checkOrderReady();


    }

    public void checkOrderReady(){
        List<Burger> unmadeBurgers = new ArrayList<>(List.copyOf(this.orders));

        for ( Burger burger : this.orders){

            List<String> burgerIngredients = burger.getIngredients();
            List<String> usedIngredients = new ArrayList<>();
            boolean available = false;

            for ( String ingredient : burgerIngredients ){

                if ( (this.stock.findStockIngredient(ingredient) != null)
                        && (this.stock.findStockIngredient(ingredient).getQuantity() > 0) ){

                    usedIngredients.add(ingredient);
                    available = true;

                }else {
                    available = false;
                    break;
                }

            }

            if (usedIngredients.containsAll(burgerIngredients)){
                for ( String ingredient: burgerIngredients){
                    this.stock.take(ingredient);
                }
            }

            if(available){
                System.out.println("The order is ready: " + burger.getName());
                unmadeBurgers.remove(burger);
            }else break;

        }

        this.orders = unmadeBurgers;

    }




}
