package de.tum.in.ase;

public class Customer {
    //      attributes
    private String name;
    private double money;
    private Stack<Product> productsInBasket;

    /**
     * @param name cannot be null -> throw IllegalArgumentException
     * @param money cannot be negative -> throw IllegalArgumentException
     */
    public Customer(String name, double money) {
        if (name == null || money <0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.money = money;
        this.productsInBasket = new LinkedStack<>();
    }

    //      getters
    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public Stack<Product> getProductsInBasket() {
        return productsInBasket;
    }

    //      methods

    /**
     *
     * @return true if the money attribute is greater than 0.
     */
    public boolean hasMoney(){
        return money > 0;
    }

    /**
     * remove the amount to pay from the money attribute
     * @param amount if insufficient or negative -> UnsupportedOperationException
     */
    public void pay(double amount){
        if ( (money < amount) || (amount < 0)){
            throw new UnsupportedOperationException();
        }

        money = money - amount;
    }

    /**
     *
     * @param product push to basket (stack)
     */
    public void addProductToBasket(Product product){
        productsInBasket.push(product);
    }

    /**
     * This method should move the elements from the Customer basket (Stack) to the given product band (Queue).
     *  Hint: Stack uses LIFO principle and Queue uses FIFO principle.
     * @param band queue
     */
    public void placeAllProductsOnBand(Queue<Product> band){
        int count = productsInBasket.size();

        if (count > 0){
            for (int i=0; i < count; i++){
                Product p = productsInBasket.pop();
                band.enqueue(p);
            }
        }

    }

    /**
     * Here the products should be put back in the Customers basket (Stack) and be removed from the product band (Queue).
     * Implement this method analogously to the one from 2.
     * @param band queue
     */
    public void takeAllProductsFromBand(Queue<Product> band){
        int count = band.size();

        if (count > 0){
            for (int i=0; i < count; i++){
                Product p = band.dequeue();
                productsInBasket.push(p);
            }
        }
    }

    /**
     *The customer should choose the Checkout with the shortest Queue and enqueue herself/himself to the other customers.
     * @param supermarket if null -> IllegalArgumentException
     */
    public void goToCheckout(TUMSupermarket supermarket){
        if (supermarket == null){
            throw new IllegalArgumentException();
        }
        supermarket.getCheckoutWithSmallestQueue().getCustomers().enqueue(this);
    }


    @Override
    public String toString() {
        return "Customer: " + name + ", money: " + money + "\n" + productsInBasket;
    }

}
