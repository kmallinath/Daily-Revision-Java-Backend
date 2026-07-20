package com.learn.springbootbasics.proxies;

public class Skoda implements Car{
    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String getCompanyName() {
        return "Skoda" ;
    }

    @Override
    public int getWarranty(int dateOdPurchase) {
        return dateOdPurchase+10;
    }
}
