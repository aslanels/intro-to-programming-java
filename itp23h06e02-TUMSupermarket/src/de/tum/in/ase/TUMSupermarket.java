package de.tum.in.ase;


public class TUMSupermarket {
    //      attributes
    private Checkout[] checkouts;

    /**
     * Create a new Checkout array. Initialize the array-elements with newly created object.
     * @param numberOfCheckouts if 0 or smaller -> IllegalArgumentException
     */
    public TUMSupermarket(int numberOfCheckouts) {
        if (numberOfCheckouts <= 0){
            throw new IllegalArgumentException();
        }
        this.checkouts = new Checkout[numberOfCheckouts];

        for (int i=0; i < numberOfCheckouts; i++){
            checkouts[i] = new Checkout();
        }
    }

    //      methods

    /**
     *
     * @return the Checkout with the smallest Queue of waiting customers.
     */
    public Checkout getCheckoutWithSmallestQueue(){

        Checkout checkoutWithSmallestQueue = checkouts[0];

        for (Checkout checkout : checkouts) {
            if (checkout.customerQueueLength() < checkoutWithSmallestQueue.customerQueueLength()) {
                checkoutWithSmallestQueue = checkout;
            }
        }
        return checkoutWithSmallestQueue;
    }

    /**
     * For each Checkout the next Customer should be served.
     */
    public void serveCustomers(){

        for (Checkout checkout: checkouts){
            checkout.serveNextCustomer();
        }
    }

    /**
     * delete the Checkout-object with the given index.
     * decrease the size of the Checkout array by 1 (-> there has to be no null-value in it)
     * it should contain all the other Checkout-objects in the same order as before.
     * all Customers from the removed Checkout must go to the next-shortest Queue.
     * @param index if it doesn't exist IllegalArgumentException
     * NOTE:Pay attention that the last Customer of the deleted Checkout is the first who leaves the Queue.
     */

    public void closeCheckout(int index){

        if (index < 0 || index > checkouts.length){
            throw new IllegalArgumentException();
        }

        Checkout removedCheckout = checkouts[index];
        Checkout[] newCheckouts = new Checkout[checkouts.length - 1];
        int j = 0;
        for (int i=0; i < newCheckouts.length; i++){
            if (i != index){
               newCheckouts[j] = checkouts[i];
               j++;
            }
        }

        this.checkouts = newCheckouts;
        Queue<Customer> movedCustomers = removedCheckout.getCustomers();

        for (int i=0; i<movedCustomers.size(); i++){
            getCheckoutWithSmallestQueue().getCustomers().enqueue(movedCustomers.dequeue());
        }
    }


    //      getters and setters


    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Checkout[] checkouts) {
        this.checkouts = checkouts;
    }
}
