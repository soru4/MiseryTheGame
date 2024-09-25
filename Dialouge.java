
/**
 * Write a description of class Dialouge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
import java.lang.*;
public class Dialouge extends Actor
{
    long startTime;
    long endTime;
    public Dialouge(String message)
    {
        startTime = System.currentTimeMillis();
        getWorld().showText("Yes! I can buy a handfull of chickpeas for the entire week", 100, 550, Color.WHITE);
        endTime = startTime + 10000;
    }
    
    
    public void act(){
        if(System.currentTimeMillis() >= endTime){
             getWorld().showText("", 100, 550, Color.WHITE);
            
        }
    
    }}
