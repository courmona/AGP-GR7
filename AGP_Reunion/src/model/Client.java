package model;


public class Client {
	private int budget;
	private String confort;
	private String site;

	public Client(int budget, String confort, String site) {
		this.budget = budget;
		this.confort = confort;
		this.site = site;
		
	}
	public int getBudget() {
		return budget;
	}
	public String getConfort() {
		return confort;
	}
	public String getSite() {
		return site;
	}
}
