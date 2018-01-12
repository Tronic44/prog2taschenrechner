
public class Bruch {
	private int nenner;
	private int zaehler;

	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler / ggT(zaehler, nenner);
		this.nenner = nenner / ggT(zaehler, nenner);
	}

	private static int ggT(int zahl1, int zahl2) {
		while (zahl2 != 0) {
			if (zahl1 > zahl2) {
				zahl1 = zahl1 - zahl2;
			} else {
				zahl2 = zahl2 - zahl1;
			}
		}
		return zahl1;
	}

	@Override
	public String toString() {
		if (this.nenner == 1) {
			return "" + this.zaehler;
		}
		return "" + this.zaehler + "/" + this.nenner;

	}

	public int getZeahler() {
		return zaehler;
	}

	public int getNenner() {
		return nenner;
	}
}
