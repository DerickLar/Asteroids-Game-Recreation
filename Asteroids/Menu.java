import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Menu extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("MenuSoundtrack.mp3");
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        prepare();
    }
    
    private void prepare() {
        GreenfootImage logo = new GreenfootImage("AsteroidsLogo.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic, getWidth()/2, getHeight()/4);
        Exit exit = new Exit();
        addObject(exit, getWidth()/2, (getHeight()/6) * 5);
        Play play = new Play();
        addObject(play, getWidth()/2, getHeight()/2);
        Tutorial tutorial = new Tutorial();
        addObject(tutorial, getWidth()/2, (getHeight()/3) * 2);
    }
    
    public void started() {
        soundtrack.playLoop();
    }
    
    public void stopped() {
        soundtrack.stop();
    }
}
