package velociraptor;
import java.lang.Math;

public class Predator {
	public Double maxSpeed;
	public Double xPos;
	public Double yPos;
	// assume facing the direction of <x,y> vector.
	public Double xVel;
	public Double yVel;
	public Double distanceThreshold; // minimum distance, regardless of
								     // detection, will start sprinting.
	public Double turnRadius;
	public Double angularVelocity;
	public Double maxTurningAngle;
	public Double maxSpeedTimeLimit;

	public Predator(Double xPosition, Double yPosition, Double maxSpeed, Double maxSpeedTimeLimit,
			Double distanceThreshold, Double turnRadius, Double angularVelocity) {
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.maxSpeedTimeLimit = maxSpeedTimeLimit;
		this.turnRadius = turnRadius;
		this.distanceThreshold = distanceThreshold;
		this.angularVelocity = angularVelocity;
		this.maxTurningAngle = (Math.PI + angularVelocity) / 2.0;
	}
	
	public void move(Prey prey, Double timeLeft) {
		Double xPrey = prey.xPos;
		Double yPrey = prey.yPos;

		Double xPreyFuture = prey.xVel * 0.8 * timeLeft;
		Double yPreyFuture = prey.yVel * 0.8 * timeLeft;
		Double angle = getAngle(prey.xVel, prey.yVel);

		Double a, b, c;
		a = distanceFormula(xPrey, yPrey, this.xPos, this.yPos);
		b = distanceFormula(xPrey, yPrey, xPreyFuture, yPreyFuture);
		c = Math.sqrt(b^2 + c^2 - 2 * b * c * Math.cos(angle));
		Double anticipatedAngle = Math.asin(b / c * Math.sin(angle));

		if (anticipatedAngle > maxTurningAngle) {
			
		}
	}

	private Double distanceFormula(Double x1, Double y1, Double x2, Double y2) {
		return Math.sqrt((x1 - x2)^2 + (y1 - y2)^2);
	}

	private Double getAngle(Double x, Double y) {
		return Math.atan(Matb.abs(y), Math.abs(x));
	}
}