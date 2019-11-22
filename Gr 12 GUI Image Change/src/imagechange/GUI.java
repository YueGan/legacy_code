package imagechange;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class GUI extends javax.swing.JFrame {

    private ImageIcon picture = null; //easy to access original ImageIcon
    private BufferedImage pic; //pic that gets changed around by other methods
    private BufferedImage pic1;//original pic, does not get changed
    JFileChooser fc;

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        fileChooser = new javax.swing.JFileChooser();
        saveChooser = new javax.swing.JFileChooser();
        jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        original = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        hFlip = new javax.swing.JMenuItem();
        vFlip = new javax.swing.JMenuItem();
        grey = new javax.swing.JMenuItem();
        invertC = new javax.swing.JMenuItem();
        gaussian = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jMenu1.setText("File");

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        jMenu1.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save As");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);
        jMenu1.add(jSeparator1);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        original.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        original.setText("Restore to Original");
        original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalActionPerformed(evt);
            }
        });
        jMenu2.add(original);
        jMenu2.add(jSeparator2);

        hFlip.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        hFlip.setText("Horizontal Flip");
        hFlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hFlipActionPerformed(evt);
            }
        });
        jMenu2.add(hFlip);

        vFlip.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        vFlip.setText("Vertical Flip");
        vFlip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vFlipActionPerformed(evt);
            }
        });
        jMenu2.add(vFlip);

        grey.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        grey.setText("Grey Scale");
        grey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greyActionPerformed(evt);
            }
        });
        jMenu2.add(grey);

        invertC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        invertC.setText("Invert Colour");
        invertC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertCActionPerformed(evt);
            }
        });
        jMenu2.add(invertC);

        gaussian.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        gaussian.setText("Gaussian Blur");
        gaussian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaussianActionPerformed(evt);
            }
        });
        jMenu2.add(gaussian);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                StringTokenizer st = new StringTokenizer(file.getName());
                System.out.println(st.nextToken("."));
                String f = st.nextToken();
                System.out.println(f);
                ImageIO.write(pic, f, file);
            } catch (IOException ex) {
            }

        }
    }//GEN-LAST:event_saveActionPerformed

    private void originalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalActionPerformed
        jLabel.setIcon(picture);
        pic = pic1;
    }//GEN-LAST:event_originalActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                pic = ImageIO.read(file);
                pic1 = pic;
                picture = new ImageIcon(ImageIO.read(file));
            } catch (IOException e) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        jLabel.setIcon(picture);
    }//GEN-LAST:event_openActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void hFlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hFlipActionPerformed

        int w = pic.getWidth();
        int h = pic.getHeight();
        BufferedImage pic2 = new BufferedImage(w, h, pic.getType());
        pic2.createGraphics();
        Graphics2D graphics = pic2.createGraphics();
        graphics.drawImage(pic, 0, 0, w, h, 0, h, w, 0, null);
        graphics.dispose();

        replacingImage(pic2);

    }//GEN-LAST:event_hFlipActionPerformed

    private void vFlipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFlipActionPerformed

        int w = pic.getWidth();
        int h = pic.getHeight();
        BufferedImage pic2 = new BufferedImage(w, h, pic.getType());
        pic2.createGraphics();
        Graphics2D graphics = pic2.createGraphics();
        graphics.drawImage(pic, 0, 0, w, h, w, 0, 0, h, null);
        graphics.dispose();

        replacingImage(pic2);
    }//GEN-LAST:event_vFlipActionPerformed

    private void greyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greyActionPerformed

        BufferedImage pic2 = new BufferedImage(pic.getWidth(), pic.getHeight(), pic.getType());
        pic2.createGraphics();
        for (int x = 0; x < pic.getWidth(); x++) {
            for (int y = 0; y < pic.getHeight(); y++) {
                int rgb = pic.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = (rgb & 0xff);

                int grayS = (int) Math.round(0.2126 * r + 0.7152 * g + 0.0722 * b);
                Color c = new Color(grayS, grayS, grayS);
                pic2.setRGB(x, y, c.getRGB());
            }
        }

        replacingImage(pic2);
    }//GEN-LAST:event_greyActionPerformed

    private void invertCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertCActionPerformed
        int w = pic.getWidth();
        int h = pic.getHeight();

        BufferedImage pic2 = new BufferedImage(w, h, pic.getType());
        pic2.createGraphics();
        for (int x = 0; x < pic.getWidth(); x++) {
            for (int y = 0; y < pic.getHeight(); y++) {
                int rgb = pic.getRGB(x, y);
                int r = 255 - ((rgb >> 16) & 0xff);
                int g = 255 - ((rgb >> 8) & 0xff);
                int b = 255 - ((rgb & 0xff));

                Color invert = new Color(r, g, b);
                pic2.setRGB(x, y, invert.getRGB());
            }
        }
        replacingImage(pic2);
    }//GEN-LAST:event_invertCActionPerformed

    private void gaussianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaussianActionPerformed
        BufferedImage pic2 = new BufferedImage(pic.getWidth(), pic.getHeight(), pic.getType());
        pic2.createGraphics();
        double[] weight = new double[9];
        int[] rgb = new int[9];
        int count = 0;
        double total = 0.0;
        double center = 0.0;
        int[] grayStore = new int[9];
        int[] rStore = new int[9];
        int[] gStore = new int[9];
        int[] bStore = new int[9];
        for (int x = 1; x < pic.getWidth() - 1; x++) {
            for (int y = 1; y < pic.getHeight() - 1; y++) {
                for (int xx = -1; xx < 2; xx++) {
                    for (int yy = -1; yy < 2; yy++) {
                        int nX = x + xx;
                        int nY = y + yy;
                        rgb[count] = pic.getRGB(nX, nY);
                        weight[count] = (1 / (2 * Math.PI * 2.25) * (Math.exp(-((Math.pow(xx, 2) + Math.pow(yy, 2)) / 2 * 2.25))));

                        total += weight[count];

                        rStore[count] = ((rgb[count] >> 16) & 0xff);
                        gStore[count] = ((rgb[count] >> 8) & 0xff);
                        bStore[count] = ((rgb[count] & 0xff));
                        int r = ((rgb[count] >> 16) & 0xff);
                        int g = ((rgb[count] >> 8) & 0xff);
                        int b = ((rgb[count] & 0xff));

                        count++;
                    }
                }
                int centerr = 0;
                int centerg = 0;
                int centerb = 0;
                
                for (int i = 0; i < 9; i++) {
                    weight[i] = weight[i] / total;

                    centerr += (rStore[i] * weight[i]);
                    centerg += (gStore[i] * weight[i]);
                    centerb += (bStore[i] * weight[i]);
                }

                int pixr = (int) Math.round(centerr);
                int pixg = (int) Math.round(centerg);
                int pixb = (int) Math.round(centerb);
                int picRRR = pic.getRGB(x, y);


                int r = (int) Math.round((picRRR >> 16) & 0xff);
                int g = (int) Math.round((picRRR >> 8) & 0xff);
                int b = (int) Math.round((picRRR & 0xff));


                Color blur = new Color(pixr, pixg, pixb);
                pic2.setRGB(x, y, blur.getRGB());
                count = 0;
                total = 0.0;
                center = 0.0;
            }
        }
        replacingImage(pic2);

    }//GEN-LAST:event_gaussianActionPerformed
    public void replacingImage(BufferedImage pic2) {

        ImageIcon picture2 = new ImageIcon(pic2);
        jLabel.setIcon(picture2);
        pic = pic2;

    }

    /* @param
     args the command line arguments

     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        System.out.println((1 / (2 * Math.PI * 2.25)) * (Math.pow(2.71828, -((Math.pow(1, 2) + Math.pow(1, 2)) / 2 * 2.25))));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem exit;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem gaussian;
    private javax.swing.JMenuItem grey;
    private javax.swing.JMenuItem hFlip;
    private javax.swing.JMenuItem invertC;
    private javax.swing.JLabel jLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem original;
    private javax.swing.JMenuItem save;
    private javax.swing.JFileChooser saveChooser;
    private javax.swing.JMenuItem vFlip;
    // End of variables declaration//GEN-END:variables
}
