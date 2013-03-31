// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


#include "AutoDrive.h"
#include "../Robotmap.h"
#include "../Robot.h"
#include "Timer.h"

AutoDrive::AutoDrive(double xaxis, double yaxis, double twistvalue) {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	Requires(Robot::swerveDriveSystem);
	x=xaxis;
	y=yaxis;
	twist=twistvalue;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
}

// Called just before this Command runs the first time
void AutoDrive::Initialize() {
	Robot::swerveDriveSystem->EnablePIDControl(true);
	Robot::swerveDriveSystem->EnableFieldOrientedDrive(true);
}

// Called repeatedly when this Command is scheduled to run
void AutoDrive::Execute() {
	Robot::swerveDriveSystem->DoSwerve(x,y,twist);
}

// Make this return true when this Command no longer needs to run execute()
bool AutoDrive::IsFinished() {
	return IsTimedOut();
}

// Called once after isFinished returns true
void AutoDrive::End() {
	Robot::swerveDriveSystem->DoSwerve(0.0,0.0,0.0);
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void AutoDrive::Interrupted() {

}
