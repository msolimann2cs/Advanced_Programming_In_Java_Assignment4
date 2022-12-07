package Customers;

import java.util.concurrent.atomic.AtomicInteger;
// Customer class
public class Customer {
    // Customer name
    String name;
    // Customer VIP or regular status
    boolean vip;
    // Customer ID/Ticker number
    AtomicInteger id;
    // --------------------------------------- Setters and getters ---------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public void setId(AtomicInteger id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public boolean getVipStatus(){
        return vip;
    }
    public AtomicInteger getId() {
        return id;
    }
}
