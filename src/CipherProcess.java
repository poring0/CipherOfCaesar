import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class CipherProcess {

	private JFrame frame;
	private JTextField textPlain;
	private JTextField textCipher;
	private JSlider slider;
	private JRadioButton rdbtnAllCharacter;
	private JRadioButton rdbtnAlphabetOnly;
	private final ButtonGroup groupMode = new ButtonGroup();
	private JLabel lblPlainText;
	private JLabel lblCipherText;
	private JLabel lblShift;
	private JLabel lblMode;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmViewHelp;
	private JMenuItem mntmAboutCC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CipherProcess window = new CipherProcess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CipherProcess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblPlainText = new JLabel("Plain text");
		frame.getContentPane().add(lblPlainText, "2, 2, right, default");
		
		textPlain = new JTextField();
		textPlain.setText("fill your text");
		frame.getContentPane().add(textPlain, "4, 2, fill, default");
		textPlain.setColumns(10);
		
		lblCipherText = new JLabel("Cipher text");
		frame.getContentPane().add(lblCipherText, "2, 4, right, default");
		
		textCipher = new JTextField();
		textCipher.setEditable(false);
		textCipher.setText("---");
		frame.getContentPane().add(textCipher, "4, 4, fill, default");
		textCipher.setColumns(10);
		
		lblShift = new JLabel("Shift");
		frame.getContentPane().add(lblShift, "2, 6, right, default");
		
		lblMode = new JLabel("Mode");
		frame.getContentPane().add(lblMode, "6, 6");
		
		slider = new JSlider();
		slider.setValue(2);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMaximum(25);
		frame.getContentPane().add(slider, "4, 8");
		
		
		rdbtnAllCharacter = new JRadioButton("All Character");
		rdbtnAllCharacter.setSelected(true);
		groupMode.add(rdbtnAllCharacter);
		frame.getContentPane().add(rdbtnAllCharacter, "6, 8");
		
		rdbtnAlphabetOnly = new JRadioButton("Alphabet Only");
		groupMode.add(rdbtnAlphabetOnly);
		frame.getContentPane().add(rdbtnAlphabetOnly, "6, 10");
		
		
		JButton btnCipher = new JButton("Cipher");
		btnCipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CaesarCipher caesarCipher = new CaesarCipher();
				
				if(rdbtnAllCharacter.isSelected()) {
					textCipher.setText(caesarCipher.CipherAllCharacter(slider.getValue(), textPlain.getText()));
				}
				else if(rdbtnAlphabetOnly.isSelected()) {
					textCipher.setText(caesarCipher.CipherAlphabetOnly(slider.getValue(), textPlain.getText()));
				}
			}
		});
		frame.getContentPane().add(btnCipher, "6, 2, 1, 3");
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmViewHelp = new JMenuItem("View Help");
		mnHelp.add(mntmViewHelp);
		
		mntmAboutCC = new JMenuItem("About CipherCaesar");
		mntmAboutCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "CipherCaesar v.1.0\nProduct by poring0\nhttps://poring0.wordpress.com");
			}
		});
		mnHelp.add(mntmAboutCC);
		

		
	}

}
