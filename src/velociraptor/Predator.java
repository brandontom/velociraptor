package velociraptor;

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
	public Double maxSpeedTimeLimit;

	public Predator(Double xPosition, Double yPosition, Double maxSpeed, Double maxSpeedTimeLimit,
			Double distanceThreshold, Double turnRadius) {
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.maxSpeedTimeLimit = maxSpeedTimeLimit;
		this.turnRadius = turnRadius;
		this.distanceThreshold = distanceThreshold;
	}
	
	public void move(Prey Prey){
		//TODO
	}

}