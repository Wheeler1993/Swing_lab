
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//import sun.security.mscapi.KeyStore.MY;

public class CaesarFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel up;
	//private JPanel down;
	private JTextField input;
	private JTextField output;
	private JButton letsCode;
	private JComboBox<String> box;
	public CaesarFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("SwingLab");
		this.setSize(400, 110);
		input =  new JTextField(20);
		output =  new JTextField(20);
		output.setEditable(false);
		letsCode = new JButton("Code!");
		box = new JComboBox<String>(abc());
		up = new JPanel();
		//down = new JPanel();
		FlowLayout layout = new FlowLayout();
		up.setLayout(layout);
		//down.setLayout(layout);
		letsCode.setActionCommand("Code");
		OKButtonActionListener lis = new OKButtonActionListener();
		InputFieldKeyListener lis1 = new InputFieldKeyListener();
		input.createDefaultModel().addDocumentListener(lis1);
		letsCode.addActionListener(lis);
		up.add(box);
		up.add(input);
		up.add(letsCode);
		up.add(new JLabel("Output"));
		up.add(output);
		this.add(up);
		//this.add(down);
		this.setResizable(true);
		
	}
	
	String[] abc(){
		String res[] = new String[26];
		for(int i = 0; i<26; i++){
			res[i]=new String (Character.toString((char)(i+'A')));
		}
		return res;
	}
	
	class OKButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Code")){
				output.setText(Caesar.caesarCode(input.getText(), (char)(box.getSelectedIndex()+'A')));
			}
		}
		
	}
	class InputFieldKeyListener implements DocumentListener{
		/*public void keyTyped(KeyEvent e){
			output.setText(Caesar.caesarCode(input.getText(), (char)(box.getSelectedIndex()+'A')));
		}*/

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			output.setText(Caesar.caesarCode(input.getText(), (char)(box.getSelectedIndex()+'A')));
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			output.setText(Caesar.caesarCode(input.getText(), (char)(box.getSelectedIndex()+'A')));
		}
	}
}
