import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

import java.util.Random;

public class ColorChange extends Actor {

    private Random random = new Random();

    public void act() {
        // Your code here
        changeColor();
    }

    private void changeColor() {
        GreenfootImage image = new GreenfootImage(getImage());

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        image.setColor(new Color(red, green, blue));
        image.fill();

        setImage(image);
    }
}


