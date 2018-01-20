import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class GUI {

	JFrame frmTaschenrechnerByYannick;
	JTextField textField_eingabe;
	JTextField textField_ausgabe;

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTaschenrechnerByYannick = new JFrame();
		frmTaschenrechnerByYannick.setTitle("Taschenrechner by Yannick Dreher");
		frmTaschenrechnerByYannick.setBounds(100, 100, 776, 369);
		frmTaschenrechnerByYannick.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTaschenrechnerByYannick.getContentPane().setLayout(null);

		textField_eingabe = new JTextField();
		textField_eingabe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_eingabe.setBounds(17, 42, 718, 67);
		frmTaschenrechnerByYannick.getContentPane().add(textField_eingabe);
		textField_eingabe.setColumns(10);

		JLabel lblEingabe = new JLabel("Eingabe:");
		lblEingabe.setBounds(17, 19, 82, 23);
		frmTaschenrechnerByYannick.getContentPane().add(lblEingabe);

		textField_ausgabe = new JTextField();
		textField_ausgabe.setBackground(Color.WHITE);
		textField_ausgabe.setEditable(false);
		textField_ausgabe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_ausgabe.setBounds(17, 195, 434, 67);
		frmTaschenrechnerByYannick.getContentPane().add(textField_ausgabe);
		textField_ausgabe.setColumns(10);

		JLabel lblAusgabe = new JLabel("Ausgabe:");
		lblAusgabe.setBounds(17, 160, 82, 23);
		frmTaschenrechnerByYannick.getContentPane().add(lblAusgabe);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						textField_ausgabe.setText(Parse.start(textField_eingabe.getText()));
					} catch (NullPointerException a) {
						JOptionPane.showMessageDialog(null, "Kritscher Fehler:  " + a + " \n" + "Versuche mal Leerzeichen hinzuzufügen oder zu entfernen" );
						System.out.println("error1: "+a);
					} catch(Exception b) {
					}
				}
				textField_eingabe.requestFocus();
			}
		});
		btnBerechne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textField_ausgabe.setText(Parse.start(textField_eingabe.getText()));
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Kritscher Fehler:  " + e + " \n" + "Versuche mal Leerzeichen hinzuzufügen oder zu entfernen" );
					System.out.println("error2: " +e);
				}catch(Exception b) {
				}
			textField_eingabe.requestFocus();
			}
		});

		JButton btnHilfe = new JButton("Was kann ich eingeben?");
		btnHilfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Was darf man eingeben?" + "\n" + "Zahlen als Integer oder Double " + "\n" + "Natürlich + - * /"
								+ "\n" + "Für ein Bruch einfach '/' nutzen" + "\n"
								+ "Eine imaginäre Zahl einfach mit i kennzeichnen" + "\n" + "Belibig viele Klammern"
								+"\n" +"\n"+ "Muss ich noch was Beachten?" +"\n" +"Eigentlich nicht!"
								+ "\n" + "Viel Spaß");

				textField_eingabe.requestFocus();
			}
		});
		btnHilfe.setBounds(17, 108, 237, 23);
		frmTaschenrechnerByYannick.getContentPane().add(btnHilfe);
		btnBerechne.setBounds(530, 195, 205, 67);
		frmTaschenrechnerByYannick.getContentPane().add(btnBerechne);

		textField_eingabe.requestFocus();
		frmTaschenrechnerByYannick.getRootPane().setDefaultButton(btnBerechne);
		
		JButton btnDamitWeiterRechnen = new JButton("damit weiter rechnen");
		btnDamitWeiterRechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_eingabe.setText(textField_ausgabe.getText());
				textField_ausgabe.setText("");
				textField_eingabe.requestFocus();
			}
		});
		btnDamitWeiterRechnen.setBounds(224, 263, 227, 23);
		frmTaschenrechnerByYannick.getContentPane().add(btnDamitWeiterRechnen);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_eingabe.setText("");
			}
		});
		btnClear.setBounds(660, 104, 75, 31);
		frmTaschenrechnerByYannick.getContentPane().add(btnClear);
	}
}
