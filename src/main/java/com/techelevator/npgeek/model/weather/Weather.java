package com.techelevator.npgeek.model.weather;

public class Weather {

	private String parkCode;
	private Integer fiveDayForecastValue;
	private Integer low;
	private Integer high;
	private String forecast;
	private String image;
	

	// Getters and Setters
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public Integer getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(Integer fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	// Methods
	public String getHighCelcius() {
		Double temp = ((high - 32) * (.5556));
		return  String.format("%.2f", temp) + " C";
	}

	public String getHighFahrenheit() {
		return high + " F";
	}

	public String getLowFahrenheit() {
		return low + " F";
	}

	public String getLowCelcius() {
		Double temp = ((low - 32) * (.5556));
		return  String.format("%.2f", temp) + " C";
	}

	public String getAlert() {

		StringBuilder str = new StringBuilder();

		if (forecast.equals("snow")) {
			str.append("Pack snowshoes. ");
		}
		if (forecast.equals("rain")) {
			str.append("Pack your rain gear and wear waterproof shoes. ");
		}
		if (forecast.equals("thunderstorms")) {
			str.append("Seek shelter and avoid hiking on exposed ridges. Watch for sharks. ");
		}
		if (forecast.equals("sunny")) {
			str.append("Pack sunblock. Nobody wants you glittering. ");
		}
		if ((high > 75) || (low > 75)) {
			str.append("Bring an extra gallon of water. Or you'll die. ");
		}
		if ((high - low) >= 20) {
			str.append("Wear breathable layers. ");
		}
		if ((high < 20) || (low < 20)) {
			str.append("Frigid temperatures will kill you. The Starks say 'Winter is Coming.' ");
		}
		return str.toString();
	}

}
