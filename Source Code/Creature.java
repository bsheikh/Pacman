import java.awt.*;
import java.util.Random;


/**
 * The Class Creature.
 */
public class Creature implements MoveableShape{
	
	/** The speed rate. */
	private int speedRate;
	
	/** The side bounds. */
	private Rectangle sideBounds;
	
	/** The y direction. */
	private int yDirection;
	
	/** The x direction */
	private int xDirection;
	
	/** The random number Gen. */
	private Random rand;
	
	/**
	 * Instantiates a new creature.
	 */
	public Creature() {
		
	}
	
	/**
	 * Instantiates a new creature.
	 *
	 * @param posX initialize positiotnX
	 * @param posY initialize positionY
	 * @param myspeedRate initialize speed of the creature
	 */
	public Creature(int posX, int posY, int myspeedRate) {
		sideBounds = new Rectangle(posX, posY, 60, 60); 
		speedRate = myspeedRate;
		initializeDirection();
	}
	
	/**
	 * Initialize direction.
	 * Decides which way creature goes
	 */
	public void initializeDirection() {
		int randomNum = rand.nextInt(4);
		switch (randomNum) {
		case 0: setDirection(speedRate,0); break; //right 
		case 1: setDirection(0,-speedRate); break;//up
		case 2: setDirection(-speedRate,0); break;//left
		case 3: setDirection(0,speedRate); break;//down
		default: setDirection(speedRate,0);
		}
	}
	
	/**
	 * Gets the x value
	 *
	 * @return the x value of the bounds
	 */
	public int getX() {
		return (int)sideBounds.getX();
	}
	
	/**
	 * Gets the y coordinate
	 * @return the y value of the bounds
	 */
	public int getY() {
		return (int)sideBounds.getY();
	}
	
	/**
	 * Gets the x direction
	 * @return the x direction of the creature the creature is traveling on
	 */
	public int getXDir() {
		return xDirection;
	}
	
	/**
	 * Gets the y direction
	 * @return the y direction of the creature the creature is traveling on
	 */
	public int getYDir() {
		return yDirection;
	}
	
	/**
	 * Gets the rectangle.
	 * @return the rectangle side bounds
	 */
	public Rectangle getRectangle() {
		return sideBounds;
	}
	
	/**
	 * Sets the direction for the creature
	 * @param xDirection the x direction of the creature
	 * @param yDirection the y direction of the creature
	 */
	public void setDirection(int xDirection, int yDirection) {
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}
	
	/**
	 * Add's direction to the x and y coordinates of the shape therefore allowing it to move
	 */
	public void move() {
		sideBounds.x += xDirection;
		sideBounds.y += yDirection;
	}
	
	/**
	 * Checks to see if the shapes collide
	 * @param other checks with other to see if it collides
	 * @return return's true if it collides, false otherwise
	 */
	public boolean collide(MoveableShape other) {
		Predator x = (Predator)other;
		if (this.getX() - x.getX() < 60) {
			if (this.getY() - x.getY() <60) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * draw method
	 * Draw various shapes
	 * @param g2 is the graphics required to draw
	 */
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.draw(sideBounds);
		g2.fill(sideBounds);
		
	}
}
