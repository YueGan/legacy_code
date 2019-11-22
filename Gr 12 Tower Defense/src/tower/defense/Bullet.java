package tower.defense;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bullet {

    int x;
    int y;
    private Ellipse2D circle;
    float xSpeed;
    float ySpeed;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.circle = new Ellipse2D.Double(x, y, 5, 5);
    }

    public void setC(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void target(int x, int y) {
        xSpeed = (x - this.x) / 1;
        ySpeed = (y - this.y) / 1;
        ySpeed = ySpeed * (float) (2.5 / Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed));
        xSpeed = xSpeed * (float) (2.5 / Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed));
    }

    public void update(TowerDefense panel) {
        this.x += xSpeed;
        this.y += ySpeed;
    }

    public boolean checkCollision(CrossFieldMonster mob) {
        return circle.intersects(mob.getMob());
    }

    public void paintComponent(Graphics2D g2) {
        circle.setFrame(x, y, 5, 5);
        g2.setColor(Color.BLACK);
        g2.fill(circle);
        g2.draw(circle);
    }
}
