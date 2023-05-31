package mx.com.fime.tallerPOO.PIA;

public class Usuario 
{
	int matricula;
	String nombre, contraseña;
	double saldo;
	
	Usuario(int matricula, String nombre, String contraseña, double saldo) 
	{
		this.matricula = matricula;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.saldo = saldo;
	}

	int getMatricula() 
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
