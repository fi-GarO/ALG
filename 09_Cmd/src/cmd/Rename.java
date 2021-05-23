package cmd;

import java.io.File;

/**
 *
 * @author Jiri.Turyna
 */
public class Rename extends Command {

    @Override
    public String execute(File actualDir) {
        File file;
        if (params.length != 3) {
            return "Unknown command";
        } else {
            File f1 = new File(actualDir.getAbsolutePath() + "\\" + params[1]);
            File f2 = new File(actualDir.getAbsolutePath() + "\\" + params[2]);
            f1.renameTo(f2);
            return "Rename completed";
        }
    }

}