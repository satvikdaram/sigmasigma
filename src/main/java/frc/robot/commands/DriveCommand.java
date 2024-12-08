package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final XboxController controller;

    public DriveCommand(DriveSubsystem driveSubsystem, XboxController controller) {
        this.driveSubsystem = driveSubsystem;
        this.controller = controller;
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        double move = controller.getRawAxis(1); // y axis
        double turn = controller.getRawAxis(4); // x axis
        driveSubsystem.arcadeDrive(move, turn);
    }

    @Override
    public boolean isFinished() {
        return false; 
    }
}
