package lab02.org;

public class Walec {
	private double r;
	private double h;

	public Walec(double r, double h) {
		this.r = r;
		this.h = h;
	}

	public Walec() {
	}

	public void setRadius(double r) {
		this.r = r;
	}

	public void setHeight(double h) {
		this.h = h;
	}

	public double getRadius() {
		return this.r;
	}

	public double getHeight() {
		return this.h;
	}

	public double baseArea() {
		return Math.PI * Math.pow(this.r, 2);
	}

	public double latSurfaceArea() {
		return 2 * Math.PI * this.r * this.h;
	}

	public double totSurfaceArea() {
		return 2 * baseArea() + latSurfaceArea();
	}

	public double volume() {
		return baseArea() * this.h;
	}
}
