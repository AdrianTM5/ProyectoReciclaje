package mx.com.fime.tallerPOO.PIA;

public class Usuario 
{
	private String matricula, nombre, contraseña;
	private double saldo;
	
	Usuario(String matricula, String nombre, double saldo) 
	{
		this.matricula = matricula;
		this.nombre = nombre;
		this.saldo = saldo;
	}

	String getMatricula() 
	{
		return matricula;
	}

	String getNombre() 
	{
		return nombre;
	}

	double getSaldo() 
	{
		return saldo;
	}

	void setSaldo(double saldo) 
	{
		this.saldo = saldo;
	}
}
