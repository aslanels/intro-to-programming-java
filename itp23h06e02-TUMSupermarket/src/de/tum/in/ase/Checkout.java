package de.tum.in.ase;

public class Checkout {
    //      attributes
    private Queue<Customer> customers = new LinkedQueue<>();
    private Queue<Product> bandBeforeCashier = new LinkedQueue<>();
    private Queue<Product> bandAfterCashier = new LinkedQueue<>();

    //      constructors
    public Checkout() {
    }

    public Checkout(LinkedQueue<Customer> customers, LinkedQueue<Product> bandBeforeCashier, LinkedQueue<Product> bandAfterCashier) {
        this.customers = customers;
        this.bandBeforeCashier = bandBeforeCashier;
        this.bandAfterCashier = bandAfterCashier;
    }

    //      methods

    /**
     *
     * @return customer queue length
     */
    public int customerQueueLength(){
        return customers.size();
    }

    /**
     * if empty -> UnsupportedOperationException
     * next Customer should be dequeued from the Queue and put all his/her products on the band before the cashier.
     *  After that every product from the current customer should be scanned and added to the Queue after the cashier.
     *  customer should then put the products back in their basket
     *  After all products have been scanned, the total sum should be payed by the Customer.
     */
    public void serveNextCustomer(){
        if (customers.isEmpty()){
            throw new UnsupportedOperationException();
        }
        Customer nextCustomer = customers.dequeue();
        nextCustomer.placeAllProductsOnBand(bandBeforeCashier);

        int productCount = bandBeforeCashier.size();
        double productPrice = 0;

        if (productCount > 0){
            for (int i=0; i < productCount; i++){
                Product p = bandBeforeCashier.dequeue();
                productPrice += p.getPrice();
                bandAfterCashier.enqueue(p);
            }
        }

        nextCustomer.takeAllProductsFromBand(bandAfterCashier);
        nextCustomer.pay(productPrice);
    }



    //      getters and setters

    public Queue<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Queue<Customer> customers) {
        this.customers = customers;
    }

    public Queue<Product> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public void setBandBeforeCashier(Queue<Product> bandBeforeCashier) {
        this.bandBeforeCashier = bandBeforeCashier;
    }

    public Queue<Product> getBandAfterCashier() {
        return bandAfterCashier;
    }

    public void setBandAfterCashier(Queue<Product> bandAfterCashier) {
        this.bandAfterCashier = bandAfterCashier;
    }
}
