package velociraptor;

public class Main {

	static Double startXPositionPredator = 25.0;
	static Double startYPositionPredator = 25.0;
	static Double startXPositionPrey = 75.0;
	static Double startYPositionPrey = 75.0;
	static Double timeStep = .001;
	
	public static void main(String[] args) {
		//Calculate starting xposition and yposition based on distance thresholds.
		Double distanceThresholdPrey = 15.0;
		Double distanceThresholdPredator = 20.0; // TODO get threshold when predator should start sprinting. for use in calculation of initial positions.
		calculateStartingPositions(distanceThresholdPredator, distanceThresholdPrey);
		
		
		Double maxSpeedPredator = 16.67; // meters per second
		Double maxSpeedTimeLimitPredator = 15.0; // seconds
		Double turnRadiusPredator = 1.5; // meters

		Double maxSpeedPrey = 13.9; // meters per second
		Double maxSpeedTimeLimitPrey = Double.MAX_VALUE; // seconds
		Double turnRadiusPrey = .5; // meters

		Predator pred = new Predator(startXPositionPredator, startYPositionPredator, maxSpeedPredator,
				maxSpeedTimeLimitPredator, distanceThresholdPredator, turnRadiusPredator);
		Prey prey = new Prey(startXPositionPrey, startYPositionPrey, maxSpeedPrey, maxSpeedTimeLimitPrey,
				distanceThresholdPrey, turnRadiusPrey);

		Simulator simulator = new Simulator(timeStep, pred, prey);

		simulator.simulate();
	}

	private static void calculateStartingPositions(Double distanceThresholdPredator, Double distanceThresholdPrey) {
		//TODO actually calculate starting positions of predator and prey.
		startXPositionPredator = 25.0;
		startYPositionPredator = 25.0;
		startXPositionPrey = 75.0;
		startYPositionPrey = 75.0;
	}

}
