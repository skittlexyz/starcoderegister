package system;

import client.individualUser;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Register extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private String windowTitle = "StarCode Register";
	
	JFrame frame = new JFrame(windowTitle);
	ArrayList<individualUser> users = new ArrayList<individualUser>();
	private int usersQuantity = 0;
	
	public Register() {
		frame.setLayout(null);
		frame.setSize(getPreferredSize());
		frame.setResizable(false);
	}
	public void launch() {
		showMainMenu();
	}
	private void showMainMenu() {
		JLabel title = new JLabel("StarCode - Escolha uma opção!");
		title.setBounds(10,10,450,15);
		JButton register = new JButton("Cadastrar");
		JButton search = new JButton("Pesquisar");
		JButton show = new JButton("Mostrar");
		JButton exit = new JButton("Sair");
		register.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            showRegisterMenu();
	            showMainMenu();
	         }
	    });
		search.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		         showSearchMenu();
	        	 showMainMenu();
	         }
	    });
		show.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		         showShowMenu();
	        	 showMainMenu();
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
		frame.setSize(460,110);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private Boolean showRegisterMenu() {
		frame.setVisible(false);
		users.add(new individualUser());
		
		String name = checkForString(JOptionPane.showInputDialog(null, "Digite seu nome!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);
		if (name == "") {
			showMainMenu();
			return false;
		} else {
			users.get(usersQuantity).name = name;
		}
		String email = checkForString(JOptionPane.showInputDialog(null, "Digite seu email!", windowTitle, JOptionPane.QUESTION_MESSAGE), 2);
		if (email == "") {
			showMainMenu();
			return false;
		} else {
			users.get(usersQuantity).email = email;
		}
		long tel = checkForNumber(JOptionPane.showInputDialog(null, "Digite seu telefone!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);
		if (tel == 0) {
			showMainMenu();
			return false;
		} else {
			users.get(usersQuantity).tel = tel;
		}
		long zipcode = checkForNumber(JOptionPane.showInputDialog(null, "Digite seu zipcode!", windowTitle, JOptionPane.QUESTION_MESSAGE), 2);
		if (zipcode == 0) {
			showMainMenu();
			return false;
		} else {
			users.get(usersQuantity).zipcode = zipcode;
		}
		usersQuantity++;
		return true;
	}
	private Boolean showSearchMenu() {
		frame.setVisible(false);
		String search = JOptionPane.showInputDialog(null, "Digite o nome para procurar!", windowTitle, JOptionPane.QUESTION_MESSAGE);
		String text = "";
		for(int i = 0; i < usersQuantity; i++) {
			if(deAccent(search.toLowerCase()).equals(deAccent(users.get(i).name.toLowerCase()))) {
				text += "ID: " + (i+1) +
						"\nNome: " + users.get(i).name +
						"\nEmail: " + users.get(i).email +
						"\nTelefone: " + users.get(i).tel +
						"\nZipcode: " + users.get(i).zipcode;
				JOptionPane.showMessageDialog(null, text, windowTitle, JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Não encontrado!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
		return true;
	}
	private void showShowMenu() {
		frame.setVisible(false);
		String text = "";
		for(int i = 0; i < usersQuantity; i++) {
			if (i == 0) {
				text += "ID: " + (i+1) +
						"\nNome: " + users.get(i).name +
						"\nEmail: " + users.get(i).email +
						"\nTelefone: " + users.get(i).tel +
						"\nZipcode: " + users.get(i).zipcode;
			} else {
				text += "ID: " + (i+1) +
						"\nNome: " + users.get(i).name +
						"\nEmail: " + users.get(i).email +
						"\nTelefone: " + users.get(i).tel +
						"\nZipcode: " + users.get(i).zipcode + "\n\n";
			}
			
		}
		JTextArea textArea = new JTextArea(text);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		textArea.setEditable(false);
		scrollPane.setPreferredSize( new Dimension(100, 90));
		JOptionPane.showMessageDialog(null, scrollPane, windowTitle, JOptionPane.INFORMATION_MESSAGE);
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
	private String checkForString(String current, int variation) {
		if (current == null) {
			return "";
		} else {
			if (current == "" || current.length() <= 0) {
				JOptionPane.showMessageDialog(null, "O texto não pode ficar vazio!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
				if (variation == 1) {
					return checkForString(JOptionPane.showInputDialog(null, "Digite seu nome!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);				
				} else if (variation == 2) {
					return checkForString(JOptionPane.showInputDialog(null, "Digite seu email!", windowTitle, JOptionPane.QUESTION_MESSAGE), 2);					
				}
			} else {				
				return current;
			}
		}
		return "";
	}
	private long checkForNumber(String current, int variation) {
		if (current == null) {
			return 0;
		} else {	
			if (current == "" || current.length() <= 0) {
				JOptionPane.showMessageDialog(null, "O texto não pode ficar vazio!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
				if (variation == 1) {
					return checkForNumber(JOptionPane.showInputDialog(null, "Digite seu telefone!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);				
				} else if (variation == 2) {
					return checkForNumber(JOptionPane.showInputDialog(null, "Digite seu zipcode!", windowTitle, JOptionPane.QUESTION_MESSAGE), 2);					
				}
			} else {				
				try {
					long number = Long.parseLong(current);
					return number;
				} catch (NumberFormatException nfe) {
					if (variation == 1) {
						JOptionPane.showMessageDialog(null, "Você deve escrever seu telefone!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
						return checkForNumber(JOptionPane.showInputDialog(null, "Digite seu telefone!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);				
					} else if (variation == 2) {
						JOptionPane.showMessageDialog(null, "Você deve escrever seu zipcode!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
						return checkForNumber(JOptionPane.showInputDialog(null, "Digite seu zipcode!", windowTitle, JOptionPane.QUESTION_MESSAGE), 2);					
					}
				}
			}
		}
		return 0;
	}
	public static String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
