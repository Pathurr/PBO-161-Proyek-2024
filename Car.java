import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Player
{
    // Encapsulate CarLives with a private access modifier
    private int carLives;

    public Car(int lives){
        getImage().scale(getImage().getWidth()/3, getImage().getHeight()/3);
        this.carLives = lives; // Initialize carLives
    }

    // Getter
    public int getCarLives() {
        return carLives;
    }

    // Setter
    public void setCarLives(int lives) {
        if (lives >= 0) { // Ensure lives cannot be negative
            this.carLives = lives;
        }
    }

    public void act()
    {
        slideAround();
        collectBoost();
        maxSpeed();
        loseLife();
        CarHit();
        YouWin();
        YouLoser();
    }

    public void CarHit(){
        if (hitEnemy()){
            setLocation(40, 560);
        }
    }

    public void loseLife(){
        if(hitEnemy()){
            setCarLives(getCarLives() - 1); // Use setter to update carLives
        }
    }

    public void YouLoser(){
        if(getCarLives() == 0){
            getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
