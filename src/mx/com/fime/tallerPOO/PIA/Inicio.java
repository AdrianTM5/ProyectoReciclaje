package mx.com.fime.tallerPOO.PIA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Inicio extends JFrame
{

	private JPanel contentPane;
	Thread ThreadI;
	JButton PapelBtn;
	JButton PlasticoBtn;
	JButton CartonBtn;

	/**
	 * Launch the application.
	 */
	void lanzar(){
		ThreadI = new Thread(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadI.start();
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TituloLabel = new JLabel("Proyecto Reciclaje");
		TituloLabel.setVerticalAlignment(SwingConstants.TOP);
		TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLabel.setBackground(new Color(240, 240, 240));
		TituloLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		TituloLabel.setBounds(10, 22, 464, 33);
		contentPane.add(TituloLabel);
		
		JLabel SeleccioneLabel = new JLabel("Seleccione el material a pesar:");
		SeleccioneLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		SeleccioneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SeleccioneLabel.setBounds(10, 83, 464, 24);
		contentPane.add(SeleccioneLabel);
		
		PapelBtn = new JButton("Papel");
		PapelBtn.setBackground(new Color(0, 255, 0));
		PapelBtn.setBounds(44, 177, 118, 48);
		contentPane.add(PapelBtn);
		
		PlasticoBtn = new JButton("Plástico");
		PlasticoBtn.setBackground(new Color(0, 255, 0));
		PlasticoBtn.setBounds(186, 177, 118, 48);
		contentPane.add(PlasticoBtn);
		
		CartonBtn = new JButton("Cartón");
		CartonBtn.setBackground(new Color(0, 255, 0));
		CartonBtn.setBounds(328, 177, 118, 48);
		contentPane.add(CartonBtn);
	}
}
