package cmd;

/**
 *
 * @author Jiri.Turyna
 */
public class Parser {
       
    public static Command parse(String line){ //dir  -e .java
            String[] p = line.split(" +"); //p[0] dir; p[1] -e p[2] .java
            if (line.isEmpty()){
                System.out.println(" ");
            }
            char first = Character.toUpperCase(p[0].charAt(0)); //D
            String name =  Command.COMMAND_PACKAGE + "." + first + p[0].substring(1); //cmd.Dir
        try{    
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance();
            command.setParams(p);
            return command;
        } catch (Exception e){
           throw new RuntimeException("Command could not be parsed");
        }
    }
}
