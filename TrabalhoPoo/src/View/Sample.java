package View;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Sample {

	private JFrame frmProjetoPoo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sample window = new Sample();
					window.frmProjetoPoo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjetoPoo = new JFrame();
		frmProjetoPoo.setTitle("Projeto GC");
		frmProjetoPoo.setBounds(100, 100, 1366, 768);
		frmProjetoPoo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
