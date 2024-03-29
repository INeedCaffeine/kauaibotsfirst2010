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

import org.usfirst.frc2465.GizmoBot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton grabButton1;
    public JoystickButton grabButton2;
    public JoystickButton liftButton1;
    public JoystickButton liftButton2;
    public JoystickButton tilterButton;
    public JoystickButton stepLiftButton;
    public Joystick opJoystick;
    public Joystick driver;    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        opJoystick = new Joystick(0);
        driver = new Joystick(1);
        
        
        stepLiftButton = new JoystickButton(opJoystick, 1);
        stepLiftButton.whileHeld(new RaiseStepLift());
        tilterButton = new JoystickButton(opJoystick, 4);
        tilterButton.whileHeld(new TiltBack());
        liftButton2 = new JoystickButton(opJoystick, 6);
        liftButton2.whileHeld(new RaiseLift2());
        liftButton1 = new JoystickButton(opJoystick, 2);
        liftButton1.whileHeld(new RaiseLift1());
        grabButton2 = new JoystickButton(opJoystick, 5);
        grabButton2.whileHeld(new CloseGrab2());
        grabButton1 = new JoystickButton(opJoystick, 3);
        grabButton1.whileHeld(new CloseGrab1());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand(-90));

        SmartDashboard.putData("CloseGrab1", new CloseGrab1());

        SmartDashboard.putData("CloseGrab2", new CloseGrab2());

        SmartDashboard.putData("RaiseLift1", new RaiseLift1());

        SmartDashboard.putData("RaiseLift2", new RaiseLift2());

        SmartDashboard.putData("OpenGrab1", new OpenGrab1());

        SmartDashboard.putData("OpenGrab2", new OpenGrab2());

        SmartDashboard.putData("LowerLift1", new LowerLift1());

        SmartDashboard.putData("LowerLift2", new LowerLift2());

        SmartDashboard.putData("TiltBack", new TiltBack());

        SmartDashboard.putData("RaiseStepLift", new RaiseStepLift());

        SmartDashboard.putData("SteerTopCam", new SteerTopCam());

        SmartDashboard.putData("TiltForward", new TiltForward());

        SmartDashboard.putData("LowerStepLift", new LowerStepLift());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getOpJoystick() {
        return opJoystick;
    }
    public Joystick getdriver() {
        return driver;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

