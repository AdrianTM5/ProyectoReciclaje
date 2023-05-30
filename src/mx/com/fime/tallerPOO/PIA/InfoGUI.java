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
	JLabel CalculandoLabel;
	JLabel IndicacionLabel;
	JLabel PesoLabel;
	
	

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
		
		CalculandoLabel = new JLabel("Calculando...");
		CalculandoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CalculandoLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 28));
		CalculandoLabel.setBounds(10, 11, 248, 275);
		panelBascula.add(CalculandoLabel);
		CalculandoLabel.setVisible(false);
		
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
		MaterialLabel.setBounds(10, 77, 49, 24);
		panelDatos.add(MaterialLabel);
		
		MaterialTextField = new JTextField();
		MaterialTextField.setEditable(false);
		MaterialTextField.setBounds(66, 76, 76, 20);
		panelDatos.add(MaterialTextField);
		MaterialTextField.setColumns(10);
		
		ValorLabel = new JLabel("Valor:");
		ValorLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		ValorLabel.setBounds(21, 124, 38, 24);
		panelDatos.add(ValorLabel);
		
		ValorTextField = new JTextField();
		ValorTextField.setEditable(false);
		ValorTextField.setColumns(10);
		ValorTextField.setBounds(66, 123, 76, 20);
		panelDatos.add(ValorTextField);
		
		TotalLabel = new JLabel("Total:");
		TotalLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		TotalLabel.setBounds(21, 173, 38, 24);
		panelDatos.add(TotalLabel);
		
		TotalTextField = new JTextField();
		TotalTextField.setEditable(false);
		TotalTextField.setColumns(10);
		TotalTextField.setBounds(66, 172, 76, 20);
		panelDatos.add(TotalTextField);
	}
}
