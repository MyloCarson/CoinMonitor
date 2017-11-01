package mylocarson.coinmonitor.models;

import com.google.gson.annotations.SerializedName;


public class ETH {

	@SerializedName("Symbol")
	private String symbol;

	@SerializedName("ImageUrl")
	private String imageUrl;

	@SerializedName("SortOrder")
	private String sortOrder;

	@SerializedName("TotalCoinSupply")
	private String totalCoinSupply;

	@SerializedName("Algorithm")
	private String algorithm;

	@SerializedName("Url")
	private String url;

	@SerializedName("Name")
	private String name;

	@SerializedName("ProofType")
	private String proofType;

	@SerializedName("PreMinedValue")
	private String preMinedValue;

	@SerializedName("FullName")
	private String fullName;

	@SerializedName("TotalCoinsFreeFloat")
	private String totalCoinsFreeFloat;

	@SerializedName("Id")
	private String id;

	@SerializedName("FullyPremined")
	private String fullyPremined;

	@SerializedName("Sponsored")
	private boolean sponsored;

	@SerializedName("CoinName")
	private String coinName;

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setSortOrder(String sortOrder){
		this.sortOrder = sortOrder;
	}

	public String getSortOrder(){
		return sortOrder;
	}

	public void setTotalCoinSupply(String totalCoinSupply){
		this.totalCoinSupply = totalCoinSupply;
	}

	public String getTotalCoinSupply(){
		return totalCoinSupply;
	}

	public void setAlgorithm(String algorithm){
		this.algorithm = algorithm;
	}

	public String getAlgorithm(){
		return algorithm;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProofType(String proofType){
		this.proofType = proofType;
	}

	public String getProofType(){
		return proofType;
	}

	public void setPreMinedValue(String preMinedValue){
		this.preMinedValue = preMinedValue;
	}

	public String getPreMinedValue(){
		return preMinedValue;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setTotalCoinsFreeFloat(String totalCoinsFreeFloat){
		this.totalCoinsFreeFloat = totalCoinsFreeFloat;
	}

	public String getTotalCoinsFreeFloat(){
		return totalCoinsFreeFloat;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFullyPremined(String fullyPremined){
		this.fullyPremined = fullyPremined;
	}

	public String getFullyPremined(){
		return fullyPremined;
	}

	public void setSponsored(boolean sponsored){
		this.sponsored = sponsored;
	}

	public boolean isSponsored(){
		return sponsored;
	}

	public void setCoinName(String coinName){
		this.coinName = coinName;
	}

	public String getCoinName(){
		return coinName;
	}

	@Override
 	public String toString(){
		return 
			"ETH{" + 
			"symbol = '" + symbol + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",sortOrder = '" + sortOrder + '\'' + 
			",totalCoinSupply = '" + totalCoinSupply + '\'' + 
			",algorithm = '" + algorithm + '\'' + 
			",url = '" + url + '\'' + 
			",name = '" + name + '\'' + 
			",proofType = '" + proofType + '\'' + 
			",preMinedValue = '" + preMinedValue + '\'' + 
			",fullName = '" + fullName + '\'' + 
			",totalCoinsFreeFloat = '" + totalCoinsFreeFloat + '\'' + 
			",id = '" + id + '\'' + 
			",fullyPremined = '" + fullyPremined + '\'' + 
			",sponsored = '" + sponsored + '\'' + 
			",coinName = '" + coinName + '\'' + 
			"}";
		}
}