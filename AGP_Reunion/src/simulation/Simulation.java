package simulation;

import java.util.List;

import model.AbstractClient;
import model.AbstractOperation;
import model.Client;
import model.VIPClient;

import org.jfree.ui.RefineryUtilities;

import persistence.JdbcPersistence;
import persistence.StatisticPersistence;
import bank.Bank;
import bank.Cashier;
import bank.Queue;
import chart.PieGraphicalResult;

/**
 * System simulation. Access point of all related information.
 */
public class Simulation {
	private Bank bank;
	private StatisticManager statisticManager;
	private SimulationEntry simulationEntry;

	public Simulation(SimulationEntry simulationEntry) {
		this.simulationEntry = simulationEntry;
		int cashierCount = simulationEntry.getCashierCount();
		bank = new Bank(cashierCount);
		statisticManager = new StatisticManager();
	}

	public void simulate() {
		int simulationDuration = simulationEntry.getSimulationDuration();
		int clientArrivalInterval = simulationEntry.getClientArrivalInterval();
		for (int currentSystemTime = 0; currentSystemTime <= simulationDuration; currentSystemTime++) {

			statisticManager.simulationDurationRecord();
			SimulationUtility.printBankStat(currentSystemTime, bank);

			updateBank(currentSystemTime);

			boolean newClientArrival = newClientArrival(clientArrivalInterval, currentSystemTime);
			if (newClientArrival) {
				int serviceTime = generateRandomServiceTime();
				AbstractOperation operation = SimulationUtility.getRandomOperation(serviceTime);
				AbstractClient client;
				double priorityClientRate = simulationEntry.getPriorityClientRate();
				if (SimulationUtility.isPriorityClient(priorityClientRate)) {
					client = new VIPClient(currentSystemTime, operation, simulationEntry.getClientPatienceTime());
				} else {
					client = new Client(currentSystemTime, operation, simulationEntry.getClientPatienceTime());
				}

				Cashier freeCashier = bank.getFreeCashier();
				if (freeCashier == null) {
					SimulationUtility.printClientArrival(currentSystemTime, false);
					Queue queue = bank.getQueue();
					queue.addQueueLast(client);
				} else {
					SimulationUtility.printClientArrival(currentSystemTime, true);
					serveClient(currentSystemTime, freeCashier, client);
				}
			}
		}

	}

	private void updateBank(int currentSystemTime) {
		List<Cashier> cashiers = bank.getCashiers();
		Queue queue = bank.getQueue();
		for (Cashier cashier : cashiers) {

			if (!cashier.isFree()) {
				statisticManager.cashierOccupationRecord();
			}

			cashier.work();

			if (cashier.serviceFinished()) {
				// Leaving client
				AbstractClient leavingClient = cashier.getServingClient();
				leavingClient.setDepartureTime(currentSystemTime);
				SimulationUtility.printClientDeparture(currentSystemTime);
				statisticManager.registerServedClient(leavingClient);

				cashier.setServingClient(null);

				// Serve a client in the queue
				if (!queue.isEmpty()) {
					AbstractClient nextClient;

					nextClient = queue.findPriorityClient();
					if (nextClient == null) {
						nextClient = queue.getQueueFirst();
					} else {
						queue.removePriorityClient(nextClient);
					}
					serveClient(currentSystemTime, cashier, nextClient);
				}
			}
		}

		// Leaving impatient clients
		queue.updateClientPatience();
		List<AbstractClient> impatientClients = queue.removeImpatientClients();
		for (AbstractClient client : impatientClients) {
			statisticManager.registerNonServedClient(client);
			SimulationUtility.printClientDepartureWithoutBeingServed(currentSystemTime);
		}
	}

	private void showGraphicalSimulationResult(int idEntry) {
		PieGraphicalResult pieGraphicalResult = new PieGraphicalResult(idEntry);
		pieGraphicalResult.pack();
		RefineryUtilities.centerFrameOnScreen(pieGraphicalResult);
		pieGraphicalResult.setVisible(true);

		// LineGraphicalResult lineGraphicalResult = new
		// LineGraphicalResult(idEntry);
		// lineGraphicalResult.pack();
		// RefineryUtilities.centerFrameOnScreen(lineGraphicalResult);
		// lineGraphicalResult.setVisible(true);
	}

	private int persistSimulationResult() {
		StatisticPersistence persistenceProxy = new JdbcPersistence();
		return persistenceProxy.persist(simulationEntry, statisticManager);
	}

	private void serveClient(int currentSystemTime, Cashier cashier, AbstractClient client) {
		client.setServiceStartTime(currentSystemTime);
		AbstractOperation operation = client.getOperation();
		int serviceTime = operation.getServiceTime();
		cashier.serve(client, serviceTime);
		SimulationUtility.printServiceTimeTrace(currentSystemTime, serviceTime);
	}

	private int generateRandomServiceTime() {
		int minServiceTime = simulationEntry.getMinServiceTime();
		int maxServiceTime = simulationEntry.getMaxServiceTime();
		int randomServiceTime = SimulationUtility.getRandomServiceTime(minServiceTime, maxServiceTime);
		return randomServiceTime;
	}

	private boolean newClientArrival(int clientArrivalInterval, int simIter) {
		return simIter % clientArrivalInterval == 0;
	}

	public String simulationResults() {
		StringBuffer results = new StringBuffer();
		results.append("########## Simulation results : #####################\n");
		results.append("Simulation Duration : " + simulationEntry.getSimulationDuration() + "\n");
		results.append("Served client count : " + statisticManager.servedClientCount() + "\n");
		results.append("Average client waiting time : " + statisticManager.calculateAverageClientWaitingTime() + " \n");
		results.append("Average client service time : " + statisticManager.calculateAverageClientServiceTime() + " \n");
		results.append("Cashier occupation rate : "
				+ statisticManager.calculateAverageCashierOccupationRate(simulationEntry.getCashierCount()) + " % \n");
		results.append("Non-Served client count : " + statisticManager.nonServedClientCount() + "\n");
		results.append("Client satisfaction rate : " + statisticManager.calculateClientSatisfactionRate() + " %");
		return results.toString();
	}

	public void graphicalResults() {
		int idEntry = persistSimulationResult();
		showGraphicalSimulationResult(idEntry);
	}

}
