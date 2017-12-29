import java.util.regex.Pattern;

public class Parse {
	private static Object[] list = new Object[10];
	private static Object[] clip = new Object[10];
	private static String input;

	/**
	 * Diese Methode teilt den Eingabe String in ein Array auf, und wandelt es ein
	 * ein Object Array um Modifiziert die Klassenvariable Object list[] und clip[]!
	 * 
	 * @param input
	 *            Der Input String, der ANalysiert werden soll
	 * @throws FailException
	 */
	public static void start(String start) throws FailException {
		input = split(new StringBuilder(start)).toString();
		testeklammer(input);
		split(new StringBuilder(input));

		//
		// if(input.contains("(")&&input.contains(")")){
		// String sclip = "";
		// String first = "";
		// try{
		// sclip = input.substring(input.indexOf("("), input.indexOf(")")+2);
		// first = sclip.substring(1, sclip.length()-2);
		// }catch(Exception e){
		// try{
		// sclip = input.substring(input.indexOf("("), input.indexOf(")")+1);
		// first = sclip.substring(1, sclip.length()-1);
		// }catch(Exception g){
		// Main.stop("Irgendwie stimmt die Klammer nicht! #210", input);
		// }
		// }
		// String[] firstsplit = first.split(" ");
		// for(int j = 0; j<firstsplit.length; j++){
		// clip[j] = search(firstsplit[j]);
		// }
		// input = input.replaceAll(Pattern.quote(sclip), resort(clip).toString()+"
		// ");//hier muss das ergebnis von der Klammer rein!
		// }
		//
		//
		//
		//
		// String[] split = input.split(" ");
		// for (int i = 0; i < split.length; i++) {
		// list[i] = search(split[i]);
		// }
		// for(Object i: list){
		// System.out.println(i);
		// }

		System.out.println(input);
		System.out.println(resort(list));
	}

	public static StringBuilder split(StringBuilder start) throws FailException {
		// String temp;
		int klammer = countklammer(start);
		// while (klammer > 1) {
		// input.substring(beginIndex);
		for (int i = 1; i < start.length(); i++) {
			if (start.charAt(i) == '(') {
				String temp = split(new StringBuilder(start.substring(i))).toString();
				System.out.println(1 + "" + temp);
				String alt = start.toString();
				input = alt.replaceAll(Pattern.quote(alt), temp + " ");// error... die zeile stimmt nicht!
			}
			if (start.charAt(i) == ')') {
				String first = start.substring(1, i - 1);
				System.out.println(2 + "" + first);
				String[] firstsplit = first.split(" ");
				for (int j = 0; j < firstsplit.length; j++) {
					clip[j] = search(firstsplit[j]);
				}
				klammer--;
				return new StringBuilder(resort(clip).toString());
			}

		}
		// }
		return new StringBuilder(start);

	}

