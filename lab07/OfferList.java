package lab07;

import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {
	private ArrayList<RealEstate> offertList = new ArrayList<RealEstate>();

	public void addOffert(RealEstate offert) {
		offertList.add(offert);
	}

	public void removeOffert(RealEstate offert) {
		offertList.remove(offert);
	}

	public ArrayList<RealEstate> filterOfferList(Predicate<RealEstate> predicate) {
		ArrayList<RealEstate> filteredList = new ArrayList<RealEstate>();
		for (RealEstate offert : offertList) {
			if (predicate.test(offert)) {
				filteredList.add(offert);
			}
		}
		return filteredList;
	}

	public void addOffer(RealEstate proprety) {
		offertList.add(proprety);
	}
}
