package simulation;

import model.Client;

import org.jfree.ui.RefineryUtilities;

import persistence.JdbcPersistence;

/**
 * System simulation. Access point of all related information.
 */
public class Simulation {
	private SimulationEntry simulationEntry;

	public Simulation(SimulationEntry simulationEntry) {
		this.simulationEntry = simulationEntry;
		int cashierCount = simulationEntry.getCashierCount();
	}

	public void simulate() {
		
	}

	/*private int persistSimulationResult() {
		StatisticPersistence persistenceProxy = new JdbcPersistence();
		return persistenceProxy.persist(simulationEntry, statisticManager);
	}*/


	private boolean newClientArrival(int clientArrivalInterval, int simIter) {
		return simIter % clientArrivalInterval == 0;
	}

	public String simulationResults() {
		StringBuffer results = new StringBuffer();
		results.append("########## Simulation results : #####################\n");
		results.append("Simulation Duration : " + simulationEntry.getSimulationDuration() + "\n");
		return results.toString();
	}

}
