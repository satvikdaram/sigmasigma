package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Joystick;

public class DriveSubsystem extends SubsystemBase {
    private final CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private final CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
    private final CANSparkMax rearLeftMotor = new CANSparkMax(Constants.REAR_LEFT_MOTOR_PORT, MotorType.kBrushless);
    private final CANSparkMax rearRightMotor = new CANSparkMax(Constants.REAR_RIGHT_MOTOR_PORT, MotorType.kBrushless);

    private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);

    public DriveSubsystem() {
        frontLeftMotor.setInverted(false);
        frontRightMotor.setInverted(true);
        rearLeftMotor.setInverted(false);
        rearRightMotor.setInverted(true);
        //invert motors
    }

    public void arcadeDrive(double move2, double turn2) {
        double move = joystick.getRawAxis(Constants.DRIVE_AXIS); //y axis
        double turn = joystick.getRawAxis(Constants.TURN_AXIS); //x axis 

        double leftSpeed = move + turn;
        double rightSpeed = move - turn;

        frontLeftMotor.set(leftSpeed);
        rearLeftMotor.set(leftSpeed);
        frontRightMotor.set(rightSpeed);
        rearRightMotor.set(rightSpeed);
    }

}

