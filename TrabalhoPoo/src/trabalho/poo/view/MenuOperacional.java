package trabalho.poo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import trabalho.poo.controller.Clientes;
import trabalho.poo.model.ConnectionFactory;
import trabalho.poo.model.RepositorioClientes;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MenuOperacional extends JFrame {
	
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
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperacional frame = new MenuOperacional();
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
	public MenuOperacional() {
		setTitle("Cadastro cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnCadastrar.add(mntmCliente);
		
		JMenu mnProjeto = new JMenu("Projeto...");
		mnCadastrar.add(mnProjeto);
		
		JMenuItem mntmProjeto = new JMenuItem(new AbstractAction("Projeto") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
							Projeto frame = new Projeto();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
		    }
		});
		mnProjeto.add(mntmProjeto);
		
		JMenuItem mntmEtapa = new JMenuItem(new AbstractAction("Etapa") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
							Etapa frame = new Etapa();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnProjeto.add(mntmEtapa);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(380, 122, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0,100,0));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(333, 125, 37, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setForeground(new Color(0,100,0));
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setBounds(311, 177, 56, 14);
		contentPane.add(lblEndereco);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 174, 99, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTel = new JLabel("Telefone:");
		lblTel.setForeground(new Color(0,100,0));
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTel.setBounds(311, 232, 59, 14);
		contentPane.add(lblTel);
		
		JFormattedTextField formattedTextFieldTel = new JFormattedTextField(Mascara("(##) # ####-####"));
		formattedTextFieldTel.setBounds(371, 229, 105, 20);
		contentPane.add(formattedTextFieldTel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(new Color(0,100,0));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(333, 286, 28, 14);
		contentPane.add(lblCpf);
		
		JFormattedTextField formattedTextFieldCPF = new JFormattedTextField(Mascara("###.###.###-##"));
		formattedTextFieldCPF.setBounds(375, 283, 101, 20);
		contentPane.add(formattedTextFieldCPF);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0,100,0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(333, 335, 46, 14);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(380, 329, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cadastrar(textField, textField_1, textField_2, formattedTextFieldCPF, formattedTextFieldTel)
					RepositorioClientes repoClientes = new RepositorioClientes();
					Clientes clientes = new Clientes(formattedTextFieldCPF.getText(), textField.getText(), textField_1.getText(), formattedTextFieldTel.getText(), textField_2.getText());
				  try {
					repoClientes.incluir(ConnectionFactory.getConnection(), clientes);
					JOptionPane.showMessageDialog(null, "Operação concluida");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		btnCadastrar.setBounds(357, 423, 89, 23);
		contentPane.add(btnCadastrar);
	}
}
