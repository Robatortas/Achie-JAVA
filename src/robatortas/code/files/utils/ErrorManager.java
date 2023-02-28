package robatortas.code.files.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ErrorManager {
	
	int w = 350, h = 150;
	Dimension size = new Dimension(w, h);
	
	JPanel panel;
	GridBagConstraints gbc = new GridBagConstraints();
	
	List<JTextArea> texts = new LinkedList<JTextArea>();
	
	ErrorType type;
	
	/** <NEWLINE>
	 * <b>ErrorManager function in ErrorManager class</b>
	 * <br><br>
	 * 
	 */
	public ErrorManager(Throwable throwable, String info, ErrorType type) {
		this.type = type;
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
//		JOptionPane.showInternalMessageDialog(null, info);
		
		JFrame frame = new JFrame();
		
		this.panel = new JPanel();
		
		frame.setTitle("ACHIE: ERROR");
		frame.setSize(size);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
//		frame.pack();

		frame.add(panel);
		gui();
		panel.setSize(size);
//		panel.setBackground(new Color(86, 86, 86));
		panel.setVisible(true);
		
		panel.setLayout(new GridBagLayout());
		
//		gbc.gridheight = 10;
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void gui() {
		JTextArea title = new JTextArea();
		JTextArea info = new JTextArea();
		JButton ok = new JButton("ok");
		
		this.texts.add(title);
		this.texts.add(info);
		
		int fontSize = 25;
		
		for(int i = 0; i < this.texts.size(); i++) {
			JTextArea currText = this.texts.get(i);
			
			currText.setFont(new Font("Arial", 0, 30));
			currText.setEditable(false);
			currText.setBackground(null);
		}
		
		title.setBounds(100, 5, this.w, this.h);
		title.setText("ERROR");
		

		fontSize = 15;
		
		info.setBounds(10, 40, this.w, this.h);
		info.setFont(new Font("Arial", 0, 15));
		info.setText(type.type);
		
		ok.setSize(50, 70);
		ok.setFocusable(false);
		
		ok.addActionListener(e -> {
			System.out.println("Ended Process");
			System.exit(0);
		});
		
		panel.add(title, gbc);
		panel.add(info, gbc);
		panel.add(ok, gbc);
	}
	
	/**<NEWLINE>
	 * <b>ErrorType enum on the CrashHandler class</b>
	 * <br><br>
	 * Used to give a small description about the error that occurred
	 * <br><br>
	 * UNHANDLED: Not handled by system.
	 * <br>
	 * UNEXPECTED: The error wasn't expected.
	 * <br>
	 * IRREDEEMABLE: Not able to be handled by system.
	 * <br>
	 * SERIOUS: Potential for crash, probably should exit the program.
	 * <br>
	 * HANDLED: The system handled the exception.
	 * <br><br>
	 * Exit Code Meanings: https://www.techiedelight.com/exit-codes-java-system-exit-method/ 
	 */
	public static enum ErrorType {
		
		UNHANDLED("Unhandled Error: Not handled.", -3),
		UNEXPECTED("Unexpected Error: This shouldn't happen.", -2),
		IRREDEEMABLE("Irredeemable Error: Not able to be handled", -1),
		SERIOUS("Serious Error: Possible unplayable content", 1),
		HANDLED("Handled Error: Solved by system", 2);
		
		public int exitCode;
		public String type;
		
		ErrorType(String type, int exitCode) {
			this.type = type;
			this.exitCode = exitCode;
		}
	}
}