	public static boolean testeklammer(String start) throws FailException {
		int auf = 0, zu = 0, wechsel = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == '(') {
				auf++;
				wechsel++;
			}
			if (start.charAt(i) == ')') {
				zu++;
				wechsel--;
			}
		}
		if (wechsel < 0) {
			System.out.println(auf + "   " + zu + "   " + wechsel);
			Main.stop("Falsche Klammersetzung #201", input);
		}
		if (auf == zu) {
			return true;
		} else {
			Main.stop("Falsche Klammersetzung #202", input);
		}
		return false;
	}

	public static int countklammer(StringBuilder start) throws FailException {
		int zu = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == ')') {
				zu++;
			}
		}
		return zu;
	}

	/**
	 * Teste auf Eigentschaften des Strings, wie z.B. ob es eine Dezimalzahl ist,
	 * ein Bruch etc.
	 * 
	 * @param check
	 *            der zu Analysierende String
	 * @return das gefundene Object
	 * @throws FailException
	 */
	private static Object search(String check) throws FailException {
		if (check == null) {
			return "error";
		}
		try {
			return Double.parseDouble(check);
		} catch (Exception e) {
		}
		if (check.contains("i")) {
			return readimag(check);
		}
		switch (check) {
		case "+":
			return "+";
		case "-":
			return "-";
		case "*":
			return "*";
		case "/":
			return "/";
		default:
			if (check.contains("/")) {
				int zaehler = 0;
				int nenner = 0;
				String[] newbruch = check.split("/");
				if (newbruch.length == 2) {
					try {
						zaehler = Integer.parseInt(newbruch[0]);
						nenner = Integer.parseInt(newbruch[1]);
						return new Bruch(zaehler, nenner);
					} catch (NumberFormatException e) {
						Main.stop("In Br�chen stehen ganze Zahlen #221", check);
					}
				} else {
					Main.stop("Kein echter Bruch #222", check);
				}
			}
			Main.stop("kein G�ltiges Zeichen #223", check);
			return null;
		}

	}

	/**
	 * testet alle Kombinationen, wie eine Imagin�re Zahl aufgabut ist
	 * 
	 * @param check
	 *            die zu �berpr�fende Zeichenkette
	 * @return die fertige Imagin�re Zahl
	 * @throws FailException
	 *             falls eine Konvetion nicht eingehalten wurde
	 */
	private static Komplex readimag(String check) throws FailException {
		double reell, imag;
		try {
			if (check.contains("+")) {
				String[] newimag = check.split("\\+");
				if (newimag.length == 2) {
					if (newimag[1].contains("i")) {
						reell = Double.parseDouble(newimag[0]);
						imag = Double.parseDouble(newimag[1].replaceAll("i", ""));
						return new Komplex(reell, imag);
					} else {
						reell = Double.parseDouble(newimag[1]);
						imag = Double.parseDouble(newimag[0].replaceAll("i", ""));
						return new Komplex(reell, imag);
					}
				} else {
					Main.stop("keine g�ltige Imagin�re Zahl #231", check);
				}
			} else {
				if (check.contains("-")) {
					String[] newimag = check.split("-");
					if (newimag.length == 2) {
						if (newimag[1].contains("i")) {
							reell = Double.parseDouble(newimag[0]);
							imag = Double.parseDouble(newimag[1].replaceAll("i", ""));
							return new Komplex(reell, imag * (-1));
						} else {
							reell = Double.parseDouble(newimag[1]);
							imag = Double.parseDouble(newimag[0].replaceAll("i", ""));
							return new Komplex(reell, imag * (-1));
						}
					} else {
						Main.stop("keine g�ltige Imagin�re Zahl #232", check);
					}
				} else {
					Main.stop("keine g�ltige Imagin�re Zahl #233", check);
				}
			}
			Main.stop("keine g�ltige Imagin�re Zahl #234", check);
		} catch (Exception e) {
			Main.stop("Keine g�ltige Imagin�re Zahl #235", check);
		}
		return null;
	}

	/**
	 * Z�hlt die Elemente abz�glich 'null'
	 * 
	 * @param count
	 *            Object-Array
	 * @return Int-Anzahl der Elemente abz�glich derer, die 'null' sind
	 */
	private static int nullcounter(Object[] count) {
		int real = 0;
		for (int k = 0; count.length > k; k++) {
			if (count[k] != null) {
				real += 1;
			}
		}
		return real;
	}

	/**
	 * Testet, ob noch '*' oder '/' im Object-Array enthalten sind
	 * 
	 * @param count
	 *            Object-Array
	 * @return Boolean
	 */
	private static boolean punktcounter(Object[] count) {
		int test = 0;
		for (int h = 0; count.length > h; h++) {
			if (count[h].equals("*") || count[h].equals("/")) {
				test += 1;
			}
		}
		if (test == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Testet, ob noch '+' oder '-' im Object-Array enthalten sind
	 * 
	 * @param count
	 *            Object-Array
	 * @return Boolean
	 */
	private static boolean strichcounter(Object[] count) {
		int test = 0;
		for (int h = 0; count.length > h; h++) {
			if (count[h].equals("+") || count[h].equals("-")) {
				test += 1;
			}
		}
		if (test == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Entfernt alle 'null' -Objecte und "sortiert" das Array neu und k�rzt es auf
	 * die minimale Gr��e
	 * 
	 * @param all
	 * @return Das verkleinerte Object-Array
	 */
	private static Object[] removenull(Object[] all) {
		Object[] allmini = new Object[nullcounter(all)];
		for (int l = 0; allmini.length > l; l++) {
			try {
				allmini[l] = all[l];
			} catch (Exception e) {
				break;
			}
		}
		return allmini;
	}

	public static Object resort(Object[] all) throws FailException {
		// wenn das Array nur noch ein Element hat, muss es die L�sung sein
		if (all.length == 1) {
			return all[0];
		}
		// wenn nicht wird das Array genommen, kopiert und alle leeren eintr�ge entfernt
		Object[] allmini = all;
		// das gek�rzte Array wird jetzt im sinne von punkt vor strich durchgegangen und
		// berechnet
		Object result;
		while (punktcounter(removenull(allmini))) {
			allmini = removenull(allmini);
			for (int i = 0; allmini.length > i; i++) {
				result = decidepunkt(allmini, i);
				if (result != null) {
					allmini[i - 1] = result;
					for (int j = i; allmini.length > j; j++) {
						try {
							allmini[j] = allmini[j + 2];
						} catch (Exception e) {
							allmini[j] = null;
						}
					}
					break;
				} else {
					continue;
				}

			}
		}
		while (strichcounter(removenull(allmini))) {
			allmini = removenull(allmini);
			for (int i = 0; allmini.length > i; i++) {
				result = decidestrich(allmini, i);
				if (result != null) {
					allmini[i - 1] = result;
					for (int j = i; allmini.length > j; j++) {
						try {
							allmini[j] = allmini[j + 2];
						} catch (Exception e) {
							allmini[j] = null;
						}
					}
					break;
				} else {
					continue;
				}

			}
		}
		// das nun verk�rze Arry durchl�uft die berechnung nochmal
		return resort(removenull(allmini));
	}

	private static Object decidepunkt(Object[] all, int i) throws FailException {
		try {
			if (all[i] == null) {
				return null;
			}
			if (all[i].equals("*")) {
				switch (all[i - 1].getClass().getName()) {
				case "Bruch":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.mult((Bruch) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.mult((Bruch) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.mult((Bruch) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #251", all[i + 1]);
						break;
					}
					break;
				case "Komplex":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.mult((Komplex) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.mult((Komplex) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.mult((Komplex) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #252", all[i + 1]);
						break;
					}
				case "java.lang.Double":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.mult((Double) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.mult((Double) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.mult((Double) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #253", all[i + 1]);
						break;
					}
				default:
					Main.stop("Fataler Dicide Error #254", "Error");
					break;
				}
			}
			if (all[i].equals("/")) {
				switch (all[i - 1].getClass().getName()) {
				case "Bruch":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.div((Bruch) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.div((Bruch) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.div((Bruch) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #255", all[i + 1]);
						break;
					}
					break;
				case "Komplex":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.div((Komplex) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.div((Komplex) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.div((Komplex) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #256", all[i + 1]);
						break;
					}
				case "java.lang.Double":
					switch (all[i + 1].getClass().getName()) {
					case "Komplex":
						return Calculate.div((Double) all[i - 1], (Komplex) all[i + 1]);
					case "Bruch":
						return Calculate.div((Double) all[i - 1], (Bruch) all[i + 1]);
					case "java.lang.Double":
						return Calculate.div((Double) all[i - 1], (Double) all[i + 1]);
					default:
						Main.stop("Dicide Error #257", all[i + 1]);
						break;
					}
				default:
					Main.stop("Fataler Dicide Error #258", "Error");
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			Main.stop("Falsche Eingabe", all[i]);
		}

		return null;

	}

	public static Object decidestrich(Object[] all, int i) throws FailException {
		if (all[i].equals("+")) {
			switch (all[i - 1].getClass().getName()) {
			case "Bruch":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.add((Bruch) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.add((Bruch) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.add((Bruch) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #261", all[i + 1]);
					break;
				}
				break;
			case "Komplex":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.add((Komplex) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.add((Komplex) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.add((Komplex) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #262", all[i + 1]);
					break;
				}
			case "java.lang.Double":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.add((Double) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.add((Double) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.add((Double) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #263", all[i + 1]);
					break;
				}
			default:
				Main.stop("Fataler Dicide Error #264", "Error");
				break;
			}
		}
		if (all[i].equals("-")) {
			switch (all[i - 1].getClass().getName()) {
			case "Bruch":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.sub((Bruch) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.sub((Bruch) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.sub((Bruch) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #265", all[i + 1]);
					break;
				}
				break;
			case "Komplex":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.sub((Komplex) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.sub((Komplex) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.sub((Komplex) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #266", all[i + 1]);
					break;
				}
			case "java.lang.Double":
				switch (all[i + 1].getClass().getName()) {
				case "Komplex":
					return Calculate.sub((Double) all[i - 1], (Komplex) all[i + 1]);
				case "Bruch":
					return Calculate.sub((Double) all[i - 1], (Bruch) all[i + 1]);
				case "java.lang.Double":
					return Calculate.sub((Double) all[i - 1], (Double) all[i + 1]);
				default:
					Main.stop("Dicide Error #267", all[i + 1]);
					break;
				}
			default:
				Main.stop("Fataler Dicide Error #268", "Error");
				break;
			}
		}
		return null;
	}

}