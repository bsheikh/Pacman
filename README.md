## Pacman

### Images

![alt tag](https://raw.githubusercontent.com/bsheikh/Pacman/master/Images/1.png)

### Instructions

* Creatures implement the interface MoveableShape that can be used as a generic mechanism for animating a shape. A moveable shape must have methods void move() and void draw(Graphics2D g) and boolean collide(MoveableShape other)

* Write a generic GamePanel that draws and moves (i.e. animates) an array list of MoveableShape objects. The objects should be initially randomly positioned in the panel. Design a basic superclass Creature that stores the (x,y) position of a creature, the width and height of the creature's bounding rectangle, and any other variables and methods you deem necessary. The Creature class must implement the MoveableShape interface. You may choose to leave these methods empty or supply default behavior in the Creature superclass. 

* The predator creature is a special creature that devours other prey creatures. That is, when the predator collides with a prey, it "eats" the prey by removing it from the array list. The predator is always moving - either up, down, left, or right - and only it's direction is under user control. The left mouse button turns the predator 90 degrees counterclockwise (i.e. if it was moving up, then a left mouse button click will change its direction to left). The right mouse button turns it 90 degrees clockwise. Hints: 1) the collide() method can use the predator's "contains()" method, 2) the MouseEvent class has a getButton() method - see the Java API. 

* The game is over when the predator has devoured all the prey. The game should start (and creatures begin moving) when the user presses a button or when the user clicks a mouse button for the first time - its your choice. Measure and print the elapsed time for a user to finish the game on the console window. 