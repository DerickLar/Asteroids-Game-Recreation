import greenfoot.*;

public class PlayerLives extends Actor {
    private GreenfootImage image;
    public int x;
    public int y;

    public PlayerLives(int x, int y) {
        updateImage();
        this.x = x;
        this.y = y;
    }

    private void updateImage() {
        image = new GreenfootImage("PlayerLife.png");
        setImage(image);
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4);
    }
}
