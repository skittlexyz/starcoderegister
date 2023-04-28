package registerSystem;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class RegisterSystem extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private String windowTitle = "StarCode Register";
	
	JFrame frame = new JFrame(windowTitle);
	
	public RegisterSystem() {
		frame.setLayout(null);
		frame.setSize(getPreferredSize());
	}
	public int showMenu() {
		JLabel title = new JLabel("StarCode - Escolha uma opção!");
		title.setBounds(10,10,450,15);
		JButton register = new JButton("Cadastrar");
		JButton search = new JButton("Pesquisar");
		JButton show = new JButton("Mostrar");
		JButton exit = new JButton("Sair");
		register.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            frame.setVisible(false);
	            
	            frame.setVisible(true);
	         }
	    });
		search.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.setVisible(false);
		            
	        	 frame.setVisible(true);
	         }
	    });
		show.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.setVisible(false);
		            
	        	 frame.setVisible(true);
	         }
	    });
		exit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 System.exit(0);
	         }
	    });
		register.setBounds(10,35,100,30);
		search.setBounds(120,35,100,30);
		show.setBounds(230,35,100,30);
		exit.setBounds(340,35,100,30);
		frame.add(title);
		frame.add(register);
		frame.add(search);
		frame.add(show);
		frame.add(exit);
		frame.setSize(470,120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return 0;
	}
	public Boolean confirmString(String text) {
		int answer = JOptionPane.showConfirmDialog(null, text, windowTitle, JOptionPane.YES_NO_CANCEL_OPTION);
		if (answer == 0) {
			return true;
		} else {
			return false;
		}
	}
	public void alertString(String text) {
		JOptionPane.showMessageDialog(null, text, windowTitle, JOptionPane.PLAIN_MESSAGE);
	}
}
