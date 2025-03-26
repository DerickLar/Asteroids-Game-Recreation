import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Powerups extends Actor
{
    protected int timer = 0;
    
    public void act()
    {
        timer++;
        if (timer == 200) {
            (getWorld()).removeObject(this); // remove the powerup after a certain amount of time
            timer = 0;
        }
    }
    
    public Powerups() {
        getImage().scale(getImage().getWidth()/6, getImage().getHeight()/6); // scale powerups to 1/4 of their size
    }
}
