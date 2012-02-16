#ifndef ROBOTMAP_H
#define ROBOTMAP_H

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
 
////////////////////////////////////////////////////////////////////////////////
// CAN Bus Addresses (Drive Subsystem)
////////////////////////////////////////////////////////////////////////////////

#define LEFT_REAR_CAN_ADDRESS 5
#define RIGHT_REAR_CAN_ADDRESS 2
#define RIGHT_FRONT_CAN_ADDRESS 3
#define LEFT_FRONT_CAN_ADDRESS 4

////////////////////////////////////////////////////////////////////////////////
// Analog Breakout Board 1 Sensors
////////////////////////////////////////////////////////////////////////////////

#define DRIVE_YAW_GYRO_CHANNEL 1
#define DRIVE_PITCH_GRYO_CHANNEL 2
#define DRIVE_ROLL_GYRO_CHANNEL 3
#define FRONT_RANGEFINDER_CHANNEL 4
#define RIGHT_RANGEFINDER_CHANNEL 5
#define REAR_RANGEFINDER_CHANNEL 6
#define LEFT_RANGEFINDER_CHANNEL 7

////////////////////////////////////////////////////////////////////////////////
// Analog Breakout Board 2 Sensors
////////////////////////////////////////////////////////////////////////////////

#define DRIVE_ACCELEROMETER_X_CHANNEL 2
#define DRIVE_ACCELEROMETER_Y_CHANNEL 3
#define DRIVE_ACCELEROMETER_Z_CHANNEL 4

////////////////////////////////////////////////////////////////////////////////
// PWM Outputs
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// GPIO
////////////////////////////////////////////////////////////////////////////////

#define DRIVE_FRONT_EDGEFINDER_CHANNEL 4
#define DRIVE_RIGHT_EDGEFINDER_CHANNEL 5
#define DRIVE_REAR_EDGEFINDER_CHANNEL 6
#define DRIVE_LEFT_EDGEFINDER_CHANNEL 7
#endif