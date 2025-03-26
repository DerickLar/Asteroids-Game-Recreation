import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameOver extends World
{

    GreenfootSound gameOverSound = new GreenfootSound("GameOver.wav");
    private int finalScore;
    public GameOver(int score)
    {    
        super(800, 500, 1);
        finalScore = score;
        prepare();
    }
    
    private void prepare() {
        GreenfootImage gameOver = new GreenfootImage("Game Over", 70, Color.WHITE, Color.BLACK);
        Picture gameOverPic = new Picture(gameOver);
        addObject(gameOverPic, getWidth()/2, getHeight()/4);
        
        GreenfootImage score = new GreenfootImage("Total Score: " + finalScore, 50, Color.GREEN, Color.BLACK);
        Picture scorePic = new Picture(score);
        addObject(scorePic, getWidth()/2, getHeight()/4 + 100);
        
        Continue continueButton = new Continue();
        Exit exitButton = new Exit();
        addObject(continueButton, getWidth()/2 + 20, getHeight()/2 + 50);
        addObject(exitButton, getWidth()/2, getHeight()/2 + 150);
        gameOverSound.play();
    }
}
