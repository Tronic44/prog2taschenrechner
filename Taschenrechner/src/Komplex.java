
/**
 * Die Klasse Komplex, die fuer Komplexe Zahlendefiniert ist
 * 
 * @author yannick
 *
 */
public class Komplex {

	private double reell;
	private double imag;

	/**
	 * Konstruktor fuer die Klasse Komplex
	 * 
	 * @param reell
	 *            ist der Reelle Anteil der Komplexen Zahl
	 * @param imag
	 *            ist der Imaginaere Anteil der Komplexen Zahl
	 */
	public Komplex(double reell, double imag) {
		this.reell = Math.round(reell * 100.0) / 100.0;
		this.imag = Math.round(imag * 100.0) / 100.0;
	}

	/**
	 * Gibt eine Komplexe Zahl, gemaess der Notaion: "Reelleranteil +-
	 * Imaginaereranteil*i" aus, selbst wenn ein Anteil den Wert 0 hat. Allerdings
	 * wird aus optischen Gruenden die Zahl hier auf zwei Nachkommastellen gerundet!
	 */
	@Override
	public String toString() {
		if (this.imag == 0) {
			if (this.reell == 0) {
				return "" + 0;
			} else {
				return "" + reell;
			}
		} else {
			if (this.reell == 0) {
				if (this.imag > 0) {
					return "+" + imag + "i";
				} else {
					return "-" + imag * (-1) + "i";
				}
			}
		}

		if (this.imag > 0) {
			return "" + reell + " + i*" + imag;
		} else {
			return "" + reell + " -" + imag * (-1) + "i";
		}
	}

	/**
	 * Liefert den Reellen Anteil einer Komplexen Zahl
	 */
	public double getReell() {
		return reell;
	}

	/**
	 * Liefert den Imaginaeren Anteil einer Komplexen Zahl
	 */
	public double getImag() {
		return imag;
	}

	/**
	 * Bildet den reziproken Wert einer Komplexen Zahl
	 * 
	 * @return den Kehrwert als Komplexe Zahl
	 */
	public Komplex komrezi() {
		double rezireell = this.getReell() / (this.getReell() * this.getReell() + this.getImag() * this.getImag());
		double reziimag = (-1) * this.getImag() / (this.getReell() * this.getReell() + this.getImag() * this.getImag());
		return new Komplex(rezireell, reziimag);
	}
}
