import greenfoot.Actor;

public class Explosion extends Actor {
    private int animationFrame = 3;

    public Explosion() {
        setImage("Explosion1.png");
        getImage().scale(getImage().getWidth()/4, getImage().getHeight()/4); // scale the image size
    }
    
    public void act() {
        if (animationFrame <= 27) {
            if ((animationFrame / 3) % 3 == 0) {
               setImage("Explosion" + (animationFrame / 3) + ".png"); 
            }
            animationFrame++;
        } else {
            getWorld().removeObject(this);
        }
    }
}
