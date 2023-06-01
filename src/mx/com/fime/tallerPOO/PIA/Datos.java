package mx.com.fime.tallerPOO.PIA;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class Datos extends JFrame {

	private JPanel contentPane;
	Thread ThreadIV;
	JTextField MatriculaTextField;
	JTextField NombreTextField;
	JTextField SaldoTextField;

	/**
	 * Launch the application.
	 */
	void lanzar(){
		ThreadIV = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadIV.start();
	}

	/**
	 * Create the frame.
	 */
	public Datos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DatosLabel = new JLabel("Datos");
		DatosLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		DatosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DatosLabel.setBounds(10, 11, 464, 46);
		contentPane.add(DatosLabel);
		
		JLabel MatriculaLabel = new JLabel("Matricula:");
		MatriculaLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		MatriculaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MatriculaLabel.setBounds(55, 112, 78, 24);
		contentPane.add(MatriculaLabel);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		NombreLabel.setBounds(70, 160, 63, 24);
		contentPane.add(NombreLabel);
		
		JLabel SaldoLabel = new JLabel("Saldo:");
		SaldoLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		SaldoLabel.setBounds(78, 205, 55, 24);
		contentPane.add(SaldoLabel);
		
		MatriculaTextField = new JTextField();
		MatriculaTextField.setEditable(false);
		MatriculaTextField.setBounds(143, 111, 134, 20);
		contentPane.add(MatriculaTextField);
		MatriculaTextField.setColumns(10);
		
		NombreTextField = new JTextField();
		NombreTextField.setEditable(false);
		NombreTextField.setBounds(143, 159, 234, 20);
		contentPane.add(NombreTextField);
		NombreTextField.setColumns(10);
		
		SaldoTextField = new JTextField();
		SaldoTextField.setHorizontalAlignment(SwingConstants.LEFT);
		SaldoTextField.setEditable(false);
		SaldoTextField.setBounds(143, 204, 105, 20);
		contentPane.add(SaldoTextField);
		SaldoTextField.setColumns(10);
	}
}
