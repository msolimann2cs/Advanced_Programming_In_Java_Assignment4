package Screens;

import Queue.Consumer;
import Queue.Producer;
import Services.DataManager;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainMenu {
    // Responsible for handing the variables and other services
    DataManager data = new DataManager();
    Scanner inputScanner = new Scanner(System.in);
    // Generates the queue of people coming into the bank
    Producer producer = new Producer(data);
    // Generated the tellers handling customers
    Consumer consumer = new Consumer(data);
    // Buffer service for safe multi-threading
    ExecutorService buffer = Executors.newCachedThreadPool();
    // Core of the program
    public void MainMenuPropmt(){
        // Asks bank admistrative details
        if(data.getCustomersNumber().intValue() == 0 && data.getTellersNumber() == 0){
            EntryMessage();
        }
        // Creates one thread for the producer (Simulating customers arriving to the bank)
        for(int i = 0; i < 1; i++){
            buffer.execute(producer);
        }
        // Creates N threads for the number of tellers chosen
        for(int i = 0; i < data.getTellersNumber(); i++){
            buffer.execute(consumer);
        }
    }
    void EntryMessage(){
        // Allows user to choose manual or automatic mode
        // Manual mode allows user to choose if customer is VIP or regular
        // Automatic mode randomly assigns VIP/regular status for the customers instead
        while (data.queueMode < 1 || data.queueMode > 2){
            System.out.println("1- Manual Mode, 2- Automatic Mode");
            data.queueMode = inputScanner.nextInt();
        }
        // Asks user how many customers are present that day
        while (data.getCustomersNumber().intValue() <= 0){
            System.out.println("Input how many customers are present");
            int num = inputScanner.nextInt();
            data.setCustomersNumber(num);
            data.customerNumber2.set(num);
        }
        // Asks user how many tellers are present that day
        while (data.getTellersNumber() <= 0){
            System.out.println("Input how many tellers are present");
            data.setTellersNumber(inputScanner.nextInt());
        }
    }
}
