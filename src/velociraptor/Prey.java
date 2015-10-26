package velociraptor;

import java.util.ArrayList;

public class Prey {
	public Double maxSpeed;
	public Double xPos;
	public Double yPos;
	// assume facing the direction of <x,y> vector.
	public Double xVel;
	public Double yVel;
	public Double autoDetectionDistance; // distance when automatically detect
											// prey.
	public Double turnRadius;
	public Double maxSpeedTimeLimit;

	public Prey(Double xPosition, Double yPosition, Double maxSpeed, Double maxSpeedTimeLimit,
			Double autoDetectionDistance, Double turnRadius) {
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.maxSpeedTimeLimit = maxSpeedTimeLimit;
		this.turnRadius = turnRadius;
		this.autoDetectionDistance = autoDetectionDistance;
		this.xVel = 0.0;
		this.yVel = 0.0;
	}

	public void move(ArrayList<Predator> predators) {
		Predator closest = predators.get(0);
		Double avgX = 0.0;
		Double avgY = 0.0;
		for (Predator pred : predators) {
			if(Predator.distanceFormula(pred.xPos, pred.yPos, this.xPos, this.yPos) <= Predator.distanceFormula(closest.xPos, closest.yPos, this.xPos, this.yPos)){
				closest = pred;
			}
			avgX += pred.xPos;
			avgY += pred.yPos;
		}
		avgX /= predators.size();
		avgY /= predators.size();
		Double xDiff = xPos - closest.xPos;
		Double yDiff = yPos - closest.yPos;
		if(Predator.distanceFormula(avgX, avgY, this.xPos, this.yPos) <= Predator.distanceFormula(closest.xPos, closest.yPos, this.xPos, this.yPos)){
			xDiff = xPos - avgX;
			yDiff = yPos - avgY;
		}

		Double x = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)) / Math.pow(maxSpeed, 2));

		xVel = xDiff / x;
		yVel = yDiff / x;

		xPos += xVel * Main.timeStep;
		yPos += yVel * Main.timeStep;
	}

}
