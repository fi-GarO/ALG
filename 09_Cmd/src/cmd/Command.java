package cmd;

import java.io.File;

/**
 *
 * @author Jiri.Turyna
 */
public abstract class Command {
    public static String COMMAND_PACKAGE = "cmd";
    
    protected String[] params; // | dir | -e | .java |
    
    public void setParams(String[] params){
        this.params = new String[params.length];
        System.arraycopy(params, 0, this.params, 0, params.length);
    }
    
    public abstract String execute(File actualDir);
        /*switch (params[0]){
            case "dir": dir(); break;
            case "cd" : cd(); break; ...
        }*/
}
