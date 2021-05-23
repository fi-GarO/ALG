/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author Jiri.Turyna
 */
public class Mkdir extends Command {

    @Override
    public String execute(File actualDir) {
        File file = null;
        if (params.length == 1) {
            System.out.println("Missing operand");
        }
        if (params.length == 2) {
            try {
                file = new File(file.getAbsolutePath() + "\\" + params[1]);
                file.mkdir();
                return "Folder created";
            } catch (Exception e) {
                return "Folder already exists";
            }

        } else {
            return "Unknown command";
        }
    }

}
