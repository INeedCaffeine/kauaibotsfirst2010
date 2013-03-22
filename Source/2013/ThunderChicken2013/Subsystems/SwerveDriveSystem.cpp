// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


///////////////////////////////////////////////////////////f
// Robot-specific measurements (in units of inches)
///////////////////////////////////////////////////////////

const float cWidth			= 20.625;				// Distance between left/right wheels
const float cLength			= 23.375;				// Distance btwn front/back wheels
const float wheelDiameter	= 4.0;					// Per AndyMark Specs
const float wheelRadius		= wheelDiameter / 2;

#include "SwerveDriveSystem.h"
#include "../Robotmap.h"
#include "../Robot.h"
#include <math.h>


SwerveDriveSystem::SwerveDriveSystem() : Subsystem("SwerveDriveSystem") {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	left_front_steer_motor = RobotMap::swerveDriveSystemleft_front_steer_motor;
	left_front_angle_sensor = RobotMap::swerveDriveSystemleft_front_angle_sensor;
	left_front_steer = RobotMap::swerveDriveSystemleft_front_steer;
	left_front_rpm_sensor = RobotMap::swerveDriveSystemleft_front_rpm_sensor;
	left_front_drive_motor = RobotMap::swerveDriveSystemleft_front_drive_motor;
	left_front_drive = RobotMap::swerveDriveSystemleft_front_drive;
	right_front_steer_motor = RobotMap::swerveDriveSystemright_front_steer_motor;
	right_front_angle_sensor = RobotMap::swerveDriveSystemright_front_angle_sensor;
	right_front_steer = RobotMap::swerveDriveSystemright_front_steer;
	right_front_rpm_sensor = RobotMap::swerveDriveSystemright_front_rpm_sensor;
	right_front_drive_motor = RobotMap::swerveDriveSystemright_front_drive_motor;
	right_front_drive = RobotMap::swerveDriveSystemright_front_drive;
	left_back_steer_motor = RobotMap::swerveDriveSystemleft_back_steer_motor;
	left_back_angle_sensor = RobotMap::swerveDriveSystemleft_back_angle_sensor;
	left_back_steer = RobotMap::swerveDriveSystemleft_back_steer;
	left_back_rpm_sensor = RobotMap::swerveDriveSystemleft_back_rpm_sensor;
	left_back_drive_motor = RobotMap::swerveDriveSystemleft_back_drive_motor;
	left_back_drive = RobotMap::swerveDriveSystemleft_back_drive;
	right_back_steer_motor = RobotMap::swerveDriveSystemright_back_steer_motor;
	right_back_angle_sensor = RobotMap::swerveDriveSystemright_back_angle_sensor;
	right_back_steer = RobotMap::swerveDriveSystemright_back_steer;
	right_back_drive_motor = RobotMap::swerveDriveSystemright_back_drive_motor;
	right_back_rpm_sensor = RobotMap::swerveDriveSystemright_back_rpm_sensor;
	right_back_drive = RobotMap::swerveDriveSystemright_back_drive;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	imu = RobotMap::imu;	
	fod_enable = true;
	RobotMap::swerveDriveSystemleft_front_steer->SetSetpoint(0.0);
	RobotMap::swerveDriveSystemright_front_steer->SetSetpoint(0.0);
	RobotMap::swerveDriveSystemleft_back_steer->SetSetpoint(0.0);
	RobotMap::swerveDriveSystemright_back_steer->SetSetpoint(0.0);
	invert_left_back_drive = 1.0;
	invert_right_back_drive = 1.0;
	invert_left_front_drive = 1.0;
	invert_right_front_drive = 1.0;
}
    
void SwerveDriveSystem::InitDefaultCommand() {
	SetDefaultCommand(new SwerveDrive() /*SimpleDrive()*/);
	// Set the default command for a subsystem here.
	//SetDefaultCommand(new MySpecialCommand());
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
}

void SwerveDriveSystem::EnableFieldOrientedDrive( bool enable )
{
	fod_enable = enable;
}

bool SwerveDriveSystem::IsFieldOrientedDriveEnabled()
{
	return fod_enable;
}

void SwerveDriveSystem::ZeroFieldOrientedDriveYaw()
{
	imu->ZeroYaw();
}

