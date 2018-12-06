package trabalho.poo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import trabalho.poo.controller.*;
import trabalho.poo.model.ConnectionFactory;
import trabalho.poo.model.RepositorioFuncionarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MenuRH extends JFrame {
	public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); 
            F_Mascara.setPlaceholderCharacter(' ');
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField formattedTextField;
	private JLabel lblFuno;
	private JTextField textField_2;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRH frame = new MenuRH();
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
	public MenuRH() {
		setTitle("Departamento RH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setForeground(new Color(0,100,0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(291, 142, 65, 14);
		contentPane.add(lblName);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setForeground(new Color(0,100,0));
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTel.setBounds(294, 198, 24, 14);
		contentPane.add(lblTel);
		
		JLabel lblEnd = new JLabel("Endere\u00E7o:");
		lblEnd.setForeground(new Color(0,100,0));
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnd.setBounds(260, 259, 58, 14);
		contentPane.add(lblEnd);
		
		textField = new JTextField();
		textField.setBounds(328, 256, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 139, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		formattedTextField = new JFormattedTextField(Mascara("(##) # ####-####"));
		formattedTextField.setBounds(328, 195, 89, 20);
		contentPane.add(formattedTextField);
		
		lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setForeground(new Color(0,100,0));
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuno.setBounds(272, 325, 46, 14);
		contentPane.add(lblFuno);
		
		textField_2 = new JTextField();
		textField_2.setBounds(328, 322, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario umFuncionario = new Funcionario(textField_2.getText(), textField_1.getText(), formattedTextField.getText(), textField.getText());
				RepositorioFuncionarios funcionarios = new RepositorioFuncionarios();
				try {
					funcionarios.incluir(ConnectionFactory.getConnection(), umFuncionario);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(325, 380, 89, 23);
		contentPane.add(btnCadastrar);
	}
}
