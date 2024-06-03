package lab07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void menu() {
		System.out.println("--- Menu ---");
		System.out.println("1. Add house offer");
		System.out.println("2. Add flat offer");
		System.out.println("3. Show all house offers");
		System.out.println("4. Show all flat offers");
		System.out.println("5. Show all house offers in city with living area not less than given value");
		System.out.println(
				"6. Show all flat offers in city not more expensive than given value and from given floor");
		System.out.println("7. Show all offers");
		System.out.println("0. Exit");

		System.out.print("Choose option: ");

	}

	public static int convertPostalCode(String code) {
		String newCode = code.replace("-", "");
		return Integer.parseInt(newCode);
	}

	public static void addNewHouseOffer(Scanner reader, OfferList offerList) {
		System.out.print("City: ");
		String city = reader.nextLine();
		System.out.print("Street: ");
		String street = reader.nextLine();
		System.out.print("House number: ");
		int houseNumber = reader.nextInt();
		reader.nextLine();
		System.out.print("Postal code: ");
		String postalCode = reader.nextLine();
		System.out.print("Living area: ");
		double livingArea = reader.nextDouble();
		System.out.print("Total area: ");
		double totalArea = reader.nextDouble();
		System.out.print("Price: ");
		double price = reader.nextDouble();
		reader.nextLine();
		System.out.print("Offer valid from (dd-mm-yyyy): ");
		String validFrom = reader.nextLine();

		int postalCodeInt = convertPostalCode(postalCode);
		PostalCode newPostalCode = new PostalCode(postalCodeInt);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate validDate = LocalDate.parse(validFrom, formatter);

		House house = new House(street, houseNumber, city, newPostalCode, livingArea, price, validDate,
				totalArea);
		offerList.addOffer(house);

		System.out.println("House added");
	}

	public static void AddNewFlatOffer(Scanner reader, OfferList offerList) {
		System.out.print("City: ");
		String city = reader.nextLine();
		System.out.print("Street: ");
		String street = reader.nextLine();
		System.out.print("House number: ");
		int houseNumber = reader.nextInt();
		reader.nextLine();
		System.out.print("Flat number: ");
		int flatNumber = reader.nextInt();
		reader.nextLine();
		System.out.print("Floor: ");
		int floor = reader.nextInt();
		reader.nextLine();
		System.out.print("Postal code: ");
		String postalCode = reader.nextLine();
		System.out.print("Living area: ");
		double livingArea = reader.nextDouble();
		System.out.print("Price: ");
		double price = reader.nextDouble();
		reader.nextLine();
		System.out.print("Offer valid from (dd-mm-yyyy): ");
		String validFrom = reader.nextLine();

		int postalCodeInt = convertPostalCode(postalCode);
		PostalCode newPostalCode = new PostalCode(postalCodeInt);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate validDate = LocalDate.parse(validFrom, formatter);

		Flat flat = new Flat(street, houseNumber, city, newPostalCode, livingArea, price, validDate,
				floor, flatNumber);
		offerList.addOffer(flat);

		System.out.println("Flat added");
	}

	public static void showAllAvailableHouses(OfferList offerList) {
		LocalDate date = LocalDate.now();

		ArrayList<RealEstate> filteredList = offerList.filterOfferList(offer -> offer instanceof House
				&& (offer.getOfferDate().isAfter(date) || offer.getOfferDate().isEqual(date)));
		for (RealEstate offer : filteredList) {
			System.out.println(offer);
		}
	}

	public static void showAllAvailableFlats(OfferList offerList) {
		LocalDate date = LocalDate.now();

		ArrayList<RealEstate> filteredList = offerList.filterOfferList(offer -> offer instanceof Flat
				&& (offer.getOfferDate().isAfter(date) || offer.getOfferDate().isEqual(date)));
		for (RealEstate offer : filteredList) {
			System.out.println(offer);
		}
	}

	public static void showHouseSpecifiedSearch(OfferList offerList, Scanner reader) {
		System.out.print("City: ");
		String city = reader.nextLine();
		System.out.print("Living area: ");
		double livingArea = reader.nextDouble();

		ArrayList<RealEstate> filteredList = offerList.filterOfferList(
				offer -> offer instanceof House && offer.getCity().equals(city)
						&& offer.getLivingArea() >= livingArea);
		for (RealEstate offer : filteredList) {
			System.out.println(offer);
		}
	}

	public static void showFlatSpecifiedSearch(OfferList offerList, Scanner reader) {
		System.out.print("City: ");
		String city = reader.nextLine();
		System.out.print("Price: ");
		double price = reader.nextDouble();
		System.out.print("Floor: ");
		int floor = reader.nextInt();

		ArrayList<RealEstate> filteredList = offerList.filterOfferList(
				offer -> offer instanceof Flat && offer.getCity().equals(city)
						&& offer.getPrice() <= price && ((Flat) offer).getFloor() >= floor);
		for (RealEstate offer : filteredList) {
			System.out.println(offer);
		}
	}

	public static void populateOfferList(OfferList offerList) {

		PostalCode postalCode1 = new PostalCode(12345);
		PostalCode postalCode2 = new PostalCode(54321);
		PostalCode postalCode3 = new PostalCode(98765);
		PostalCode postalCode4 = new PostalCode(56789);
		PostalCode postalCode5 = new PostalCode(13579);

		LocalDate date = LocalDate.now();
		LocalDate date1 = date.minusDays(2);
		LocalDate date2 = date.minusDays(1);
		LocalDate date3 = date;
		LocalDate date4 = date.plusDays(1);
		LocalDate date5 = date.plusDays(2);

		House house1 = new House("Street1", 1, "City1", postalCode1, 100, 100000, date1, 200);
		House house2 = new House("Street2", 2, "City2", postalCode2, 200, 200000, date2, 300);
		House house3 = new House("Street3", 3, "City3", postalCode3, 300, 300000, date3, 400);
		House house4 = new House("Street4", 4, "City4", postalCode4, 400, 400000, date4, 500);
		House house5 = new House("Street5", 5, "City4", postalCode5, 500, 500000, date5, 600);

		Flat flat1 = new Flat("Street1", 1, "City1", postalCode1, 100, 100000, date1, 1, 1);
		Flat flat2 = new Flat("Street2", 2, "City2", postalCode2, 200, 200000, date2, 2, 2);
		Flat flat3 = new Flat("Street3", 3, "City3", postalCode3, 300, 300000, date3, 3, 3);
		Flat flat4 = new Flat("Street4", 4, "City5", postalCode4, 400, 400000, date4, 4, 4);
		Flat flat5 = new Flat("Street5", 5, "City5", postalCode5, 500, 500000, date5, 4, 4);
		Flat flat6 = new Flat("Street6", 6, "City5", postalCode1, 600, 500000, date1, 3, 3);
		Flat flat7 = new Flat("Street7", 7, "City5", postalCode2, 700, 700000, date2, 4, 4);

		offerList.addOffer(house1);
		offerList.addOffer(house2);
		offerList.addOffer(house3);
		offerList.addOffer(house4);
		offerList.addOffer(house5);

		offerList.addOffer(flat1);
		offerList.addOffer(flat2);
		offerList.addOffer(flat3);
		offerList.addOffer(flat4);
		offerList.addOffer(flat5);
		offerList.addOffer(flat6);
		offerList.addOffer(flat7);

	}

	public static void showAllOffers(OfferList offerList) {
		ArrayList<RealEstate> filteredList = offerList.filterOfferList(offer -> true);
		for (RealEstate offer : filteredList) {
			System.out.println(offer);
		}
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		OfferList offerList = new OfferList();
		boolean exit = false;

		while (!exit) {
			menu();
			int option = reader.nextInt();
			reader.nextLine();
			switch (option) {
				case 1 -> addNewHouseOffer(reader, offerList);
				case 2 -> AddNewFlatOffer(reader, offerList);
				case 3 -> showAllAvailableHouses(offerList);
				case 4 -> showAllAvailableFlats(offerList);
				case 5 -> showHouseSpecifiedSearch(offerList, reader);
				case 6 -> showFlatSpecifiedSearch(offerList, reader);
				case 7 -> showAllOffers(offerList);
				case 0 -> exit = true;
				case 99 -> populateOfferList(offerList);
			}
		}
	}
}
