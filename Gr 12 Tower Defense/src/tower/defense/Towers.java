
package tower.defense;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public abstract class Towers {
    
    protected int x;
    protected int y;
    protected int r;
    protected int atk;
    protected int originalAtk;
    protected Date d;
    protected int delay;
    protected int width;
    protected int height;
    protected int level;
    
    public Ellipse2D circle;
    
    public Area areaC;
    
    public Towers(int x, int y, int r, int atk, int delay){
        this.x = x;
        this.y = y;
        this.r = r;
        this.atk = atk;
        this.circle = new Ellipse2D.Double(x, y, r, r);
        areaC = new Area(circle);
        d = new Date();
        this.delay = delay;
        level = 1;
        originalAtk = atk; 
    }
    
    public void setDelay(int delay){
        this.delay = delay;
    }            
    
    public void setAtk(int atk){
        this.atk = atk;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setDate(Date d){
        this.d = d;
    }
    
    public int getDelay(){
        return delay;
    }
    
    public Date getDate(){
        return d;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getAtk(){
        return atk;
    }
    
    public int getOriAtk(){
        return originalAtk;
    }
    
    public void newDate(){
        d = new Date();
    }
    
    public void setRadius(int radius){
        r = radius;
    }
    
    public int getRadius(){
        return r;
    }
    
    public int getLevel(){
        return level;
    }
    
    public String getStats(){
        return "Level: " + level + ", Attack: " + atk + ", Range: " + r;
    }
    
    public abstract void upgrade();
    
    public boolean checkCollision(Monsters mob) {
        areaC = new Area(circle);
//        System.out.println(areaC.intersects(mob.getMob().getX(), mob.getMob().getY(), mob.getMob().getWidth(), mob.getMob().getHeight()));
        return areaC.intersects(mob.getMob().getX(), mob.getMob().getY(), mob.getMob().getWidth(), mob.getMob().getHeight());
    }
    
    public abstract void update(TowerDefense panel);
		
    public abstract void paintComponent(Graphics2D g2);    
}
