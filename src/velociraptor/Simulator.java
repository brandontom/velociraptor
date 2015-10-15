package velociraptor;

public class Simulator {
	Predator predator;
	Prey prey;
	Double timeStep;

	public Simulator(Double timeStep, Predator predator, Prey prey) {
		this.predator = predator;
		this.prey = prey;
		this.timeStep = timeStep;
	}

	public Result simulate() {
		while(!chaseIsOver()){
			prey.move(predator);
			predator.move(prey);
		}

		// formulate result.
		Result result = new Result();
		result.predatorSuccess = false; //TODO check if predator succeeded and caught the prey
		result.timeOfChase = 10.0; //TODO not that important, but maybe check time of chase? idk...
		return result;
	}

	private boolean chaseIsOver() {
		//TODO check if time period is over.
		//TODO check if predator caught prey.
		return false;
	}

}
