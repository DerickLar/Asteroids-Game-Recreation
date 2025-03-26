import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shot extends SpaceActors
    {
        private final int width = 10;
        private final int height = 3;
        private final int speed = 500;
        //private int shooter; // 0 == Player, 1 == UFO
        private SpaceActors shooter = null;

        public Shot(int direction, SpaceActors object)
        {
            //Create image of shot
            GreenfootImage image = new GreenfootImage(width,height);
            if(object instanceof Player)
                image.setColor(Color.WHITE);
            else
                image.setColor(Color.GREEN); 
            image.fillRect(0,0,width,height);
            setImage(image);
            
            //shooter = 0;
            shooter = object;
            setBoundryInteraction(SpaceActors.REMOVE);//Set shot interaction with boundry to be removed
            turn(direction);  //Set current direction of shot
        }
        
        
        //Move shot in a consistent straight line
        public void act()
        {
            move(speed);
        }
        
        public SpaceActors getShooter()
        {
            return shooter;
        }
    }
