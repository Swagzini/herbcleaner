package herbcleaner;

import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public class Banking extends TaskNode {



    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean accept() {
        if(!getInventory().contains(HerbCleaner.grimyHerb)) {
            log("Banking validate");
            return true;
        }
        return false;
    }

    @Override
    public int execute() {
        if (getInventory().isItemSelected()){
            getInventory().deselect();
        }
        log("Banking");
        getBank().open();
        sleepUntil(() -> getBank().isOpen(),5000);
        if(getBank().isOpen()) {
            if(!getInventory().isEmpty()) {
                getBank().depositAllItems();
                sleepUntil(() -> getInventory().isEmpty(), 3000);
            }
            if (!getBank().contains(HerbCleaner.grimyHerb)) {
                getTabs().logout();
                return -1;
            }
                getBank().withdrawAll(HerbCleaner.grimyHerb);
                sleepUntil(() -> getInventory().contains(HerbCleaner.grimyHerb),3000);
                if (getInventory().contains(HerbCleaner.grimyHerb)) {
                    getBank().close();
                    sleep(500, 600);
                }

        }
        return 0;
    }


}
