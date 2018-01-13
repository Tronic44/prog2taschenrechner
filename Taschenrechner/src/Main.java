import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmTaschenrechnerByYannick.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// String input = "1 / 4-3i + 1 / 4+3i";
		// String input = "4/6";
		// String input = "1+2*(3+4)+(5*(2/2))+4+3i";
		// try {
		// Parse.start(input);
		// } catch (FailException e) {
		// System.out.println();
		// }

	}

	public static void stop(String error, int code, Object a) throws FailException {
		JOptionPane.showMessageDialog(null, "Fehlercode: \"" + code + "\"" + "\n" + error + ": \" " + a + " \"");
		System.out.println(error + ":  " + a);
		throw new FailException();

	}

	public static void stop() throws FailException {
		throw new FailException();
	}

}