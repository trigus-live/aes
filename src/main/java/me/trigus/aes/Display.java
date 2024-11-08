package me.trigus.aes;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel{

    private final World world;

    public Display(World world){
        this.world = world;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color bgColor = new Color(32,32,32);
        Color entityColor = new Color(220, 170, 0);

        g.setColor(bgColor);
        g.fillRect(0, 0, world.getWidth() - 1, world.getHeight() - 1 );

        g.setColor(entityColor);
        for(Entity entity : world.getEntityList()) {
            int x = (int) entity.getPosX() - 1;
            int y = (int) entity.getPosY() - 1;
            g.fillOval(x - 2, y - 2, 4, 4);
        }
    }

    public void update() {
        repaint();
    }
}
