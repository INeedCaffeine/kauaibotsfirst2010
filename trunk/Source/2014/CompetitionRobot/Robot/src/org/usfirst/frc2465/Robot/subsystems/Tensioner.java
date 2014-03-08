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
 * The Tensioner class manages the robot mechanism
 * which controls the tension of a kicking system
 * comprised of bands which store energy in order to
 * "kick" the game ball.  The tensioner has a close
 * relationship and must work in concert with the
 * Leg subystem.
 * 
 * The Tensioner has three logical states:
 * 
 * - High Tension (ready to kick)
 * - Low Tension (ready to "putt")
 * - Slack Tension
 * 
 * A tensioning bar is controlled by a motor, and
 * limit switches are used to define the limits
 * of motion.
 * 
 * An Potentiometer sensor measures the position of
 * the tension bar, from which the current tension
 * level is derived.
 * 
 * In order to maintain high tension, a locking
 * mechanism is provided, controlled by a relay.
 * This lock must be enabled in order to maintain
 * a high tension level.
 */

public class Tensioner extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftSC = RobotMap.tensionerLeftSC;  // Positive == Detension; Negative == Tensioning
    DigitalInput leftMin = RobotMap.tensionerLeftMin; // true == Low Tension
    DigitalInput leftMax = RobotMap.tensionerLeftMax; // true == High Tension
    AnalogChannel sensor = RobotMap.tensionerSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    static double TENSIONER_MIN_MOTOR_SPEED = -1;
    static double TENSIONER_MAX_MOTOR_SPEED = 1;    
    
    public static final int kTensionSlack           = 0;
    public static final int kTensionMin             = 1;
    public static final int kTensionMax             = 2;
    public static final int kTensionIntermediate    = 3;
    
    double min_tension_volts = RobotPreferences.getTensionerMinVolts();
    double slack_tension_volts = RobotPreferences.getTensionerSlackVolts();
    double max_tension_volts = RobotPreferences.getTensionerMaxVolts();
    double threshold_volts = RobotPreferences.getTensionerOnTargetToleranceVolts();
    
    public Tensioner() {
        
        super(  "Tensioner",
                RobotPreferences.getTensionerP(),
                RobotPreferences.getTensionerI(),
                RobotPreferences.getTensionerD());
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(   
                RobotPreferences.getTensionerMinVolts(), 
                RobotPreferences.getTensionerMaxVolts());
        getPIDController().setOutputRange(
                TENSIONER_MIN_MOTOR_SPEED, 
                TENSIONER_MAX_MOTOR_SPEED);
        getPIDController().setAbsoluteTolerance(threshold_volts);
        setSetpoint(
                RobotPreferences.getTensionerDefaultVolts());
        
        // TODO:  Enable this once the PID Controllers are 
        // tuned.
        
        //enable();
        
    }

    public boolean isDetensioned() {
        double curr_volts = sensor.getAverageVoltage();
        return ( ( curr_volts > (slack_tension_volts - threshold_volts ) ) &&
                 ( curr_volts < (slack_tension_volts + threshold_volts ) ) );
    }
    
    public double getTensionLevel() {
        return sensor.getAverageVoltage();
    }
    
    public boolean isEnabled() {
        return this.getPIDController().isEnable();
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // Returns current tension level in volts
    
    protected double returnPIDInput() {
        return sensor.getAverageVoltage();
    }

    // Controls output of both left and right motors
    // NOTE:  Only one motor may actually be used;
    // in this case, the right speed controller will
    // not be used.
    
    protected void usePIDOutput(double output) {
        
        output = -output;
        
        //
        // Only allow the arms to move in a direction away from a limit switch 
        // if that limit switch is closed, unless the motor command is 0.0 
        // (so the motor controller can be disabled)
        //

        if ((output > 0.0 && !leftMin.get()) || (output < 0.0 && !leftMax.get()) || (output == 0.0))
            this.leftSC.set(output);
        else
            this.leftSC.set(0);
     }

}

