package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ClawCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final ClawSubsystem clawSubsystem = new ClawSubsystem();
    private final XboxController controller = new XboxController(Constants.JOYSTICK_PORT);

    public RobotContainer() {
        driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, controller));

        new JoystickButton(controller, XboxController.Button.kB.value)
            .onTrue(new ClawCommand(clawSubsystem));
    }

    public Command getAutonomousCommand() {
        return new AutonomousCommand(driveSubsystem);
    }
}
