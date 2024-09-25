import mayflower.*;

public class Obstacle1Chain extends Actor
{
    MayflowerImage[] ob1 = new MayflowerImage[2];
    Timer animationT;
    int counter = 0;
    
    public Obstacle1Chain()
    {
        
        setImage("img/ob1/ob1.1.png");
         for(int i = 0; i < ob1.length; i++){
            ob1[i] = new MayflowerImage("img/ob1/ob1." + ( i+ 1 )+ ".png");
        }
        animationT = new Timer(150000000);
        
    }

    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        setLocation(x, y);
        AnimationHelper(ob1);
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
