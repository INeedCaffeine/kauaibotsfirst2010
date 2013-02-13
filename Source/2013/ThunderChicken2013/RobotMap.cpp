// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// C++ from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


#include "RobotMap.h"
#include "LiveWindow/LiveWindow.h"


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ALLOCATION
Servo* RobotMap::cameraazimuth_servo = NULL;
Servo* RobotMap::cameraelevation_servo = NULL;
SpeedController* RobotMap::shootermotor = NULL;
DoubleSolenoid* RobotMap::magazinetrigger = NULL;
DoubleSolenoid* RobotMap::magazinelifter = NULL;
ProximitySensor* RobotMap::magazinefirsbee_counter = NULL;
Compressor* RobotMap::pneumaticscompressor = NULL;
ProximitySensor* RobotMap::tilterheight_sensor = NULL;
SpeedController* RobotMap::tiltermotor = NULL;
SpeedController* RobotMap::climberfront_winch_motor = NULL;
SpeedController* RobotMap::climberrear_winch_motor = NULL;
SpeedController* RobotMap::swerveDriveSystemleft_front_steer_motor = NULL;
AngleSensor* RobotMap::swerveDriveSystemleft_front_angle_sensor = NULL;
PIDController* RobotMap::swerveDriveSystemleft_front_steer = NULL;
Encoder* RobotMap::swerveDriveSystemleft_front_rpm_sensor = NULL;
SpeedController* RobotMap::swerveDriveSystemleft_front_drive_motor = NULL;
PIDController* RobotMap::swerveDriveSystemleft_front_drive = NULL;
SpeedController* RobotMap::swerveDriveSystemright_front_steer_motor = NULL;
AngleSensor* RobotMap::swerveDriveSystemright_front_angle_sensor = NULL;
PIDController* RobotMap::swerveDriveSystemright_front_steer = NULL;
Encoder* RobotMap::swerveDriveSystemright_front_rpm_sensor = NULL;
SpeedController* RobotMap::swerveDriveSystemright_front_drive_motor = NULL;
PIDController* RobotMap::swerveDriveSystemright_front_drive = NULL;
SpeedController* RobotMap::swerveDriveSystemleft_back_steer_motor = NULL;
AngleSensor* RobotMap::swerveDriveSystemleft_back_angle_sensor = NULL;
PIDController* RobotMap::swerveDriveSystemleft_back_steer = NULL;
Encoder* RobotMap::swerveDriveSystemleft_back_rpm_sensor = NULL;
SpeedController* RobotMap::swerveDriveSystemleft_back_drive_motor = NULL;
PIDController* RobotMap::swerveDriveSystemleft_back_drive = NULL;
SpeedController* RobotMap::swerveDriveSystemright_back_steer_motor = NULL;
AngleSensor* RobotMap::swerveDriveSystemright_back_angle_sensor = NULL;
PIDController* RobotMap::swerveDriveSystemright_back_steer = NULL;
SpeedController* RobotMap::swerveDriveSystemright_back_drive_motor = NULL;
Encoder* RobotMap::swerveDriveSystemright_back_rpm_sensor = NULL;
PIDController* RobotMap::swerveDriveSystemright_back_drive = NULL;
SerialPort *RobotMap::imu_serial_port = NULL;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ALLOCATION

