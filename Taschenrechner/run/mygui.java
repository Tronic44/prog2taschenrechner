import javax.swing.*;

public class mygui extends JFrame {
	public mygui(){
		setTitle("Simpler Taschenrechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(400,400);
		JPanel p = new JPanel();
		add(p);
		JButton b1 = new JButton("=");
		JTextField in = new JTextField("", 10);
		p.add(in);
		p.add(b1);
		
		
		
		pack();

	}
}
