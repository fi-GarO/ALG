/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.awt.BorderLayout;
import java.io.File;

/**
 *
 * @author Jiri.Turyna
 */
public class Cd extends Command {

    @Override
    public String execute(File actualDir) {
        File file = null;
        if (params.length == 1 ){
            System.out.println(" ");
        } 
        if (params.length > 2 && params[1] == ".."){
            file = new File(actualDir.getParent());
        } else {
            try {
                file = new File(file.getAbsolutePath() + "\\" + params[1]);
            } catch (Exception e) {
                System.out.println("Folder not found");
            }
        }
        
        return file.toString();
    }   
    
}
