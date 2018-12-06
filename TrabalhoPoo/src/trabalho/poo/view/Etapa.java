package trabalho.poo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Etapa extends JFrame {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etapa frame = new Etapa();
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
	public Etapa() {
		setTitle("Cadastro etapa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCliente = new JMenuItem(new AbstractAction("Cliente") {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							dispose();
							MenuOperacional frame = new MenuOperacional();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
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
		
		JMenuItem mntmEtapa = new JMenuItem("Etapa");
		mnProjeto.add(mntmEtapa);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(283, 76, 37, 14);
		contentPane.add(lblInicio);
		
		JLabel lblFinal = new JLabel("Final:");
		lblFinal.setBounds(283, 118, 46, 14);
		contentPane.add(lblFinal);
		
		JButton btnCadastrarEtapa = new JButton("Cadastrar etapa");
		btnCadastrarEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cadastra_etapa(formattedTextField, formattedTextfield_1)
				//trabalho.poo.controller.Etapa etapa = new trabalho.poo.controller.Etapa(Math.random(), Math.random(), formattedTextField., formattedTextfield_1);
			}
		});
		btnCadastrarEtapa.setBounds(283, 169, 176, 23);
		contentPane.add(btnCadastrarEtapa);
		
		JButton btnEditarEtapa = new JButton("Editar etapa");
		btnEditarEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editar_etapa(formattedTextField, formattedTextfield_1, textField)
			}
		});
		btnEditarEtapa.setBounds(232, 297, 151, 23);
		contentPane.add(btnEditarEtapa);
		
		JButton btnExcluirEtapa = new JButton("Excluir etapa");
		btnExcluirEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//excluir_etapa(textField)
			}
		});
		btnExcluirEtapa.setBounds(393, 297, 140, 23);
		contentPane.add(btnExcluirEtapa);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(Mascara("##/##/####"));
		formattedTextField.setBounds(330, 73, 98, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(Mascara("##/##/####"));
		formattedTextField_1.setBounds(330, 115, 98, 20);
		contentPane.add(formattedTextField_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(318, 251, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(340, 248, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
