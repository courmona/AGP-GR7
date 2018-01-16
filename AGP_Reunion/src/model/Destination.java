package model;

public class Destination {
	private int idDestination;
	private String nomDestination = "Ile de la Réunion";
	public Destination(String nomDestination , int idDestination) {
		this.nomDestination = nomDestination;
		this.idDestination = idDestination;
	}
	public int getId() {
		return idDestination;
	}
	public String getDestination() {
		return nomDestination;
	}
}
