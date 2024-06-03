package lab07;

import java.time.LocalDate;

public final class House extends RealEstate {
	private double areaOfLand;

	public House(String street, int number, String city, PostalCode postalCode, double livingArea, double price,
			LocalDate offerDate, double areaOfLand) {
		super(street, number, city, postalCode, livingArea, price, offerDate);
		this.areaOfLand = areaOfLand;
	}

	public double getAreaOfLand() {
		return areaOfLand;
	}

	public void setAreaOfLand(int areaOfLand) {
		this.areaOfLand = areaOfLand;
	}

	@Override
	public String toString() {
		return super.toString() + " | Area of land: " + areaOfLand;
	}

}
