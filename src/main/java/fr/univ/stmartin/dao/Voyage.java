package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the voyage database table.
 * 
 */
@Entity
@Table(name="voyage")
@NamedQuery(name="Voyage.findAll", query="SELECT v FROM Voyage v")
public class Voyage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idVoyage;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="voyage")
	private List<Client> clients;

	//bi-directional many-to-one association to Destination
	@ManyToOne
	@JoinColumn(name="idDestination", nullable=false)
	private Destination destination;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="idHotel", nullable=false)
	private Hotel hotel;

	public Voyage() {
	}

	public int getIdVoyage() {
		return this.idVoyage;
	}

	public void setIdVoyage(int idVoyage) {
		this.idVoyage = idVoyage;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setVoyage(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setVoyage(null);

		return client;
	}

	public Destination getDestination() {
		return this.destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}