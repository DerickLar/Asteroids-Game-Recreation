import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class UFO extends SpaceActors
{
    private int thrust = 2;
    private int actDelay = 10;
    private int shotDelay = 80;
    private boolean hasShot = false;
    private int turnDegree = 500; //5 degrees
    
    public UFO()
    {
        this.setImage("UFO.png");
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        setBoundryInteraction(SpaceActors.WARP);//Set boundry interaction of UFO to warp
    }
    
    public void act()
    {
        // Waits a bit before chasing the player
        if(actDelay <=0)
            ufoAI();
        else 
            actDelay--;
        
        move(); //Move UFO
        
        if(shotDelay == 0){
            shotDelay = 80;
            hasShot = false;
        }
        
        if(hasShot)
            shotDelay--;
        
        Shot s = (Shot)getOneIntersectingObject(Shot.class);
        if (s != null && s.getShooter() instanceof Player) {
            MyWorld.addScore(50);
            getWorld().removeObject(s);
            getWorld().removeObject(this);
        }
    }
    
    public void ufoAI()
    {
        List pList = getWorld().getObjects(Player.class);
        Player p = (Player) pList.get(0);
        
        if(p.getLives() != 0)
        {
            int x = p.getX() - this.getX();
            int y = p.getY() - this.getY();
            int direction = normalise((int) (Math.toDegrees( Math.atan2(y, x))));
            double length = Math.hypot(x,y);
            
            if(length <= 100)
            {
                addSpeed(thrust, this.getScaledR());
                turnToPlayer(normalise(direction+180));
            }
            else
            {
                addSpeed(thrust, this.getScaledR());
                turnToPlayer(direction);
            }
            
            if(direction <= this.getRotation()+10 && direction >= this.getRotation()-10)
            {
                if(Greenfoot.getRandomNumber(50) < 1 && !hasShot){
                    getWorld().addObject(new Shot(this.getScaledR(), this), getX(), getY());
                    hasShot = true;
                }
            }
            
        }
    }
    
    public void turnToPlayer(int direction)
    {
        int theta = this.getRotation() - direction;
        if(theta <= 180 && theta > 0){
            turn(turnDegree * -1);
        }
        else{
            turn(turnDegree);
        }
    }
    
    public static int normalise(int angle)
    {
        while(angle >= 360){
            angle -= 360;
        }
        while (angle < 0){
            angle += 360;
        }
        
        return angle;
    }
}
