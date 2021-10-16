package com.example.birzha;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
private Stocks Apple = new Stocks("Apple","AAPL");
private Stocks HeadHunter = new Stocks("HeadHunter","HHR");
private Stocks Google = new Stocks("Gooogle","GOOGL");
private Stocks Amazon = new Stocks("Amazon","AMZN");
private Stocks BankOfAmerica = new Stocks("BankOfAmerica","BAC");
private Stocks Microsoft = new Stocks("Microsoft","MSFT");
private Stocks Tesla = new Stocks("Tesla","TSLA");
private Stocks Mastercard = new Stocks("Mastercard","MA");
private Stocks Pfizer = new Stocks("Pfizer","PFE");
private Stocks Nvidia = new Stocks("Nvidia","NVDA");
private Stocks Alibaba = new Stocks("Alibaba","BABA");

TextView applecost , hhrcost , googlecost,amazoncost,baccost,msftcost,tslacost;
TextView applechange,hhrchange,googlechange,amazonchange,bacchange,msftchange,tslachange;

TextView mastercardcost,pfizercost,nvidiacost,alibabacost;
TextView mastercardchange,pfizerchange,nvidiachange,alibabachange;

public String cost="{\"c\":145.86,\"dp\":0.1511,\"h\":146.33,\"l\":144.1101,\"o\":144.38,\"pc\":145.64,\"t\":1627675202}";

    int counter=0;
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler = new Handler();
    private ImageButton refresh ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // refresh =  findViewById(R.id.refresh);
        Changes(Apple.Url, Apple);
        Changes(HeadHunter.Url,HeadHunter);
        Changes(Google.Url,Google);
        Changes(Amazon.Url,Amazon);
        Changes(BankOfAmerica.Url,BankOfAmerica);
        Changes(Microsoft.Url,Microsoft);
        Changes(Tesla.Url,Tesla );
        Changes(Mastercard.Url,Mastercard );
        Changes(Pfizer.Url,Pfizer);
        Changes(Nvidia.Url,Nvidia);
        Changes(Alibaba.Url,Alibaba);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                Apple.cost="0";

                        applecost= findViewById(R.id.AppleCost);
                        applechange=findViewById(R.id.AppleChange);

        hhrcost= findViewById(R.id.HeadHunterCost);
        hhrchange=findViewById(R.id.HeadHunterChange);

                        googlecost=findViewById(R.id.googleCost);
                        googlechange=findViewById(R.id.googleChange);

        amazoncost= findViewById(R.id.amazonCost);
        amazonchange=findViewById(R.id.amazonChange);

                         baccost=findViewById(R.id.bacCost);
                         bacchange=findViewById(R.id.bacChange);

        msftcost=findViewById(R.id.microsoftCost);
        msftchange=findViewById(R.id.microsoftChange);

                         tslacost=findViewById(R.id.teslaCost);
                         tslachange=findViewById(R.id.teslaChange);

        mastercardcost=findViewById(R.id.macost);
        mastercardchange=findViewById(R.id.machange);

                        pfizercost=findViewById(R.id.pfizercost);
                        pfizerchange=findViewById(R.id.pfizerchange);

        nvidiacost=findViewById(R.id.nvdacost);
        nvidiachange=findViewById(R.id.nvdachange);

                        alibabacost=findViewById(R.id.babacost);
                        alibabachange=findViewById(R.id.babachange);


startTimer();

 }


