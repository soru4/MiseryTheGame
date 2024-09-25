/*Use 
   Scene Builder tpo */
import mayflower.*;
public class SceneBuilder extends World
{
    String groundTile;
    public String[][] scene = new String[6][12];
    Timer dropSpawn;
     
     boolean rock;
     
    public SceneBuilder(String gT, String bg, boolean rocks, boolean chains, String music){
        //    
        MyMayflower.micaWithinScene = 0; // resets mica within scene
        Mayflower.playMusic(music);
        this.groundTile = gT;
        addObject(new PoorMiner(), 10    ,  400); // adds in the char
        setBackground(bg);
        setGround();
        ChooseOb2Pos();
        rock = rocks;
        dropSpawn = new Timer(2100000000); // the rate at which the water droplets fall
        
        if(chains)
            ChooseOb1Pos();
        
    }
       
    
    public void setGround(){
        // ground is the bottom row
        // adds in the ground
        int row = scene.length -1; 
        
        for(int i = 0; i < scene[row].length; i++){
            scene[row][i] = "Ground";
            
            addObject(new Tile(groundTile), i * 100,  (row*100));
        }
        
    }
    public void ChooseWaterDropPos(){
        int r = 0; 
        // as the method states, places in the water dropelets randomly on the top of world
        int c = (int)(Math.random() * scene[r].length);
        addObject(new WaterDroplet(), c * 100,  (r*100));
    }
    public void ChooseRockDropPos(){
        int r = 0; 
        // as the method states, places in the rocks randomly on the top of 
        int c = (int)(Math.random() * scene[r].length);
        addObject(new Rocks(), c * 100,  (r*100));
    }
   
    
                

           
    
    public void ChooseOb1Pos(){
        int c; // places OB1 which is the minecart with chains
        for (int i = 0; i < 3; i++){
            c = (int)(Math.random() * (scene[0].length-3) +3);
            if(scene[0][c] == (null)){
                addObject(new Obstacle1Chain(), (c * 100), 0);
                addObject(new Obstacle1MC(), (c * 100) + 15, 275);
                scene[0][c] = "ob1";
            } else{
                continue;
            }
            
        }
    }
    
    public void ChooseOb2Pos(){
        int c;
        // places the stalagsomethings with the mica above them
         for (int r = 0; r < 5; r++){
            c = (int)(Math.random() * (scene[0].length-3) +3);
            
                addObject(new StalagSomething(), (c * 100), 450);
                scene[4][c] = "Mica";
                Mica tempMica = new Mica();
                MyMayflower.micaWithinScene++;

                addObject(tempMica, c*100, (4)*100);
                scene[5][c] = "ob2";
            
            
        }
    }
    public void act(){
        
       if(dropSpawn.isDone()){
           // spawns in the water and stuff
                dropSpawn.set(2139000000);
                
                ChooseWaterDropPos();
               if(rock)
                    ChooseRockDropPos();
            }
    }
}
