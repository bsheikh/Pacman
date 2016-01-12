import java.awt.*;

/**
 * The Class Predator.
 */
public class Predator extends Creature {
 
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
 public int radius = 50;
 
 /** The angle. */
 public int angle;
 
 /** The direction face. */
 public int directionFace = 0; // which way the mouth faces
 
 /** The is predator. */
 public boolean isPredator;
 
 /** The indicator. */
 private int indicator;

 
 /**
  * Instantiates a new predator.
  *
  * @param xPosition the x position
  * @param yPosition the y position
  * @param speed the speed
  */
 public Predator(int xPosition, int yPosition, int speed) {
  this.xPosition = xPosition;
  this.yPosition = yPosition;
  this.speed = speed;
  //this.setPredator();
  isPredator = true;
  indicator = 0;
  this.setDir(this.getSpeed(), 0);
 }
 
 
 /**
  * Left. Changes direction of predator
  */
 public void left() {
  indicator +=1;
  indicatorToDirection();
  directionFace+=90;
 }
 
 /**
  * Right.Changes direction of predator
  */
 public void right() {
  indicator -=1;
  indicatorToDirection();
  directionFace-=90;
 }

 
 /**
  * Indicator to direction. Tells which way it should turn
  */
 public void indicatorToDirection() {
  if (indicator == -4 || indicator == 4) {
   indicator = 0;
   
  }
  
  if (indicator == 0) this.setDir(this.getSpeed(), 0); 
  if (indicator == 1) this.setDir(0, -this.getSpeed());
  if (indicator == 2) this.setDir(-this.getSpeed(), 0);
  if (indicator == 3) this.setDir(0, this.getSpeed()); 
  
  if (indicator == -1) this.setDir(0, this.getSpeed());
  if (indicator == -2) this.setDir(-this.getSpeed(), 0);
  if (indicator == -3) this.setDir(0, -this.getSpeed()); 
 }
 
 
 /**
  * Reverse indicator. Tells which way it should turn but in the opposite direction
  */
 public void reverseIndicator() {
  if (indicator == -2 || indicator ==2) {
   indicator = 0;//reverse left
   directionFace = 0;
  } else if (indicator == 0) {
   indicator = 2; // reverse right
   directionFace = 180;
  } else if (indicator ==  1 || indicator == -3) {
   indicator = -1; //reverse up
   directionFace=270;
  } else if (indicator  == -1 || indicator == 3) {
   indicator =1; // reverse down
   directionFace = 90;
  }
  
 }
 
 /**
  * Gets the speed.
  *
  * @return the speed
  */
 public int getSpeed() 
 {
  return speed;
 }
 
 /**
  * Gets the x Position
  * 
  * @return xPosition
  */
 public int getX() {
  return xPosition;
 }
 
 /**
  * Gets the y Position
  * 
  * @return yPosition
  */
 public int getY() {
  return yPosition;
 }
 
 /**
  * Gets the x Direction
  * 
  * @return directionX, which way the creature is moving
  */
 public int getXDir() {
  return directionX;
 }
 
 /**
  * Gets the y Direction
  * 
  * @return directionY, which way the creature is moving
  */
 public int getYDir() {
  return directionY;
 }
 
 /**
  * Sets the direction 
  *
  * @param directionX the direction x
  * @param directionY the direction y
  */
 public void setDir(int directionX, int directionY) {
  this.directionX = directionX;
  this.directionY = directionY;
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
  return false;
 }

 /**
  * Draw various shapes.
  *
  * @param g2 is the graphics required to draw
  */
 public void draw(Graphics2D g2) {

  //pacman body
  angle = (int) (20 * (Math.sin((xPosition + yPosition)*2*Math.PI/50) + 1)); 
  g2.setColor(Color.YELLOW);
  g2.fillArc(xPosition, yPosition, radius, radius, angle/2 + directionFace, 360-angle);
  
  // pacman eyes
  g2.setColor(Color.black);
  g2.fillOval(xPosition + radius / 4 ,yPosition + radius / 4 , radius / 5, radius / 5); // drawing eye;
  
  
  
 }
}
