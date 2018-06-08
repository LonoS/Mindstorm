/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krennKronlachner.mindstorm.main;


//import ch.aplu.ev3.SensorPort;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 *
 * @author Paul 
 */
public class collisionThread implements Runnable{
    
    @Override
    public void run() {
       EV3UltrasonicSensor sensor = new EV3UltrasonicSensor(SensorPort.S3);
       
        SampleProvider distanceProvider = sensor.getMode("Distance");
        
        while(true){
            
            float[] test = new float[distanceProvider.sampleSize()];
            distanceProvider.fetchSample(test, 0);
            Float dist = test[0]*100;
            LCD.drawString("Distanz=  " + (dist), 0, 0);
            
            if(dist < 7){
                variablesClass.driveForward = false;
                variablesClass.stop = true;
            }
            else{
                variablesClass.driveForward = true;
                variablesClass.stop = false;
            }
            
            
            Delay.msDelay(500);
        }
       
       
    }
    
}
