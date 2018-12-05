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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

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
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(111, 106, 37, 14);
		contentPane.add(lblInicio);
		
		JLabel lblFinal = new JLabel("Final:");
		lblFinal.setBounds(91, 172, 46, 14);
		contentPane.add(lblFinal);
		
		JButton btnCadastrarEtapa = new JButton("Cadastrar etapa");
		btnCadastrarEtapa.setBounds(179, 312, 176, 23);
		contentPane.add(btnCadastrarEtapa);
		
		JButton btnEditarEtapa = new JButton("Editar etapa");
		btnEditarEtapa.setBounds(179, 381, 151, 23);
		contentPane.add(btnEditarEtapa);
		
		JButton btnExcluirEtapa = new JButton("Excluir etapa");
		btnExcluirEtapa.setBounds(190, 444, 140, 23);
		contentPane.add(btnExcluirEtapa);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(Mascara("##/##/####"));
		formattedTextField.setBounds(187, 103, 98, 20);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(Mascara("##/##/####"));
		formattedTextField_1.setBounds(187, 169, 90, 20);
		contentPane.add(formattedTextField_1);
	}
}
