import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Button
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSoundtrack.mp3");
    
    public Back() {
        GreenfootImage backButton = new GreenfootImage(150, 60);
        Font adjustedFont = new Font(true, false, 50);
        backButton.setFont(adjustedFont);
        backButton.setColor(Color.WHITE);
        backButton.drawString("Back", 0, 50);
        setImage(backButton);    
    }
    
    public void act()
    {
        checkMouse();
        checkClick(new Menu());
    }
}
