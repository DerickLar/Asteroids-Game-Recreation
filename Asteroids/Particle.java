import greenfoot.Actor;

public class Particle extends Actor {
    private int speed;
    
    public Particle(int speed) {
        this.speed = speed;
    }

    public void act() {
        setLocation(getX() + speed, getY());
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}

