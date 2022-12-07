package Queue;

import Customers.Customer;
import Services.DataManager;
import java.util.concurrent.ThreadLocalRandom;
public class Consumer implements Runnable {
    // Instance of the data manager passed from main menu
    private DataManager data;
    // Constructor
    public Consumer(DataManager data) {
        this.data = data;
    }
    // Function of tellers serving customers
    @Override
    public void run() {
        // Generated a random agent name for the teller through the built-in API
        String agentName = data.api.generateName();
        // The thread that keeps working as long as there are customers present
        while (data.customerNumber2.intValue() > 0){
            // Creates a customer instance
            Customer customer;
            try {
                // Priotrizes VIP by checking if no VIP customers are present the teller serves a regular customer if present
                if(data.VIPCustomersArray.isEmpty()){
                    if(!data.regularCustomersArray.isEmpty()){
                        // Formulates customer from the regular customers queue
                        customer = data.regularCustomersArray.take();
                        System.out.println("(SERVING) "+"Ticker number: " + customer.getId() + " regular customer " + customer.getName() + " its your turn, please head to agent " + agentName + " booth");
                        // Random time of how long it takes to serve the customer
                        try {
                            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
                            System.out.println("(SERVED) "+"Ticket number: " + customer.getId() + " regular customer " + customer.getName() + " got served by agent " + agentName);
                            // Decreases amount of customers by one
                            data.customerNumber2.decrementAndGet();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Thread Interrupted");
                        }
                    }
                }
                else {
                    // Formulates customer from the VIP customers queue
                    customer = data.VIPCustomersArray.take();
                    System.out.println("(SERVING) "+"Ticker number: " + customer.getId() + " VIP customer " + customer.getName() + " its your turn, please head to agent " + agentName + " booth");
                    // Random time of how long it takes to serve the customer
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
                        System.out.println("(SERVED) "+"Ticket number: " + customer.getId() +" VIP customer " + customer.getName() + " got served by agent " + agentName);
                        // Decreases amount of customers by one
                        data.customerNumber2.decrementAndGet();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Thread Interrupted");
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
