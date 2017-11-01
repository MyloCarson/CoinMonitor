package mylocarson.coinmonitor.models.priceModel;

import com.google.gson.annotations.SerializedName;

public class PriceResponse {

	@SerializedName("HKD")
	private double hKD;

	@SerializedName("MXN")
	private double mXN;

	@SerializedName("EUR")
	private double eUR;

	@SerializedName("DKK")
	private double dKK;

	@SerializedName("CLP")
	private double cLP;

	@SerializedName("CAD")
	private double cAD;

	@SerializedName("MYR")
	private double mYR;

	@SerializedName("INR")
	private double iNR;

	@SerializedName("CNY")
	private double cNY;

	@SerializedName("AUD")
	private double aUD;

	@SerializedName("ILS")
	private double iLS;

	@SerializedName("KRW")
	private double kRW;

	@SerializedName("JPY")
	private double jPY;

	@SerializedName("NGN")
	private double nGN;

	@SerializedName("GBP")
	private double gBP;

	@SerializedName("CZK")
	private double cZK;

	@SerializedName("IDR")
	private double iDR;

	@SerializedName("HUF")
	private double hUF;

	@SerializedName("NZD")
	private double nZD;

	@SerializedName("BRL")
	private double bRL;

	public void setHKD(double hKD){
		this.hKD = hKD;
	}

	public double getHKD(){
		return hKD;
	}

	public void setMXN(double mXN){
		this.mXN = mXN;
	}

	public double getMXN(){
		return mXN;
	}

	public void setEUR(double eUR){
		this.eUR = eUR;
	}

	public double getEUR(){
		return eUR;
	}

	public void setDKK(double dKK){
		this.dKK = dKK;
	}

	public double getDKK(){
		return dKK;
	}

	public void setCLP(double cLP){
		this.cLP = cLP;
	}

	public double getCLP(){
		return cLP;
	}

	public void setCAD(double cAD){
		this.cAD = cAD;
	}

	public double getCAD(){
		return cAD;
	}

	public void setMYR(double mYR){
		this.mYR = mYR;
	}

	public double getMYR(){
		return mYR;
	}

	public void setINR(double iNR){
		this.iNR = iNR;
	}

	public double getINR(){
		return iNR;
	}

	public void setCNY(double cNY){
		this.cNY = cNY;
	}

	public double getCNY(){
		return cNY;
	}

	public void setAUD(double aUD){
		this.aUD = aUD;
	}

	public double getAUD(){
		return aUD;
	}

	public void setILS(double iLS){
		this.iLS = iLS;
	}

	public double getILS(){
		return iLS;
	}

	public void setKRW(double kRW){
		this.kRW = kRW;
	}

	public double getKRW(){
		return kRW;
	}

	public void setJPY(double jPY){
		this.jPY = jPY;
	}

	public double getJPY(){
		return jPY;
	}

	public void setNGN(double nGN){
		this.nGN = nGN;
	}

	public double getNGN(){
		return nGN;
	}

	public void setGBP(double gBP){
		this.gBP = gBP;
	}

	public double getGBP(){
		return gBP;
	}

	public void setCZK(double cZK){
		this.cZK = cZK;
	}

	public double getCZK(){
		return cZK;
	}

	public void setIDR(double iDR){
		this.iDR = iDR;
	}

	public double getIDR(){
		return iDR;
	}

	public void setHUF(double hUF){
		this.hUF = hUF;
	}

	public double getHUF(){
		return hUF;
	}

	public void setNZD(double nZD){
		this.nZD = nZD;
	}

	public double getNZD(){
		return nZD;
	}

	public void setBRL(int bRL){
		this.bRL = bRL;
	}

	public double getBRL(){
		return bRL;
	}

	@Override
 	public String toString(){
		return 
			"PriceResponse{" + 
			"hKD = '" + hKD + '\'' + 
			",mXN = '" + mXN + '\'' + 
			",eUR = '" + eUR + '\'' + 
			",dKK = '" + dKK + '\'' + 
			",cLP = '" + cLP + '\'' + 
			",cAD = '" + cAD + '\'' + 
			",mYR = '" + mYR + '\'' + 
			",iNR = '" + iNR + '\'' + 
			",cNY = '" + cNY + '\'' + 
			",aUD = '" + aUD + '\'' + 
			",iLS = '" + iLS + '\'' + 
			",kRW = '" + kRW + '\'' + 
			",jPY = '" + jPY + '\'' + 
			",nGN = '" + nGN + '\'' + 
			",gBP = '" + gBP + '\'' + 
			",cZK = '" + cZK + '\'' + 
			",iDR = '" + iDR + '\'' + 
			",hUF = '" + hUF + '\'' + 
			",nZD = '" + nZD + '\'' + 
			",bRL = '" + bRL + '\'' + 
			"}";
		}
}