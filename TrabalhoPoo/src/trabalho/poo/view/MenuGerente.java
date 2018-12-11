package trabalho.poo.view;

import trabalho.poo.controller.*;
import trabalho.poo.model.ConnectionFactory;
import trabalho.poo.model.RepositorioProjeto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		btnEmitirRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
							try {
								showData frame = new showData(ConnectionFactory.getConnection());
								frame.setVisible(true);
							} catch (Exception e) {
							e.printStackTrace();
							}
						}
						});
						RepositorioProjeto.recuperaProjeto(ConnectionFactory.getConnection());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
				}
		});
		btnEmitirRelatrio.setBounds(668, 510, 106, 40);
		contentPane.add(btnEmitirRelatrio);
		
		JLabel lblCodF = new JLabel("Codigo do funcion\u00E1rio:");
		lblCodF.setForeground(new Color(0,100,0));
		lblCodF.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodF.setBounds(241, 195, 133, 14);
		contentPane.add(lblCodF);
		
		JLabel lblCodE = new JLabel("Codigo da etapa:");
		lblCodE.setForeground(new Color(0,100,0));
		lblCodE.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodE.setBounds(269, 239, 111, 14);
		contentPane.add(lblCodE);
		
		JLabel lblCodP = new JLabel("Codigo do projeto:");
		lblCodP.setForeground(new Color(0,100,0));
		lblCodP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodP.setBounds(252, 277, 133, 14);
		contentPane.add(lblCodP);
		
		textField_1 = new JTextField();
		textField_1.setBounds(384, 192, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(384, 236, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(384, 274, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Alocado.Alocado(textField_1,  textField_2, textField_3);
			}
		});
		btnAlocar.setBounds(323, 347, 89, 23);
		contentPane.add(btnAlocar);
	}
}
