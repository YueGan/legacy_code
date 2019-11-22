package tower.defense;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TowerDefense extends JPanel implements Runnable {

    private ArrayList<Monsters> Mobjects = new ArrayList<>();
    private ArrayList<Towers> Tobjects = new ArrayList<>();
    private boolean run = false;
    private Date timer = new Date();
    private Date atkTimer = new Date();
    private Image img;
    private JLabel text1;
    private JLabel text2;
    private JLabel stageText;
    private JButton nextWave;
    private JButton towers;
    private JButton cancel;
    private JButton upgrade;
    private JButton laser;
    int count = 0;
    int level = 1;
    String pic;
    int gold = 50;
    int lives = 20;
    int stage = 0;
    Iterator<Monsters> e;
    int income;
    boolean allowed;
    int random;

    public static void main(String[] args) {
        TowerDefense TD = new TowerDefense();
    }

    public TowerDefense() {
        setLayout(null);

        JFrame frame = new JFrame();


        nextWave = new JButton();
        nextWave.setIcon(new ImageIcon(getClass().getResource("/tower/defense/Wave.png")));
        nextWave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextWave(evt);
                nextWave.setEnabled(false);
                stage++;
                stageText.setText("Stage: " + stage);
            }
        });
        towers = new JButton();
        towers.setIcon(new ImageIcon(getClass().getResource("/tower/defense/Bullet.jpg")));
        towers.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (gold >= 7) {
                    towerMaker(evt);
                    towers.setEnabled(false);
                    cancel.setEnabled(true);
                    allowed = true;
                    laser.setEnabled(false);
                } else {
                    towers.setEnabled(true);
                    cancel.setEnabled(false);
                    allowed = false;
                }
            }
        });
        cancel = new JButton();
        cancel.setIcon(new ImageIcon(getClass().getResource("/tower/defense/X.png")));
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel(evt);
                towers.setEnabled(true);
                cancel.setEnabled(false);
                allowed = false;
            }
        });

        upgrade = new JButton();
        upgrade.setIcon(new ImageIcon(getClass().getResource("/tower/defense/U.jpg")));
        upgrade.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMouseListener(new upgrade());
            }
        });

        laser = new JButton();
        laser.setIcon(new ImageIcon(getClass().getResource("/tower/defense/Laser.jpg")));
        laser.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (gold >= 15) {
                    laserMaker(evt);
                    laser.setEnabled(false);
                    cancel.setEnabled(true);
                    allowed = true;
                    towers.setEnabled(false);
                } else {
                    laser.setEnabled(true);
                    cancel.setEnabled(false);
                    allowed = false;
                }
            }
        });
        setPreferredSize(new Dimension(800, 600));

