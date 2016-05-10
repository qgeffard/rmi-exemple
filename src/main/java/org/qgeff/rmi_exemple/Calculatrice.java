package org.qgeff.rmi_exemple;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Calculatrice implements CalculatriceAPI{

	public int add(int i, int j) {
		return i+j;
	}

	public int substract(int i, int j) {
		return i-j;
	}
	
	public void bindMe(){
		try {
		    CalculatriceAPI stub = (CalculatriceAPI) UnicastRemoteObject.exportObject(this, 34052);
		    Registry registry = LocateRegistry.createRegistry(32560);
		    registry.rebind("Calculatrice", stub);

		    System.out.println("Server ready");
		} catch (Exception e) {
		    System.err.println("Server exception: " + e.toString());
		    e.printStackTrace();
		}
	}

}
