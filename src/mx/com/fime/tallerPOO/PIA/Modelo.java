package mx.com.fime.tallerPOO.PIA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modelo implements ActionListener
{
	Inicio ini;
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
		if(e.getSource() == ini.CartonBtn)
		{
			material = 1;
			//cal.show
			ini.dispose();
		}
		else if(e.getSource() == ini.PapelBtn)
		{
			material = 2;
			//cal.show
			ini.dispose();
		}
		else if(e.getSource() == ini.CartonBtn)
		{
			material = 3;
			//cal.show
			ini.dispose();
		}
	}
}
