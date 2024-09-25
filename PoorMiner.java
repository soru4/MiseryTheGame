import mayflower.*;
import java.lang.*;
public class PoorMiner extends Actor
{
    int counter = 0; 
    public MoveState moveState = MoveState.NONE;
    public String dir = "Right";
   
    Timer animationT;
    Timer jumpT;
    MayflowerImage[] walkR = new MayflowerImage[4];
    MayflowerImage[] walkL = new MayflowerImage[4];
    MayflowerImage[] idleR = new MayflowerImage[4];
    MayflowerImage[] idleL = new MayflowerImage[4];
    MayflowerImage[] jumpR = new MayflowerImage[4];
    MayflowerImage[] jumpL = new MayflowerImage[4];
    MayflowerImage[] fallR = new MayflowerImage[4];
    MayflowerImage[] fallL = new MayflowerImage[4];
    public int mica = 0;

    public float hydration = 10; 
    public int health = 100;
    public boolean isComputers = true;
    Timer hydTimer;
    public PoorMiner(boolean isOurComputers
    )
    {
        // this is the class for the poor child miner 
        // this game will attempt to bring aawarness to child labourers. 
      
        
        for(int i = 0; i < walkR.length; i++){
            walkR[i] = new MayflowerImage("img/walk/walk" + ( i+ 1 )+ ".png");
        }
        for(int i = 0; i < walkR.length; i++){
            walkL[i] = new MayflowerImage("img/walk/walk" + ( i+ 1 )+ ".png");
            walkL[i].mirrorHorizontally();
        }
           for(int i = 0; i < walkR.length; i++){
            idleR[i] = new MayflowerImage("img/idle/idle" + ( i+ 1 )+ ".png");
            
        }
          for(int i = 0; i < idleL.length; i++){
            idleL[i] = new MayflowerImage("img/idle/idle" + ( i+ 1 )+ ".png");
            idleL[i].mirrorHorizontally();
        }
        for(int i = 0; i < idleL.length; i++){
            jumpL[i] = new MayflowerImage("img/jump/jump" + ( i+ 1 )+ ".png");
            jumpL[i].mirrorHorizontally();
        }
        for(int i = 0; i < idleL.length; i++){
            jumpR[i] = new MayflowerImage("img/jump/jump" + ( i+ 1 )+ ".png");
          
        }
         for(int i = 0; i < idleL.length; i++){
            fallL[i] = new MayflowerImage("img/fall/Fall" + ( i+ 1 )+ ".png");
            fallL[i].mirrorHorizontally();
        }
        for(int i = 0; i < idleL.length; i++){
            fallR[i] = new MayflowerImage("img/fall/Fall" + ( i+ 1 )+ ".png");

        }
        setImage("img/walk/walk1.png");
        animationT = new Timer(150000000);
        hydTimer = new Timer(240000000 );
        isComputers = isOurComputers;
        if(isComputers){
            health *=2;
        }
    }
    public void act(){
        if(isTouching(Mica.class)){
            mica+= ((int) (Math.random() * 2 )+ 1);
            if(mica == 1){
                //new Dialouge("Yes! I can buy a handfull of chickpeas for the entire week");
            }
           getWorld().removeObject( getOneIntersectingObject(Mica.class));
        }
        if(isTouching(Rocks.class)){
            health-=50;
           getWorld().removeObject( getOneIntersectingObject(Rocks.class));
        }
        getWorld().showText(printState() , 10, 30, Color.WHITE);
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
         if(!isTouching(Tile.class)){
            setLocation(x, y+1);
        }
        
        if(isGrounded()){
             if (Mayflower.isKeyDown( Keyboard.KEY_RIGHT ) && x <1200 - w) {
                dir = "Right"; // sets dir to right
               moveState = MoveState.WALKR;  // sets movestate to walk r 
               setLocation(Mayflower.isKeyDown(Keyboard.KEY_LSHIFT ) ? x + 2 : x + 1, y); // if dash move at 2 if not dash move at 1 
            
            }
            else if (Mayflower.isKeyDown( Keyboard.KEY_LEFT ) && x > 0 ) {
                moveState = MoveState.WALKL;
                dir = "Left";
               setLocation(Mayflower.isKeyDown(Keyboard.KEY_LSHIFT ) ? x - 2 : x - 1, y);// if dash move at 2 if not dash move at 1 
            }
            
           
            else{
                moveState = MoveState.NONE;
            }
            
           
        }
         else if(y > 50 && !Mayflower.isKeyDown(Keyboard.KEY_UP)){
             moveState = dir.equals("Left") ? MoveState.FALLL : MoveState.FALLR; // if we are not grounded and not jumping we can fall  based on the die. 
        }
        
        if(Mayflower.isKeyDown( Keyboard.KEY_UP) && y >= 250 && x <1200 - w && x > 0 ){
                
            setLocation(dir.equals("Left") ? x-2 : x+2, y - 3);
            moveState = dir.equals("Left") ? MoveState.JUMPL : MoveState.JUMPR;
            // based on the direction that the charachter is facing we jump up and move horizontally in that dir and set the movestate accordingly for animation helper method. 
          
            // set Animation 
                
        }
      
        
        
        if(getX() >= 1120 && MyMayflower.sceneCounter == 1){
          Mayflower.setWorld(new SceneBuilder("img/tiles/S1Ground.png", "img\\background\\Scene2.png", false, true, "")); // changes scenes to 2
          MyMayflower.sceneCounter++;
          //new Dialouge("Sephora has billions and I have nothing");
        }
        else if(getX() >= 1120 && MyMayflower.sceneCounter == 2){
          Mayflower.setWorld(new SceneBuilder("img/tiles/S1Ground.png", "img\\background\\Scene3.png", true, true, "")); // changes scenes to 3
          MyMayflower.sceneCounter++;
          //new Dialouge("I don’t know how i've gotten here alive. This mine is dangerous");
        }
        else if(getX() >= 1120 && MyMayflower.sceneCounter == 3){
          Mayflower.setWorld(new GameOver(0)); // changes scenes to game over
        
        }
        addHydration();
        touchMC();
        touchStalag();
        animationManager();
    }
    public void animationManager(){
        
        
        // just sets animation based on move state. 
         // start with walkR
          
        if(moveState == MoveState.WALKR){
           AnimationHelper(walkR);//sets animm to walk right
        } else if(moveState == MoveState.WALKL){ 
            AnimationHelper(walkL); // set anim to walkL 
        }else if(moveState == MoveState.JUMPR){
              AnimationHelper(jumpR);// set anim 
             
        }
        else if(moveState == MoveState.JUMPL){
              AnimationHelper(jumpL);
        }
        else if(moveState == MoveState.FALLR){
              AnimationHelper(fallR);
             
        }
        else if(moveState == MoveState.FALLL){
              AnimationHelper(fallL);
        }
        else{
             // idle is active, play idle anim with according dir
            if(dir.equals("Right")){
                  AnimationHelper(idleR);
                  moveState = MoveState.IDLER;
            }
            if(dir.equals("Left")){
              AnimationHelper(idleL); // 
                moveState = MoveState.IDLEL;
            }
        }
         
    }
    public void AnimationHelper(MayflowerImage[] anim){
            // loops through the animation
                if(animationT.isDone()){
                animationT.reset();
        
             setImage(anim[counter]);
             
             counter++;
               if(counter >= anim.length)
                   counter = 0;
            }
    }
    
