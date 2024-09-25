
/**
 * Write a description of class WaterDroplet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;
public class Rocks extends Actor
{
    // instance variables - replace the example below with your own
   
    MayflowerImage[] fallingWater = new MayflowerImage[2];
    /**
     * Constructor for objects of class rocks
     */
        Timer animationT;
    int counter = 0;
        public Rocks()
        {
        // initialise instance variables
            if ((int) (Math.random() * 2) == 0){
            setImage("img/ob3/ob3r1.1.png");
             for(int i = 0; i < fallingWater.length; i++){
                fallingWater[i] = new MayflowerImage("img/ob3/ob3r1." + ( i+ 1 )+ ".png");
                fallingWater[i].crop(10,10,40,40);
            }
            animationT = new Timer(150000000);
            }    else{
            setImage("img/ob3/ob3r2.1.png");
             for(int i = 0; i < fallingWater.length; i++){
                fallingWater[i] = new MayflowerImage("img/ob3/ob3r2." + ( i+ 1 )+ ".png");
                fallingWater[i].crop(10,10,40,40);
            }
            animationT = new Timer(150000000);
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
        if(isTouching(StalagSomething.class))
            getWorld().removeObject( (this));
        if(isTouching(Obstacle1Chain.class))
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
