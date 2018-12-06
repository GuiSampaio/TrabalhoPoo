package trabalho.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
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
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Project GC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setForeground(new Color(178, 34, 34));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(333, 113, 56, 32);
		contentPane.add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(226, 244, 303, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsurio.setForeground(new Color(0, 100, 0));
		lblUsurio.setBounds(178, 208, 56, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setForeground(new Color(0, 100, 0));
		lblSenha.setBounds(186, 247, 48, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(funcao == 1) Gerente
				/*	EventQueue.invokeLater(new Runnable() {
				 *		public void run() {
				 *		try {
				 *			dispose();
				 *			MenuGerente frame = new MenuGerente();
				 *			frame.setVisible(true);
				 *		} catch (Exception e) {
				 *			e.printStackTrace();
				 *		}
				 *	}
				 *});
				 */
				
				//if(funcao == 2) RH
				/*	EventQueue.invokeLater(new Runnable() {
				 *		public void run() {
				 *		try {
				 *			dispose();
				 *			MenuRH frame = new MenuRH();
				 *			frame.setVisible(true);
				 *		} catch (Exception e) {
				 *			e.printStackTrace();
				 *		}
				 *	}
				 *});
				 */
				
				//if(funcao == 3) Operacional
				/*	EventQueue.invokeLater(new Runnable() {
				 *		public void run() {
				 *		try {
				 *			dispose();
				 *			MenuOperacional frame = new MenuOperacional();
				 *			frame.setVisible(true);
				 *		} catch (Exception e) {
				 *			e.printStackTrace();
				 *		}
				 *	}
				 *});
				 */
				
				Window window = SwingUtilities.windowForComponent(btnEntrar);
				window.setVisible(false);
				
			}
		});
		btnEntrar.setBounds(237, 307, 131, 57);
		contentPane.add(btnEntrar);
		
		JFormattedTextField formattedTextFieldUsuario = new JFormattedTextField(Mascara("###.###.###-##"));
		formattedTextFieldUsuario.setBounds(226, 205, 303, 20);
		contentPane.add(formattedTextFieldUsuario);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnCadastrar.setBounds(380, 307, 131, 57);
		contentPane.add(btnCadastrar);
	}
}