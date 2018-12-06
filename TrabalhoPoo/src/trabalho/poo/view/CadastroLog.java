package trabalho.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import trabalho.poo.model.ConnectionFactory;
import trabalho.poo.model.LoginRepositorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class CadastroLog extends JFrame {
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;

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
		lblCPF.setForeground(new Color(0,100,0));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCPF.setBounds(310, 124, 46, 14);
		contentPane.add(lblCPF);
		
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		formattedTextFieldCPF.setBounds(335, 121, 90, 20);
		contentPane.add(formattedTextFieldCPF);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0,100,0));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(297, 170, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(335, 167, 90, 20);
		contentPane.add(passwordField);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setForeground(new Color(0,100,0));
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuno.setBounds(236, 230, 46, 14);
		contentPane.add(lblFuno);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		buttonGroup.add(rdbtnGerente);
		rdbtnGerente.setActionCommand ( "1" );
		rdbtnGerente.setForeground(new Color(0,100,0));
		rdbtnGerente.setBounds(297, 226, 72, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnRh = new JRadioButton("RH");
		buttonGroup.add(rdbtnRh);
		rdbtnRh.setActionCommand ( "2" );
		rdbtnRh.setForeground(new Color(0,100,0));
		rdbtnRh.setBounds(379, 226, 46, 23);
		contentPane.add(rdbtnRh);
		
		JRadioButton rdbtnOperacional = new JRadioButton("Operacional");
		buttonGroup.add(rdbtnOperacional);
		rdbtnOperacional.setActionCommand ( "3" );
		rdbtnOperacional.setForeground(new Color(0,100,0));
		rdbtnOperacional.setBounds(438, 226, 109, 23);
		contentPane.add(rdbtnOperacional);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Window window = SwingUtilities.windowForComponent(btnRegistrar);
					window.setVisible(false);
			    
					try {
						String selectedOption = buttonGroup.getSelection (     ).getActionCommand ( );
						LoginRepositorio login = new LoginRepositorio();
						switch(selectedOption) {
						case "1":
							JOptionPane.showMessageDialog(null, formattedTextFieldCPF.getText() + " Cadastrado como gerente");
							//enviar os dados para o banco de login com funcao gerente ex: controller.setCadastro(formattedTextFieldCPF,  selectedOption)
							login.cadastrarPessoa(ConnectionFactory.getConnection(), Integer.parseInt(selectedOption), formattedTextFieldCPF.getText());
							break;
						case "2":
							JOptionPane.showMessageDialog(null, formattedTextFieldCPF.getText() + " Cadastrado como RH");
							login.cadastrarPessoa(ConnectionFactory.getConnection(), Integer.parseInt(selectedOption), formattedTextFieldCPF.getText());
							break;
						case "3":
							JOptionPane.showMessageDialog(null,  formattedTextFieldCPF.getText() + " Cadastrado como Operacional");
							login.cadastrarPessoa(ConnectionFactory.getConnection(), Integer.parseInt(selectedOption), formattedTextFieldCPF.getText());
							break;
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog (null, "Erro, função não selecionada!");
						window.setVisible(true);
					}				
			}
		});
		btnRegistrar.setBounds(267, 323, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Window window = SwingUtilities.windowForComponent(btnCancelar);
			    window.setVisible(false);
			}
		});
		btnCancelar.setBounds(383, 323, 89, 23);
		contentPane.add(btnCancelar);
	}
}
