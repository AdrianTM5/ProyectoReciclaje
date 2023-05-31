package mx.com.fime.tallerPOO.PIA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controlador implements ActionListener
{
	Inicio ini;
	InfoGUI infoG;
	Modelo mod;
	Controlador cont;
	Connection con;
	Bascula bas = new Bascula();
	
	public Controlador(Inicio ini, InfoGUI infoG, Modelo mod) 
	{
		this.ini = ini;
		this.infoG = infoG;
		this.mod = mod;
		arrancar();
	}
	
	private void arrancar()
	{
		ini.lanzar();
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
		
		//Aqui probablemente vaya un ciclo para que vayan cambiando los mensajes
		infoG.IndicacionLabel.setVisible(false);
		if(bas.peso > 0d)
		{
			infoG.CalculandoLabel.setVisible(true);
			//Deberia haber un Threadsleep aqui para que el mensaje se quede un rato pero si lo pongo se queda en blanco
			infoG.CalculandoLabel.setVisible(false);
		}
		else
		{
			infoG.IndicacionLabel.setVisible(true);
		}
		infoG.PesoLabel.setVisible(true);
		infoG.PesoTextField.setVisible(true);
		infoG.PesoTextField.setText(bas.peso+" kg");
		
		infoG.TotalTextField.setText(bas.peso * valorMate+"");
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
