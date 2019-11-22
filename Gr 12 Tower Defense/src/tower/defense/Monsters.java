package tower.defense;

import java.awt.*;
import java.awt.geom.*;

public abstract class Monsters {
    
    protected int x;
    protected int y;
    protected int hp;
    public Rectangle2D mob;
    protected int oriHP;
    
    public Monsters(int x, int y, int hp){
        this.x = x;
        this.y = y;
        this.hp = hp;
        oriHP = hp;
    }
    
    public void setHP(){
        this.hp = hp;
    }
    
    public int getHP(){
        return hp;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getOriHp(){
        return oriHP;
    }
    
    public abstract void takeDamage(int dmg);
    
    public abstract Rectangle2D getMob();
    
    public abstract void update(TowerDefense panel);
    
    public abstract void paintComponent(Graphics2D g2);
}
