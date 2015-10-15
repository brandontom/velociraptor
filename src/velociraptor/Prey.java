package velociraptor;

public class Prey {
	public Double maxSpeed;
	public Double xPos;
	public Double yPos;
	//assume facing the direction of <x,y> vector.
	public Double xVel;
	public Double yVel;
	public Double autoDetectionDistance; //distance when automatically detect prey.
	public Double turnRadius;
	public Double maxSpeedTimeLimit;

	public Prey(Double xPosition, Double yPosition, Double maxSpeed, Double maxSpeedTimeLimit, Double autoDetectionDistance, Double turnRadius){
		this.maxSpeed = maxSpeed;
		this.yPos = yPosition;
		this.xPos = xPosition;
		this.maxSpeedTimeLimit = maxSpeedTimeLimit;
		this.turnRadius = turnRadius;
		this.autoDetectionDistance = autoDetectionDistance;
	}
	
	public void move(Predator predator){
		
	}
	
}
