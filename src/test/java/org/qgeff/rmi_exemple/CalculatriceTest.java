package org.qgeff.rmi_exemple;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatriceTest {
	static Calculatrice calc;
	
	@BeforeClass
	public static void setup(){
		calc = new Calculatrice();
	}
	
	@Test
	public void bindTest(){
		calc.bindMe();
	}
	
	@Test
	public CalculatriceAPI getTest() throws RemoteException, NotBoundException{
		bindTest();
		
		Registry registry = LocateRegistry.getRegistry(32560);
		CalculatriceAPI service = (CalculatriceAPI) registry.lookup("Calculatrice");
		return service;
		
	}
	
	@Test
	public void getAndPlayTest() throws RemoteException, NotBoundException {
		int rsl = getTest().add(1, 1);
		System.out.println(rsl);
	}

}
