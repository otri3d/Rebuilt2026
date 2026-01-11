package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ConveyorSubsystem;

public class ConveyorCommand extends Command {
    private ConveyorSubsystem m_subsystem;

    public ConveyorCommand(ConveyorSubsystem conveyor) {
        m_subsystem = conveyor;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(conveyor);
    } 
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // Call the  subsystem to move
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
        m_subsystem.ToggleConveyor();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Since it ended we want to stop the intake
        m_subsystem.StopSpinning();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}