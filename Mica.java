
/**
 * Write a description of class Mica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;
import java.util.Random;
public class Mica extends Actor
{
   

    /**
     * Constructor for objects of class Mica
     */
    public Mica()
    {
       Random random = new Random();

       int rand = random.nextInt(3-1 + 1) + 1;
        setImage(rand == 1 ? "img/mica/Mica1.png" : ((rand == 2 )? "img/mica/Mica2.png" : "img/mica/Mica3.png"));
        
    }

   public void act(){
  
       
            
            
}
}
