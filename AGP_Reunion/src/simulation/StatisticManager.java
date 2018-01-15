package simulation;

import java.util.ArrayList;
import java.util.List;

import model.AbstractClient;


/**
 * This class regroup statistic information. It calculates the simulation
 * result.
 */
public class StatisticManager {
	private List<AbstractClient> servedClients = new ArrayList<AbstractClient>();
	private List<AbstractClient> nonServedClients = new ArrayList<AbstractClient>();
	private int simulationDuration = 0;
	private int occupiedCashier = 0;

	public List<AbstractClient> getServedClients() {
		return servedClients;
	}

	public void setServedClients(List<AbstractClient> servedClients) {
		this.servedClients = servedClients;
	}

	public List<AbstractClient> getNonServedClients() {
		return nonServedClients;
	}

	public void setNonServedClients(List<AbstractClient> nonServedClients) {
		this.nonServedClients = nonServedClients;
	}

	public void registerServedClient(AbstractClient client) {
		servedClients.add(client);
	}

	public void registerNonServedClient(AbstractClient client) {
		nonServedClients.add(client);
	}

	public void simulationDurationRecord() {
		simulationDuration++;
	}

	public void cashierOccupationRecord() {
		occupiedCashier++;
	}

	public double calculateAverageCashierOccupationRate(int cashierCount) {
		return (occupiedCashier * 100 / simulationDuration) / cashierCount;
	}

	public double calculateAverageClientWaitingTime() {
		int totalWaitingTime = 0;
		for (AbstractClient client : servedClients) {
			int serviceStartTime = client.getServiceStartTime();
			int arrivalTime = client.getArrivalTime();
			totalWaitingTime += serviceStartTime - arrivalTime;
		}
		int servedClientCount = servedClientCount();
		return totalWaitingTime / servedClientCount;
	}

	public double calculateAverageClientServiceTime() {
		int totalServiceTime = 0;
		for (AbstractClient client : servedClients) {
			int departureTime = client.getDepartureTime();
			int serviceStartTime = client.getServiceStartTime();
			totalServiceTime += departureTime - serviceStartTime;
		}
		return totalServiceTime / servedClientCount();
	}

	public int servedClientCount() {
		return servedClients.size();
	}

	public int nonServedClientCount() {
		return nonServedClients.size();
	}

	public double calculateClientSatisfactionRate() {
		return servedClientCount()  * 100 / (servedClientCount() + nonServedClientCount());
	}
}
