package mx.com.fime.tallerPOO.PIA;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JButton;

public class InfoGUI extends JFrame 
{

	Thread ThreadII;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JLabel ValorLabel;
	private JLabel TotalLabel;
	private JLabel MaterialLabel;
	JTextField MaterialTextField;
	JTextField ValorTextField;
	JTextField TotalTextField;
	JTextField PesoTextField;
	JLabel IndicacionLabel;
	JLabel PesoLabel;
	JButton AceptarBtn;
	
	

	/**
	 * Launch the application.
	 */
	void lanzar(){
		ThreadII = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadII.start();
	}

	/**
	 * Create the frame.
	 */
	public InfoGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBascula = new JPanel();
		panelBascula.setBackground(new Color(0, 166, 0));
		panelBascula.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBascula.setBounds(20, 28, 268, 297);
		contentPane.add(panelBascula);
		panelBascula.setLayout(null);
		
		PesoLabel = new JLabel("El peso es de:");
		PesoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PesoLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		PesoLabel.setBounds(10, 54, 248, 24);
		panelBascula.add(PesoLabel);
		PesoLabel.setVisible(false);
		
		PesoTextField = new JTextField();
		PesoTextField.setForeground(new Color(0, 0, 0));
		PesoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		PesoTextField.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		PesoTextField.setEditable(false);
		PesoTextField.setBackground(new Color(0, 166, 0));
		PesoTextField.setBounds(10, 89, 248, 84);
		panelBascula.add(PesoTextField);
		PesoTextField.setColumns(10);
		
		IndicacionLabel = new JLabel("Favor de pesar su material");
		IndicacionLabel.setBounds(10, 183, 248, 103);
		panelBascula.add(IndicacionLabel);
		IndicacionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IndicacionLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		PesoTextField.setVisible(false);
		
		panelDatos = new JPanel();
		panelDatos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDatos.setBackground(new Color(0, 166, 0));
		panelDatos.setBounds(309, 28, 152, 297);
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);
		
		MaterialLabel = new JLabel("Material:");
		MaterialLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		MaterialLabel.setBounds(10, 35, 49, 24);
		panelDatos.add(MaterialLabel);
		
		MaterialTextField = new JTextField();
		MaterialTextField.setHorizontalAlignment(SwingConstants.LEFT);
		MaterialTextField.setEditable(false);
		MaterialTextField.setBounds(66, 34, 76, 20);
		panelDatos.add(MaterialTextField);
		MaterialTextField.setColumns(10);
		
		ValorLabel = new JLabel("Valor:");
		ValorLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		ValorLabel.setBounds(21, 82, 38, 24);
		panelDatos.add(ValorLabel);
		
		ValorTextField = new JTextField();
		ValorTextField.setHorizontalAlignment(SwingConstants.LEFT);
		ValorTextField.setEditable(false);
		ValorTextField.setColumns(10);
		ValorTextField.setBounds(66, 81, 76, 20);
		panelDatos.add(ValorTextField);
		
		TotalLabel = new JLabel("Total:");
		TotalLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		TotalLabel.setBounds(21, 131, 38, 24);
		panelDatos.add(TotalLabel);
		
		TotalTextField = new JTextField();
		TotalTextField.setHorizontalAlignment(SwingConstants.LEFT);
		TotalTextField.setEditable(false);
		TotalTextField.setColumns(4);
		TotalTextField.setBounds(66, 130, 76, 20);
		panelDatos.add(TotalTextField);
		
		AceptarBtn = new JButton("Aceptar");
		AceptarBtn.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		AceptarBtn.setBackground(new Color(0, 255, 0));
		AceptarBtn.setBounds(10, 218, 132, 52);
		panelDatos.add(AceptarBtn);
	}
}
