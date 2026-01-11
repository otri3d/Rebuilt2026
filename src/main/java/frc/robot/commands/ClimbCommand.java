package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends Command {
    // To move we need the subsystem that has the motors
    // A value for forward speed
    // A value for rotating speed
    // DoubleSupplier means that the value is a live/constant changing value
    private ClimbSubsystem m_ClimbSubsystem;

    public ClimbCommand(ClimbSubsystem subsystem) {
        m_ClimbSubsystem = subsystem;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // Activate Solenoids
        m_ClimbSubsystem.ToggleSolenoid();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
