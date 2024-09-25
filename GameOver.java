
/**
 * Write a description of class GameOver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import mayflower.*;
public class GameOver extends World
{
 
 
    int type = 0;
    public GameOver(int x)
    {
        Mayflower.playMusic("aud\\endscene.mp3");
        this.type = x; 
        setBackground("img\\background\\richwhiteguy.png");
        
    }

    
    public void act(){
        
        switch(type){
            case 1:
                showText("You died due to dehydration", (1200/ 2) - 500, 250, Color.RED);
                showText("and labour malpractice by the bourgeoisie class", (1200/ 2) - 500, 290, Color.RED);
                break;
            case 0:
                showText("You WON!!!!!!!", (1200/ 2) - 500, 250, Color.GREEN);
                showText("You have started a revolution against the bourgeoisie", (1200/ 2) - 500, 290, Color.BLUE);
                break;
            default:
                    
            showText("You died due to horrendous working conditions as a impoverished labourer",(1200/ 2) - 540, 250, Color.RED);
            showText("in a mica mine caused by the bourgeoisie class", (1200/ 2) - 500, 290, Color.RED);
            break;
        }
    
        showText("Press Enter key to go to the title screen", (1200/ 2) - 220, 320, Color.BLACK);
         if(Mayflower.isKeyDown( Keyboard.KEY_ENTER)){
         
            
            
            // start Game
            Mayflower.setWorld(new TitleScreen());
            
            // set Animation 
            
        }
        
    }
    
   
}
