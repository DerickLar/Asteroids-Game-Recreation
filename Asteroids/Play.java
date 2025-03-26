import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    private GreenfootSound menu = new GreenfootSound("MenuSoundtrack.mp3");
    private GreenfootSound game = new GreenfootSound("GameSoundtrack.mp3");
    
    public Play() {
        GreenfootImage playButton = new GreenfootImage(100, 60);
        Font adjustedFont = new Font(true, false, 50);
        playButton.setFont(adjustedFont);
        playButton.setColor(Color.WHITE);
        playButton.drawString("Play", 0, 50);
        setImage(playButton);
        game.setVolume(25);
    }
    
    public void act() {
        checkMouse();
        checkClick(new MyWorld(), menu, game);
    }
}
