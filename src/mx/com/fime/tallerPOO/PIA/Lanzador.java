package mx.com.fime.tallerPOO.PIA;

public class Lanzador 
{
	public static void main(String[] args) 
	{
		Inicio ini = new Inicio();
		InfoGUI infG = new InfoGUI();
		Modelo mod = new Modelo();
		
		
		Controlador co = new Controlador(ini, infG, mod);
	}
}
