import greenfoot.World;
import greenfoot.Actor;
import greenfoot.Greenfoot;

public class ScreenShake {
    private static int intensity = 5;

    public static void shake(World world) {
        int deltaX = Greenfoot.getRandomNumber(intensity) - intensity / 2;
        int deltaY = Greenfoot.getRandomNumber(intensity) - intensity / 2;

        for (Object obj : world.getObjects(null)) {
            if (obj instanceof Actor) {
                Actor actor = (Actor) obj;
                actor.setLocation(actor.getX() + deltaX, actor.getY() + deltaY);
            }
        }
    }
}
