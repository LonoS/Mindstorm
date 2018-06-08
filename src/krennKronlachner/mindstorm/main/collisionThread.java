/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krennKronlachner.mindstorm.main;


import ch.aplu.ev3.SensorPort;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
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
       EV3UltrasonicSensor sensor = new EV3UltrasonicSensor((Port) SensorPort.S4);
       
        SampleProvider distanceProvider = sensor.getMode("Distance");
        
        while(true){
            
            float[] test = new float[distanceProvider.sampleSize()];
            distanceProvider.fetchSample(test, 0);
            
            LCD.drawString("Distanz=  " + (test[0]*100), 0, 0);
            
            Delay.msDelay(500);
        }
       
       
    }
    
}
