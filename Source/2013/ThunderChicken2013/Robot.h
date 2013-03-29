// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


#ifndef _ROBOT_H
#define _ROBOT_H

#include "WPILib.h"
#include "Commands/Command.h"
#include "RobotMap.h"
#include "LiveWindow/LiveWindow.h"

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INCLUDES
#include "Commands/AutonomousCommand.h"
#include "Subsystems/Camera.h"
#include "Subsystems/Climber.h"
#include "Subsystems/Magazine.h"
#include "Subsystems/Pneumatics.h"
#include "Subsystems/Shooter.h"
#include "Subsystems/SwerveDriveSystem.h"
#include "Subsystems/Tilter.h"
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=INCLUDES
#include "OI.h"
#include "Commands/FODEnableDisable.h"
#include "Commands/AutoDrive.h"
#include "Commands/AutoFire.h"
#include "Commands/AutoTilt.h"
#include "Commands/ZeroYaw.h"
#include "Commands/SimpleDrive.h"
#include "Commands/SwerveDrive.h"
#include "Commands/RunCameraGimbal.h"
#include "Commands/DeployChute.h"
#include "Commands/DisableShooterDriveControl.h"
#include "Commands/EnableShooterDriveControl.h"
#include "Commands/FireFrisbee.h"
#include "Commands/LowerAllHooks.h"
#include "Commands/LowerRearClimberHook.h"
#include "Commands/LowerFrontClimberHook.h"
#include "Commands/RaiseFrontCLimberHook.h"
#include "Commands/RaiseRearClimberHook.h"
#include "Commands/SetShooterRPM.h"
#include "Commands/SetShooterTiltAngleDegrees.h"
#include "Commands/FireAtWill.h"
#include "Commands/AutoRev.h"

class Robot : public IterativeRobot {
public:
	Command *autonomousCommand;
	static OI *oi;
	LiveWindow *lw;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	static Camera* camera;
	static Shooter* shooter;
	static Magazine* magazine;
	static Pneumatics* pneumatics;
	static Tilter* tilter;
	static Climber* climber;
	static SwerveDriveSystem* swerveDriveSystem;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	virtual void RobotInit();
	virtual void AutonomousInit();
	virtual void AutonomousPeriodic();
	virtual void TeleopInit();
	virtual void TeleopPeriodic();
	virtual void TestPeriodic();
};
#endif
