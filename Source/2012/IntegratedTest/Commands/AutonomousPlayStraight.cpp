#include "AutonomousPlayStraight.h"
#include "DriveDistance.h"
#include "ShootNow.h"
#include "WaitTime.h"
#include "CameraUp.h"

AutonomousPlayStraight::AutonomousPlayStraight() {
        // Add Commands here:
        // e.g. AddSequential(new Command1());
        //      AddSequential(new Command2());
        // these will run in order.
		AddParallel(new CameraUp(true));
		AddParallel(new ShootNow(true,7.0,false));
		AddSequential(new DriveDistance(false,70,90,false));
		AddSequential(new ShootNow(true,8.0,true));
		AddSequential(new CameraUp(false));
		//AddSequential(new WaitTime(1.0));
        // To run multiple commands at the same time,
        // use AddParallel()
        // e.g. AddParallel(new Command1());
        //      AddSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
}