void SwerveDriveSystem::EnablePIDControl(bool enable)
{
	if ( enable )
	{
		RobotMap::swerveDriveSystemleft_front_steer->Enable();
		RobotMap::swerveDriveSystemright_front_steer->Enable();
		RobotMap::swerveDriveSystemleft_back_steer->Enable();
		RobotMap::swerveDriveSystemright_back_steer->Enable();		
	}
	else // disable
	{
		RobotMap::swerveDriveSystemleft_front_steer->Disable();		
		RobotMap::swerveDriveSystemright_front_steer->Disable();
		RobotMap::swerveDriveSystemleft_back_steer->Disable();
		RobotMap::swerveDriveSystemright_back_steer->Disable();
	}
}


// Put methods for controlling this subsystem
// here. Call these from Commands.

// vX : "strafe" value - range is -1 to 1
// vY:  "fwd" value - range is -1 to 1
// vRot:  "rcw" value - range is -1 to 1

void SwerveDriveSystem::DoSimpleDrive( float vY, float vRot){
	RobotMap::swerveDriveSystemleft_front_steer_motor->Set( vRot );
	RobotMap::swerveDriveSystemright_front_steer_motor->Set( vRot );
	RobotMap::swerveDriveSystemleft_back_steer_motor->Set( vRot );
	RobotMap::swerveDriveSystemright_back_steer_motor->Set( vRot );	
		
	RobotMap::swerveDriveSystemleft_front_drive_motor->Set( vY );
	RobotMap::swerveDriveSystemright_front_drive_motor->Set( vY );
	RobotMap::swerveDriveSystemleft_back_drive_motor->Set( vY );
	RobotMap::swerveDriveSystemright_back_drive_motor->Set( vY );
}

