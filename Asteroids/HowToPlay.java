import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay extends World
{
    public HowToPlay()
    {    
        super(800, 500, 1); 
        prepare();
    }
    
    private void prepare() {
        GreenfootImage tutorial = new GreenfootImage("Navigate your spaceship using the keyboard. \n Avoid or shoot asteroids and UFOs.\n Use the left and right arrows to turn the ship,\n press the up arrow to accelerate forward.\n Use the spacebar to shoot.\n You get three lives, survive as long as you can.\n Good luck!", 30,Color.WHITE, Color.BLACK);
        Picture tutorialPic = new Picture(tutorial);
        addObject(tutorialPic, getWidth()/2, getHeight()/2);
        Back backButton = new Back();
        addObject(backButton, getWidth()/2, getHeight()/4 * 3);
        GreenfootImage rocket = new GreenfootImage("rocket.png");
        Picture rocketPic = new Picture(rocket);
        addObject(rocketPic, getWidth()/2, getHeight()/7 * 6);
    }
}
