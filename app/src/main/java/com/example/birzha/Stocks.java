package com.example.birzha;

import org.jsoup.nodes.Document;

public class Stocks {
    public String name;
    public String ticker;
    public String cost;
    public String change;
    public String changeDollar;
    public String firstCost;
    public String minusOr;
    private Document doc ;
    public String Url ;
    private Thread secThread;
    private Runnable runnable;
    public int ZeroPoint =0;
Stocks(String Name, String Ticker){
    name =Name;
    ticker =Ticker;
    Url = "https://finnhub.io/api/v1/quote?symbol="+ticker+"&token=c3o0rtaad3ia07uejit0";

    }

}
