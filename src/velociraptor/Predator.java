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
			Double distanceThreshold, Double turnRadius) {
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.maxSpeedTimeLimit = maxSpeedTimeLimit;
		this.turnRadius = turnRadius;
		this.distanceThreshold = distanceThreshold;
		this.angularVelocity = maxSpeed/turnRadius;
		this.xVel = 0.0;
		this.yVel = 0.0;
	}
	
	public void move(Prey prey, Double timeLeft) {
		Double xPrey = prey.xPos;
		Double yPrey = prey.yPos;

		Double xPreyFuture = prey.xPos + (prey.xVel * 0.005*timeLeft);
		if(xPreyFuture == 0){
			xPreyFuture = 0.0;
		}
		Double yPreyFuture = prey.yPos + (prey.yVel * 0.005*timeLeft);
		if(yPreyFuture == 0){
			yPreyFuture = 0.0;
		}
		Double angle = getAngle(prey.xVel, prey.yVel);

//		Double a, b, c;
//		a = distanceFormula(xPrey, yPrey, this.xPos, this.yPos);
//		b = distanceFormula(xPrey, yPrey, xPreyFuture, yPreyFuture);
//		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * b * a * Math.cos(angle));
//		Double anticipatedAngle = Math.asin(b / c * Math.sin(angle));
//
//		if (anticipatedAngle > maxTurningAngle) {
//			anticipatedAngle = maxTurningAngle;
//		}
//		System.out.println(maxTurningAngle);
//		Double xDiff = (xPos - prey.xPos)*-1;
//		Double yDiff = (yPos - prey.yPos)*-1;

		Double xDiff = (xPos - xPreyFuture)*-1;
		Double yDiff = (yPos - yPreyFuture)*-1;
		
		Double x = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2))/Math.pow(maxSpeed, 2));
		Double newXVel = xDiff/x;
		Double newYVel = yDiff/x;
//		Double dotProduct = newXVel*xVel + newYVel*yVel;
//		Double anticipatedAngle = Math.acos(dotProduct/(lengthFormula(xVel, yVel) * lengthFormula(newXVel,newYVel)));
//		if(anticipatedAngle > maxTurningAngle){
//			anticipatedAngle = maxTurningAngle;
//		}
		
		xVel = newXVel;
		yVel = newYVel;
//		System.out.println(xVel + " " + yVel);

		xPos += xVel*Main.timeStep;
		yPos += yVel*Main.timeStep;
	}

	public static Double distanceFormula(Double x1, Double y1, Double x2, Double y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

	private Double getAngle(Double x, Double y) {
		return Math.atan2(Math.abs(y), Math.abs(x));
	}
	
	public static Double lengthFormula(Double x, Double y){
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}