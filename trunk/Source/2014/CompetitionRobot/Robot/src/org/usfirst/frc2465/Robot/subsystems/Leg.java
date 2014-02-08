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
* The Leg class manages the robot mechanisms
* which control the kicking "leg" component of the 
* robot.
* 
* The Leg mechanism has a motor which retracts the leg,
* and a latch which holds the leg in place, ready to
* kick.
* 
* The Leg mechanism also contains a "trigger" mechanism,
* which when activated will release the latch, causing
* the leg to fire.
* 
* State Machine Description:
* 
* 1) The trigger must first be made ready, but running
* the trigger motor relay (in either the forward or reverse
* direction) until the "trigger ready" input switch is 
* "true".
* 
* 2) Then, the leg must be pulled back, until both the
* latched input switch is "true" and the "ready" input
* switch is "true".  The motor pulling the leg back should
* be operated at a high speed.
* 
* Note that during the process of retracting the leg, the
* tensioner should not be operated, as a tightening
* of the tensioner when the leg is not latched will 
* prohibit the leg from being latched, due to opposing
* forces.
*/
public class Leg extends Subsystem implements Runnable {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput latched = RobotMap.legLatched;
    DigitalInput ready = RobotMap.legReady;
    DigitalInput triggerReady = RobotMap.triggerReady;
    SpeedController SC = RobotMap.legSC;
    Relay trigger = RobotMap.legTriggerMotorRelay;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    int state;
    Thread thread;
    
    public static final int kStateReleased          = 0; 
    public static final int kStateMovingToLatched   = 1; 
    public static final int kStateMovingToReady     = 2;
    public static final int kStateReady             = 3;
    
    public void Leg() {
        
        SC.set(0);
        trigger.setDirection(Relay.Direction.kForward);
        trigger.set(Relay.Value.kOff);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        thread = new Thread(this);
        //thread.start();
    }
    
    public int getState() {
        return current_state;
    }
    
    // Users can either request kStateReady or kStateReleased
    
    public boolean requestState( int new_state ) {
        
        if ( ( new_state == kStateReady ) || ( new_state == kStateReleased ) )
        {
            requested_state = new_state;
            return true;
        }
        
        return false;
    }

    int requested_state = kStateReady;
    int current_state = kStateReady;
    double latched_motor_speed = RobotPreferences.getLegLatchedMotorSpeed();
    double update_period_seconds = RobotPreferences.getLegUpdatePeriodSeconds();
    
    public void run() {
        
        boolean is_trigger_ready = triggerReady.get();
        boolean is_latched = latched.get();
        boolean is_ready = ready.get();
        
        switch ( requested_state ) {

            case kStateReady:
            
               if ( !is_trigger_ready ) {
                   trigger.set(Relay.Value.kForward);
               }
               else {
                   if ( is_latched ) {
                        if ( !is_ready ) {
                            current_state = kStateMovingToReady;
                            SC.set(latched_motor_speed);
                        }
                        else {
                            current_state = kStateReady;
                            SC.set(0);
                        }
                    }
                    else {
                        current_state = kStateMovingToLatched;
                        SC.set(latched_motor_speed);
                    }   
                }
            
            break;

            case kStateReleased:
            
                if ( is_latched && is_ready ) {
                    trigger.set(Relay.Value.kForward);
                }
                else {
                    trigger.set(Relay.Value.kOff);
                }
            
            break;

            default:
                break;

        }

       Timer.delay(update_period_seconds);
    }    
}

