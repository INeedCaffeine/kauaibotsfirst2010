#ifndef __MecanumDrive_h__
#define __MecanumDrive_h__
/*
 * MecanumDrive.h
 *
 *  Created on: Nov 22, 2009
 *      Author: slibert
 */

#include "Encoder.h"
#include "Jaguar.h"
#include "CustomGyro.h"
#include "FilteredAccelerometer.h"

/*
 * Description:  Custom Robot Drive Class to extend the
 * WPI Library RobotDrive class in order to add the
 * ability to operate a mecanum omniwheel drive system,
 * and also to incorporate feedback from quadrature encoders.
 */
class MecanumDrive
{
protected:
	Jaguar	m_frontLeftMotor;
	Jaguar  m_frontRightMotor;
	Jaguar  m_rearLeftMotor;
	Jaguar  m_rearRightMotor;
	Encoder m_frontLeftEncoder;
	Encoder m_frontRightEncoder;
	Encoder m_rearLeftEncoder;
	Encoder m_rearRightEncoder;
	CustomGyro	m_gyroscope;
	FilteredAccelerometer m_accelerometerX;
	FilteredAccelerometer m_accelerometerY;
	
public:
	MecanumDrive( UINT32 frontLeftMotorChannel,
			UINT32 frontRightMotorChannel,
			UINT32 rearLeftMotorChannel,
			UINT32 rearRightMotorChannel,
			UINT32 frontLeftEncoderChannelA,
			UINT32 frontLeftEncoderChannelB,
			UINT32 frontRightEncoderChannelA,
			UINT32 frontRightEncoderChannelB,
			UINT32 rearLeftEncoderChannelA,
			UINT32 rearLeftEncoderChannelB,
			UINT32 rearRightEncoderChannelA,
			UINT32 rearRightEncoderChannelB,
			UINT32 gyroChannel,
			UINT32 accelerometerChannelX,
			UINT32 accelerometerChannelY);

	virtual void DoMecanum( float vX, float vY, float vRot );
	void InitializeSensors();
	void RestartSensors();

	Encoder& 			FrontLeftEncoder() { return m_frontLeftEncoder; } 
	Encoder& 			FrontRightEncoder() { return m_frontRightEncoder; } 
	Encoder& 			RearLeftEncoder() { return m_rearLeftEncoder; } 
	Encoder& 			RearRightEncoder() { return m_rearRightEncoder; } 
	
	SpeedController& 	FrontLeftMotor() { return m_frontLeftMotor; }
	SpeedController& 	FrontRightMotor() { return m_frontRightMotor; }
	SpeedController& 	RearLeftMotor() { return m_rearLeftMotor; }
	SpeedController& 	RearRightMotor() { return m_rearRightMotor; }
	
	CustomGyro&			Gyroscope() { return m_gyroscope; }
	FilteredAccelerometer& 		AccelerometerX() { return m_accelerometerX; }
	FilteredAccelerometer&		AccelerometerY() { return m_accelerometerY; }
	
	virtual ~MecanumDrive();
protected:
	void MecanumDriveFwdKinematics( float wheelSpeeds[4], float* pVelocities );
	void MecanumDriveInvKinematics( float velocities[3], float* pWheelSpeeds);
	void DoMecanumInternal( float vX, float vY, float vRot );
	
	double InputJoystickAdjust( double dJoystickIn );
	double InputJoystickAdjust2( double dJoystickIn );
	double InputJoystickAdjust3( double dJoystickIn );
};
#endif