//        addKeyListener(new ControlMarine());
        setFocusable(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(this);
        text1 = new JLabel();
        text2 = new JLabel();
        stageText = new JLabel();
        add(text1);
        add(text2);
        add(stageText);
        add(nextWave);
        add(towers);
        add(cancel);
        add(upgrade);
        add(laser);
        text1.setText("Gold: " + gold);
        text1.setBackground(Color.WHITE);
        text1.setBounds(10, 10, 60, 30);
        text2.setText("Lives: " + lives);
        text2.setBackground(Color.WHITE);
        text2.setBounds(10, 25, 60, 30);
        stageText.setText("Stage: " + stage);
        stageText.setBackground(Color.WHITE);
        stageText.setBounds(10, 40, 60, 30);
        nextWave.setBounds(740, 10, 40, 30);
        towers.setBounds(740, 60, 40, 30);
        laser.setBounds(700, 60, 40, 30);
        cancel.setBounds(740, 110, 40, 30);
        upgrade.setBounds(740, 160, 40, 30);
        frame.pack();
        start();

    }

    public void start() {
        Thread thread = new Thread(this);
        run = true;
        thread.start();
    }

    public void run() {
        Thread thread = new Thread(this);
        while (run) {
            if (lives == 0) {
                run = false;
                thread.stop();
            }

            try {
                Iterator<Monsters> b = Mobjects.iterator();
                while (b.hasNext()) {
                    Monsters m = b.next();
                    m.update(this);
                    if (m.getY() == 605) {
                        lives--;
                        text2.setText("Lives: " + lives);
                        m = null;
                        Mobjects.remove(m);

                    }
                }
            } catch (Exception e) {
            }

            try {
                Iterator<Towers> t = Tobjects.iterator();
                while (t.hasNext()) {
                    Towers nT = t.next();
                    nT.update(this);
                    Iterator<Monsters> l = Mobjects.iterator();

                    while (l.hasNext()) {
                        Monsters m = l.next();
                        if (m.getHP() > 0) {
                            if (nT.checkCollision(m) == true) {
                                Date atkTimer2 = new Date();
                                long diffInMillis = atkTimer2.getTime() - nT.getDate().getTime();
                                if (diffInMillis > nT.getDelay()) {
                                    m.takeDamage(nT.getAtk());
                                    nT.newDate();
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e) {
            }

            // draw objects and sleep


            repaint();
            try {
                Thread.sleep(17);
            } catch (Exception e) {
            }
        }
    }

    private void nextWave(java.awt.event.ActionEvent evt) {
        Random random1 = new Random();
        int r = random1.nextInt(750);
        random = random1.nextInt(9);
        level++;
        Mobjects.add(new CrossFieldMonster(r, -50, 1, level, 10, random));
        count++;
        
        timer = new Date();
    }

    private void towerMaker(java.awt.event.ActionEvent evt) {

        addMouseListener(new NewTower());

    }

    private void laserMaker(java.awt.event.ActionEvent evt) {

        addMouseListener(new NewLaser());

    }

    private class NewLaser implements MouseListener {

        public void mouseClicked(MouseEvent event) {
            if (allowed) {
                Tobjects.add(new LaserTower(event.getX(), event.getY(), 100, 3000));
                removeMouseListener(this);
                laser.setEnabled(true);
                cancel.setEnabled(false);
                gold = gold - 15;
                text1.setText("Gold: " + gold);
                towers.setEnabled(true);
            }
        }

        public void mousePressed(MouseEvent event) {
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }
    }

    private void cancel(java.awt.event.ActionEvent evt) {

        towers.setEnabled(false);
        removeMouseListener(new NewTower());

    }

    private class NewTower implements MouseListener {

        public void mouseClicked(MouseEvent event) {
            if (allowed) {
                Tobjects.add(new BulletTower(event.getX(), event.getY(), 75, 1500));
                removeMouseListener(this);
                towers.setEnabled(true);
                cancel.setEnabled(false);
                gold = gold - 7;
                text1.setText("Gold: " + gold);
                laser.setEnabled(true);
            }
        }

        public void mousePressed(MouseEvent event) {
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }
    }

    private class upgrade implements MouseListener {

        public void mouseClicked(MouseEvent event) {
            for (Towers i : Tobjects) {
                if (event.getX() > i.getX() && event.getX() < i.getX() + i.getWidth() && event.getY() > i.getY() && event.getY() < i.getY() + i.getHeight()) {
                    if (gold >= (int) +Math.round((i.getLevel() * 1.5) * i.getOriAtk()) && (gold - (int) +Math.round((i.getLevel() * 1.5) * i.getOriAtk()) > 0)) {

                        i.upgrade();
                        gold = gold - ((int) +Math.round((i.getLevel() * 1.5) * i.getOriAtk()));
                        text1.setText("Gold: " + gold);
                        System.out.println(gold);
                        System.out.println((int) +Math.round((i.getLevel() * 1.5) * i.getOriAtk()));
                    }
                    System.out.println(i.getStats());
                } else {
                    continue;
                }
            }
        }

        public void mousePressed(MouseEvent event) {
        }

        public void mouseReleased(MouseEvent event) {
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Date timer2 = new Date();
        long diffInMillis = timer2.getTime() - timer.getTime();
        if (diffInMillis > 1000) {
            if (count > 0 && count != 10) {
                Random random1 = new Random();
                int r = random1.nextInt(750);
                Mobjects.add(new CrossFieldMonster(r, -50, 1, level, 10, random));
                count++;
            } else if (count == 10) {
                count = 0;
                nextWave.setEnabled(true);
                level++;
            }


            timer = new Date();
        }
        try {
            Iterator<Monsters> b = Mobjects.iterator();
            while (b.hasNext()) {
                Monsters i = b.next();
                if (i.getHP() <= 0) {
                    gold++;
                    text1.setText("Gold: " + gold);
                    e = Mobjects.iterator();
                    while (e.hasNext()) {
                        Monsters u = e.next();
                        if (u.equals(i)) {
                            e.remove();
                        }
                    }
                } else {
                    i.paintComponent(g2);
                }
            }
        } catch (Exception e) {
        }

        for (Towers i : Tobjects) {
            i.paintComponent(g2);
        }


    }
}
