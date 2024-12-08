package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutonomousCommand;

public class Robot extends TimedRobot {
    private final RobotContainer robotContainer = new RobotContainer();
    private final Compressor compressor = new Compressor(null); 

    @Override
    public void robotInit() {
        compressor.enableDigital(); 

    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void autonomousInit() {
        new AutonomousCommand(robotContainer.getDriveSubsystem()).schedule();
    }
}
