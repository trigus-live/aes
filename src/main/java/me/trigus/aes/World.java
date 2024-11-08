package me.trigus.aes;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class World {

    private final int width;
    private final int height;

    private final List<Entity> entityList;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.entityList = new CopyOnWriteArrayList<>();
    }

    public void update() {

        //remove Obsolete entities
        entityList.removeIf(Entity::isObsolete);

        if (entityList.size() < 25) {
            Random random = new Random();
            float x = random.nextFloat(0, width);
            float y = random.nextFloat(0, height);
            float a = random.nextFloat(0, 360);
            float v = random.nextFloat(0.2f, 0.5f);
            addEntity(new Entity(this, x, y, a, v));
        }

        for (Entity entity : entityList){
            entity.update();
        }
    }

    public void addEntity(Entity entity) {
        entityList.add(entity);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }
}
