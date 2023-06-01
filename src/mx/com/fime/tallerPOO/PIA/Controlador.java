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
import javax.swing.JTextField;

public class Controlador implements ActionListener
{
	Inicio ini;
	InfoGUI infoG;
	RegistrarGUI reg;
	Modelo mod;
	Datos dat;
	Controlador cont;
	Connection con;
	java.sql.Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps;
	Bascula bas = new Bascula();
	double total;
	
	public Controlador(Inicio ini, InfoGUI infoG, RegistrarGUI reg, Datos dat, Modelo mod) 
	{
		this.ini = ini;
		this.infoG = infoG;
		this.reg = reg;
		this.dat = dat;
		this.mod = mod;
		arrancar();
	}
	
	private void arrancar()
	{
		ini.lanzar();
		infoG.lanzar();
		reg.lanzar();
		dat.lanzar();
		while(ini.ThreadI.isAlive() == true && infoG.ThreadII.isAlive() == true && reg.ThreadIII.isAlive() == true)
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
			try {
				if(con != null)
				{
					try {
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM usuarios");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					convertirDatos(rs);
					
					String mat = reg.MatriculaTextField.getText();
					boolean a = false, b = false, op = false;
					Usuario u = null;
					
					for(int i = 0; i < mod.Almacen.size(); i++)
					{
						if(op == false)
						{
							if(mod.Almacen.get(i).getMatricula().equals(mat))
							{
								a = true;
								op = true;
								u = mod.Almacen.get(i);
							}
						}
					}
					
					if(a == true)
					{
						reg.dispose();
						dat.setVisible(true);
						
						//mostar los datos del usuario
						dat.MatriculaTextField.setText(u.getMatricula());
						dat.NombreTextField.setText(u.getNombre());
						dat.SaldoTextField.setText(Math.round((u.getSaldo() + total))+"");
						
						int saldoNuevo = Integer.parseInt(dat.SaldoTextField.getText());
						
						try {
							ps = con.prepareStatement("UPDATE usuarios SET sald_usu = ? WHERE usuarios.matr_usu = ?");
							ps.setDouble(1, saldoNuevo);
							ps.setString(2, u.getMatricula());
							int rowsAffected = ps.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error al conectarse a la BD", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			finally
			{
					try {
						if(st != null) st.close();
						if(rs != null) rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
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
		
		total = bas.peso * valorMate;
		
		infoG.TotalTextField.setText(Math.round(total)+"");
	}
	
	private void conectar(String usr, String pw)
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
	
	private void convertirDatos(ResultSet rs)
	{
		if(!mod.Almacen.isEmpty())
		{
			mod.Almacen.clear();
		}
		try {
			while(rs.next())
			{
				String mat = rs.getString("matr_usu");
				String nom = rs.getString("nom_usu");
				double sal = rs.getDouble("sald_usu");
				
				Usuario usu = new Usuario(mat, nom, sal);
				mod.Almacen.add(usu);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
