package velociraptor;
import java.lang.Math;

public class Main {

	static Double startXPositionPredator = 100.0;
	static Double startYPositionPredator = 125.0;
	static Double startXPositionPrey = 100.0;
	static Double startYPositionPrey = 100.0;
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
		Double turnRadiusPrey = 0.5; // meters

		Predator pred = new Predator(startXPositionPredator, startYPositionPredator, maxSpeedPredator,
				maxSpeedTimeLimitPredator, distanceThresholdPredator, turnRadiusPredator);
		Prey prey = new Prey(startXPositionPrey, startYPositionPrey, maxSpeedPrey, maxSpeedTimeLimitPrey,
				distanceThresholdPrey, turnRadiusPrey);

		Simulator simulator = new Simulator(timeStep, pred, prey);

		simulator.simulate();
	}

	private static void calculateStartingPositions(Double distanceThresholdPredator, Double distanceThresholdPrey) {
		Double detectPosition = calculateDetectThreshold();
		if (detectPosition < distanceThresholdPrey) {
			startXPositionPredator = 100.0; // Half of 200 size grid
			startYPositionPredator = 100.0 + distanceThresholdPrey; // Half of 200 size grid plus detect distance
			startXPositionPrey = 100.0; // Center of 200 size grid
			startYPositionPrey = 100.0; // Center of 200 size grid
		} else if (detectPosition < distanceThresholdPredator) {
			startXPositionPredator = 100.0; // Half of 200 size grid
			startYPositionPredator = 100.0 + distanceThresholdPredator; // Half of 200 size grid plus detect distance
			startXPositionPrey = 100.0; // Center of 200 size grid
			startYPositionPrey = 100.0; // Center of 200 size grid
		} else if (detectPosition > distanceThresholdPredator) {
			startXPositionPredator = 100.0; // Half of 200 size grid
			startYPositionPredator = 100.0 + detectPosition; // Half of 200 size grid plus detect distance
			startXPositionPrey = 100.0; // Center of 200 size grid
			startYPositionPrey = 100.0; // Center of 200 size grid
		}
	}

	private static Double calculateDetectThreshold() {
		return inverseCDF(Math.random());
	}

	private static Double inverseCDF(Double randomNumber) {
		Double a = 10.27452;
		Double b = -0.89106;

		// Reverse the CDF
		// C(x) = a / x^(5/8) + b
		// Map C(x) --> x
		return Math.pow(a / (randomNumber - b), 8/5);
	}

}
