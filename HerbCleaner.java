package herbcleaner;

import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.listener.InventoryListener;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.awt.*;

@ScriptManifest(version = 0.1, author = "Swagzini", category = Category.HERBLORE, name = "Swagzini's Herb Cleaner")
public class HerbCleaner extends TaskScript{

    public static String grimyHerb = "Grimy tarromin";
    private int herbsCleaned = 0;


    @Override
    public void onStart() {
       addNodes(new Cleaning(true), new Banking(), new WalkToBank());
    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onPaint(Graphics g) {

    }



}