void RobotMap::init() {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	LiveWindow* lw = LiveWindow::GetInstance();

	cameraazimuth_servo = new Servo(1, 5);
	lw->AddActuator("Camera", "azimuth_servo", cameraazimuth_servo);
	
	cameraelevation_servo = new Servo(1, 6);
	lw->AddActuator("Camera", "elevation_servo", cameraelevation_servo);
	
	shootermotor = new Jaguar(1, 1);
	lw->AddActuator("Shooter", "motor", (Jaguar*) shootermotor);
	
	magazinetrigger = new DoubleSolenoid(1, 1, 2);      
	
	magazinelifter = new DoubleSolenoid(1, 3, 4);      
		
	magazinefirsbee_counter = new ProximitySensor(1, 1, ProximitySensor::kShortRange);
	lw->AddSensor("Magazine", "firsbee_counter", magazinefirsbee_counter);
	
	pneumaticscompressor = new Compressor(2, 7, 1, 1);
	
	
	tilterheight_sensor = new ProximitySensor(1, 2, ProximitySensor::kMediumRange);
	lw->AddSensor("Tilter", "height_sensor", tilterheight_sensor);
	
	tiltermotor = new Jaguar(1, 2);
	lw->AddActuator("Tilter", "motor", (Jaguar*) tiltermotor);
	
	climberfront_winch_motor = new Jaguar(1, 3);
	lw->AddActuator("Climber", "front_winch_motor", (Jaguar*) climberfront_winch_motor);
	
	climberrear_winch_motor = new Jaguar(1, 4);
	lw->AddActuator("Climber", "rear_winch_motor", (Jaguar*) climberrear_winch_motor);
	
	swerveDriveSystemleft_front_steer_motor = new Talon(1, 9);
	lw->AddActuator("SwerveDriveSystem", "left_front_steer_motor", (Talon*) swerveDriveSystemleft_front_steer_motor);
	
	swerveDriveSystemleft_front_angle_sensor = new AngleSensor(1, 12, 14, 13);
	lw->AddSensor("SwerveDriveSystem", "left_front_angle_sensor", swerveDriveSystemleft_front_angle_sensor);
	
	swerveDriveSystemleft_front_steer = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemleft_front_angle_sensor, swerveDriveSystemleft_front_steer_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "left_front_steer", swerveDriveSystemleft_front_steer);
	swerveDriveSystemleft_front_steer->SetContinuous(false); swerveDriveSystemleft_front_steer->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemleft_front_steer->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemleft_front_rpm_sensor = new Encoder(1, 11, 1, 10, false, Encoder::k4X);
	lw->AddSensor("SwerveDriveSystem", "left_front_rpm_sensor", swerveDriveSystemleft_front_rpm_sensor);
	swerveDriveSystemleft_front_rpm_sensor->SetDistancePerPulse(1.0);
        swerveDriveSystemleft_front_rpm_sensor->SetPIDSourceParameter(Encoder::kRate);
        swerveDriveSystemleft_front_rpm_sensor->Start();
	swerveDriveSystemleft_front_drive_motor = new Talon(1, 10);
	lw->AddActuator("SwerveDriveSystem", "left_front_drive_motor", (Talon*) swerveDriveSystemleft_front_drive_motor);
	
	swerveDriveSystemleft_front_drive = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemleft_front_rpm_sensor, swerveDriveSystemleft_front_drive_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "left_front_drive", swerveDriveSystemleft_front_drive);
	swerveDriveSystemleft_front_drive->SetContinuous(false); swerveDriveSystemleft_front_drive->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemleft_front_drive->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemright_front_steer_motor = new Talon(1, 7);
	lw->AddActuator("SwerveDriveSystem", "right_front_steer_motor", (Talon*) swerveDriveSystemright_front_steer_motor);
	
	swerveDriveSystemright_front_angle_sensor = new AngleSensor(1, 7, 9, 8);
	lw->AddSensor("SwerveDriveSystem", "right_front_angle_sensor", swerveDriveSystemright_front_angle_sensor);
	
	swerveDriveSystemright_front_steer = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemright_front_angle_sensor, swerveDriveSystemright_front_steer_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "right_front_steer", swerveDriveSystemright_front_steer);
	swerveDriveSystemright_front_steer->SetContinuous(false); swerveDriveSystemright_front_steer->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemright_front_steer->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemright_front_rpm_sensor = new Encoder(1, 6, 1, 5, false, Encoder::k4X);
	lw->AddSensor("SwerveDriveSystem", "right_front_rpm_sensor", swerveDriveSystemright_front_rpm_sensor);
	swerveDriveSystemright_front_rpm_sensor->SetDistancePerPulse(1.0);
        swerveDriveSystemright_front_rpm_sensor->SetPIDSourceParameter(Encoder::kRate);
        swerveDriveSystemright_front_rpm_sensor->Start();
	swerveDriveSystemright_front_drive_motor = new Talon(1, 8);
	lw->AddActuator("SwerveDriveSystem", "right_front_drive_motor", (Talon*) swerveDriveSystemright_front_drive_motor);
	
	swerveDriveSystemright_front_drive = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemright_front_rpm_sensor, swerveDriveSystemright_front_drive_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "right_front_drive", swerveDriveSystemright_front_drive);
	swerveDriveSystemright_front_drive->SetContinuous(false); swerveDriveSystemright_front_drive->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemright_front_drive->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemleft_back_steer_motor = new Talon(2, 9);
	lw->AddActuator("SwerveDriveSystem", "left_back_steer_motor", (Talon*) swerveDriveSystemleft_back_steer_motor);
	
	swerveDriveSystemleft_back_angle_sensor = new AngleSensor(2, 12, 14, 13);
	lw->AddSensor("SwerveDriveSystem", "left_back_angle_sensor", swerveDriveSystemleft_back_angle_sensor);
	
	swerveDriveSystemleft_back_steer = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemleft_back_angle_sensor, swerveDriveSystemleft_back_steer_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "left_back_steer", swerveDriveSystemleft_back_steer);
	swerveDriveSystemleft_back_steer->SetContinuous(false); swerveDriveSystemleft_back_steer->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemleft_back_steer->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemleft_back_rpm_sensor = new Encoder(2, 11, 2, 10, false, Encoder::k4X);
	lw->AddSensor("SwerveDriveSystem", "left_back_rpm_sensor", swerveDriveSystemleft_back_rpm_sensor);
	swerveDriveSystemleft_back_rpm_sensor->SetDistancePerPulse(1.0);
        swerveDriveSystemleft_back_rpm_sensor->SetPIDSourceParameter(Encoder::kRate);
        swerveDriveSystemleft_back_rpm_sensor->Start();
	swerveDriveSystemleft_back_drive_motor = new Talon(2, 10);
	lw->AddActuator("SwerveDriveSystem", "left_back_drive_motor", (Talon*) swerveDriveSystemleft_back_drive_motor);
	
	swerveDriveSystemleft_back_drive = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemleft_back_rpm_sensor, swerveDriveSystemleft_back_drive_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "left_back_drive", swerveDriveSystemleft_back_drive);
	swerveDriveSystemleft_back_drive->SetContinuous(false); swerveDriveSystemleft_back_drive->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemleft_back_drive->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemright_back_steer_motor = new Talon(2, 7);
	lw->AddActuator("SwerveDriveSystem", "right_back_steer_motor", (Talon*) swerveDriveSystemright_back_steer_motor);
	
	swerveDriveSystemright_back_angle_sensor = new AngleSensor(2, 7, 9, 8);
	lw->AddSensor("SwerveDriveSystem", "right_back_angle_sensor", swerveDriveSystemright_back_angle_sensor);
	
	swerveDriveSystemright_back_steer = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemright_back_angle_sensor, swerveDriveSystemright_back_steer_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "right_back_steer", swerveDriveSystemright_back_steer);
	swerveDriveSystemright_back_steer->SetContinuous(false); swerveDriveSystemright_back_steer->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemright_back_steer->SetOutputRange(-1.0, 1.0);
	swerveDriveSystemright_back_drive_motor = new Talon(2, 8);
	lw->AddActuator("SwerveDriveSystem", "right_back_drive_motor", (Talon*) swerveDriveSystemright_back_drive_motor);
	
	swerveDriveSystemright_back_rpm_sensor = new Encoder(2, 6, 2, 5, false, Encoder::k4X);
	lw->AddSensor("SwerveDriveSystem", "right_back_rpm_sensor", swerveDriveSystemright_back_rpm_sensor);
	swerveDriveSystemright_back_rpm_sensor->SetDistancePerPulse(1.0);
        swerveDriveSystemright_back_rpm_sensor->SetPIDSourceParameter(Encoder::kRate);
        swerveDriveSystemright_back_rpm_sensor->Start();
	swerveDriveSystemright_back_drive = new PIDController(1.0, 0.0, 0.0,/* F: 0.0, */ swerveDriveSystemright_back_rpm_sensor, swerveDriveSystemright_back_drive_motor, 0.02);
	lw->AddActuator("SwerveDriveSystem", "right_back_drive", swerveDriveSystemright_back_drive);
	swerveDriveSystemright_back_drive->SetContinuous(false); swerveDriveSystemright_back_drive->SetAbsoluteTolerance(0.2); 
        swerveDriveSystemright_back_drive->SetOutputRange(-1.0, 1.0);

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
    imu_serial_port = new SerialPort(57600);
}