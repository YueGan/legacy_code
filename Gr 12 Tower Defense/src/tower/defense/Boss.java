/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tower.defense;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author 321233652
 */
public class Boss extends Monsters {

    protected int xSpeed;
    protected int ySpeed;
    private Rectangle2D.Double mob;

    public Boss(int x, int y, int xSpeed, int stage, int hp) {
        super(x, y, hp);
        hp = 10 * (int) +Math.round(2 * (stage * 1.25));
    }

    public void takeDamage(int dmg) {
        hp = hp - dmg;
    }

    public Rectangle2D getMob() {
        return mob;
    }

    public void update(TowerDefense panel) {
    }

    public void paintComponent(Graphics2D g2) {
    }
}
