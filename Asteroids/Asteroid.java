import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends SpaceActors
{
    private int size;
    private int health;
    private int rotationSpeed = (int) Math.random() * 100 - 200;
    private int movementSpeed = 100;
    private int direction = (int) (Math.random() * 360) * 100;
    
    // default Asteroid constructor
    public Asteroid() {
        size = 3;
        health = 3;
        setBoundryInteraction(WARP);
    }
    
    // constructor for child Asteroids
    public Asteroid(int size) {
        this.size = size;
        health = size;
        setBoundryInteraction(WARP);
        
        switch (size) {
            case 2: 
                getImage().scale(getImage().getWidth() / 3 * 2, getImage().getHeight() / 3 * 2);
                break;
            case 1:
                getImage().scale(getImage().getWidth() / 3, getImage().getHeight() / 3);
                break;
        }
    }
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        rotateAsteroid();
        move(movementSpeed, direction);
        
        // Get all possible shot intersecting asteriod
        List<Shot> listS = getIntersectingObjects(Shot.class);        
        if (listS != null){ // Check that list is not empty
            for(Shot s: listS){ //Check that each shot is from the player
                if(s.getShooter() instanceof Player) {
                    health -= 1;
                    getWorld().removeObject(s);
                }
            }
        }
  
        if (health <= 0) {
            MyWorld.addScore(20);//Add to player score
            if (size > 1) {
                getWorld().addObject(new Asteroid(size - 1), getX(), getY());
                getWorld().addObject(new Asteroid(size - 1), getX(), getY());
            }
            
            getWorld().removeObject(this);
        }
    }
    
    // Rotates the image, **not the Asteroid object itself**
    public void rotateAsteroid() {
        turn(rotationSpeed);
    }
}
