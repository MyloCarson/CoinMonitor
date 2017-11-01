package mylocarson.coinmonitor.models;

import com.google.gson.annotations.SerializedName;



public class Data {

    public BTC getbTC() {
        return bTC;
    }

    public void setbTC(BTC bTC) {
        this.bTC = bTC;
    }

    public ETH geteTH() {
        return eTH;
    }

    public void seteTH(ETH eTH) {
        this.eTH = eTH;
    }

    public DASH getDash() {
        return dash;
    }

    public void setDash(DASH dash) {
        this.dash = dash;
    }

    @SerializedName("BTC")
	private BTC bTC;
	@SerializedName("ETH")
	private ETH eTH;

	@SerializedName("DASH")
	private DASH dash;

	@Override
	public String toString(){
		return
				"Data{" +

						",btc = '" + bTC + '\'' +
						",eth = '" + eTH + '\'' +
						",dash = '" + dash + '\''+
						"}";
	}
}