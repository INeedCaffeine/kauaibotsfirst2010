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
import edu.wpi.first.wpilibj.command.PIDSubsystem;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2465.Robot.RobotPreferences;

/**
 *
 */
public class Tensioner extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftSC = RobotMap.tensionerLeftSC;
    DigitalInput leftMin = RobotMap.tensionerLeftMin;
    DigitalInput leftMax = RobotMap.tensionerLeftMax;
    ProximitySensor leftDistance = RobotMap.tensionerLeftDistance;
    SpeedController rightSC = RobotMap.tensionerRightSC;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    static double TENSIONER_MIN_MOTOR_SPEED = -1;
    static double TENSIONER_MAX_MOTOR_SPEED = 1;    
    
    public static final int kStateHighTension     = 0; 
    public static final int kStateLowTension      = 1; 
    public static final int kStateSlackTension    = 2;
    public static final int kStateIndeterminate   = 3;

    double low_tension_distance = RobotPreferences.getTensionerLowDistanceInches();
    double slack_tension_distance = RobotPreferences.getTensionerSlackDistanceInches();
    double high_tension_distance = RobotPreferences.getTensionerHighDistanceInches();
    
    public Tensioner() {
        
        super(  "Tensioner",
                RobotPreferences.getTensionerP(),
                RobotPreferences.getTensionerI(),
                RobotPreferences.getTensionerD());
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(   
                RobotPreferences.getTensionerMinDistanceInches(), 
                RobotPreferences.getTensionerMaxDistanceInches());
        getPIDController().setOutputRange(
                TENSIONER_MIN_MOTOR_SPEED, 
                TENSIONER_MAX_MOTOR_SPEED);
        getPIDController().setAbsoluteTolerance(
                RobotPreferences.getTensionerOnTargetToleranceInches());
        setSetpoint(
                RobotPreferences.getTensionerDefaultDistanceInches());
        enable();
        
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public double getDistanceInches() {
        return leftDistance.getDistanceInches();
    }
    
    // Returns current distance in inches
    
    protected double returnPIDInput() {
        return getDistanceInches();
    }

    // Controls output of both left and right motors
    // NOTE:  Only one motor may actually be used;
    // in this case, the right speed controller will
    // not be used.
    
    protected void usePIDOutput(double d) {
        
        if ( leftMin.get() || leftMax.get() ) {
            d = 0;
        }
        
        leftSC.set(d);
        rightSC.set(d);
    }
    
    public int getState() {
        double distance_inches = getDistanceInches();
        
        double on_target_threshold = RobotPreferences.getTensionerOnTargetToleranceInches();

        if ( ( distance_inches > ( low_tension_distance - on_target_threshold ) ) &&
             ( distance_inches < ( low_tension_distance + on_target_threshold ) ) ) {
            
            return Tensioner.kStateLowTension;
        }
        else if ( ( distance_inches > ( high_tension_distance - on_target_threshold ) ) &&
             ( distance_inches < ( high_tension_distance + on_target_threshold ) ) ) {
            
            return Tensioner.kStateHighTension;
        }
        else if ( ( distance_inches > ( slack_tension_distance - on_target_threshold ) ) &&
             ( distance_inches < ( slack_tension_distance + on_target_threshold ) ) ) {
            
            return Tensioner.kStateSlackTension;
        }
        
        return Tensioner.kStateIndeterminate;
    }
    
}

