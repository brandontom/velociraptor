package velociraptor;

import java.awt.Point;

public class Prey {
	Double maxSpeed;
	Double xPos;
	Double yPos;
	//assume facing the direction of <x,y> vector.
	Double xVel;
	Double yVel;
	Double autoDetectionDistance; //distance when automatically detect prey.
	Double turnRadius;

	public Prey(Double xPosition, Double yPosition, Double xVel, Double yVel, Double maxSpeed, Double autoDetectionDistance, Double turnRadius){
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.xVel = xVel;
		this.yVel = yVel;
		this.turnRadius = turnRadius;
		this.autoDetectionDistance = autoDetectionDistance;
	}
	
}
