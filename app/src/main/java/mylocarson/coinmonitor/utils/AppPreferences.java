package mylocarson.coinmonitor.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import mylocarson.coinmonitor.models.BTC;
import mylocarson.coinmonitor.models.CoinResponse;
import mylocarson.coinmonitor.models.ETH;
import mylocarson.coinmonitor.models.priceModel.PriceResponse;

/**
 * Created by user on 31/10/2017.
 */

public class AppPreferences {
    private  static final String PREF_NAME = "CoinMonitor";
    private static   SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    public static void saveBTC(Context context, PriceResponse priceResponse, BTC btc){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = preferences.edit();
        Gson gson = new Gson();
        String jsonString = gson.toJson(priceResponse);
        String btcJson = gson.toJson(btc);

        editor.putString("PriceResponse",jsonString);
        editor.putString("BTC",btcJson);
        editor.apply();

    }

    public static void saveETH(Context context, PriceResponse priceResponse, ETH eth){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = preferences.edit();
        Gson gson = new Gson();
        String jsonString = gson.toJson(priceResponse);
        String ethJson = gson.toJson(eth);

        editor.putString("PriceResponse",jsonString);
        editor.putString("ETH",ethJson);
        editor.apply();

    }

    public static PriceResponse getPriceResponse(Context context){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String coinRespString =  preferences.getString("PriceResponse","NULL");
        Gson gson = new Gson();
        return  gson.fromJson(coinRespString,PriceResponse.class);
    }

    public static BTC getBTC (Context context){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String BTCString =  preferences.getString("BTC","NULL");
        Gson gson = new Gson();
        return  gson.fromJson(BTCString,BTC.class);
    }

    public static ETH getETH (Context context){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String ETHString =  preferences.getString("ETH","NULL");
        Gson gson = new Gson();
        return  gson.fromJson(ETHString,ETH.class);
    }

    public static void saveParams(Context context,String points, String action, int time, String country,double oldvalue){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("Point",points);
        editor.putString("Action",action);
        editor.putString("Time",Integer.toString(time));
        editor.putString("Country",country);
        editor.putString("OldValue",Double.toString(oldvalue));
        editor.apply();
    }

    public static ArrayList<String> getParams(Context context){
        preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(preferences.getString("Point","100"));
        arrayList.add(preferences.getString("Action","NULL"));
        arrayList.add(preferences.getString("Time","NULL"));
        arrayList.add(preferences.getString("Country","NULL"));
        arrayList.add(preferences.getString("OldValue","NULL"));

        return  arrayList;
    }
}