    public void addHydration(){
        if(isTouching(WaterDroplet.class)){
            hydration = hydration + 6 >= 100 ? 100 : hydration + 6;//
            // touching a WAterdroplet Obj
        
            getWorld().removeObject( getOneIntersectingObject(WaterDroplet.class)); // removes the obj
        
        
        }
         int x = (int)(Math.random() * 170);

        if(x == 50){
            
           
             hydration = hydration + -1f <=  0 ? 0 : hydration + -1f;
             // game Over
             if(hydration <= 0)
                  Mayflower.setWorld(new GameOver(1));
        }
        if(health <= 0){
            Mayflower.setWorld(new GameOver(2));
        }
    }
    
    public boolean isGrounded(){
        return isTouching(Tile.class);
    }
    
    public String printState(){
        return 
         "Mica: " + mica +  ":" + "\nHydration: " + hydration + ":" + " Health: " + health;
    }
     public String printMultiState(){
        return 
          mica +  ":" + hydration + ":"+ health + ":" + getX() + ":" + getY() + ":"
          + moveStateToString();
    }
    
    public String moveStateToString(){
        if(moveState == MoveState.WALKL){
            return "walkL";
        }
        else if(moveState == MoveState.WALKR){
            return "walkR";
        }
        else if(moveState == MoveState.IDLEL){
            return "idleL";
        }
        else if(moveState == MoveState.IDLER){
            return "idleR";
        }
        else if(moveState == MoveState.JUMPL){
            return "JUMPL";
        }
        else if(moveState == MoveState.JUMPR){
            return "JUMPR";
        }  else if(moveState == MoveState.FALLR){
            return "FallR";
        }
        else if(moveState == MoveState.FALLL){
            return "FallL";
        }
        return "";
    }
    Timer cd = new Timer(700000000);
    public void touchMC(){
        if (isTouching(Obstacle1MC.class)){
            if(cd.isDone()){
                health -= 15;
                cd.reset();
           }
        }
    }
    public void touchStalag(){
        if (isTouching(StalagSomething.class)){
            if(cd.isDone()){
                health -= 5;
                cd.reset();
           }
        }
    }
    public enum MoveState{
        WALKL,
        WALKR,
         IDLEL,
        IDLER,
        JUMPR,
        JUMPL,
        FALLR,
        FALLL,
        NONE
        
    }
}
