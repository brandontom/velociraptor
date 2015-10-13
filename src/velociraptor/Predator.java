package velociraptor;

import java.awt.Point;

public class Predator {
	Double maxSpeed;
	Double xPos;
	Double yPos;
	//assume facing the direction of <x,y> vector.
	Double xVel;
	Double yVel;
	Double distanceThreshold; //minimum distance, regardless of detection, will start sprinting.
	Double turnRadius;

	public Predator(Double xPosition, Double yPosition, Double xVel, Double yVel, Double maxSpeed, Double distanceThreshold, Double turnRadius){
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.xVel = xVel;
		this.yVel = yVel;
		this.turnRadius = turnRadius;
		this.distanceThreshold = distanceThreshold;
	}
	
}
