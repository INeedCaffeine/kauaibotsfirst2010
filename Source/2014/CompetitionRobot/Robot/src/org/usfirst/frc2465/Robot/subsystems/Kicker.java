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
import org.usfirst.frc2465.Robot.RobotPreferences;


/**
* The Kicker class manages the robot mechanisms
 which control the kicking "leg" component of the 
 robot.
* 
* The Kicker mechanism has a motor which retracts the leg,
 and a latch which holds the leg in place, ready to
 kick.
 
 The Kicker mechanism also contains a "trigger" mechanism,
 which when activated will release the latch, causing
 the leg to fire.
 
 State Machine Description:
 
 1) The trigger must first be made ready, but running
 the trigger motor relay (in either the forward or reverse
 direction) until the "trigger ready" input switch is 
 "true".
 
 2) Then, the leg must be pulled back, until both the
 latched input switch is "true" and the "ready" input
 switch is "true".  The motor pulling the leg back should
 be operated at a high speed.
 
 Note that during the process of retracting the leg, the
 tensioner should not be operated, as a tightening
 of the tensioner when the leg is not latched will 
 prohibit the leg from being latched, due to opposing
 forces.
*/
public class Kicker extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput latched = RobotMap.legLatched;
    DigitalInput ready = RobotMap.legReady;
    DigitalInput triggerReady = RobotMap.triggerReady;
    SpeedController SC = RobotMap.legSC;
    Relay trigger = RobotMap.legTriggerMotorRelay;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    ProximitySensor ball_present_proximity = RobotMap.ballPresentSensor;

    public void Leg() {
        
        SC.set(0);
        trigger.setDirection(Relay.Direction.kBoth);
        trigger.set(Relay.Value.kOff);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        // TODO:  Start the Kicker state machine
        // thread once correct mechanism behavior
        // is verified.
        
        //thread.start();
    }
    
    public void startTriggerMotor() {
        trigger.set(Relay.Value.kReverse);
    }
    
    public void stopTriggerMotor() {
        trigger.set(Relay.Value.kOff);
    }

    public void startLegRetractor() {
        SC.set(RobotPreferences.getLegMotorSpeed());
    }
    
    public void stopLegRetractor() {
        SC.set(0);
    }
    
    public boolean isTriggerReady() {
        return triggerReady.get();
    }
    
    public boolean isLegLatchedAndRetractorReady() {
        return (this.latched.get() && this.ready.get());
    }
    
    public boolean isBallPresent ()
    {
        double distance = ball_present_proximity.getDistanceMM ();
        boolean present;

        //
        // Determine if the ball is within the empirically-determined range 
        //

        if ((distance >= ball_present_proximity_min) && (distance <= ball_present_proximity_max))
        {
            present = true;
        }
        else
        {
            present = false;
        }

        return present;
    }
    
    double ball_present_proximity_min = RobotPreferences.ballPresentProximityMin();
    double ball_present_proximity_max = RobotPreferences.ballPresentProximityMax();
    
}