public void Refresh(){
    Changes(Apple.Url, Apple);
    Changes(HeadHunter.Url,HeadHunter);
    Changes(Google.Url,Google);
    Changes(Amazon.Url,Amazon);
    Changes(BankOfAmerica.Url,BankOfAmerica);
    Changes(Microsoft.Url,Microsoft);
    Changes(Tesla.Url,Tesla );
    Changes(Mastercard.Url,Mastercard);
    Changes(Pfizer.Url,Pfizer);
    Changes(Nvidia.Url,Nvidia);
    Changes(Alibaba.Url,Alibaba);
}
private void format(Stocks a){
        double  c = Double.parseDouble(a.cost);
        double fc=Double.parseDouble(a.change);
        double pr = Double.parseDouble(a.changeDollar);
        if (pr==0){
            a.ZeroPoint=1;
        }
        else a.ZeroPoint=0;
        if (  Math.round(pr*100)/100 != 0)
        pr=(double)  Math.round(pr*100)/100;
        c= (double)  Math.round(c*100)/100;
        if ( Math.round(fc*100)/100!=0)
        fc = (double) Math.round(fc*100)/100;


    a.cost= Double.toString(c);
    a.change=Double.toString(fc);
    a.changeDollar=Double.toString(pr);
}
    private void startTimer(){
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run(){
                        format(Apple);
                        format(HeadHunter);
                        format(Google);
                        format(Amazon);
                        format(Amazon);
                        format(BankOfAmerica);
                        format(Microsoft);
                        format(Tesla);
                        format(Mastercard);
                        format(Pfizer);
                        format(Nvidia);
                        format(Alibaba);
                        onResume();
                        //your code is here
                    }
                });
            }
        };
        timer.schedule(timerTask, 5000,100000);
    }
      private void startTimer2(){
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run(){

                        onResume();
                        //your code is here
                    }
                });
            }
        };
        timer.schedule(timerTask, 3000);}
    private void stopTimer(){
        if(timer != null){
            timer.cancel();
            timer.purge();
        }
    }



    private void startTimer1(){
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run(){
                        Changes(Apple.Url, Apple);
                        Changes(HeadHunter.Url,HeadHunter);
                        Changes(Google.Url,Google);
                        Changes(Amazon.Url,Amazon);
                        Changes(BankOfAmerica.Url,BankOfAmerica);
                        Changes(Microsoft.Url,Microsoft);
                        Changes(Tesla.Url,Tesla );
                        Changes(Mastercard.Url,Mastercard);
                        Changes(Pfizer.Url,Pfizer);
                        Changes(Nvidia.Url,Nvidia);
                        Changes(Alibaba.Url,Alibaba);

                        //your code is here
                    }
                });
            }
        };
        timer.schedule(timerTask, 10000, 100000);
    }
    private void startResume(){
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run(){
                        format(Apple);
                        format(HeadHunter);
                        format(Google);
                        format(Amazon);
                        format(Amazon);
                        format(BankOfAmerica);
                        format(Microsoft);
                        format(Tesla);
                        format(Mastercard);
                        format(Pfizer);
                        format(Nvidia);
                        format(Alibaba);
                        //your code is here
                    }
                });
            }
        };
        timer.schedule(timerTask, 5000);
    }
    int resume =0;
    @Override
    protected void onResume() {
        super.onResume();
        startTimer1();
        startResume();
        changeView(Apple, applecost, applechange);
        changeView(HeadHunter,hhrcost,hhrchange);
        changeView(Google,googlecost,googlechange);
        changeView(Amazon,amazoncost,amazonchange);
        changeView(BankOfAmerica,baccost,bacchange);
        changeView(Microsoft,msftcost,msftchange);
        changeView(Tesla,tslacost,tslachange);
        changeView(Mastercard,mastercardcost,mastercardchange);
        changeView(Pfizer,pfizercost,pfizerchange);
        changeView(Nvidia,nvidiacost,nvidiachange);
        changeView(Alibaba,alibabacost,alibabachange);


       // hhrcost.setText("$" + HeadHunter.cost);
       // hhrchange.setText("+$" + HeadHunter.changeDollar + " (" +     HeadHunter.change + "%)");
       // hhrchange.setTextColor(getResources().getColor(R.color.green));

    }
    @SuppressLint("SetTextI18n")
    private void changeView (Stocks stocks, TextView cost, TextView change){

            cost.setText("$" + stocks.cost);

            if (stocks.minusOr=="-")
            {change.setText("-$" + stocks.changeDollar + " (" + stocks.change + "%)");
                change.setTextColor(getResources().getColor(R.color.design_default_color_error));}

else {
        if (stocks.ZeroPoint==1)
        {change.setText("$" + stocks.changeDollar + " (" + stocks.change + "%)");
            change.setTextColor(getResources().getColor(R.color.white));}
            else {
            change.setText("+$" + stocks.changeDollar + " (" + stocks.change + "%)");
            change.setTextColor(getResources().getColor(R.color.green));
        }
            }



    }
    private String isComEnding(String substring){
        boolean isComEnding = substring.endsWith(",");
        boolean isComEnding1 = substring.endsWith(",\"");
        boolean isComEnding2 =substring.endsWith(",\"d");
        boolean isComEnding3 =substring.endsWith(",\"d\"");
        boolean isComEnding4 =substring.endsWith("0,\"h\":");
        boolean isComEnding5 =substring.endsWith("0,\"dp");

        if (isComEnding){
            substring=substring.substring(0,substring.length()-1);
        }
        if (isComEnding1){
            substring=substring.substring(0,substring.length()-2);
        }
        if (isComEnding2){
            substring=substring.substring(0,substring.length()-3);
        }
        if (isComEnding3 || isComEnding5){
            substring=substring.substring(0,substring.length()-4);
        }
        if (isComEnding4){
            substring=substring.substring(0,substring.length()-5);
        }

        return substring;
}
int count =0;
    private void differentStocks(JSONObject response,Stocks HH)
    {

        int indexJava = response.toString().indexOf("\"pc\":");
        String substring = response.toString().substring(indexJava + 5, indexJava + 11);

        substring=isComEnding(substring);
        Log.e("MyLog", substring);
        HH.firstCost= substring;

        int indexJava1 = response.toString().indexOf("\"c\":");
        String substring1 = response.toString().substring(indexJava1 + 4, indexJava1 +10);


        substring1=isComEnding(substring1);
        Log.e("MyLog", substring1);
        HH.cost=substring1;

        int indexJava2 = response.toString().indexOf("\"dp\":");
        String substring2 = response.toString().substring(indexJava2 + 5, indexJava2 + 11);


        substring2=isComEnding(substring2);
        Log.e("MyLog", substring2);
        HH.change=substring2;


        int indexJava3 = response.toString().indexOf("\"d\":");
        String substring3 = response.toString().substring(indexJava3 + 4, indexJava3 + 9);

        substring3=isComEnding((substring3));
        Log.e("MyLog", substring3);
        HH.changeDollar =substring3;

        if (substring3.charAt(0)=='-')
        {HH.minusOr="-";}

count++;
if (count==2)
        onResume();
    }


public void Changes (String s,Stocks HH){

    RequestQueue requestQueue= Volley.newRequestQueue(this);


    String URL =s;
    JsonObjectRequest objectRequest=new JsonObjectRequest(
            Request.Method.GET,
            URL,
            null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("MyLog", response.toString());

                    differentStocks(response,HH);

                    cost=response.toString();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Rest Response",error.toString());
                }
            }

    );
    requestQueue.add(objectRequest);
}

}