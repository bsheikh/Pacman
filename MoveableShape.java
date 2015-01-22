import java.awt.*;

/**
 * The Interface MoveableShape.
 */
public interface MoveableShape {
	
	/**
	 * Move.
	 * Moves the method
	 */
	void move();
	

	/**
	 * Collide Class
	 * Check's if the objects have collided with each other
	 * @param other the other object defined as a MoveableShape
	 * @return true if the objects collide, false otherwise
	 */
	boolean collide(MoveableShape other); 
	
	/**
	 * Draw.
	 * Draw various shapes
	 * @param g2 is the graphics required to draw
	 */
	void draw(Graphics2D g2); 
	
}
