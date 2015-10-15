package velociraptor;

public class Main {

	public static void main(String[] args) {
		Double startXPositionPredator = 25.0;
		Double startYPositionPredator = 25.0;
		Double maxSpeedPredator = 16.67; // meters per second
		Double maxSpeedTimeLimitPredator = 15.0; // seconds
		Double distanceThresholdPredator = 20.0; // TODOTODOTODOTODOTODOTODO
		Double turnRadiusPredator = 1.5; // meters

		Double startXPositionPrey = 75.0;
		Double startYPositionPrey = 75.0;
		Double maxSpeedPrey = 13.9; // meters per second
		Double maxSpeedTimeLimitPrey = Double.MAX_VALUE; // seconds
		Double distanceThresholdPrey = 15.0;
		Double turnRadiusPrey = .5; // meters

		Predator pred = new Predator(startXPositionPredator, startYPositionPredator, maxSpeedPredator,
				maxSpeedTimeLimitPredator, distanceThresholdPredator, turnRadiusPredator);
		Prey prey = new Prey(startXPositionPrey, startYPositionPrey, maxSpeedPrey, maxSpeedTimeLimitPrey,
				distanceThresholdPrey, turnRadiusPrey);

		Simulator simulator = new Simulator(pred, prey);

		simulator.simulate();
	}

}
