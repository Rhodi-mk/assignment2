package sample;
import java.util.ArrayList;
import java.util.List;

public class Exec {
    public static void main(String[] args) {
        WingControls wingControls = new WingControls();
        EngineControls engineControls = new EngineControls();
        List<CommandController> commandControllers = new ArrayList<CommandController>();
        commandControllers.add(wingControls);
        commandControllers.add(engineControls);
        Controls controls = new Controls(commandControllers);

        Pilot pilot = new Pilot(controls);
        pilot.fly();
    }
}
