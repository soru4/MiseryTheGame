import mayflower.*;

public class MyMayflower extends Mayflower
{
    public static int micaWithinScene;
   
    public static int sceneCounter;
    public MyMayflower()
    {
        super("Lab 1", 1200, 600);
         micaWithinScene = 0;
  
         sceneCounter = 1;
    }
    public void init(){
        Mayflower.setFullScreen(false);
        World w = new TitleScreen();
        Mayflower.setWorld(w);
    }
   
}
