package trabalho.poo.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Projeto extends JFrame {
	
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
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projeto frame = new Projeto();
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
	public Projeto() {
		setTitle("Cadastro Projeto");
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
		
		JMenuItem mntmProjeto = new JMenuItem("Projeto");
		mnProjeto.add(mntmProjeto);
		
		JMenuItem mntmEtapa = new JMenuItem("Etapa");
		mnProjeto.add(mntmEtapa);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setForeground(new Color(0,100,0));
		lblDataInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataInicio.setBounds(276, 172, 70, 14);
		contentPane.add(lblDataInicio);
		
		JLabel lblValorDoProjeto = new JLabel("Valor do projeto:");
		lblValorDoProjeto.setForeground(new Color(0,100,0));
		lblValorDoProjeto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorDoProjeto.setBounds(248, 203, 98, 14);
		contentPane.add(lblValorDoProjeto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(356, 200, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastrarProjeto = new JButton("Cadastrar projeto");
		btnCadastrarProjeto.setBounds(283, 278, 168, 23);
		contentPane.add(btnCadastrarProjeto);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(Mascara("##/##/####"));
		formattedTextField.setBounds(356, 169, 86, 20);
		contentPane.add(formattedTextField);
	}

}
