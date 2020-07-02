package Pratica7;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
* Interface que deve ser compartilhada por servidor e clientes
*/
public interface CalculadoraDistribuida extends Remote{

public double somarDoisNumeros(double a, double b) throws RemoteException;
public double subtrairDoisNumeros(double a, double b) throws RemoteException;
public double multiplicaDoisNumeros(double a, double b) throws RemoteException;
public double dividirDoisNumeros(double a, double b) throws RemoteException;
public double dividirDoisNumerosResto(double a, double b) throws RemoteException;
public double raizQuadrada(double numero) throws RemoteException;
public double potencia(int base, int expoente) throws RemoteException;

}
