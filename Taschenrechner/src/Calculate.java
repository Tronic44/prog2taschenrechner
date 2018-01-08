
public class Calculate{
	
	
	private static double toDouble(Bruch a){
		return (double) a.getZeahler()/ (double) a.getNenner();
	}
	
	
	private static Bruch multtoBruch(Bruch a, double d){
		int k=10_000;
		int zaehler = (int)  (d*k*a.getZeahler());
		int nenner = (int) (a.getNenner()*k);
		return new Bruch(zaehler,nenner);
	}
	public static Object mult(Double double1, Double double2) {
		return double1*double2;
	}
	public static Object mult(Bruch a, Bruch b){
		return new Bruch(a.getZeahler()*b.getZeahler(),a.getNenner()*b.getNenner()); 
	}
	public static Object mult(Bruch a, double d){
		return multtoBruch(a,d);
	}
	public static Object mult(double d, Bruch b){
		return mult(b,d);		
	}
	public static Object mult(double d, Komplex i){
		Komplex i2 = new Komplex(d,0);
		double multreell = i2.getReell()*i.getReell()-i2.getImag()*i.getImag();
		double multimag = i2.getReell()*i.getImag();
		return new Komplex(multreell,multimag);
	}
	public static Object mult(Komplex i, double d){
		return mult(d,i);
	}
	public static Object mult(Komplex i, Bruch b){
		return mult(toDouble(b), i);
	}
	public static Object mult(Bruch b, Komplex i){
		return mult(toDouble(b),i);
	}
	public static Object mult(Komplex i, Komplex i2){
		double multreell = i2.getReell()*i.getReell()-i2.getImag()*i.getImag();
		double multimag = i2.getReell()*i.getImag()+i2.getImag()*i.getReell();
		return new Komplex(multreell,multimag);
	
	}
	
	
	
	
	
	
	public static Object add(double d1, double d2){
		return d1+d2;
		
	}
	public static Object add(double d, Bruch b1){
		int k = 10_000;
		return add(b1,new Bruch((int)d*k,k));
		
	}
	public static Object add(Bruch b, double d){
		return add(d,b);
	}
	public static Object add(Bruch b1, Bruch b2){
		return new Bruch(b1.getZeahler()*b2.getNenner()+b2.getZeahler()*b1.getNenner(),b1.getNenner()*b2.getNenner());
	}
	public static Object add(double d, Komplex i1){
		Komplex i2 = new Komplex(d,0);
		return add(i1,i2);
	}
	public static Object add(Komplex i, double d){
		return add(d,i);
	}
	public static Object add(Komplex i, Bruch b){
		return add(toDouble(b),i);
	}
	public static Object add(Bruch b, Komplex i){
		return add(toDouble(b),i);
	}
	public static Object add(Komplex i1, Komplex i2){
		return new Komplex(i1.getReell()+i2.getReell(),i1.getImag()+i2.getImag());
	}
	
	
	
	
	
	
	public static Object sub(double d1, double d2){
		return d1-d2;
	}
	public static Object sub(double d, Bruch b){
		int k = 10_000;
		return sub(b,new Bruch((int)d*k,k));
	}
	public static Object sub(Bruch b, double d){
		return sub(d,b);
	}
	public static Object sub(Bruch b1, Bruch b2){
		return new Bruch(b1.getZeahler()*b2.getNenner()-b2.getZeahler()*b1.getNenner(),b1.getNenner()*b2.getNenner());
	}
	public static Object sub(double d, Komplex i1){
		Komplex i2 = new Komplex(d,0);
		return sub(i2,i1);
	}
	public static Object sub(Komplex i, double d){
		return sub(d,i);
	}
	public static Object sub(Komplex i, Bruch b){
		return sub(i,toDouble(b));
	}
	public static Object sub(Bruch b, Komplex i){
		return sub(toDouble(b),i);
	}
	public static Object sub(Komplex i1, Komplex i2){
		return new Komplex(i1.getReell()-i2.getReell(),i1.getImag()-i2.getImag());
	}
	
	
	
	
	
	
	
	public static Object div(double d1, double d2){
		return d1/d2;
	}
	public static Object div(double d, Bruch b){
		return d/toDouble(b);
	}
	public static Object div(Bruch b, double d){
		return div(d,b);
	}
	public static Object div(Bruch b1, Bruch b2){
		return new Bruch(b1.getZeahler()*b2.getNenner(), b1.getNenner()* b2.getZeahler());
	}
	public static Object div(double d, Komplex i){
		Komplex i2 = new Komplex(d,0);
		return div(i2,i);
	}
	public static Object div(Komplex i, double d){
		return new Komplex(i.getReell()/d, i.getImag()/d);
	}
	public static Object div(Komplex i, Bruch b){
		return div(i,toDouble(b));
	}
	public static Object div(Bruch b, Komplex i){
		return div(toDouble(b),i);
	}
	public static Object div(Komplex i1, Komplex i2){
		Komplex k1 = new Komplex(i2.komrezi().getReell(), i2.komrezi().getImag());
		double multreellup = k1.getReell()*i1.getReell()-k1.getImag()*i1.getImag();
		double multimag = k1.getReell()*i1.getImag()+k1.getImag()*i1.getReell();
		double multreelldown = k1.getReell()*i2.getReell()-k1.getImag()*i2.getImag();
		return (new Komplex(multreellup/multreelldown, multimag/multreelldown));
	}
	
}
