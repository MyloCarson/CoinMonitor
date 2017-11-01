package mylocarson.coinmonitor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import mylocarson.coinmonitor.MainActivity;
import mylocarson.coinmonitor.R;
import mylocarson.coinmonitor.models.priceModel.PriceResponse;
import mylocarson.coinmonitor.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConversionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConversionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Bind(R.id.coinType)
    TextView coinType;

    @Bind(R.id.coinPrice)
    EditText coinPrice;

    @Bind(R.id.currencyType)
    TextView currencyType;

    @Bind(R.id.currencyPrice)
    EditText currencyPrice;

    @Bind(R.id.result)
    TextView result;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public PriceResponse priceResponse;
    public static  String SELECTED_COIN_PRICE;

    public ConversionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConversionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConversionFragment newInstance(String param1, String param2) {
        ConversionFragment fragment = new ConversionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conversion, container, false);
        ButterKnife.bind(this,view);

        ((AppCompatActivity)getActivity()).getDelegate().setSupportActionBar(toolbar);

        priceResponse = MainActivity.mainPriceResponse;
        setViews();

        currencyPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0){
                    convertCurrency(charSequence);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>0){
                    convertCurrency(charSequence);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    String getCountry(String countryCode){
        String country = "";
        switch (countryCode){
            case Constants.FIRST_CODE:
                country = Constants.FIRST_COUNTRY;
                break;
            case Constants.SECOND_CODE:
                country = Constants.SECOND_COUNTRY;
                break;

            case Constants.THIRD_CODE:
                country = Constants.THIRD_COUNTRY;
                break;

            case Constants.FOURTH_CODE:
                country = Constants.FOURTH_COUNTRY;
                break;

            case Constants.FIFTH_CODE:
                country = Constants.FIFTH_COUNTRY;
                break;

            case Constants.SIXTH_CODE:
                country = Constants.SIXTH_COUNTRY;
                break;

            case Constants.SEVENTH_CODE:
                country = Constants.SEVENTH_COUNTRY;
                break;

            case Constants.EIGHT_CODE:
                country = Constants.EIGHT_COUNTRY;
                break;

            case Constants.NINETH_CODE:
                country = Constants.NINETH_COUNTRY;
                break;

            case Constants.TENTH_CODE:
                country = Constants.TENTH_COUNTRY;
                break;
            case Constants.ELEVENTH_CODE:
                country = Constants.ELEVENTH_COUNTRY;
                break;

            case Constants.TWELEVETH_CODE:
                country = Constants.TWELEVETH_COUNTRY;
                break;


            case Constants.THIRTEENTH_CODE:
                country = Constants.THIRTEENTH_COUNTRY;
                break;


            case Constants.FOURTEENTH_CODE:
                country = Constants.FOURTEENTH_COUNTRY;
                break;


            case Constants.FIFTEENTH_CODE:
                country = Constants.FIFTEENTH_COUNTRY;
                break;

            case Constants.SIXTEENTH_CODE:
                country = Constants.SIXTEENTH_COUNTRY;
                break;


            case Constants.SEVENTEENTH_CODE:
                country = Constants.SEVENTEENTH_COUNTRY;
                break;


            case Constants.EIGHTEENTH_CODE:
                country = Constants.EIGHTEENTH_COUNTRY;
                break;


            case Constants.NINETEENTH_CODE:
                country = Constants.NINETEENTH_COUNTRY;
                break;
            case Constants.TWENTETH_CODE:
                country = Constants.TWENTETH_COUNTRY;
                break;

        }
        return country;
    }

    private void setViews(){
        priceResponse = MainActivity.mainPriceResponse;
        switch (MainActivity.POSITION){
            case "1":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE= MainActivity.convertDouble(priceResponse.getNGN());
                break;

            case "2":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getAUD());
                break;

            case "3":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getGBP());
                break;

            case "4":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getCAD());
                break;

            case "5":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getCLP());
                break;

            case "6":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getCNY());
                break;

            case "7":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getCZK());
                break;

            case "8":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getDKK());
                break;

            case "9":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getEUR());
                break;

            case "10":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getHKD());
                break;

            case "11":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getHUF());
                break;

            case "12":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getINR());
                break;

            case "13":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getILS());
                break;

            case "14":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getJPY());
                break;

            case "15":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getKRW());
                break;

            case "16":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getMYR());
                break;

            case "17":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getBRL());
                break;

            case "18":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getMXN());
                break;

            case "19":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getNZD());
                break;

            case "20":
                currencyType.setText(getCountry(MainActivity.COUNTRY));
                SELECTED_COIN_PRICE=MainActivity.convertDouble(priceResponse.getIDR());
                break;


        }

        switch (MainActivity.SELECTED_COIN){
            case MainActivity.FIRST_COIN:
                coinType.setText(MainActivity.BTC.getFullName());
                break;

            case MainActivity.SECOND_COIN:
                coinType.setText(MainActivity.ETH.getFullName());
        }
    }

    private void convertCurrency(CharSequence charSequence){
        String coinPriceString = coinPrice.getText().toString();
        if (coinPriceString.length() == 0 || coinPriceString.isEmpty() ){
            coinPrice.setError("Provide a value");
        }else {
            String coinValue = SELECTED_COIN_PRICE;
            double coinDoubleValue = Double.parseDouble(coinValue) * Double.parseDouble(coinPriceString);

            String amount = charSequence.toString();
            double enteredAmount = Double.parseDouble(amount);

            String finalAmount = Double.toString(coinDoubleValue * enteredAmount);

            result.setText(finalAmount);
        }

    }

}
