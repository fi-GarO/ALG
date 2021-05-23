package cmd;

import java.util.Scanner;

/**
 *
 * @author Jiri.Turyna
 */
public class CmdUI {
    public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CmdInterface cmd = new CmdEditor();
        
        String line;
        while(cmd.isRunning()){
            System.out.print(cmd.getActualDir() + "$ ");
            line = sc.nextLine();
            try{
                System.out.println(cmd.parseAndExecute(line));
            } catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
