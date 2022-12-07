package Queue;

import Customers.Customer;
import Services.DataManager;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
public class Producer implements Runnable{
    // Instance of the data manager passed from main menu
    private DataManager data;
    Scanner inputScanner = new Scanner(System.in);
    // Constructor
    public Producer(DataManager data){
        this.data = data;
    }
    // Function simulating customers arriving to the bank
    @Override
    public void run() {
        // Loops through how many customers to be generated
        for(int i = 0; i < data.getCustomersNumber().intValue(); i++){
            int vipStatus = 0;
            // Creates a new customer instance
            Customer customer = new Customer();
            // Sets customer name from randomly generated name function from built-in API
            customer.setName(data.api.generateName());
            // Checks if its manual mode or automatic mode
            // Manual mode
            if(data.queueMode == 1){
                // Asks the customer if they're regular or VIP
                while (vipStatus <= 0 || vipStatus > 2){
                    System.out.println("Welcome to the bank " + customer.getName());
                    System.out.println("Choose your account class");
                    System.out.println("1- Regular");
                    System.out.println("2- VIP");
                    vipStatus = inputScanner.nextInt();
                }
                vipStatus--;
            }
            // Automatic mode
            else {
                // Randomly assigns VIP or regular status
                vipStatus = ThreadLocalRandom.current().nextInt(0, 2);
            }
            // Formulates a regular customer
            if(vipStatus == 0){
                // Sets customer to regular
                customer.setVip(false);
                // Gives customer an ID/Ticker number
                customer.setId(new AtomicInteger(i + 1));
                // Output message in case of automatic mode
                if(data.queueMode == 2){
                    System.out.println("Welcome to the bank regular customer " + customer.getName());
                }
                System.out.println("Your ticket number is " + customer.getId() + " there are " + (data.VIPCustomersArray.size() + data.regularCustomersArray.size()) + " customers ahead of you");
                // Puts the customer in regular queue
                try {
                    data.regularCustomersArray.put(customer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Simulates time taken for a customer to arrive to the bank so not all generated customers arrive at once
                // but at a random interval
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 1200));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
            // Formulates a VIP customer
            else{
                // Sets customer status to VIP
                customer.setVip(true);
                // Gives customer an ID/Ticker number
                customer.setId(new AtomicInteger(i + 1));
                // Output message in automatic mode
                if(data.queueMode == 2){
                    System.out.println("Welcome to the bank VIP customer " + customer.getName());
                }
                System.out.println("Your ticket number is " + customer.getId() + " there are " + (data.VIPCustomersArray.size()) + " customers ahead of you");
                // Puts customer in VIP queue
                try {
                    data.VIPCustomersArray.put(customer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Simulates time taken for a customer to arrive to the bank so not all generated customers arrive at once
                // but at a random interval
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200, 1200));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread Interrupted");
                }
            }
        }
    }
}
