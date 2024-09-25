
/**
 * Write a description of class TitleScreen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class TitleScreen extends World
{
 
 

    public TitleScreen()
    {
         
         MyMayflower.sceneCounter = 1;
         Mayflower.playMusic("aud\\mainmenu.mp3");
         
         setGround();
    }

    
    public void act(){
        showText("Misery: The Game", (1200/ 2) - 180, 250, Color.WHITE);
        showText("Press Enter key to begin!!", (1200/ 2) - 220, 290, Color.WHITE);
         if(Mayflower.isKeyDown( Keyboard.KEY_ENTER)){
         
            
            
            // start Game
            Mayflower.setWorld(new SceneBuilder("img/tiles/S1Ground.png", "img\\background\\CaveS1BG.jpg", false, false, "aud\\LVL1.mp3"));
            
            // set Animation 
            
        }
        
    }
    
    public void setGround(){
        // ground is the bottom row
        
        for(int r = 0; r < 6; r++){
            for (int c = 0; c < 12; c++){
               
                    addObject(new Tile("img/tiles/S1Ground.png"), c * 100,  (r*100));
            }
        
        }
    }
}
