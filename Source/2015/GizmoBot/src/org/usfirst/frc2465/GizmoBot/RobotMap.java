// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2465.GizmoBot;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.AxisCamera;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DoubleSolenoid grab1Valve;
    public static DoubleSolenoid lift1Valve;
    public static DoubleSolenoid grab2Valve;
    public static DoubleSolenoid lift2Valve;
    public static DoubleSolenoid tilterTilterValve;
    public static DoubleSolenoid stepLiftStepLiftValve;
    public static Servo topCamHorizontalServo;
    public static Servo topCamVerticalServo;
    public static AnalogInput toteRangerToteRangeSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static AxisCamera topCam = null;          // the axis camera object (connected to the switch)
    public static AxisCamera armCam = null;          // the axis camera object (connected to the switch)
    
    static final String topcam_host = "10.24.65.99";
    static final String armcam_host = "10.24.65.100";
    
    /*************************************************************
     * lift1:    solenoid forward = v
     *           solenoid reverse = ^
     *        
     * lift2:    solenoid forward = v
     *           solenoid reverse = ^
     *        
     * arm1:     solenoid forward = closed
     *           solenoid reverse = open
     *        
     * arm2:     solenoid forward = closed
     *           solenoid reverse = open
     *        
     * steplift: solenoid forward = TBD
     *           solenoid reverse = TBD
     *        
     * tilter:   solenoid forward = TBD
     *           solenoid reverse = TBD
     *        
     * Solenoid port 4 = cylinder low side
     * Solenoid port 2 = cylinder high side        
     ************************************************************/
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS\
    	try {
    		grab1Valve = new DoubleSolenoid(0, 0, 1);      
    		LiveWindow.addActuator("Grab1", "Grab1Valve", grab1Valve);
    	} catch (Exception ex) {
    		 
    	}
    	
    	try {
    		lift1Valve = new DoubleSolenoid(0, 2, 3);      
    		LiveWindow.addActuator("Lift1", "Lift1Valve", lift1Valve);
    	} catch (Exception ex) {
    		
    	}

    	try {
	        grab2Valve = new DoubleSolenoid(0, 4, 5);      
	        LiveWindow.addActuator("Grab2", "Grab2Valve", grab2Valve);
    	} catch (Exception ex) {
		
    	}
        
    	try {
	        lift2Valve = new DoubleSolenoid(0, 6, 7);      
	        LiveWindow.addActuator("Lift2", "Lift2Valve", lift2Valve);
    	} catch (Exception ex) {
    		
    	}        
        
        try {
	        tilterTilterValve = new DoubleSolenoid(1, 0, 1);      
	        LiveWindow.addActuator("Tilter", "TilterValve", tilterTilterValve);
    	} catch (Exception ex) {
    		
    	}
        
        try {
	        stepLiftStepLiftValve = new DoubleSolenoid(1, 2, 3);      
	        LiveWindow.addActuator("StepLift", "StepLiftValve", stepLiftStepLiftValve);
    	} catch (Exception ex) {
    		
    	}
        
        try {
	        topCamHorizontalServo = new Servo(0);
	        LiveWindow.addActuator("TopCam", "HorizontalServo", topCamHorizontalServo);
    	} catch (Exception ex) {
    		
    	}
        
        try {
	        topCamVerticalServo = new Servo(1);
	        LiveWindow.addActuator("TopCam", "VerticalServo", topCamVerticalServo);
    	} catch (Exception ex) {
    		
    	}
        
        try {
        	toteRangerToteRangeSensor = new AnalogInput(0);
        	LiveWindow.addSensor("ToteRanger", "ToteRangeSensor", toteRangerToteRangeSensor);
    	} catch (Exception ex) {
    		
    	}
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        try
        {
	        topCam = new AxisCamera(topcam_host);
	        topCam.writeResolution(AxisCamera.Resolution.k320x240);
	        topCam.writeMaxFPS(10);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();      	
        }
        
        try
        {
	        armCam = new AxisCamera(armcam_host);
	        armCam.writeResolution(AxisCamera.Resolution.k320x240);
	        armCam.writeMaxFPS(10);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();      	
        }
        
    }
}
