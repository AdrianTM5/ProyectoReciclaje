package mx.com.fime.tallerPOO.PIA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener
{
	Inicio ini;
	InfoGUI infoG;
	RegistrarGUI reg;
	Modelo mod;
	Controlador cont;
	Connection con;
	java.sql.Statement st = null;
	ResultSet rs = null;
	Bascula bas = new Bascula();
	
	public Controlador(Inicio ini, InfoGUI infoG, RegistrarGUI reg, Modelo mod) 
	{
		this.ini = ini;
		this.infoG = infoG;
		this.reg = reg;
		this.mod = mod;
		arrancar();
	}
	
	private void arrancar()
	{
		ini.lanzar();
		infoG.lanzar();
		reg.lanzar();
		while(ini.ThreadI.isAlive() == true && infoG.ThreadII.isAlive() == true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addActionListeners();
	}
	
	//Agregar action listeners a los botones de la clase Inicio
	private void addActionListeners()
	{
		ini.CartonBtn.addActionListener(this);
		ini.PapelBtn.addActionListener(this);
		ini.PlasticoBtn.addActionListener(this);
		infoG.AceptarBtn.addActionListener(this);
		reg.btnEnviar.addActionListener(this);
	}
	
	short material;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == ini.PapelBtn)
		{
			material = 1;
			ini.dispose();
			infoG.setVisible(true);
			setInfo();
		}
		else if(e.getSource() == ini.PlasticoBtn)
		{
			material = 2;
			ini.dispose();
			infoG.setVisible(true);
			setInfo();
		}
		else if(e.getSource() == ini.CartonBtn)
		{
			material = 3;
			ini.dispose();
			infoG.setVisible(true);
			setInfo(); 
		}
		else if(e.getSource() == infoG.AceptarBtn)
		{
			if(bas.peso > 0)
			{
				infoG.dispose();
				reg.setVisible(true);
				conectar(null, null);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Favor de pesar su material", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == reg.btnEnviar)
		{
			if(con != null)
			{
				String mat = reg.MatriculaTextField.getText();
				String pw = reg.PasswordField.getText();
				
				try {
					st = con.createStatement();
					
					boolean a = false, b = false, op = false;
					for(int i = 0; i < 2; i++)
					{
						rs = st.executeQuery("SELECT matr_usu FROM usuarios LIMIT "+i+", 1");
						rs.next();
						
						if(rs.getString("matr_usu") == mat)
						{
							if(op == false)
							{
								a = true;
								op = true;
							}
						}
					}
					for(int i = 0; i < 2; i++)
					{
						rs = st.executeQuery("SELECT con_usu FROM usuarios LIMIT "+i+", 1");
						rs.next();
						System.out.println(rs.getString("con_usu"));
						System.out.println(pw);
						
						if(rs.getString("con_usu") == pw)
						{
							if(op == false)
							{
								b = true;
								op = true;
							}
						}
					}
					System.out.println(a);
					System.out.println(b);
					if(a == true && b == true)
					{
						reg.dispose();
						System.out.println("1");
//						infUsu.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Credenciales erroneas", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					try
					{
						if(rs != null) rs.close();
						if(st != null) st.close();
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error al conectarse a la BD", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void setInfo()
	{
		String nomMate = null;
		double valorMate = 0;
		switch(material)
		{
			case 1:
			{
				nomMate = "Papel";
				valorMate = 0.75d;
				break;
			}
			case 2:
			{
				nomMate = "Plastico";
				valorMate = 1.00d;
				break;
			}
			case 3:
			{
				nomMate = "Cartón";
				valorMate = 1.45d;
				break;
			}
		}
		infoG.MaterialTextField.setText(nomMate);
		infoG.ValorTextField.setText(valorMate+"");
		bas.getPeso();
		
		infoG.IndicacionLabel.setVisible(false);
		if(bas.peso <= 0d)
		{
			infoG.IndicacionLabel.setVisible(true);
		}
		infoG.PesoLabel.setVisible(true);
		infoG.PesoTextField.setVisible(true);
		infoG.PesoTextField.setText(bas.peso+" kg");
		
		infoG.TotalTextField.setText(""+bas.peso * valorMate);
	}
	
	void conectar(String usr, String pw)
	{
		String server = "jdbc:mysql://localhost/proyectoreciclaje";
		usr = "Adri_TM5";
		pw = "Mario654321!";
		
		try 
		{
			con = DriverManager.getConnection(server,usr,pw);
			
		} 
		catch (SQLException e) {}
	}
}
