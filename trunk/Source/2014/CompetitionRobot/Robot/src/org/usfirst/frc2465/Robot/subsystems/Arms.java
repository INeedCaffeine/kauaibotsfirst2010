
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

/*****************************************************************/
/* IMPORTANT:  Positive Motor voltage -> lower position (volts)  */
/*             Negative Motor voltage -> higher position (volts) */
/*****************************************************************/
/**
 *
 */
public class Arms extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SpeedController sC = RobotMap.armsSC;
    public SpeedController rotationSC = RobotMap.armsRotationSC;
    DigitalInput min = RobotMap.armsMin;
    DigitalInput max = RobotMap.armsMax;
    AnalogChannel sensor = RobotMap.armsSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Positions
    
    public static final int kPositionDown          = 0; 
    public static final int kPositionTeeUp         = 1; 
    public static final int kPositionHandoff       = 2;
    public static final int kPositionUp            = 3;
    public static final int kPositionIndeterminate = 4;    
    
    // Speeds
    
    public static final int kSpeedGrab      = 0;
    public static final int kSpeedLift      = 1;
    public static final int kSpeedRetract   = 2;
    public static final int kSpeedHandoff   = 3;
    
    // Voltage Settings
    
    double max_volt                 = RobotPreferences.getArmsMaxSensorVolts();
    double min_volt                 = RobotPreferences.getArmsMinSensorVolts();
    public double tolerance_volts   = RobotPreferences.getArmsOnTargetToleranceVolts();
    double down_volts               = RobotPreferences.getArmsVoltsDown();
    double teeup_volts              = RobotPreferences.getArmsVoltsTeeup();
    double handoff_volts            = RobotPreferences.getArmsVoltsHandoff();
    double up_volts                 = RobotPreferences.getArmsVoltsUp();

    double arms_jog_amount = RobotPreferences.getArmsJogAmount();
    
    public Arms() {
        
        super(  "Arms",
                RobotPreferences.getArmsPDown(),
                RobotPreferences.getArmsIDown(),
                RobotPreferences.getArmsDDown());
        
        // Configure the PID Controller
        
        getPIDController().setContinuous(false);
        getPIDController().setInputRange(min_volt, max_volt);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setAbsoluteTolerance(tolerance_volts);
        setSetpoint(RobotPreferences.getArmsDefaultVolts());
        
        // Start the PID Controller
        
        // NOTE:  The PID Controller for the arms should *always*
        // be enabled.
        
        disable();
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean isAtMin() {
        return min.get();
    }
    
    public boolean isAtMax() {
        return max.get();
    }
    
    public void startArmsDown() {
        this.sC.set(.5);
    }
    
    public void stop() {
        disable();
    }
    
    public void setPositionAndSpeed( int position, int speed ) {
        disable();
        setSpeed(speed);
        goToPosition(position);
        enable();
    }
    
    protected void goToPosition( int position ) {
        switch ( position ) {
            case kPositionDown:
                setSetpoint(down_volts);
                break;
            case kPositionTeeUp:
                setSetpoint(teeup_volts);
                break;
            case kPositionHandoff:
                setSetpoint(handoff_volts);
                break;
            case kPositionUp:
                setSetpoint(up_volts);
                break;
            default:
                System.out.println("Arms.goToPosition() - invalid position:  " + position);
        }
    }
    
    public void setSpeed( int speed ) {
        switch ( speed ) {
            case kSpeedGrab:
                this.getPIDController().setPID(
                        RobotPreferences.getArmsPDown(),
                        RobotPreferences.getArmsIDown(),
                        RobotPreferences.getArmsDDown());
                break;
            case kSpeedLift:
                this.getPIDController().setPID(
                        RobotPreferences.getArmsPLift(),
                        RobotPreferences.getArmsILift(),
                        RobotPreferences.getArmsDLift());
                break;
            case kSpeedRetract:
                break;
            case kSpeedHandoff:
                break;
             default:
                System.out.println("Arms.setSpeed() - invalid speed:  " + speed);
       }
    }
    
    /* Indicates current arm angle, 
    *  this method invoked by the 
    *  PID Controller.
    */
    
    protected double returnPIDInput() {
        double avg_voltage = sensor.getAverageVoltage();
        if ( avg_voltage < 2.3 ) {
            this.rotationSC.set(-.7);
        } else {
            this.rotationSC.set(0);
        }
        return avg_voltage;
    }

    /* Controls the arm motor, driven
    *  by the PID controller.
    */
    
    protected void usePIDOutput(double output) {
        
        //
        // Important:  invert the motor polarity!
        //             (Positive Motor Voltage -> Lower Position)
        //
        
        //
        // Only allow the arms to move in a direction away from a limit switch 
        // if that limit switch is closed, unless the motor command is 0.0 
        // (so the motor controller can be disabled)
        //

        if ((output > 0.0 && !max.get()) || (output < 0.0 && !min.get()) || (output == 0.0))
            this.sC.set(-output);
        else
            this.sC.set(0);

    }

    /* 
    *  Determines current Arm Position, relative to 
    *  predefined locations along the arm's travel,
    *  and based upon input from the arm's angle
    *  sensor.
    */
    
    public int getArmsPosition() {
        double set_point = getPIDController().getSetpoint();
        boolean on_target = getPIDController().onTarget();
        int state;
        if ( !on_target ) {
            state = kPositionIndeterminate;
        }
        else {
            if ( ( set_point > (down_volts - tolerance_volts ) ) &&
                 ( set_point < (down_volts + tolerance_volts ) ) ) {
                state = kPositionDown;
            }
            else if ( ( set_point > (teeup_volts - tolerance_volts ) ) &&
                 ( set_point < (teeup_volts + tolerance_volts ) ) ) {
                state = kPositionTeeUp;
            }
            else if ( ( set_point > (handoff_volts - tolerance_volts ) ) &&
                 ( set_point < (handoff_volts + tolerance_volts ) ) ) {
                state = kPositionHandoff;
            }
            else if ( ( set_point > (up_volts - tolerance_volts ) ) &&
                 ( set_point < (up_volts + tolerance_volts ) ) ) {
                state = kPositionUp;
            }
            else {
                state = kPositionIndeterminate;
            }
        }
        return state;
    }
    
    //
    // These routines will move the arms just a bit, and are primarily for diagnostic and development
    // purposes
    //
    
    public void jogArmsUp()
    {
        setSetpointRelative (arms_jog_amount);
    }
    
    public void jogArmsDown()
    {
        setSetpointRelative (-arms_jog_amount);
    }
    
}