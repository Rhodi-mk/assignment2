package sample;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pilot {
    private Controls cockpit;

    public Pilot(Controls cockpit){
        this.cockpit = cockpit;
    }

    private String[ ] commands = {
            Controls.TAKE_OFF,
            Controls.LAND,
            Controls.REACH_ALTITUDE,
            WingControls.MOVE_UP,
            WingControls.MOVE_DOWN,
            WingControls.KEEP_FLAT,
            EngineControls.SLOW_DOWN,
            EngineControls.SPEED_UP,
            Controls.EXIT
    };

    public void fly(){
        do{
            String command = (String)JOptionPane.showInputDialog(null, "Give command", "Command Controls", JOptionPane.INFORMATION_MESSAGE, null, this.commands, this.commands[0]);
            cockpit.execute(command);
        }while(true);
    }
}
