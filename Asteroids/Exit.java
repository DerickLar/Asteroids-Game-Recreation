import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Button
{
   
    public Exit() {
        GreenfootImage exitButton = new GreenfootImage(100, 60);
        Font adjustedFont = new Font(true, false, 50);
        exitButton.setFont(adjustedFont);
        exitButton.setColor(Color.WHITE);
        exitButton.drawString("Exit", 0, 50);
        setImage(exitButton);   
    }
    
    public void act()
    {
        checkMouse();
        
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
        }
    }
}
