import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continue extends Button
{
    private GreenfootSound game = new GreenfootSound("GameSoundtrack.mp3");
    
    public Continue() {
        GreenfootImage continueButton = new GreenfootImage(250, 60);
        Font adjustedFont = new Font(true, false, 50);
        continueButton.setFont(adjustedFont);
        continueButton.setColor(Color.WHITE);
        continueButton.drawString("Continue", 0, 50);
        setImage(continueButton);
    }
    
    public void act()
    {
        checkMouse();
        checkClick(new MyWorld(), game, game);
    }
}
