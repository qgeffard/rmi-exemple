package org.qgeff.rmi_exemple;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatriceAPI extends Remote {
	int add(int i , int j) throws RemoteException;
	int substract(int i, int j) throws RemoteException;
}
