package simulation;

import model.Client;
import model.Destination;
import persistence.JdbcPersistence;
public class TestSimulation {

	public static void main(String[] args) {
		
		Client client = new Client(1521,"Détente","marche à pied");
		Destination destination  = new Destination("Ile de la Réunion",599505);
		
		System.out.println("Budget : "+client.getBudget()+" €\nConfort : "+client.getConfort()+"\nType d'excursion : "+client.getSite());
		System.out.println("Résultats de recherche pour des voyages à "+ destination.getDestination()+" :\n" );
		
		System.out.println("scc : "+JdbcPersistence.servedClientCount("id_gen"));
		//System.out.println("m: "+JdbcPersistence)
				//servedClientCount("id_gen"));
		
		//System.out.println("\n Table "+JdbcPersistence.servedClientCount("id_gen"));
	}

}
