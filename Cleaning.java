package herbcleaner;

import org.dreambot.api.input.Mouse;
import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.TaskNode;

public class Cleaning extends TaskNode {

    private boolean useMouseKeys;


    public Cleaning(boolean useMouseKeys) {
        this.useMouseKeys = useMouseKeys;
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean accept() {
        if(getInventory().contains(HerbCleaner.grimyHerb)) {
            log("Cleaning validate");
            return true;
        }

        return false;
    }

    @Override
    public int execute() {
        if(useMouseKeys) {
            getMouseKeys().tabCheck();
            for (int col = 0; col < 4; col++) {
                if(!getInventory().contains(HerbCleaner.grimyHerb)) {
                    return 0;
                }
                getMouseKeys().initialColumnMouseCheck(col, i -> i.getName().equals(HerbCleaner.grimyHerb));
                getMouse().click();
                getMouse().click();
                sleep(100,150);

                for (int row = 0; row < 6; row++) {
                    getMouseKeys().pushTwo();
                    getMouse().click();
                    sleep(100,150);
                }
            }
            log("Cleaning herbs");
            getInventory().interact(HerbCleaner.grimyHerb, "Clean");
            sleep(300, 350);
        }
        return 0;
    }


}
