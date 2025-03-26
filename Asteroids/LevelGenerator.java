import greenfoot.*;
import greenfoot.*;

public class LevelGenerator {
    private int currentLevel;
    private MyWorld world;

    public LevelGenerator(MyWorld world) {
        this.world = world;
        currentLevel = 1;
    }

    public void generateLevel() {
        world.removeObjects(world.getObjects(Asteroid.class)); // Clear existing asteroids
        world.removeObjects(world.getObjects(UFO.class));   // Clear existing UFO
        world.removeObjects(world.getObjects(Player.class)); // Remove Player from world
        addAsteroids(currentLevel * 2); // Adjust the multiplier for increased difficulty
        if(currentLevel >= 2)
            addUFO();
        addPlayer(); // Add the player back to the center
    }

    private void addAsteroids(int count) {
        for (int i = 0; i < count; i++) {
            int x = Greenfoot.getRandomNumber(world.getWidth());
            int y = Greenfoot.getRandomNumber(world.getHeight());
            world.addObject(new Asteroid(), x, y);
        }
    }
    
    private void addUFO(){
        int x = Greenfoot.getRandomNumber(world.getWidth());
        int y = Greenfoot.getRandomNumber(world.getHeight());
        world.addObject(new UFO(), x, y);
    }

    private void addPlayer() {
        world.addObject(world.getPlayer(), world.getWidth() / 2, world.getHeight() / 2);
        world.getPlayer().resetPlayer();
    }

    public void levelUp() {
        currentLevel++;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}
