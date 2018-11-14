package trabalho.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CadastroLog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLog frame = new CadastroLog();
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
	public CadastroLog() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(198, 124, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(198, 170, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel label = new JLabel("");
		label.setBounds(129, 247, 46, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(230, 121, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 167, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(184, 230, 46, 14);
		contentPane.add(lblFuno);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setBounds(230, 226, 65, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnRh = new JRadioButton("RH");
		rdbtnRh.setBounds(297, 226, 46, 23);
		contentPane.add(rdbtnRh);
		
		JRadioButton rdbtnOperacional = new JRadioButton("Operacional");
		rdbtnOperacional.setBounds(345, 226, 109, 23);
		contentPane.add(rdbtnOperacional);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(183, 323, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(297, 323, 89, 23);
		contentPane.add(btnCancelar);
	}
}
