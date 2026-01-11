package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeFuelCommand extends Command {
    // We need the intake subsystem
    // Everything else is defined as a constant
    private IntakeSubsystem m_subsystem;

    public IntakeFuelCommand(IntakeSubsystem intake) {
        m_subsystem = intake;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(intake);
    } 
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // Call the drive subsystem to move
        m_subsystem.IntakeFuel();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Since it ended we want to stop the intake
        m_subsystem.StopMotor();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
