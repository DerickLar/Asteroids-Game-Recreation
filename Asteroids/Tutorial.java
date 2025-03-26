import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends Button
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSoundtrack.mp3");
    public Tutorial() {
        GreenfootImage tutorialButton = new GreenfootImage(300, 60);
        Font adjustedFont = new Font(true, false, 50);
        tutorialButton.setFont(adjustedFont);
        tutorialButton.setColor(Color.WHITE);
        tutorialButton.drawString("How to Play", 0, 50);
        setImage(tutorialButton);
    }
    
    public void act()
    {
        checkMouse();
        checkClick(new HowToPlay());
    }
}
