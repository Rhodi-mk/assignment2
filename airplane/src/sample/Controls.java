package sample;

import java.util.Iterator;
import java.util.List;

public class Controls implements CommandController{
    private List<CommandController> commandControls;

    public Controls(List<CommandController> commandControls){
        commandControls.add(this);
        this.commandControls = commandControls;
    }

    public static final String TAKE_OFF = "TAKE_OFF";
    public static final String LAND = "LAND";
    public static final String REACH_ALTITUDE = "REACH_ALTITUDE";
    public static final String EXIT = "EXIT";

    @Override
    public void execute(String command) {
        Iterator<CommandController> commandIterator = this.commandControls.iterator();
        while(commandIterator.hasNext()){
            CommandController commandController = commandIterator.next();
            if(commandController instanceof Controls){
                switch (command) {
                    case Controls.TAKE_OFF:
                        this.takeOff();
                        break;
                    case Controls.LAND:
                        this.land();
                        break;
                    case Controls.REACH_ALTITUDE:
                        this.reachAltitudeAndFly();
                        break;
                    case Controls.EXIT:
                        System.exit(1);
                }
            }else if(commandController.canHandle(command)){
                commandController.execute(command);
            }
        }
    }


    public void takeOff(){
        System.out.println("Fligh Take Off operations---------");
        this.execute(EngineControls.SPEED_UP);
        this.execute(WingControls.MOVE_UP);
        System.out.println("---------");
    }

    public void reachAltitudeAndFly(){
        System.out.println("Flying at an altitue---------");
        this.execute(EngineControls.SPEED_UP);
        this.execute(WingControls.KEEP_FLAT);
        System.out.println("---------");
    }

    public void land(){
        System.out.println("Landing the Flight----------");
        this.execute(EngineControls.SLOW_DOWN);
        this.execute(WingControls.MOVE_DOWN);
        System.out.println("---------");
    }


    @Override
    public boolean canHandle(String command) {
        if(TAKE_OFF.equals(command)||LAND.equals(command)||
                REACH_ALTITUDE.equals(command)||EXIT.equals(command)){
            return true;
        }
        return false;
    }


}

