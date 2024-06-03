package lab07;

import java.time.LocalDate;

public final class Flat extends RealEstate {
	private int flatNumber;

	private int floor;

	public Flat(String street, int number, String city, PostalCode postalCode, double livingArea, double price,
			LocalDate offerDate, int floor, int flatNumber) {
		super(street, number, city, postalCode, livingArea, price, offerDate);
		this.floor = floor;
		this.flatNumber = flatNumber;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String toString() {
		return super.toString() + " | Floor: " + floor + " Flat number: " + flatNumber;
	}
}
