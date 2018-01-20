import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Object[] test ={1.0, "/", new Komplex(4,-3), "+", 1.0, "/" , new Komplex(4,3)};
		 //		Object[] test = {new Komplex(2,-1), "/", new Komplex(1,-1)};
		 		try {
		 			System.out.println(Parse.resort(test));
		 		} catch (FailException e) {
		 			System.out.println("ups");
		 		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					GUI window = new GUI();
					window.frmTaschenrechnerByYannick.setVisible(true);
//					Object[] = {new Komplex (1,2), "*", 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void stop(String error, int code, Object a) throws FailException {
		JOptionPane.showMessageDialog(null, "Fehlercode: \"" + code + "\"" + "\n" + error + ": \" " + a + " \"");
		throw new FailException();

	}

	public static void stop() throws FailException {
		throw new FailException();
	}

}

//negative zahlen (bei + und -)
//3.5* 1/2
//3.5*11/21
//remove leere neu schreiben
//ab und zu wird keine ausgabe gemacht und kein Fehler geworfen