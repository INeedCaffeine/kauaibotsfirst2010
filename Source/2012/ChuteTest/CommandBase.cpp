#include "CommandBase.h"
#include "Subsystems/ExampleSubsystem.h"
#include "Commands/Scheduler.h"
#include "Subsystems/ChuteSubsystem.h"

CommandBase::CommandBase(const char *name) : Command(name) {
}

CommandBase::CommandBase() : Command() {
}

// Initialize a single static instance of all of your subsystems to NULL
ExampleSubsystem* CommandBase::examplesubsystem = NULL;
ChuteSubsystem* CommandBase::chute = NULL;
OI* CommandBase::oi = NULL;

void CommandBase::init() {
    // Create a single static instance of all of your subsystems. The following
	// line should be repeated for each subsystem in the project.
	examplesubsystem = new ExampleSubsystem();
	chute = new ChuteSubsystem();
	
	oi = new OI();
}
