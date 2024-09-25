import mayflower.*;
public class Obstacle1MC extends Actor
{
    MayflowerImage[] ob1mc = new MayflowerImage[3];
    Timer animationT;
    int counter = 0;
    String dir = "";
    public Obstacle1MC()
    {
       setImage("img/ob1/ob1mc1.png");
         for(int i = 0; i < ob1mc.length; i++){
            ob1mc[i] = new MayflowerImage("img/ob1/ob1mc" + ( i+ 1 )+ ".png");
            ob1mc[i].crop(15, 20, 70, 70);
        }
        animationT = new Timer(150000000);
        dir = "d";
    }
    public void act(){
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        ;
        AnimationHelper(ob1mc);
        if (y < 25){
                dir = "d";
            } else if (y > 425){
                dir = "u";
            }
        if (dir.equals("d")){
                setLocation(x, y + 2);
            } else if (dir.equals("u")){
                setLocation(x, y - 2);
            }   
        
        
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
