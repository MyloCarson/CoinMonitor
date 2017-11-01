package mylocarson.coinmonitor;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.rey.material.widget.SnackBar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mylocarson.coinmonitor.api.Api_Service;
import mylocarson.coinmonitor.api.CryptoMonitorApi;
import mylocarson.coinmonitor.fragment.ConversionFragment;
import mylocarson.coinmonitor.models.BTC;
import mylocarson.coinmonitor.models.CoinResponse;
import mylocarson.coinmonitor.models.Data;
import mylocarson.coinmonitor.models.ETH;
import mylocarson.coinmonitor.models.priceModel.PriceResponse;
import mylocarson.coinmonitor.utils.AppPreferences;
import mylocarson.coinmonitor.utils.ProgressBarHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    AlertDialog alertDialog;
    LayoutInflater inflater;

    @Bind(R.id.selectCoin)
    Spinner selectCoin;

//    @Bind(R.id.selectCountry)
//    Spinner selectCountry;


    @Bind(R.id.coinImage)
    ImageView coinImage;

    @Bind(R.id.coinName)
    TextView coinName;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    Context context;

    //    the cardviews and other views
    @Bind(R.id.cardView)
    CardView cardView;

    @Bind(R.id.cardView1)
    CardView cardView1;

    @Bind(R.id.cardView2)
    CardView cardView2;

    @Bind(R.id.cardView3)
    CardView cardView3;

    @Bind(R.id.cardView4)
    CardView cardView4;

    @Bind(R.id.cardView5)
    CardView cardView5;

    @Bind(R.id.cardView6)
    CardView cardView6;

    @Bind(R.id.cardView7)
    CardView cardView7;

    @Bind(R.id.cardView8)
    CardView cardView8;

    @Bind(R.id.cardView9)
    CardView cardView9;

    @Bind(R.id.cardView10)
    CardView cardView10;

    @Bind(R.id.cardView11)
    CardView cardView11;

    @Bind(R.id.cardView12)
    CardView cardView12;

    @Bind(R.id.cardView13)
    CardView cardView13;

    @Bind(R.id.cardView14)
    CardView cardView14;

    @Bind(R.id.cardView15)
    CardView cardView15;

    @Bind(R.id.cardView16)
    CardView cardView16;

    @Bind(R.id.cardView17)
    CardView cardView17;

    @Bind(R.id.cardView18)
    CardView cardView18;

    @Bind(R.id.cardView19)
    CardView cardView19;

    @Bind(R.id.countryPrice)
    TextView countryPrice;

    @Bind(R.id.countryPrice1)
    TextView countryPrice1;

    @Bind(R.id.countryPrice2)
    TextView countryPrice2;

    @Bind(R.id.countryPrice3)
    TextView countryPrice3;

    @Bind(R.id.countryPrice4)
    TextView countryPrice4;

    @Bind(R.id.countryPrice5)
    TextView countryPrice5;

    @Bind(R.id.countryPrice6)
    TextView countryPrice6;

    @Bind(R.id.countryPrice7)
    TextView countryPrice7;

    @Bind(R.id.countryPrice8)
    TextView countryPrice8;

    @Bind(R.id.countryPrice9)
    TextView countryPrice9;

    @Bind(R.id.countryPrice10)
    TextView countryPrice10;

    @Bind(R.id.countryPrice11)
    TextView countryPrice11;

    @Bind(R.id.countryPrice12)
    TextView countryPrice12;

    @Bind(R.id.countryPrice13)
    TextView countryPrice13;

    @Bind(R.id.countryPrice14)
    TextView countryPrice14;

    @Bind(R.id.countryPrice15)
    TextView countryPrice15;

    @Bind(R.id.countryPrice16)
    TextView countryPrice16;

    @Bind(R.id.countryPrice17)
    TextView countryPrice17;

    @Bind(R.id.countryPrice18)
    TextView countryPrice18;

    @Bind(R.id.countryPrice19)
    TextView countryPrice19;


    ProgressBarHandler progressBar;
    public static CryptoMonitorApi cryptoMonitorApi;

    public static final String FIRST_COIN = "BTC";
    public static final String SECOND_COIN = "ETH";

    public static PriceResponse mainPriceResponse;
    public static String POSITION;
    public static String COUNTRY;
    public static String SELECTED_COIN;

    public static BTC BTC;
    public static ETH ETH;

    static String ACTION;
    static String COUNTRY_CURRENCY;
    static String POINT;
    static int TIME;
    Activity activity;
    public double result;
    public double OLDPRICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        cryptoMonitorApi = new Api_Service().getCryptoMonitorApi();
        context = this;
        activity = this;
        progressBar = new ProgressBarHandler(context);
        progressBar.cancelTouch(this);
        progressBar.show();


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.coins, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectCoin.setAdapter(arrayAdapter);
        selectCoin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {
                    case FIRST_COIN:
                        progressBar.cancelTouch(activity);
                        progressBar.show();
                        connect(FIRST_COIN);
                        getPrices(FIRST_COIN);
                        SELECTED_COIN = FIRST_COIN;
                        break;
                    case SECOND_COIN:
                        progressBar.cancelTouch(activity);
                        progressBar.show();
                        connect(SECOND_COIN);
                        getPrices(SECOND_COIN);
                        SELECTED_COIN = SECOND_COIN;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reminder:
                showRemainderDialog(this);
                break;
            default:
                return false;

        }
        return true;
    }

    AlertDialog showRemainderDialog(Context context){
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.reminder_layout,null);
        final Spinner action_Option = (Spinner)view.findViewById(R.id.action_Option);
        final Spinner timeOption = (Spinner)view.findViewById(R.id.timeOption);
        final  Spinner countryOption =(Spinner)view.findViewById(R.id.countryOption);
        final Button saveSettings = (Button)view.findViewById(R.id.saveSettings);
        final Button cancelSettings = (Button)view.findViewById(R.id.cancelSettings);
        final EditText points =(EditText)view.findViewById(R.id.diffPoint);


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context,R.array.actionOption,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        action_Option.setAdapter(arrayAdapter);
        action_Option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "rises":
                        ACTION = "rises";
                        break;
                    case "falls":
                        ACTION = "falls";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence >arrayAdapter1 = ArrayAdapter.createFromResource(context,R.array.timeOption,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeOption.setAdapter(arrayAdapter1);
        timeOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "30 minutes":
                        TIME = 30;
                        break;
                    case "1 hour":
                        TIME = 60;
                        break;
                    case "2 hours":
                        TIME = 120;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(context,R.array.countries,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryOption.setAdapter(arrayAdapter2);

        countryOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "Nigeria (NGN)":
                        COUNTRY_CURRENCY = "NGN";
                        OLDPRICE =getQuick(1,SELECTED_COIN);
                        break;
                    case "Australian Dollar (AUD)":
                        COUNTRY_CURRENCY = "AUD";
                        OLDPRICE =getQuick(2,SELECTED_COIN);
                        break;
                    case "British Pound (GBP)":
                        COUNTRY_CURRENCY = "GBP";
                        OLDPRICE =getQuick(3,SELECTED_COIN);
                        break;
                    case "Canadian Dollar (CAD)":
                        COUNTRY_CURRENCY = "CAD";
                        OLDPRICE =getQuick(4,SELECTED_COIN);
                        break;
                    case "Chilean Peso (CLP)":
                        COUNTRY_CURRENCY = "CLP";
                        OLDPRICE =getQuick(5,SELECTED_COIN);
                        break;
                    case "Chinese Yuan Renminbi (CNY)":
                        COUNTRY_CURRENCY = "CNY";
                        OLDPRICE =getQuick(6,SELECTED_COIN);
                        break;
                    case "Czech Koruna (CZK)":
                        COUNTRY_CURRENCY = "CZK";
                        OLDPRICE =getQuick(7,SELECTED_COIN);
                        break;
                    case "Danish Krone (DKK)":
                        COUNTRY_CURRENCY = "DKK";
                        OLDPRICE =getQuick(8,SELECTED_COIN);
                        break;
                    case "Euro (EUR)":
                        COUNTRY_CURRENCY = "EUR";
                        OLDPRICE =getQuick(9,SELECTED_COIN);
                        break;
                    case "Hong Kong Dollar (HKD)":
                        COUNTRY_CURRENCY = "HKD";
                        OLDPRICE =getQuick(10,SELECTED_COIN);
                        break;
                    case "Hungarian Forint (HUF)":
                        COUNTRY_CURRENCY = "HUF";
                        OLDPRICE =getQuick(11,SELECTED_COIN);
                        break;
                    case "Indian Rupee (INR)":
                        COUNTRY_CURRENCY = "INR";
                        OLDPRICE =getQuick(12,SELECTED_COIN);
                        break;
                    case "Israeli New Shekel (ILS)":
                        COUNTRY_CURRENCY = "ILS";
                        OLDPRICE =getQuick(13,SELECTED_COIN);
                        break;
                    case "Japanese Yen (JPY)":
                        COUNTRY_CURRENCY = "JPY";
                        OLDPRICE =getQuick(14,SELECTED_COIN);
                        break;
                    case "Korean Won (KRW)":
                        COUNTRY_CURRENCY = "KRW";
                        OLDPRICE =getQuick(15,SELECTED_COIN);
                        break;
                    case "Malaysian Ringgit (MYR)":
                        COUNTRY_CURRENCY = "MYR";
                        OLDPRICE =getQuick(16,SELECTED_COIN);
                        break;
                    case "Brazilian Real (BRL)":
                        COUNTRY_CURRENCY = "BRL";
                        OLDPRICE =getQuick(17,SELECTED_COIN);
                        break;
                    case "Mexican Peso (MXN)":
                        COUNTRY_CURRENCY = "MXN";
                        OLDPRICE =getQuick(18,SELECTED_COIN);
                        break;
                    case "New Zealand Dollar (NZD)":
                        COUNTRY_CURRENCY = "NZD";
                        OLDPRICE =getQuick(19,SELECTED_COIN);
                        break;
                    case "Indonesian Rupiah (IDR)":
                        COUNTRY_CURRENCY = "IDR";
                        OLDPRICE =getQuick(20,SELECTED_COIN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        saveSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (points.getText().toString().isEmpty()){
                    points.setError("Provide a point");
                }else{
                    AppPreferences.saveParams(view.getContext(),POINT,ACTION,TIME,COUNTRY_CURRENCY,OLDPRICE);
                    final ArrayList<String> arrayList = AppPreferences.getParams(view.getContext());
                    final int time = Integer.parseInt(arrayList.get(2));
                    switch (SELECTED_COIN){
                        case FIRST_COIN:
                            AppPreferences.saveBTC(view.getContext(),mainPriceResponse,BTC);
                            checkUpdateBTC(arrayList.get(3),time,arrayList.get(4),arrayList.get(0),FIRST_COIN);

                            break;
                        case SECOND_COIN:
                            AppPreferences.saveETH(view.getContext(),mainPriceResponse,ETH);
                            checkUpdateETH(arrayList.get(3),time,arrayList.get(4),arrayList.get(0),FIRST_COIN);
                            break;
                    }
                }

            }
        });

        alertBuilder.setView(view);
        alertBuilder.setNegativeButton(
                "CLOSE",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //delete and dismiss
                        dialog.dismiss();
                    }
                });

        return alertBuilder.show();
    }

    private void connect(final String coinType) {
        final SnackBar snackBar = SnackBar.make(getBaseContext());
        Call<CoinResponse> coinResponseCallback = cryptoMonitorApi.cb();
        coinResponseCallback.enqueue(new Callback<CoinResponse>() {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                Log.e("Crypto :::::", response.body().toString());
                progressBar.getTouchBack(activity);
                progressBar.hide();
                if (response.body().getResponse().equals("Success")){
                    Data data = response.body().getData();
                    if (coinType.equals(FIRST_COIN)) {
                        BTC btc = data.getbTC();
                        BTC = btc;
                        Picasso.with(coinImage.getContext()).load(response.body().getBaseImageUrl()+btc.getImageUrl())
                                .placeholder(R.mipmap.money_bag).error(R.mipmap.money_bag).into(coinImage);
                        coinName.setText(btc.getFullName());
                        snackBar.text("BTC WORKED")
                                .singleLine(true)
                                .actionText("Close")
                                .actionClickListener(new SnackBar.OnActionClickListener() {
                                    @Override
                                    public void onActionClick(SnackBar sb, int actionId) {
                                        snackBar.dismiss();
                                    }
                                })
                                .duration(10000);
                    }else if (coinType.equals(SECOND_COIN)){
                        ETH eth = data.geteTH();
                        ETH = eth;
                        Picasso.with(coinImage.getContext()).load(response.body().getBaseImageUrl()+eth.getImageUrl())
                                .placeholder(R.mipmap.money_bag).error(R.mipmap.money_bag).into(coinImage);
                        coinName.setText(eth.getFullName());

                        snackBar.text("ETH WORKED")
                                .singleLine(true)
                                .actionText("Close")
                                .actionClickListener(new SnackBar.OnActionClickListener() {
                                    @Override
                                    public void onActionClick(SnackBar sb, int actionId) {
                                        snackBar.dismiss();
                                    }
                                })
                                .duration(10000);
                    }
                }else{

                    snackBar.text("Error")
                            .singleLine(true)
                            .actionText("Close")
                            .actionClickListener(new SnackBar.OnActionClickListener() {
                                @Override
                                public void onActionClick(SnackBar sb, int actionId) {
                                    snackBar.dismiss();
                                }
                            })
                            .duration(10000);
                }
            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                progressBar.getTouchBack(activity);
                progressBar.hide();
                Log.e("Crypto :::::", t.toString());
            }
        });

    }

    private void getPrices(String coinType){

        switch (coinType){
            case FIRST_COIN:
                Call<PriceResponse> priceResponseCall = cryptoMonitorApi.getPricesBTC();
                priceResponseCall.enqueue(new Callback<PriceResponse>() {
                    @Override
                    public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                        progressBar.getTouchBack(activity);
                        progressBar.hide();
                        Log.e("CoinMaster::::",response.body().toString());
                        if (response!=null){
                            PriceResponse priceResponse = response.body();
                            mainPriceResponse = priceResponse;
                            countryPrice.setText(convertDouble(priceResponse.getNGN()));
                            countryPrice1.setText(convertDouble(priceResponse.getAUD()));
                            countryPrice2.setText(convertDouble(priceResponse.getGBP()));
                            countryPrice3.setText(convertDouble(priceResponse.getCAD()));
                            countryPrice4.setText(convertDouble(priceResponse.getCLP()));
                            countryPrice5.setText(convertDouble(priceResponse.getCNY()));
                            countryPrice6.setText(convertDouble(priceResponse.getCZK()));
                            countryPrice7.setText(convertDouble(priceResponse.getDKK()));
                            countryPrice8.setText(convertDouble(priceResponse.getEUR()));
                            countryPrice9.setText(convertDouble(priceResponse.getHKD()));
                            countryPrice10.setText(convertDouble(priceResponse.getHUF()));
                            countryPrice11.setText(convertDouble(priceResponse.getINR()));
                            countryPrice12.setText(convertDouble(priceResponse.getILS()));
                            countryPrice13.setText(convertDouble(priceResponse.getJPY()));
                            countryPrice14.setText(convertDouble(priceResponse.getKRW()));
                            countryPrice15.setText(convertDouble(priceResponse.getMYR()));
                            countryPrice16.setText(convertDouble(priceResponse.getBRL()));
                            countryPrice17.setText(convertDouble(priceResponse.getMXN()));
                            countryPrice18.setText(convertDouble(priceResponse.getNZD()));
                            countryPrice19.setText(convertDouble(priceResponse.getIDR()));
                        }
                    }

                    @Override
                    public void onFailure(Call<PriceResponse> call, Throwable t) {
                        progressBar.getTouchBack(activity);
                        progressBar.hide();
                    }
                });
                break;

            case SECOND_COIN:
                Call<PriceResponse> priceResponseCall2 = cryptoMonitorApi.getPricesETH();
                priceResponseCall2.enqueue(new Callback<PriceResponse>() {
                    @Override
                    public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                        Log.e("CoinMaster::::",response.body().toString());
                        progressBar.getTouchBack(activity);
                        progressBar.hide();
                        if (response!=null){
                            PriceResponse priceResponse = response.body();
                            mainPriceResponse = priceResponse;
                            countryPrice.setText(convertDouble(priceResponse.getNGN()));
                            countryPrice1.setText(convertDouble(priceResponse.getAUD()));
                            countryPrice2.setText(convertDouble(priceResponse.getGBP()));
                            countryPrice3.setText(convertDouble(priceResponse.getCAD()));
                            countryPrice4.setText(convertDouble(priceResponse.getCLP()));
                            countryPrice5.setText(convertDouble(priceResponse.getCNY()));
                            countryPrice6.setText(convertDouble(priceResponse.getCZK()));
                            countryPrice7.setText(convertDouble(priceResponse.getDKK()));
                            countryPrice8.setText(convertDouble(priceResponse.getEUR()));
                            countryPrice9.setText(convertDouble(priceResponse.getHKD()));
                            countryPrice10.setText(convertDouble(priceResponse.getHUF()));
                            countryPrice11.setText(convertDouble(priceResponse.getINR()));
                            countryPrice12.setText(convertDouble(priceResponse.getILS()));
                            countryPrice13.setText(convertDouble(priceResponse.getJPY()));
                            countryPrice14.setText(convertDouble(priceResponse.getKRW()));
                            countryPrice15.setText(convertDouble(priceResponse.getMYR()));
                            countryPrice16.setText(convertDouble(priceResponse.getBRL()));
                            countryPrice17.setText(convertDouble(priceResponse.getMXN()));
                            countryPrice18.setText(convertDouble(priceResponse.getNZD()));
                            countryPrice19.setText(convertDouble(priceResponse.getIDR()));
                        }
                    }

                    @Override
                    public void onFailure(Call<PriceResponse> call, Throwable t) {
                        progressBar.getTouchBack(activity);
                        progressBar.hide();
                    }
                });
                break;

        }

    }

    public static final String convertDouble(double price){
        return Double.toString(price);
    }

    private void openFragment(String position, String country){
        POSITION =position;
        COUNTRY =country;
        Fragment fragment = new ConversionFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction
                .replace(R.id.mainLayout,fragment)
                .addToBackStack(null)
                .commit();
        Log.e("Crypto :::::", "Open Frag");

    }

