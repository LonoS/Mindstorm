/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krennKronlachner.mindstorm.main;

import ch.aplu.ev3.SensorPort;

/**
 *
 * @author Kroni
 */
public class variablesClass {
    
    public static boolean driveForward = true;
    public static boolean driveLeft = false;
    public static boolean driveRight = false;
    public static boolean stop = false;
    public static boolean driveBackwards = false; 
    
    public final static SensorPort ULTRAPORT = SensorPort.S4;
}
