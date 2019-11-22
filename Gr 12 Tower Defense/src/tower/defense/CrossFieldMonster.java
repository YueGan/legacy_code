package tower.defense;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class CrossFieldMonster extends Monsters {

    private int ySpeed;
    private String image;
    private int frame = 0;
    int r;

    public CrossFieldMonster(int x, int y, int ySpeed, int level, int hp, int r) {
        super(x, y, hp);
        this.ySpeed = ySpeed;
        this.r = r;

        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/tower/defense/Monsters/" + r + frame + ".png"));
            mob = new Rectangle2D.Double(x, y, image.getWidth(), image.getHeight());
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 2; i <= level; i++) {
            hp = (int) +Math.round(hp * 1.08);
        }
    }

    public void takeDamage(int dmg) {
        hp = hp - dmg;
    }

    public Rectangle2D getMob() {
        return mob;
    }

    public void update(TowerDefense panel) {
        y = y + ySpeed;
    }

    public void paintComponent(Graphics2D g2) {

        BufferedImage image = null;

        TexturePaint texture;

        if (frame == 8) {
            frame = 0;
        }
        try {
            image = ImageIO.read(getClass().getResource("/tower/defense/Monsters/" + r + frame + ".png"));
            Rectangle2D pHealth = new Rectangle2D.Double(x, y - 5, 30 / (10/hp), 5);
            Rectangle2D nHealth = new Rectangle2D.Double(x + (30 / (10/hp)), y - 5, 30 - (30 / (10/hp)), 5);
            frame++;
            mob = new Rectangle2D.Double(x, y, image.getWidth(), image.getHeight());
            mob.setFrame(x, y, image.getWidth(), image.getHeight());
            texture = new TexturePaint(image, mob);
            g2.setPaint(texture);
            g2.fill(mob);
            
            g2.setPaint(Color.GREEN);
             g2.fill(pHealth);
             g2.setPaint(Color.RED);
             g2.fill(nHealth);
             
        } catch (Exception e) {
        }
    }
}
