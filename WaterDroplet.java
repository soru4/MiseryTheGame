
/**
 * Write a description of class WaterDroplet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;
public class WaterDroplet extends Actor
{
    // instance variables - replace the example below with your own
   
    MayflowerImage[] fallingWater = new MayflowerImage[4];
    /**
     * Constructor for objects of class WaterDroplet
     */
        Timer animationT;
    int counter = 0;
    public WaterDroplet()
    {
        // initialise instance variables
        setImage("img/waterfalling/water1.png");
         for(int i = 0; i < fallingWater.length; i++){
            fallingWater[i] = new MayflowerImage("img/waterfalling/water" + ( i+ 1 )+ ".png");
        }
        animationT = new Timer(150000000);
    }
    public void act(){// on spawn it will start falling down 
         int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        setLocation(x, y+1);
        AnimationHelper(fallingWater);
        if(isTouching(Tile.class))
             getWorld().removeObject( (this));
    }
    public void AnimationHelper(MayflowerImage[] anim){
                if(animationT.isDone()){
                animationT.reset();
             System.out.println(counter);
             setImage(anim[counter]);
             
             counter++;
               if(counter >= anim.length)
                   counter = 0;
            }
    }

}
