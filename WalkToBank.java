package herbcleaner;

import org.dreambot.api.methods.container.impl.bank.BankLocation;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.script.TaskNode;

public class WalkToBank extends TaskNode {
    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean accept() {
       if(!isInBank()) {
           log("Validate Walk to Bank");
           return true;
       }
       return false;
    }

    @Override
    public int execute() {
        log("Walking to bank");
        Area bankArea = getBank().getClosestBankLocation().getArea(5);
        getWalking().walk(bankArea.getCenter());
        return 0;
    }
    private boolean isInBank() {
        for(BankLocation bank : BankLocation.values()) {
            Area area = bank.getArea(7);
            if(area.contains(getLocalPlayer())) {
                return true;
            }
        }
        return false;
    }
}
