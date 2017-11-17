public class main {
	static int testaud = 0;
	static int testaud2 = 0;

	public static void main(String[] args) {
	//	mygui haupt = new mygui();
	//	haupt.setVisible(true);
	
	String input = "1 / 6 + 1 / 6";
		try {
			Parse.split(input);
		} catch (FailException e) {
			System.out.println();
			}
	
		Object[] test ={1.0, "/", new Komplex(4,-3), "+", 1.0, "/" , new Komplex(4,3)};
//		Object[] test = {new Komplex(2,-1), "/", new Komplex(1,-1)};
		try {
			System.out.println(Parse.resort(test));
		} catch (FailException e) {
			System.out.println("ups");
		}
	}

	public static void stop(String error, Object a) throws FailException {
		System.out.println(error + ":  " + a);
		throw new FailException();
		
	}
	
	public static void stop() throws FailException {
		throw new FailException();
	}
	
	
//helpbitte
}