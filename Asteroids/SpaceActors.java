import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/*
 *  Scales each pixle/degree to be 1/100 of the actual unit. 
 *  Makes the turning/movement much smoother for all actors
 */
public abstract class SpaceActors extends Actor
{
    protected static final int sVAL = 100; //Smoothness value
    
    //Actor interaction with game boundry
    protected static final int WARP = 0;
    protected static final int REMOVE = 1;
    
    private int sX, sY; //Scaled location values
    private int velX, velY; //Scaled velocity values
    private int sR; //Scaled rotation value
    private int boundInter = REMOVE; //Determines actors boundry interaction, by defualt actor is removed
    
    /*Overriden move method, updates current location of actor using their current horizontal speed
     * and veritcal speed.
     */
    public void move()
    {
        sX += velX; //Adjust scaled x cord
        sY += velY; //Adjust scaled y cord
        super.setLocation(sX/sVAL, sY/sVAL);//Update current location of actor
        boundry(); //Check if actor has reached the boundry
    }
    
    /*Ovveriden move method, acts like the same as default move, move actor where
     *  rotation is pointing, however scaled
     */
    public void move(int amount)
    {
        move(amount, sR);
    }
    
    /*Ovveriden move method, allows for both amount of movement of an actor and setting a new 
     * direction
     */
    public void move(int amount, int direction)
    {
        //Save current velocity values
        int holdVelX = velX;
        int holdVelY = velY;
        
        //Clear velocity values
        velX = 0;
        velY = 0;
        
        //Add speed new direcrtion
        addSpeed(amount, direction);
        move();
        
        //Restore velocity values
        velX = holdVelX;
        velY = holdVelY;
    }
    
    /* Overrided turn method, rotates actor with scaling factor
     */
    public void turn(int amount)
    {
        sR = (sR + amount + 360  * sVAL) % (360 * sVAL); //Adjust scaled rotation value
        super.setRotation(sR/sVAL); //Update actor rotation value
    }
    
    //Adds speed to an actor by updating is horizontal and vertical velocitys
    public void addSpeed(int speed, int dir)
    {
        velX += Math.cos((double)dir * Math.PI/(180*sVAL)) * (double) speed; //Adjust horizontal velocity
        velY += Math.sin((double)dir * Math.PI/(180*sVAL)) * (double) speed; //Adjust vertical velocity
    }
    
    //Overidden setLocation to factor in scaling
    public void setLocation(int x, int y)
    {
        super.setLocation(x, y); //Set current location of actor
        sX = getX()*sVAL; //Adjust scaled x value
        sY = getY()*sVAL; //Adjust scaled y value
    }
    
    //Overided setRotatin to factor in scaling
    public void setRotation(int angle)
    {
        super.setRotation(angle); //Set current actor angle
        sR = getRotation()*sVAL; //Adjust scaled rotation value
    }
    
    public void setBoundryInteraction(int interaction)
    {
        boundInter = interaction;
    }
    
    //Checks if the actor has reached a game boundry.
    //Then determines how the actor should interact with the boundry
    private void boundry()
    {
        switch(boundInter)
        {
            case WARP://Actor warps from one end of boundry to the other end
                if(getX() <= 0)
                    setLocation(getX() + getWorld().getWidth(), getY());
                else if (getY() <= 0)
                    setLocation(getX(), getY()+getWorld().getHeight());
                else if (getX() >= getWorld().getWidth()-1)
                    setLocation(1, getY());
                else if (getY() >= getWorld().getHeight()-1)
                    setLocation(getX(), 1);
                break;
            case REMOVE://Actor object is removed when reaching a boundry
                if(getX() <= 0 || getX() >= getWorld().getWidth()-1 || getY() <= 0 || getY() >= getWorld().getHeight()-1) 
                    getWorld().removeObject(this);
        }
    }
    
    protected int getScaledX() { return sX; }
    
    protected int getScaledY() { return sY; }
    
    protected int getScaledR() { return sR; }
    
    protected int getvelX() { return velX; }
    
    protected int getvelY() { return velY; }
    
    protected void setVelX(int speed) { velX = speed; }
    
    protected void setVelY(int speed) { velY = speed; }
}
