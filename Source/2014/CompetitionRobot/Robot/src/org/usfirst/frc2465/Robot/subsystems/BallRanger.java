// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2465.Robot.subsystems;

import org.usfirst.frc2465.Robot.RobotMap;
import org.usfirst.frc2465.Robot.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BallRanger extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    ProximitySensor sensor = RobotMap.ballRangerSensor;
    ProximitySensor ballPresentSensor = RobotMap.ballPresentSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    final static double mm_to_inches = 1.0/254.0;
    
    public double getDistanceInches() {
        return sensor.getDistanceMM() * mm_to_inches;
    }
    
    public boolean isBallPresent() {
        // TODO:  Determine if ball is present
        // based upon the value returned from
        // the "ball present" proximity sensor.
        return false;
    }
}

