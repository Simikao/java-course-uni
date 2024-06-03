package lab07;

public class PostalCode {
	private int okreg;
	private int strefa;
	private int sektor;
	private int placowkaPocztowa;
	private int obszarDzialania;

	public PostalCode(int postalCode) {
		this.okreg = postalCode / 10000;
		this.strefa = (postalCode % 10000) / 1000;
		this.sektor = (postalCode % 1000) / 100;
		this.placowkaPocztowa = (postalCode % 100) / 10;
		this.obszarDzialania = postalCode % 10;
	}

	@Override
	public String toString() {
		return String.format("%d%d-%d%d%d", okreg, strefa, sektor, placowkaPocztowa, obszarDzialania);
	}

	public int setPostalCode(int postalCode) {
		this.okreg = postalCode / 10000;
		this.strefa = (postalCode % 10000) / 1000;
		this.sektor = (postalCode % 1000) / 100;
		this.placowkaPocztowa = (postalCode % 100) / 10;
		this.obszarDzialania = postalCode % 10;
		return postalCode;
	}

	public int getPostalCode() {
		return okreg * 10000 + strefa * 1000 + sektor * 100 + placowkaPocztowa * 10 + obszarDzialania;
	}

}
