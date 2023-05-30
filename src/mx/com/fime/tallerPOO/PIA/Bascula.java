package mx.com.fime.tallerPOO.PIA;

public class Bascula //El valor de peso vendrá de una bascula, por el momento se tiene que ingresar desde aquí
{
	double peso; //se ingresa en gramos y se convierte en kg
	
	double getPeso()
	{
		peso = 5000;
		peso = peso / 1000;
		return peso;
	}
}
