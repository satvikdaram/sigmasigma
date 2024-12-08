package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();

    @Override
    public void robotInit() {
        // Initialize the autonomous command and set it to run
        SmartDashboard.putData(new AutonomousCommand(driveSubsystem));
    }

    @Override
    public void teleopPeriodic() {
        // Here we will handle the arcade drive logic
        driveSubsystem.arcadeDrive();
    }

    @Override
    public void autonomousInit() {
        // Initialize autonomous command
        new AutonomousCommand(driveSubsystem).schedule();
    }

    @Override
    public void autonomousPeriodic() {
        // Autonomous actions are handled through the command
    }
}
