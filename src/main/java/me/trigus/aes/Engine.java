package me.trigus.aes;

public class Engine {

    private static final int MIN_TICK_TIME = 10;

    private static Engine instance;

    private boolean stop_requested = false;

    private long delta_time = 0;

    private final World world;
    private final Window window;

    public Engine(){
        instance = this;

        world = new World(1024, 768);

        window = new Window(world);

        window.init();
    }

    public void start(){

        long last_check_time = System.currentTimeMillis();

        while (!stop_requested) {
            long current_time = System.currentTimeMillis();

            //if not enough time has passed for a new tick to start, skip
            if ((current_time - last_check_time) < MIN_TICK_TIME)
                continue;

            //update delta-time and last_check_time
            delta_time = current_time - last_check_time;
            last_check_time = current_time;

            updateTime();
            world.update();
            window.update();
        }
    }

    public static Engine getEngine(){
        if (instance != null)
            return instance;
        else return null;
    }

    public World getWorld() {
        return world;
    }

    public Window getWindow() {
        return window;
    }

    public void requestStop(){
        stop_requested = true;
    }

    public long getDelta_time(){
        return delta_time;
    }

    private void updateTime(){

    }
}
