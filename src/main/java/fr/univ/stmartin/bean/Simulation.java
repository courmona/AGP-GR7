package fr.univ.stmartin.bean;
import fr.univ.stmartin.dao.*;

public class Simulation {

	public static void main(String[] args) {
		Client client = new Client(3000,6,"Détente","marche à pied");
		Destination destination  = new Destination("Ile de la Réunion",599505);
		
		System.out.println("Budget : "+client.getBudget()+" €"+"\nDurée du séjour: "+client.getNbJourSejour()+" jour(s)\nConfort : "+client.getConfort()+"\nType d'excursion : "+client.getVarThematique());
		System.out.println("Résultats de recherche pour des voyages à "+ destination.getNomDestination()+" :\n" );
		
		//System.out.println("scc : "+JdbcPersistence.servedClientCount("id_gen"));
		
		JDBCPersistence.readString("confortable");
		Hotel hotel = new Hotel();
		System.out.println("Cout total de l'hébergement"+hotel.calculerPrixTotal());

	}

}
