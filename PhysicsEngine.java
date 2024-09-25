
/**
 * Write a description of class PhysicsEngine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;

public class PhysicsEngine extends World
{
    static int  t = 0;      
    public PhysicsEngine()
    {
        // initialise instance variables
          
    }
    
    // a bunch of static methods that dont interact wiht mayflowers horrible act methods but rather return values
    public static float[] run(int x, int y) {
        long lastime = System.nanoTime();
        double AmountOfTicks = 30;
        double ns = 1000000000 / AmountOfTicks;
        double delta = 0;
        int frames = 0;
        double time = System.currentTimeMillis();
        
        while( t <= 1) {
            long now = System.nanoTime();
            delta += (now - lastime) / ns;
            lastime = now;
            
            if(delta >= 1) {
                float[] pos = Update(x,y);
                
                frames++;
                delta--;
                if(System.currentTimeMillis() - time >= 1000) {
                    System.out.println("fps:" + frames);
                    time += 1000;
                    frames = 0;
                }
            }
        }
        return null;
        
    }
    
    public static float[] Update(int x, int y){
        t+= 1/30;
        int sx = x; 
        int sy = y;
        int fx = x + 25;
        int fy = y - 50;
        
        
        return new float[] {lerp(sx, fx, t) , lerp(sy, fy, t)};
    }
    
    static float  lerp(float v0, float v1, float t) {
          return (1 - t) * v0 + t * v1;
    }
    
    public void act(){}

   
}
