package cmd;

import java.io.File;

/**
 *
 * @author Jiri.Turyna
 */
public class Exit extends Command {
    @Override
    public String execute(File actualDir) {
        System.exit(0);   
        return null;
    }
}
