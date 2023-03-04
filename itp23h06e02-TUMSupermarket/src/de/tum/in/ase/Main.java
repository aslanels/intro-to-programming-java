package de.tum.in.ase;

public class Main {
    public static void main(String[] args) {

    TUMSupermarket myMarket = new TUMSupermarket(3);
    Queue<Customer> q1 = GenerateCustomers(10);

    for (int i=0; i<myMarket.getCheckouts().length; i++){
        myMarket.getCheckouts()[i].setCustomers(q1);
    }

    // Checkout c1 = new Checkout(q1)


    }

    public static Queue<Customer> GenerateCustomers(int amount){

        Queue<Customer> customerQueue = new LinkedQueue<>();

        for (int i = 0; i < amount; i++){
            customerQueue.enqueue(new Customer("Test" + i ,10 + i));

        }

        return customerQueue;
    }

}
