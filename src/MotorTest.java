import ch.aplu.ev3.TouchSensor;
import ch.aplu.ev3.UltrasonicSensor;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
    import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.AnalogPort;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Stefan Lehner
*/
public class MotorTest 
{   
     
    public static void main(String[] args){
       
        driveForwardWhileFree();
    }
    
    
    
    public static void driveForwardWhileFree(){
//        EV3TouchSensor sensor = new EV3TouchSensor(SensorPort.S1);
//        SampleProvider touchSamples = sensor.getTouchMode();
//        float[] touching = { 0.0f }; 
//        touchSamples.fetchSample(touching, 0);
//        LCD.drawString("Touch: " + touchSamples.toString(), 0, 0);   
        
        
        
        
        
        
      Brick brick = BrickFinder.getDefault();
      // get a port instance
      Port port = LocalEV3.get().getPort("S1");
      SensorModes sensor = new EV3TouchSensor(port);
      // get an instance of this sensor in measurement mode
      SampleProvider touch= sensor.getMode("Touch");
      // initialize an array of floats for fetching samples. 
      // Ask the SampleProvider how long the array should be
      //int size = touch.sampleSize();
      float[] sample = new float[touch.sampleSize()];
      // fetch a sample
      touch.fetchSample(sample, 0);
      LCD.drawString(String.valueOf(sample[0]),0,4);
      
      while(true){
          driveForward();
          LCD.drawString(String.valueOf(sample[0]),0,4);

          if(sample[0] == 1.0){
              break;
          }
          touch.fetchSample(sample, 0);
      }
      
      
    }
    
    
    
    public static void driveForward(){
        
        
        Motor.A.forward();
        Motor.D.forward();
        
    }
    
    public static void driveRight(){
        Motor.A.forward();
        Motor.D.backward();
    }
    
    public static void driveLeft(){
        Motor.A.backward();
        Motor.D.forward();
    }
    
    public void driveBackwards(){
        Motor.A.backward();
        Motor.D.backward();
    }
    
    public static void stop(){
        Motor.A.stop();
        Motor.D.stop();
    }
    
   
}

