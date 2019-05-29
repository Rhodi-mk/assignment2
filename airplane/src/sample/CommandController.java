package sample;

public interface CommandController {
    public void execute(String command);
    public boolean canHandle(String command);
}