void SwerveDriveSystem::DoSwerve( float vX, float vY, float vRot ){
	float strafe = vX;
	float fwd = vY;
	float rcw = vRot;

	// Length of Hypotenuse of line from robot center to wheel axis center
	float r = sqrt( (cLength * cLength) + (cWidth * cWidth) );  // Todo:  make a constant
	float pi = 3.1415926;
	
	bool imu_connected = imu->IsConnected();
	double imu_angle_degrees = imu->GetYaw();
	SmartDashboard::PutBoolean("IMU_Connected", imu_connected);
	SmartDashboard::PutNumber("IMU_Yaw", imu_angle_degrees);
	
	// Field-oriented drive - Adjust input angle for gyro offset angle
	/*
	float curr_gyro_angle_degrees = 0;
	if ( fod_enable ) 
	{
		curr_gyro_angle_degrees = imu->GetYaw();
	}
	float curr_gyro_angle_radians = curr_gyro_angle_degrees * pi/180;	
	
	float temp = fwd - cos( curr_gyro_angle_radians ) + sin( curr_gyro_angle_radians);
	strafe = -fwd - sin( curr_gyro_angle_radians ) + strafe - cos( curr_gyro_angle_radians );
	fwd = temp;
	*/
	
	// Independently-steered Swerve drive inverse kinematics
	
	// Rcw direction is always perpindicular to R
	// Strafe/fwd direction is tangent of (strafe,fwd)
	// Final direction is tangent of these two directions
	
	float a = strafe - rcw * (cLength / r); // X-:  X (Strafe) Magnitude - rcw Magnitude * rcw DirectionX (L/R)
	float b = strafe + rcw * (cLength / r);	// X+:  X (Strafe) Magnitude + rcw Magnitude * rcw DirectionX (L/R)
	float c = fwd    - rcw * (cWidth  / r); // Y-:  Y (Forward) Magnitude - rcw Magnitude * rcw DirectionY (W/R)
	float d = fwd    + rcw * (cWidth  / r);	// Y+:  Y (Forward) Magnitude + rcw Magnitude * rcw DirectionY (W/R)
			
	float largest_wheel_speed = 0.0;
	
	// The wheels are numbered from wheel 1 (right-front), which is equivalent to cartesian quadrant 4,
	// and increase counter-clockwise.
	// So, the left-front wheel (2) is equivalent to cartesian quadrant 1.

	// This "rotation" appears to be a shortcut
	// that enables conversion from cartesian coordinates (0 degrees = "right") to map coordinates 
	// (0 degrees = "north"); put another way, this is a 90-degree rotation to the left	
	
	float wheel1_speed = sqrt( ( b * b ) + ( c * c ) );
	float wheel1_angle = atan2( b, c ) * 180.0 / pi;  // X+, Y- (Quadrant 4 in cartesian coordinates)
	if ( ( b == 0) && ( c == 0) ) wheel1_angle = 0;
	
	// NOTE:  atan2 expects arguments in order (y, x).  But the parameter order is X (strafe), then Y (Forward).
	// If length and width were identical, this would make no difference.
	// Is it possible this is also required to match the 90-degree rotation to the left
	// mentioned above?
	
	if ( wheel1_speed > largest_wheel_speed ) largest_wheel_speed = wheel1_speed;
	
	float wheel2_speed = sqrt( ( b * b ) + ( d * d ) );
	float wheel2_angle = atan2( b, d ) * 180.0 / pi; // X+, Y+ (Quadrant 1 in cartesian coordinates)
	if ( ( b == 0) && ( d == 0) ) wheel2_angle = 0;

	if ( wheel2_speed > largest_wheel_speed ) largest_wheel_speed = wheel2_speed;
	
	float wheel3_speed = sqrt( ( a * a ) + ( d * d ) );
	float wheel3_angle = atan2( a, d ) * 180.0 / pi; // X-, Y+ (Quadrant2 in cartesian coordaintes)
	if ( ( a == 0) && ( d == 0) ) wheel3_angle = 0;
	
	if ( wheel3_speed > largest_wheel_speed ) largest_wheel_speed = wheel3_speed;
	
	float wheel4_speed = sqrt( ( a * a ) + ( c * c ) );
	float wheel4_angle = atan2( a, c ) * 180.0 / pi; // X- Y- (Quadrant 3 in cartesian coordinates)
	if ( ( a == 0) && ( c == 0) ) wheel4_angle = 0;
	
	if ( wheel4_speed > largest_wheel_speed ) largest_wheel_speed = wheel4_speed;
	
	// Normalize wheel speeds to output motor speed range 
	// [If any wheel speed is > 1, divide all wheel speeds by the largest wheel speed]
	
	if ( largest_wheel_speed > 1.0 )
	{
		wheel1_speed /= largest_wheel_speed;
		wheel2_speed /= largest_wheel_speed;
		wheel3_speed /= largest_wheel_speed;
		wheel4_speed /= largest_wheel_speed;
	}
	
	SmartDashboard::PutNumber("Swerve_Strafe", strafe);
	SmartDashboard::PutNumber("Swerve_Forward", fwd);
	SmartDashboard::PutNumber("Swerve_RCW", rcw);
	
	SmartDashboard::PutNumber("Swerve_A", a);
	SmartDashboard::PutNumber("Swerve_B", b);
	SmartDashboard::PutNumber("Swerve_C", c);
	SmartDashboard::PutNumber("Swerve_D", d);
	
	SmartDashboard::PutNumber("Swerve_Left_Front_Angle", wheel2_angle);
	SmartDashboard::PutNumber("Swerve_Right_Front_Angle", wheel1_angle);
	SmartDashboard::PutNumber("Swerve_Left_Back_Angle", wheel3_angle);
	SmartDashboard::PutNumber("Swerve_Right_Back_Angle", wheel4_angle);
	
	// Update Steering Motors PID Controllers first (note these are likely higher latency)
	
	left_front_steer->SetSetpoint(-wheel2_angle);
	right_front_steer->SetSetpoint(-wheel1_angle);
	left_back_steer->SetSetpoint( -wheel3_angle);
	right_back_steer->SetSetpoint( -wheel4_angle);	
	
	// Update Speed Motor PID Controllers
	
	//left_front_drive->SetSetpoint( wheel2_speed );
	//right_front_drive->SetSetpoint( wheel1_speed );
	//left_back_drive->SetSetpoint( wheel3_speed );
	//right_back_drive->SetSetpoint( wheel4_speed );
	
	RobotMap::swerveDriveSystemleft_front_drive_motor->Set( wheel2_speed * invert_left_front_drive );
	RobotMap::swerveDriveSystemright_front_drive_motor->Set( wheel1_speed * invert_right_front_drive );
	RobotMap::swerveDriveSystemleft_back_drive_motor->Set( wheel3_speed * invert_left_back_drive);
	RobotMap::swerveDriveSystemright_back_drive_motor->Set( wheel4_speed * invert_right_back_drive );

}

