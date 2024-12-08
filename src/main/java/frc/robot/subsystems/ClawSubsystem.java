package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {
    private final Solenoid clawSolenoid;

    public ClawSubsystem() {
        clawSolenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.CLAW_SOLENOID_PORT);
    }

    public void openClaw() {
        clawSolenoid.set(true); 
    }

    public void closeClaw() {
        clawSolenoid.set(false);
    }

    public void toggleClaw() {
        clawSolenoid.set(!clawSolenoid.get());
    }

    public boolean isClawOpen() {
        return clawSolenoid.get();
    }
}
