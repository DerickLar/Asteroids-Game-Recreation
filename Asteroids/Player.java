import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends SpaceActors
{   
    private static final int thrust = 5;
    private static final int turnDegree = 300;//3 Degrees
    private boolean isShooting = false;
    private int lives;
    private boolean isTriple = false;
    private int timer = 0;
    private boolean lostLife = false;
    private int hitTimer = 0;
    
    //Constructor of the Player
    public Player()
    {
        //Scale the player ship to be 1/4 of the default size
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
        setBoundryInteraction(SpaceActors.WARP);//Set boundry interaction of player to warp
        lives = 3; // initiate player with 3 lives
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        turnShip(); //Turning
        accelerate(); //Moving
        move(); //Position Player location
        timer++;
        hitDetection();
        shotDetection();
        detectPowerup();       
    }
    
    private void detectPowerup() {
        // check if player is touching a powerup
        if(isTouching(Powerups.class)) {
            if(isTouching(Shield.class)) {
                ((MyWorld)getWorld()).shield = true;
                removeTouching(Shield.class);
            } else if (isTouching(TripleShot.class)) {
                isTriple = true;
                removeTouching(TripleShot.class);
                timer = 0;
            } else { // ExtraLife class
                removeTouching(ExtraLife.class);
                gainLife();
            }
        }
    }
    
    private void shotDetection() {
        //Shoot from the space ship
        //Only shoot once every time space is clicked
        if(!isShooting && Greenfoot.isKeyDown("space"))
        {
            getWorld().addObject(new Shot(this.getScaledR(), this), getX(), getY());
            isShooting = true;
            if (isTriple) { // triple shot implementation
                getWorld().addObject(new Shot(this.getScaledR(), this), getX() + 25, getY() - 20);
                getWorld().addObject(new Shot(this.getScaledR(), this), getX() - 25, getY() - 20);
            } 
        }
        
        if (timer > 300) {
            isTriple = false;
        }
        
        if(isShooting && !Greenfoot.isKeyDown("space"))//Prevents from multiple shots per click
            isShooting = false;
    }
    
    //Turns the ship when user inputs the right or left arrow
    public void turnShip()
    {
        if(Greenfoot.isKeyDown("right"))//Clockwise
                 turn(turnDegree);
        if(Greenfoot.isKeyDown("left"))//Counter-clockwise
                 turn(turnDegree * -1);
    }
    
    //Accelerate the ship foward when space is pressed by user
    public void accelerate()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            addSpeed(thrust,getScaledR());//Accelerate using method in SpaceActors
        }
    }
    
    public int getLives() {
        return lives;
    }
      
    public void loseLife() {
        lives--;
        if (lives <= 0) {
            Greenfoot.setWorld(new GameOver(MyWorld.score)); // Change to game over screen
        }
    }

    private void gainLife() {
        lives++;
    }

    private void hitDetection() {
        if (!((MyWorld)getWorld()).shield) {
            Shot s = (Shot) getOneIntersectingObject(Shot.class); // Get first Shot intersecting Player
            //Check that player is not in invulnerable phase
            if (!lostLife){
                //Player losses a life if intersecting a shot from UFO or an Asteroid
                if((s != null && s.getShooter() instanceof UFO) || this.isTouching(Asteroid.class)) {
                    loseLife();
                    lostLife = true;
                    hitTimer = 0;
                    ((MyWorld)getWorld()).addExplosion(getX(), getY());
                }
            }
        
            if (lostLife) {
                hitTimer++;
                if (hitTimer > 150) {
                    lostLife = false;
                }
            }
        }
    }
    
    public void resetPlayer(){
        this.setVelX(0);
        this.setVelY(0);
        this.setRotation(0);
    }
}
