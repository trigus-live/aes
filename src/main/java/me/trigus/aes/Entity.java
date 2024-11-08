package me.trigus.aes;

import java.util.Random;

public class Entity {

    private final World world;

    private boolean isObsolete = false;

    private float posX;
    private float posY;

    private float angle; // angle in degrees
    private float velocity;

    public Entity(World world, float posX, float posY) {
        this(world, posX, posY, 0, 0);
    }

    public Entity(World world, float posX, float posY, float angle, float velocity) {
        this.world = world;
        this.posX = posX;
        this.posY = posY;
        this.angle = angle;
        this.velocity = velocity;
    }

    public void update() {
        Engine engine = Engine.getEngine();
        assert engine != null;

        if (new Random().nextInt(100) == 0)
            isObsolete = true;

        double temp_angle = (double) Math.toRadians(angle);
        posX = posX + ((float) Math.sin(temp_angle) * (velocity * engine.getDelta_time()));
        posY = posY + ((float) Math.cos(temp_angle) * (velocity * engine.getDelta_time()));
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public boolean isObsolete() {
        return isObsolete;
    }

    public void setObsolete(boolean obsolete) {
        isObsolete = obsolete;
    }

    public World getWorld() {
        return world;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
}
