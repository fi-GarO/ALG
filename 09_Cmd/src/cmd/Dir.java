package cmd;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Jiri.Turyna
 */
public class Dir extends Command {

    @Override
    public String execute(File actualDir) {
        File[] files;
        if (params.length == 1) {
            files = actualDir.listFiles();
            return dirToString(files);
        }
        if (params.length == 2) {
            if (params[1] == "-o") {
                files = actualDir.listFiles();
                Arrays.sort(files);
                return dirToString(files);
            } else {
                System.out.println("Unknown command");
            }
        }
        if (params.length == 3 && params[1] == "-e") {
            files = actualDir.listFiles();
            StringBuilder sb = new StringBuilder("");
            for (File f : files) {
                //FileFilter filter = (File f) -> f.getName().endsWith(params[2]); //returns boolean
                //files = actualDir.listFiles(filter);
                //return dirToString(files);

                    if (params[1].contains("-e") && f.getName().endsWith(params[2]) && f.isDirectory()){
                        sb.append("%s%n" + f.getName());
                    } else {
                        sb.append(f.getName() + " " + f.length() + " ");
                        sb.append(f.lastModified());
                    }
            }
            return sb.toString();
            
        } else if (params.length == 3 && params[1] == "-s") {
            int size = Integer.parseInt(params[2]);
            FileFilter filter = (File f) -> f.length() > size;
            files = actualDir.listFiles(filter);
            return dirToString(files);

        } else {
            System.out.println("Unknown command");
        }

        return null;
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(String.format("%s%n", file.getName()));
            } else {
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }

}
