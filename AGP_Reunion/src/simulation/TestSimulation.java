package simulation;

import model.Client;

public class TestSimulation {

	public static void main(String[] args) {
		
		Client client = new Client(1521,"D�tente","marche � pied");
		System.out.println("Budget : "+client.getBudget()+"\nConfort : "+client.getConfort()+"\nType d'excursion : "+client.getSite());
		
	}
}