//    cardview clicks

    @OnClick(R.id.cardView)
    void cardviewClick(){
        openFragment("1","NGN");
        Log.e("Crypto :::::", "Clicked");
    }

    @OnClick(R.id.cardView1)
    void cardviewClick1(){
        openFragment("2","AUD");
    }

    @OnClick(R.id.cardView2)
    void cardviewClick2(){
        openFragment("3","GBP");
    }

    @OnClick(R.id.cardView3)
    void cardviewClick3(){
        openFragment("4","CAD");
    }

    @OnClick(R.id.cardView4)
    void cardviewClick4(){
        openFragment("5","CLP");
    }

    @OnClick(R.id.cardView5)
    void cardviewClick5(){
        openFragment("6","CNY");
    }

    @OnClick(R.id.cardView6)
    void cardviewClick6(){
        openFragment("7","CZK");
    }

    @OnClick(R.id.cardView7)
    void cardviewClick7(){
        openFragment("8","DKK");
    }


    @OnClick(R.id.cardView8)
    void cardviewClick8(){
        openFragment("9","EUR");
    }

    @OnClick(R.id.cardView9)
    void cardviewClick9(){
        openFragment("10","HKD");
    }

    @OnClick(R.id.cardView10)
    void cardviewClick10(){
        openFragment("11","HUF");
    }

    @OnClick(R.id.cardView11)
    void cardviewClick11(){
        openFragment("12","INR");
    }
    @OnClick(R.id.cardView12)
    void cardviewClick12(){
        openFragment("13","ILS");
    }
    @OnClick(R.id.cardView13)
    void cardviewClick13(){
        openFragment("14","JPY");
    }

    @OnClick(R.id.cardView14)
    void cardviewClick14(){
        openFragment("15","KRW");
    }

    @OnClick(R.id.cardView15)
    void cardviewClick15(){
        openFragment("16","MYR");
    }

    @OnClick(R.id.cardView16)
    void cardviewClick16(){
        openFragment("17","BRL");
    }

    @OnClick(R.id.cardView17)
    void cardviewClick17(){
        openFragment("18","MXN");
    }

    @OnClick(R.id.cardView18)
    void cardviewClick18(){
        openFragment("19","NZD");
    }

    @OnClick(R.id.cardView19)
    void cardviewClick19(){
        openFragment("20","IDR");
    }


    void setNotification (int time,double newRange,String currency,String coinType){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle(getResources().getString(R.string.app_name))
                        .setContentText(currency.toUpperCase() +" to "+ coinType.toUpperCase()+" is now " +Double.toString(newRange));

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    void checkUpdateBTC(final String currency, final int time, final String oldValue, final String points, final String coinType){
        Call<PriceResponse> responseCall = cryptoMonitorApi.getPricesBTC();
        responseCall.enqueue(new Callback<PriceResponse>() {
            @Override
            public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                PriceResponse priceResponse = response.body();
                switch(currency){
                    case "NGN":
                        comparePrice(oldValue,priceResponse.getNGN(),points,time,currency,coinType);
                        break;
                    case "AUD":
                        comparePrice(oldValue,priceResponse.getAUD(),points,time,currency,coinType);
                        break;
                    case "GBP":
                        comparePrice(oldValue,priceResponse.getGBP(),points,time,currency,coinType);
                        break;
                    case "CAD":
                        comparePrice(oldValue,priceResponse.getCAD(),points,time,currency,coinType);
                        break;
                    case "CLP":
                        comparePrice(oldValue,priceResponse.getCLP(),points,time,currency,coinType);
                        break;
                    case "CNY":
                        comparePrice(oldValue,priceResponse.getCNY(),points,time,currency,coinType);
                        break;
                    case "CZK":
                        comparePrice(oldValue,priceResponse.getCZK(),points,time,currency,coinType);
                        break;
                    case "DKK":
                        comparePrice(oldValue,priceResponse.getDKK(),points,time,currency,coinType);
                        break;
                    case "EUR":
                        comparePrice(oldValue,priceResponse.getEUR(),points,time,currency,coinType);
                        break;
                    case "HKD":
                        comparePrice(oldValue,priceResponse.getHKD(),points,time,currency,coinType);
                        break;
                    case "HUF":
                        comparePrice(oldValue,priceResponse.getHUF(),points,time,currency,coinType);
                        break;
                    case "INR":
                        comparePrice(oldValue,priceResponse.getINR(),points,time,currency,coinType);
                        break;
                    case "IDR":
                        comparePrice(oldValue,priceResponse.getIDR(),points,time,currency,coinType);
                        break;
                    case "ILS":
                        comparePrice(oldValue,priceResponse.getILS(),points,time,currency,coinType);
                        break;
                    case "JPY":
                        comparePrice(oldValue,priceResponse.getJPY(),points,time,currency,coinType);
                        break;
                    case "KRW":
                        comparePrice(oldValue,priceResponse.getKRW(),points,time,currency,coinType);
                        break;
                    case "MYR":
                        comparePrice(oldValue,priceResponse.getMYR(),points,time,currency,coinType);
                        break;
                    case "BRL":
                        comparePrice(oldValue,priceResponse.getBRL(),points,time,currency,coinType);
                        break;
                    case "MXN":
                        comparePrice(oldValue,priceResponse.getMXN(),points,time,currency,coinType);
                        break;
                    case "NZD":
                        comparePrice(oldValue,priceResponse.getNZD(),points,time,currency,coinType);
                        break;

                }
            }



            @Override
            public void onFailure(Call<PriceResponse> call, Throwable t) {

            }
        });

    }

    void checkUpdateETH(final String currency, final int time, final String oldValue, final String points, final String coinType){
        Call<PriceResponse> responseCall = cryptoMonitorApi.getPricesBTC();
        responseCall.enqueue(new Callback<PriceResponse>() {
            @Override
            public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                PriceResponse priceResponse = response.body();
                switch(currency){
                    case "NGN":
                        comparePrice(oldValue,priceResponse.getNGN(),points,time,currency,coinType);
                        break;
                    case "AUD":
                        comparePrice(oldValue,priceResponse.getAUD(),points,time,currency,coinType);
                        break;
                    case "GBP":
                        comparePrice(oldValue,priceResponse.getGBP(),points,time,currency,coinType);
                        break;
                    case "CAD":
                        comparePrice(oldValue,priceResponse.getCAD(),points,time,currency,coinType);
                        break;
                    case "CLP":
                        comparePrice(oldValue,priceResponse.getCLP(),points,time,currency,coinType);
                        break;
                    case "CNY":
                        comparePrice(oldValue,priceResponse.getCNY(),points,time,currency,coinType);
                        break;
                    case "CZK":
                        comparePrice(oldValue,priceResponse.getCZK(),points,time,currency,coinType);
                        break;
                    case "DKK":
                        comparePrice(oldValue,priceResponse.getDKK(),points,time,currency,coinType);
                        break;
                    case "EUR":
                        comparePrice(oldValue,priceResponse.getEUR(),points,time,currency,coinType);
                        break;
                    case "HKD":
                        comparePrice(oldValue,priceResponse.getHKD(),points,time,currency,coinType);
                        break;
                    case "HUF":
                        comparePrice(oldValue,priceResponse.getHUF(),points,time,currency,coinType);
                        break;
                    case "INR":
                        comparePrice(oldValue,priceResponse.getINR(),points,time,currency,coinType);
                        break;
                    case "IDR":
                        comparePrice(oldValue,priceResponse.getIDR(),points,time,currency,coinType);
                        break;
                    case "ILS":
                        comparePrice(oldValue,priceResponse.getILS(),points,time,currency,coinType);
                        break;
                    case "JPY":
                        comparePrice(oldValue,priceResponse.getJPY(),points,time,currency,coinType);
                        break;
                    case "KRW":
                        comparePrice(oldValue,priceResponse.getKRW(),points,time,currency,coinType);
                        break;
                    case "MYR":
                        comparePrice(oldValue,priceResponse.getMYR(),points,time,currency,coinType);
                        break;
                    case "BRL":
                        comparePrice(oldValue,priceResponse.getBRL(),points,time,currency,coinType);
                        break;
                    case "MXN":
                        comparePrice(oldValue,priceResponse.getMXN(),points,time,currency,coinType);
                        break;
                    case "NZD":
                        comparePrice(oldValue,priceResponse.getNZD(),points,time,currency,coinType);
                        break;

                }
            }



            @Override
            public void onFailure(Call<PriceResponse> call, Throwable t) {

            }
        });

    }

    private void comparePrice(String oldValue, double newValue, String points, final int time, final String currency, final String coinType) {
        double oldValueDouble = Double.parseDouble(oldValue);
        final double newRange = oldValueDouble - newValue;
        //final int newtime = time*60*1000;
        final int newtime = time*60*1000;
        if (newValue - oldValueDouble == Integer.parseInt(points)){

            Thread thread = new Thread(){

                @Override
                public synchronized void run() {
                    try {
                        Thread.sleep(newtime);
                        setNotification(time,newRange,currency,coinType);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            thread.start();
        }
        else  if (newValue - oldValueDouble > Integer.parseInt(points)){

            Thread thread = new Thread(){

                @Override
                public synchronized void run() {
                    try {
                        Thread.sleep(newtime);
                        setNotification(time,newRange,currency,coinType);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            thread.start();
        }
        else{

            Thread thread = new Thread(){

                @Override
                public synchronized void run() {
                    try {
                        Thread.sleep(newtime);
                        setNotification(time,newRange,currency,coinType);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            };
            thread.start();
        }
    }

    Double getQuick(final int i, final String coinType){

                switch (coinType){
                    case FIRST_COIN:
                        Call<PriceResponse> priceResponseCall =cryptoMonitorApi.getPricesBTC();
                        priceResponseCall.enqueue(new Callback<PriceResponse>() {
                            @Override
                            public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                                PriceResponse priceResponse = response.body();
                                switch (i){
                                    case 1:
                                        result =priceResponse.getNGN();
                                        break;

                                    case 2:
                                        result =priceResponse.getAUD();
                                        break;

                                    case 3:
                                        result =priceResponse.getGBP();
                                        break;

                                    case 4:
                                        result =priceResponse.getCAD();
                                        break;


                                    case 5:
                                        result =priceResponse.getCLP();
                                        break;
                                    case 6:
                                        result =priceResponse.getCNY();
                                        break;

                                    case 7:
                                        result =priceResponse.getCZK();
                                        break;

                                    case 8:
                                        result =priceResponse.getDKK();
                                        break;

                                    case 9:
                                        result =priceResponse.getEUR();
                                        break;

                                    case 10:
                                        result =priceResponse.getHKD();
                                        break;

                                    case 11:
                                        result =priceResponse.getHUF();
                                        break;

                                    case 12:
                                        result =priceResponse.getINR();
                                        break;

                                    case 13:
                                        result =priceResponse.getILS();
                                        break;

                                    case 14:
                                        result =priceResponse.getJPY();
                                        break;

                                    case 15:
                                        result =priceResponse.getKRW();
                                        break;

                                    case 16:
                                        result =priceResponse.getMYR();
                                        break;

                                    case 17:
                                        result =priceResponse.getBRL();
                                        break;

                                    case 18:
                                        result =priceResponse.getMXN();
                                        break;

                                    case 19:
                                        result =priceResponse.getNZD();
                                        break;

                                    case 20:
                                        result =priceResponse.getIDR();
                                        break;




                                }
                            }

                            @Override
                            public void onFailure(Call<PriceResponse> call, Throwable t) {

                            }
                        });
                        break;

                    case SECOND_COIN:
                        Call<PriceResponse> priceResponseCall2 =cryptoMonitorApi.getPricesETH();
                        priceResponseCall2.enqueue(new Callback<PriceResponse>() {
                            @Override
                            public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                                PriceResponse priceResponse = response.body();
                                switch (i){
                                    case 1:
                                        result =priceResponse.getNGN();
                                        break;

                                    case 2:
                                        result =priceResponse.getAUD();
                                        break;

                                    case 3:
                                        result =priceResponse.getGBP();
                                        break;

                                    case 4:
                                        result =priceResponse.getCAD();
                                        break;


                                    case 5:
                                        result =priceResponse.getCLP();
                                        break;
                                    case 6:
                                        result =priceResponse.getCNY();
                                        break;

                                    case 7:
                                        result =priceResponse.getCZK();
                                        break;

                                    case 8:
                                        result =priceResponse.getDKK();
                                        break;

                                    case 9:
                                        result =priceResponse.getEUR();
                                        break;

                                    case 10:
                                        result =priceResponse.getHKD();
                                        break;

                                    case 11:
                                        result =priceResponse.getHUF();
                                        break;

                                    case 12:
                                        result =priceResponse.getINR();
                                        break;

                                    case 13:
                                        result =priceResponse.getILS();
                                        break;

                                    case 14:
                                        result =priceResponse.getJPY();
                                        break;

                                    case 15:
                                        result =priceResponse.getKRW();
                                        break;

                                    case 16:
                                        result =priceResponse.getMYR();
                                        break;

                                    case 17:
                                        result =priceResponse.getBRL();
                                        break;

                                    case 18:
                                        result =priceResponse.getMXN();
                                        break;

                                    case 19:
                                        result =priceResponse.getNZD();
                                        break;

                                    case 20:
                                        result =priceResponse.getIDR();
                                        break;




                                }
                            }

                            @Override
                            public void onFailure(Call<PriceResponse> call, Throwable t) {

                            }
                        });
                        break;
                }

        return  result;
    }
}