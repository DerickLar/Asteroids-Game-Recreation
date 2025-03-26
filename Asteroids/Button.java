import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private boolean mouseOn = false;
    private static int MAX_TRANS = 255;
    
    public void checkMouse() {
        if (Greenfoot.mouseMoved(null)) {
            mouseOn = Greenfoot.mouseMoved(this);
        }
        
        if (mouseOn) {
            adjustTransparency(MAX_TRANS/2);
        } else {
            adjustTransparency(MAX_TRANS);
        }
    }
    
    public void checkClick(World world) {
            if (Greenfoot.mouseClicked(this)) {
                Greenfoot.setWorld(world);
            }
        }
    
    public void checkClick(World world, GreenfootSound oldMusic, GreenfootSound newMusic) { 
            if (Greenfoot.mouseClicked(this)) {
                getWorld().stopped();
                Greenfoot.setWorld(world);
                oldMusic.stop();
                if (!newMusic.isPlaying()) {
                    newMusic.play();
                    }
            }
        }
    
    public void adjustTransparency(int adjust) {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }
}
