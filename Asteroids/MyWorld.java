import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MyWorld extends World
{
    static Actor scoreDisplay;
    static Actor levelDisplay;
    static int score;
    boolean shield = false;
    private Player player = new Player();
    private LevelGenerator levelG = new LevelGenerator(this);
    private int timer = 0;
    private PlayerLives one = new PlayerLives(50, 25);
    private PlayerLives two = new PlayerLives(110, 25);
    private PlayerLives three = new PlayerLives(170, 25);

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x800 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        addObject(player, getHeight()/2, getWidth()/2); //Add Player to level
        levelG.generateLevel();
        addPlayerLives();
        score = 0;
        //Create score display that will update
        scoreDisplay = new Picture(new GreenfootImage("Score: "+score, 30, Color.GREEN.brighter(), new Color(0,0,0,0)));
        levelDisplay = new Picture(new GreenfootImage("Level: "+levelG.getCurrentLevel(), 30, Color.GREEN.brighter(), new Color(0,0,0,0)));
        addObject(scoreDisplay, 725, 15);//Add score display to level
        addObject(levelDisplay, getWidth()/2, 15);//Add level display to level
    }
    

    /*
     * Adjust score and update the visual score tracker display
     */
    public static void addScore(int num)
    {
        score += num;
        scoreDisplay.setImage(new GreenfootImage("Score: "+score, 30, Color.GREEN.brighter(), new Color(0,0,0,0)));
    }
    
    public void act() {
        powerups();
        addShieldToPlayer();
        updateLives();
        if(this.getObjects(Asteroid.class).size() == 0 && this.getObjects(UFO.class).size() == 0)
        {
            levelG.levelUp();
            levelDisplay.setImage(new GreenfootImage("Level: "+levelG.getCurrentLevel(), 30, Color.GREEN.brighter(), new Color(0,0,0,0)));
            levelG.generateLevel();
        }
    }
    
    private void powerups() {
        if(Greenfoot.getRandomNumber(1000) < 2) { // randomizes powerup spawning
            int state = Greenfoot.getRandomNumber(3); // randomizes which powerup is spawned
            switch(state) {
                case 0:
                    // extra life
                    addPowerup(new ExtraLife());
                    break;
                case 1:
                    //shield
                    addPowerup(new Shield());
                    break;
                case 2:
                    //triple shot
                    addPowerup(new TripleShot());
                    break;
            }
        }
    }
    
    // helper method for powerups() method
    private void addPowerup(Powerups power) {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(power, x, y);
    }
    
    private void addShieldToPlayer() {
        if (shield) {
            player.setImage("rocketShield.png");
            player.getImage().scale(player.getImage().getWidth()/4, player.getImage().getHeight()/4);
            timer++;
        } else {
            player.setImage("rocket.png");
            player.getImage().scale(player.getImage().getWidth()/4, player.getImage().getHeight()/4);
        }
        
        if (timer > 300) {
            shield = false;
            timer = 0;
        }
    }
    
    private void addPlayerLives() {
        addObject(one, one.x, one.y);
        addObject(two, two.x, two.y);
        addObject(three, three.x, three.y);
    }
    
    private void updateLives() {
         if (player.getLives() == 3) {
            addPlayerLives(); 
         } else if (player.getLives() == 2) {
             removeObject(three);
             addObject(two, two.x, two.y);
             addObject(one, one.x, one.y);
         } else if (player.getLives() == 1) {
             removeObject(three);
             removeObject(two);
             addObject(one, one.x, one.y);
         } else if (player.getLives() == 0) {
             removeObject(one);
             removeObject(two);
             removeObject(three);
         } else {
             int lives = player.getLives();
             lives = 3;
             addPlayerLives();
         }
      }
      
    public void addExplosion(int x, int y) {
        Explosion explosion = new Explosion();
        ScreenShake shake = new ScreenShake();
        shake.shake(this);
        addObject(explosion, x, y);
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public int getScore(){
        return score;
    }
    
    }
    
