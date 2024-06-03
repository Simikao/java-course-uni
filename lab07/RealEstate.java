package lab07;

import java.time.LocalDate;

sealed abstract class RealEstate permits House, Flat {
	protected String street;
	protected int number;
	protected String city;
	protected PostalCode postalCode;
	protected double livingArea;
	protected double price;
	protected LocalDate offerDate;

	public RealEstate(String street, int number, String city, PostalCode postalCode, double livingArea,
			double price, LocalDate offerDate) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.postalCode = postalCode;
		this.livingArea = livingArea;
		this.price = price;
		this.offerDate = offerDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public double getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(double livingArea) {
		this.livingArea = livingArea;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(LocalDate offerDate) {
		this.offerDate = offerDate;
	}

	public String toString() {
		return "Address: " + street + " " + number + ", " + city + ", " + postalCode + " | Living Area: "
				+ livingArea + " | Price: " + price
				+ " | Available? " + (LocalDate.now().compareTo(offerDate) >= 0 ? "Yes " : "No ");
	}
}
