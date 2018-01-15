package persistence;

import simulation.SimulationEntry;
import simulation.StatisticManager;

/**
 * General interface for persistence APIs.
 */
public interface StatisticPersistence {

	int persist(SimulationEntry simulationEntry, StatisticManager statisticManager);

	int servedClientCount(int simulationEntryId);
	
	int nonServedClientCount(int simulationEntryId);

}
