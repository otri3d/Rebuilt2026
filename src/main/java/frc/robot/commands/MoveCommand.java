package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class MoveCommand extends Command {
    private DriveSubsystem m_DriveSubsystem;
    private DoubleSupplier v_rightForward;
    private DoubleSupplier v_leftForward;

    public MoveCommand(DriveSubsystem subsystem, DoubleSupplier v_lForward, DoubleSupplier v_rForward) {
        m_DriveSubsystem = subsystem;
        v_leftForward = v_lForward;
        v_rightForward = v_rForward;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
        double leftY = MathUtil.applyDeadband(v_leftForward.getAsDouble(), 0.09);
        double rightX = MathUtil.applyDeadband(v_rightForward.getAsDouble(), 0.09);

        m_DriveSubsystem.Move(leftY, rightX);
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
