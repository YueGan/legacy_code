package tower.defense;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BulletTower extends Towers {

    Rectangle2D upgradingHelp;

    public BulletTower(int x, int y, int r, int delay) {
        super(x, y, r, 7, delay);
    }

    public void upgrade() {
        level++;
        atk = (int) +Math.round(atk + (5 * (level - 1)));
        
        if (delay > 500)
            delay -= 500;
        else
            delay = 250;
        
        if (r <= 250)
            r = r + 50;
        else
            r = 275;
    }
    
    public Rectangle2D getTowerShape(){
        return upgradingHelp;
    }

    public void update(TowerDefense panel) {
    }

    public void paintComponent(Graphics2D g2) {
        BufferedImage image = null;
        Rectangle2D.Double mushroom;
        TexturePaint texture;
        try {
            image = ImageIO.read(getClass().getResource("/tower/defense/B.png"));
            mushroom = new Rectangle2D.Double(x, y, image.getWidth(), image.getHeight());
            width = image.getWidth();
            height = image.getHeight();
            upgradingHelp = mushroom;
            texture = new TexturePaint(image, mushroom);
            g2.setPaint(texture);
            g2.fill(mushroom);
        } catch (Exception e) {
        }
        
        circle.setFrame((x - (r - (width/2))), (y - (r - (height/2))), (r * 2), (r * 2));
        g2.setPaint(Color.RED);
        g2.drawOval((x - (r - (width/2))), (y - (r - (height/2))), (r * 2), (r * 2));
        //g2.drawOval((x - ((r+50) - (width/2))), (y - ((r+50) - (height/2))), ((r+50) * 2), ((r+50) * 2));
        
    }
}
