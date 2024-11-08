package me.trigus.aes;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final World world;

    private final Display display;

    public Window(World world) {
        this.world = world;
        this.display = new Display(world);
    }

    public void init() {

        setTitle("Another Evolution Simulator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(world.getWidth(), world.getHeight()));
        setLocationRelativeTo(null);

        add(display);

        setVisible(true);
    }

    public void update(){
        display.repaint();
    }
}
