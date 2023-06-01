package mx.com.fime.tallerPOO.PIA;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegistrarGUI extends JFrame {

	private JPanel contentPane;
	private JLabel TituloLabel, MatriculaLabel, ContraseñaLabel;
	JTextField MatriculaTextField;
	JPasswordField PasswordField;
	JButton btnEnviar;
	Thread ThreadIII;
	
	
	

	/**
	 * Launch the application.
	 */
	void lanzar(){
	ThreadIII = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadIII.start();
	}

	/**
	 * Create the frame.
	 */
	public RegistrarGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TituloLabel = new JLabel("Inicia Sesión");
		TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		TituloLabel.setBounds(10, 43, 464, 46);
		getContentPane().add(TituloLabel);
		
		MatriculaLabel = new JLabel("Matricula:");
		MatriculaLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		MatriculaLabel.setBounds(139, 132, 65, 23);
		getContentPane().add(MatriculaLabel);
		
		ContraseñaLabel = new JLabel("Contraseña:");
		ContraseñaLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		ContraseñaLabel.setBounds(125, 210, 79, 23);
		getContentPane().add(ContraseñaLabel);
		
		MatriculaTextField = new JTextField();
		MatriculaTextField.setBounds(214, 133, 136, 20);
		getContentPane().add(MatriculaTextField);
		MatriculaTextField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(214, 211, 136, 20);
		getContentPane().add(PasswordField);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(new Color(0, 255, 0));
		btnEnviar.setForeground(new Color(0, 0, 0));
		btnEnviar.setBounds(150, 278, 185, 39);
		getContentPane().add(btnEnviar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	}
}
