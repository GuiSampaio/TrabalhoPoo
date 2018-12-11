package trabalho.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import trabalho.poo.model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import trabalho.poo.controller.Projeto;
import trabalho.poo.model.ConnectionFactory;
import trabalho.poo.model.RepositorioProjeto;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class showData extends JFrame {

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
					showData frame = new showData(ConnectionFactory.getConnection());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**RepositorioProjeto.recuperaProjeto(ConnectionFactory.getConnection());
	 * Create the frame.
	 */
	public showData(Connection conn) {
		setTitle("DataView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		Projeto e = null;

		
		try
		{	PreparedStatement pstmt = conn.prepareStatement
				("SELECT COD, CLIENTE_CPF, DATA_INICIO, VALOR FROM PROJETO ");

			ResultSet rs = pstmt.executeQuery();
	 		if (rs.next())
	 		{	e = new Projeto(rs.getInt("COD"),
					              rs.getString("CLIENTE_CPF"),
								  rs.getString("DATA_INICIO"),
						          rs.getDouble("VALOR"));
				textArea.setText("COD:" + e.getCod() + " CPF CLIENTE:" + e.getCpf() + " DATA INICIO:" + e.getDataIni() + " VALOR:" + e.getValor() + "\n");
				rs.next();
	 		}
	 		pstmt.close();
		}	
		catch (SQLException ex)
		{	ex.printStackTrace();
			System.exit(1);
		}
		
	}
}

