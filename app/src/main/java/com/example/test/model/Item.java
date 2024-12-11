package com.example.test.model;

import java.time.LocalDateTime;
import java.time.LocalDate;


public class Item {
    //variable
    private String stockTitle;
    private String SBuydate;
    private LocalDate Buydate;

    private float buyprice;
    private int stockAmount;
    private float nowPrice;
    private float profitLoss;
    private float returnRate;

    public Item(String stockTitle, String SBuydate, float buyprice, int stockAmount, float nowPrice) {
        this.stockTitle = stockTitle;
        this.SBuydate = SBuydate;
        this.buyprice = buyprice;
        this.stockAmount = stockAmount;
        this.nowPrice = nowPrice;
        this.profitLoss = calculateProfitLoss();
        this.returnRate = calculateReturnRate();
    }





    // getter and setter
    public String getTitle() { return stockTitle; }
    public void setTitle(String title) { this.stockTitle = title; }

    public String getSBuydate() { return SBuydate; }
    public void setSBuydate(String SBuydate) { this.SBuydate = SBuydate; }

    public float getBuyprice() { return buyprice; }
    public void setBuyprice(float buyprice) { this.buyprice = buyprice; }

    public int getStockAmount() { return stockAmount; }
    public void setStockAmount(int stockAmount) { this.stockAmount = stockAmount; }

    public float getNowPrice() { return nowPrice; }
    public void setNowPrice(float nowPrice) { this.nowPrice = nowPrice; }

    public float getProfitLoss() { return profitLoss; }
    public float getReturnRate() { return returnRate; }

    //calculate
    private float calculateProfitLoss(){
        return (this.nowPrice - this.buyprice) * this.stockAmount;
    }

    private float calculateReturnRate(){
        return (this.nowPrice - this.buyprice) / this.buyprice * 100;
    }



}
