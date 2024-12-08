package frc.robot.commands;

import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj2.command.*;

public class ClawCommand extends Command {
    private final ClawSubsystem clawSubsystem;

    public ClawCommand(ClawSubsystem clawSubsystem) {
        this.clawSubsystem = clawSubsystem;
        addRequirements(clawSubsystem);
    }

    @Override
    public void execute() {
        clawSubsystem.toggleClaw();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
