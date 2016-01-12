import java.awt.*;

/**
 * The Class SlowPrey.
 */
public class SlowPrey extends Creature {
	
	
	/** The x position. */
	public int xPosition;
	
	/** The y position. */
	public int yPosition;
	
	/** The direction y. */
	public int directionY;
	
	/** The direction x. */
	public int directionX;
	
	/** The speed. */
	public int speed;
	
	/** The radius. */
	public int radius = 40;
	
	/** The random number. */
	int randomNum;
	
	/** The living boolean of a creature. */
	public boolean living;
	
	/** The type creature. */
	public boolean typeCreature = false;
	
	/** The FastPrey object declared as x. */
	public FastPrey x;


	/**
	 * Instantiates a new slow prey.
	 *
	 * @param xPosition the x position
	 * @param yPosition the y position
	 * @param speed the speed
	 */
	public SlowPrey(int xPosition, int yPosition, int speed) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.speed = speed;
		initializeDirection();
		living = true;

	}
	
	/**
	 * Sets the type creature to false.
	 */
	public void setTypeCreatureToFalse() {
		typeCreature = false;
	}
	
	/**
	 * Sets the type creature to true.
	 */
	public void setTypeCreatureToTrue() {
		typeCreature = true;
	}
	
	/**
	 * Kills the creature
	 */
	public void kill() {
		living = false;
	}
	
	/**
	 * Gets the living.
	 *
	 * @return the living status of the creature, true if living, false otherwise
	 */
	public boolean getLiving() {
		return living;
	}

	
	/**
	 * Initialize the Direction
	 */
	public void initializeDirection() {
		randomNum = (int)(Math.random()*((4-0)+1));
		switch (randomNum) {
		case 0: setDir(speed,0); break; //right 
		case 1: setDir(0,-speed); break;//up
		case 2: setDir(-speed,0); break;//left
		case 3: setDir(0,speed); break;//down
		default: setDir(speed,0);
		}
	}
	
	/**
	 * Sets the direction of travel 
	 *
	 * @param directionX the direction x
	 * @param directionY the direction y
	 */
	public void setDir(int directionX, int directionY) {
		this.directionX = directionX;
		this.directionY = directionY;
	}
	
	/**
	 * get the x Position
	 * @return xPosition, returns the xPosition
	 */
	public int getX() {
		return xPosition;
	}
	
	/**
	 * Gets the y Position
	 * @return yPosition, returns the yPosition
	 */
	public int getY() {
		return yPosition;
	}
	
	/**
	 * Get the x Direction Travel
	 * 
	 * @return directionX, returns the x Direction
	 */
	public int getXDir() {
		return directionX;
	}
	
	/**
	 * Gets the Y Direction Travel
	 * 
	 * @return directionY, returns the Y Direction
	 */
	public int getYDir() {
		return directionY;
	}
	
	/**
	 * Move the creature
	 */
	public void move() {
		xPosition+= directionX;
		yPosition+= directionY;
	}
	
	/**
	 * Checks to see if the shapes collide
	 * 
	 * @param other checks with other to see if it collides
	 * @return return's true if it collides, false otherwise
	 */
	public boolean collide(MoveableShape other) {
		
		Predator x = null;
		x = (Predator)other;

		int distanceX = this.getX() - x.getX();
		int distanceY = this.getY() - x.getY();
		int sumOfDistanceSqrt = (int)Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		if (sumOfDistanceSqrt < radius+10) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Bounce collide.
	 *
	 * @param other check with other to see if it collides
	 * @return return's true of it collides, false otherwise
	 */
	public boolean bounceCollide(Creature other) {
		
		SlowPrey x = null;
		x = (SlowPrey)other;

		int distanceX = this.getX() - x.getX();
		int distanceY = this.getY() - x.getY();
		int sumOfDistanceSqrt = (int)Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		if (sumOfDistanceSqrt < radius+10) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Bounce collide with different creature.
	 *
	 * @param other check with other to see if it collides with different creatures
	 * @return return's true of it collides, false otherwise
	 */
	public boolean bounceCollideDifCreature(Creature other) {
		
		FastPrey x = null;
		x = (FastPrey)other;

		int distanceX = this.getX() - x.getX();
		int distanceY = this.getY() - x.getY();
		int sumOfDistanceSqrt = (int)Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		if (sumOfDistanceSqrt < radius+10) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Draw various shapes.
	 *
	 * @param g2 is the graphics required to draw
	 */
	public void draw(Graphics2D g2) {

		// ghost body
		g2.setColor(Color.RED);
		g2.fillArc (xPosition, yPosition, radius, radius, 0, 180); 

		g2.setColor(Color.RED);
		g2.drawRect(xPosition, yPosition + radius / 2, radius, radius / 2);
		g2.fillRect(xPosition, yPosition + radius / 2, radius, radius / 2);

		// ghost eyes
		g2.setColor(Color.black);
		g2.fillOval(xPosition + radius / 4 ,yPosition + radius / 4 , radius / 5, radius / 5); // drawing eye;
		g2.setColor(Color.black);
		g2.fillOval(xPosition + radius / 4 + (radius / 4) ,yPosition + radius / 4 , radius / 5, radius / 5); // drawing eye;
	}
}
