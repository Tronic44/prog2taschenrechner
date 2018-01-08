public class Main {

	public static void main(String[] args) {
//	String input = "1 / 4-3i + 1 / 4+3i";
		
		String input = "1 + 2 * (3 + 4) + (5 * (2 / 2))";
		try {
			Parse.start(input);
		} catch (FailException e) {
			System.out.println();
			}
		
		
//		Object[] test ={1.0, "/", new Komplex(4,-3), "+", 1.0, "/" , new Komplex(4,3)};
////		Object[] test = {new Komplex(2,1), "/", new Komplex(1,-2)};
//		try {
//			System.out.println(Parse.resort(test));
//		} catch (FailException e) {
//			System.out.println("ups");
//		}
	}

	public static void stop(String error, Object a) throws FailException {
		System.out.println(error + ":  " + a);
		throw new FailException();
		
	}
	
	public static void stop() throws FailException {
		throw new FailException();
	}
	
}