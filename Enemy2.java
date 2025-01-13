import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemies
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean upDown;
    int speed = 2;
    public Enemy2(boolean upAndDown){
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        upDown = upAndDown;
    }
    public void act()
    {
        moveAround();
        EnemyHitWalls();
    }
    public void EnemyHitWalls(){
        if(hitWalls() || isAtEdge()){
            speed = -speed;
        }
    }
    public void moveAround(){
        int x = getX();
        int y = getY();
        if (upDown){
            setLocation(x,y + speed);
        }
        else if(!upDown){
            setLocation(x + speed, y);
        }
    }
}
