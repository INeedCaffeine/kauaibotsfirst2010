// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


#include "FireFrisbee.h"
#include "Timer.h"

FireFrisbee::FireFrisbee() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	Requires(Robot::magazine);
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
}

// Called just before this Command runs the first time
void FireFrisbee::Initialize() {
	
}

// Called repeatedly when this Command is scheduled to run
void FireFrisbee::Execute() {
	Joystick* pstick = Robot::oi->getshooter_joystick();
	bool button = pstick->GetRawButton(1);
	float shooter_speed = RobotMap::shootermotor->Get();
	if((Robot::magazine->CheckFrizbees()==0) && button && (shooter_speed >= .5))
	{
		Robot::magazine->SetLoadState(true);
		Robot::magazine->SetFireState(false);
		Wait(1.0);
		Robot::magazine->SetLoadState(false);
		Robot::magazine->SetFireState(true);
		Wait(1.0);
    }
	else
	{
		Robot::magazine->SetLoadState(false);
		Robot::magazine->SetFireState(true);
	}
}

// Make this return true when this Command no longer needs to run execute()
bool FireFrisbee::IsFinished() {
	return false;
}

// Called once after isFinished returns true
void FireFrisbee::End() {
	
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void FireFrisbee::Interrupted() {

}
