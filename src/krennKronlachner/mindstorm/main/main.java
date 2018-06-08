/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krennKronlachner.mindstorm.main;

import lejos.hardware.Button;

/**
 *
 * @author Kroni
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ALL TO FALSE
        variablesClass.driveBackwards = false;
        variablesClass.driveForward = false;
        variablesClass.driveLeft = false;
        variablesClass.driveRight = false; 
        variablesClass.stop = false;
                
        
        
        
        Thread driving = new Thread(new DrivingThread());
        driving.start();
        
        variablesClass.driveForward = true;
        
        if(Button.ESCAPE.isDown()){
            variablesClass.driveForward = false;
            variablesClass.stop = true; 
        }
    }
    
}
