package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutonomousCommand;
import frc.robot.Constants;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final XboxController controller = new XboxController(Constants.JOYSTICK_PORT);

    public RobotContainer() {
        // Configure the default command
        driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, controller));
    }

    public Command getAutonomousCommand() {
        return new AutonomousCommand(driveSubsystem);
    }
}
