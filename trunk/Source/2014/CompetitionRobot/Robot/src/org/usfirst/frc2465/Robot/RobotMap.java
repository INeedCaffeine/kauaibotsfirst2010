// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2465.Robot;
    
import com.kauailabs.nav6.frc.BufferingSerialPort;
import com.kauailabs.nav6.frc.IMUAdvanced;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.visa.VisaException;
import java.util.Vector;
import org.usfirst.frc2465.Robot.subsystems.ProximitySensor;
import org.usfirst.frc2465.Robot.subsystems.UltrasonicSensor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANJaguar driveLeftFrontSC;
    public static CANJaguar driveLeftRearSC;
    public static CANJaguar driveRightFrontSC;
    public static CANJaguar driveRightRearSC;
    public static RobotDrive driveRobotDrive;
    public static DigitalInput legStop;
    public static Relay legMotor;
    public static ProximitySensor ankleAngleSensor;
    public static DigitalInput ankleAngleMin;
    public static DigitalInput ankleAngleMax;
    public static SpeedController ankleAngleSC;
    public static SpeedController tensionerLeftSC;
    public static DigitalInput tensionerLeftMin;
    public static DigitalInput tensionerLeftMax;
    public static ProximitySensor tensionerLeftDistance;
    public static SpeedController tensionerRightSC;
    public static Relay tensionerLock;
    public static SpeedController armsSC;
    public static DigitalInput armsMin;
    public static DigitalInput armsMax;
    public static AnalogChannel armsSensor;
    public static UltrasonicSensor wallRangerSensor;
    public static ProximitySensor ballRangerSensor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static BufferingSerialPort serialPort;
    public static IMUAdvanced imu;
    public static AxisCamera camera;          // the axis camera object (connected to the switch)

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        try { 
            driveLeftFrontSC = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            driveLeftRearSC = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            driveRightFrontSC = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            driveRightRearSC = new CANJaguar(5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        driveRobotDrive = new RobotDrive(driveLeftFrontSC, driveLeftRearSC,
              driveRightFrontSC, driveRightRearSC);
	
        driveRobotDrive.setSafetyEnabled(true);
        driveRobotDrive.setExpiration(0.1);
        driveRobotDrive.setSensitivity(0.5);
        driveRobotDrive.setMaxOutput(1.0);
        
        
        legStop = new DigitalInput(1, 11);
	LiveWindow.addSensor("Leg", "Stop", legStop);
        
        legMotor = new Relay(1, 1);
	LiveWindow.addActuator("Leg", "Motor", legMotor);
        
        ankleAngleSensor = new ProximitySensor(1, 1,ProximitySensor.kShortRange);
	LiveWindow.addSensor("Ankle", "AngleSensor", ankleAngleSensor);
        
        ankleAngleMin = new DigitalInput(1, 1);
	LiveWindow.addSensor("Ankle", "AngleMin", ankleAngleMin);
        
        ankleAngleMax = new DigitalInput(1, 2);
	LiveWindow.addSensor("Ankle", "AngleMax", ankleAngleMax);
        
        ankleAngleSC = new Talon(1, 7);
	LiveWindow.addActuator("Ankle", "AngleSC", (Talon) ankleAngleSC);
        
        tensionerLeftSC = new Talon(1, 1);
	LiveWindow.addActuator("Tensioner", "LeftSC", (Talon) tensionerLeftSC);
        
        tensionerLeftMin = new DigitalInput(1, 3);
	LiveWindow.addSensor("Tensioner", "LeftMin", tensionerLeftMin);
        
        tensionerLeftMax = new DigitalInput(1, 4);
	LiveWindow.addSensor("Tensioner", "LeftMax", tensionerLeftMax);
        
        tensionerLeftDistance = new ProximitySensor(1, 2, ProximitySensor.kMediumRange);
	LiveWindow.addSensor("Tensioner", "LeftDistance", tensionerLeftDistance);
        
        tensionerRightSC = new Talon(1, 2);
	LiveWindow.addActuator("Tensioner", "RightSC", (Talon) tensionerRightSC);
        
        tensionerLock = new Relay(1, 3);
	LiveWindow.addActuator("Tensioner", "Lock", tensionerLock);
        
        armsSC = new Talon(1, 3);
	LiveWindow.addActuator("Arms", "SC", (Talon) armsSC);
        
        armsMin = new DigitalInput(1, 7);
	LiveWindow.addSensor("Arms", "Min", armsMin);
        
        armsMax = new DigitalInput(1, 8);
	LiveWindow.addSensor("Arms", "Max", armsMax);
        
        armsSensor = new AnalogChannel(1, 4);
	LiveWindow.addSensor("Arms", "Sensor", armsSensor);
        
        wallRangerSensor = new UltrasonicSensor(1, 6);
	LiveWindow.addSensor("WallRanger", "Sensor", wallRangerSensor);
        
        ballRangerSensor = new ProximitySensor(1, 7, ProximitySensor.kLongRange);
	LiveWindow.addSensor("BallRanger", "Sensor", ballRangerSensor);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        try {
            serialPort = new BufferingSerialPort(57600);
            
            // You can add a second parameter to modify the 
            // update rate (in hz) from 4 to 100.  The default is 100.
            // If you need to minimize CPU load, you can set it to a
            // lower value, as shown here, depending upon your needs.
            
            // You can also use the IMUAdvanced class for advanced
            // features.

            byte update_rate_hz = 20;
            imu = new IMUAdvanced(serialPort,update_rate_hz);
        } catch (VisaException ex) {
            ex.printStackTrace();
        }
        if ( imu != null ) {
            LiveWindow.addSensor("IMU", "Gyro", imu);
        }

        //camera = AxisCamera.getInstance();
       
    }
}
