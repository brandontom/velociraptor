package velociraptor;
import java.lang.Math;
import java.util.ArrayList;

public class Main {

	private static final int numSimulations = 1000;
	private static final boolean showGraphic = false;
	static Double startXPositionPredator = 100.0;
	static Double startYPositionPredator = 125.0;
	static Double startXPositionPrey = 100.0;
	static Double startYPositionPrey = 100.0;
	static Double timeStep = .01;
	static Double killRadius = 1.0;
	
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

		for(int i = 0; i < numSimulations; i++){
			Predator pred = new Predator(startXPositionPredator, startYPositionPredator, maxSpeedPredator,
					maxSpeedTimeLimitPredator, distanceThresholdPredator, turnRadiusPredator);
			Prey prey = new Prey(startXPositionPrey, startYPositionPrey, maxSpeedPrey, maxSpeedTimeLimitPrey,
					distanceThresholdPrey, turnRadiusPrey);
			
			ArrayList<Predator> list = new ArrayList<Predator>();
			list.add(pred);
			calculateStartingPositions(distanceThresholdPredator, distanceThresholdPrey);
			Predator pred2 = new Predator(startXPositionPredator, startYPositionPredator, maxSpeedPredator,
					maxSpeedTimeLimitPredator, distanceThresholdPredator, turnRadiusPredator);
			list.add(pred2);
	
			Simulator simulator = new Simulator(timeStep, list, prey, showGraphic);
	
			if(!simulator.simulate().predatorSuccess){
				System.out.println("fail");
			}
//			System.out.println(simulator.simulate().predatorSuccess);
		}
	}

	private static void calculateStartingPositions(Double distanceThresholdPredator, Double distanceThresholdPrey) {
		Double detectPosition = calculateDetectThreshold();
		//TODO from the random distances, make it so it's random x,y around the predator.
		Double newX = (Math.random()*2)-1;
		Double newY = 1-Math.abs(newX);
		if(Math.random() > .5){
			newY *= -1;
		}
		if (detectPosition < distanceThresholdPrey) {
			startXPositionPredator = 100.0 + distanceThresholdPrey*newX; // Half of 200 size grid
			startYPositionPredator = 100.0 + distanceThresholdPrey*newY; // Half of 200 size grid plus detect distance
			startXPositionPrey = 100.0; // Center of 200 size grid
			startYPositionPrey = 100.0; // Center of 200 size grid
		} else if (detectPosition < distanceThresholdPredator) {
			startXPositionPredator = 100.0 + distanceThresholdPredator*newX; // Half of 200 size grid
			startYPositionPredator = 100.0 + distanceThresholdPredator*newY; // Half of 200 size grid plus detect distance
			startXPositionPrey = 100.0; // Center of 200 size grid
			startYPositionPrey = 100.0; // Center of 200 size grid
		} else if (detectPosition >= distanceThresholdPredator) {
			startXPositionPredator = 100.0 + detectPosition*newX; // Half of 200 size grid
			startYPositionPredator = 100.0 + detectPosition*newY; // Half of 200 size grid plus detect distance
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
		return (a/Math.pow(randomNumber, 5.0/8.0)) + b;
//		return Math.pow(a / (randomNumber - b), 8/5);
	}

}
