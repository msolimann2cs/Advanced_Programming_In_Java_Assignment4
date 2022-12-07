package Services;

import Customers.Customer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
public class DataManager {
    public API api = new API();
    // Decides manual or automatic mode
    public int queueMode = 0;
    // Amount of customers chosen
    private AtomicInteger customersNumber = new AtomicInteger(0);
    public AtomicInteger customerNumber2 = new AtomicInteger(0);
    // Amount of tellers chosen
    private int tellersNumber = 0;
    // Queue for regular customers
    public BlockingQueue<Customer> regularCustomersArray = new ArrayBlockingQueue<>(3);
    // Queue for VIP customers
    public BlockingQueue<Customer> VIPCustomersArray = new ArrayBlockingQueue<>(5);
    // --------------------------------------- Setters and getters ---------------------------------
    public AtomicInteger getCustomersNumber() {
        return customersNumber;
    }
    public int getTellersNumber() {
        return tellersNumber;
    }
    public void setCustomersNumber(int customersNumber) {
        this.customersNumber.set(customersNumber);;
    }
    public void setTellersNumber(int tellersNumber) {
        this.tellersNumber = tellersNumber;
    }

}
