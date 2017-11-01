package mylocarson.coinmonitor.api;

import mylocarson.coinmonitor.models.CoinResponse;
import mylocarson.coinmonitor.models.priceModel.PriceResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 28/10/2017.
 */

public interface CryptoMonitorApi {
    @GET("all/coinlist")
    Call<CoinResponse> cb();

    @GET("price?fsym=BTC&tsyms=NGN,AUD,GBP,CAD,CLP,CNY,CZK,DKK,EUR,HKD,HUF,INR,ILS,JPY,KRW,MYR,BRL,MXN,NZD,IDR")
    Call<PriceResponse> getPricesBTC();

    @GET("price?fsym=BTC&tsyms=NGN,AUD,GBP,CAD,CLP,CNY,CZK,DKK,EUR,HKD,HUF,INR,ILS,JPY,KRW,MYR,BRL,MXN,NZD,IDR")
    Call<PriceResponse> getPricesETH();

//    @GET("price?fsym={coinType}&tsyms=AUD")
//    Call<AUDResponse> getAUD_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=GBP")
//    Call<GBPResponse> getGBP_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=CAD")
//    Call<CADResponse> getCAD_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=CLP")
//    Call<CLPResponse> getCLP_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=CNY")
//    Call<CNYResponse> getCNY_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=CZK")
//    Call<CZKResponse> getCZK_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=DKK")
//    Call<DKKResponse> getDKK_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=EUR")
//    Call<EURResponse> getEUR_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=HKD")
//    Call<HKDResponse> getHKD_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=HUF")
//    Call<HUFResponse> getHUF_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=INR")
//    Call<INRResponse> getINR_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=ILS")
//    Call<ILSResponse> getILS_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=JPY")
//    Call<JPYResponse> getJPY_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=KRW")
//    Call<KRWResponse> getKRW_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=MYR")
//    Call<MYRResponse> getMYR_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=BRL")
//    Call<BRLResponse> getBRL_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=MXN")
//    Call<MXNResponse> getMXN_price(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=NZD")
//    Call<NZDResponse> getNZDprice(@Path("coinType") String coinType);
//
//    @GET("price?fsym={coinType}&tsyms=IDR")
//    Call<IDRResponse> getIDR_price(@Path("coinType") String coinType);




}

