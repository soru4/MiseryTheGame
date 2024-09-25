
/**
 * Write a description of class StalagSomething here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class StalagSomething extends Actor
{
       MayflowerImage[] anim = new MayflowerImage[2];
       Timer animationT;
        int counter = 0;
       /**
     * Constructor for objects of class StalagSomething
     */
    public StalagSomething()
    {
        
        
         // initialise instance variables
        setImage("img/ob2/ob2.1.png");
         for(int i = 0; i < anim.length; i++){
            anim[i] = new MayflowerImage("img/ob2/ob2." + ( i+ 1 )+ ".png");
            anim[i].crop(10, 0, 30, 50);
        }
        
        animationT = new Timer(150000000);
    }
    public void act(){
        AnimationHelper(anim);
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
