package Pratica7;

import java.rmi.RemoteException;

/**
* Classe que implementa a interface do objeto distribu´ıdo
*/
public class Calculadora implements CalculadoraDistribuida{

	@Override
	public double somarDoisNumeros(double num1, double num2) throws RemoteException {
		return num1+num2;
	}

	@Override
	public double subtrairDoisNumeros(double a, double b) throws RemoteException {
		
		return 0;
	}

	@Override
	public double multiplicaDoisNumeros(double a, double b) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double dividirDoisNumeros(double a, double b) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double dividirDoisNumerosResto(double a, double b) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double raizQuadrada(double numero) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double potencia(int base, int expoente) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}


}

