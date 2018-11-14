package trabalho.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MenuGerente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGerente frame = new MenuGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGerente() {
		setTitle("Gerente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEmitirRelatrio = new JButton("Emitir Relat\u00F3rio");
		btnEmitirRelatrio.setBounds(668, 510, 106, 40);
		contentPane.add(btnEmitirRelatrio);
		
		JLabel lblCodF = new JLabel("Codigo do funcion\u00E1rio:");
		lblCodF.setBounds(75, 192, 108, 14);
		contentPane.add(lblCodF);
		
		JLabel lblCodE = new JLabel("Codigo da etapa:");
		lblCodE.setBounds(99, 248, 83, 14);
		contentPane.add(lblCodE);
		
		JLabel lblCodP = new JLabel("Condigo do projeto:");
		lblCodP.setBounds(87, 294, 96, 14);
		contentPane.add(lblCodP);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 189, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 245, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(205, 291, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.setBounds(205, 393, 89, 23);
		contentPane.add(btnAlocar);
	}
}
