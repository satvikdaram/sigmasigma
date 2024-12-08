package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final Timer timer = new Timer();

    public AutonomousCommand(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() < 15) {
            driveSubsystem.arcadeDrive();
        } else if (timer.get() >= 15 && timer.get() < 16) {
            driveSubsystem.arcadeDrive(0, 1);
        } else {
            driveSubsystem.arcadeDrive(0, 0);
        }
    }

    @Override
    public boolean isFinished() {
        return timer.get() > 16;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.arcadeDrive(0, 0);
    }
}
