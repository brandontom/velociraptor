package velociraptor;

public class Simulator {
	Predator predator;
	Prey prey;

	public Simulator(Predator predator, Prey prey) {
		this.predator = predator;
		this.prey = prey;
	}

	public Result simulate() {
		// TODO simulate the actual scenario.

		// forumlate result.
		Result result = new Result();
		result.predatorSuccess = false;
		result.timeOfChase = 10.0;
		return result;
	}

}
