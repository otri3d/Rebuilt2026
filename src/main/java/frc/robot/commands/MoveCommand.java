package frc.robot.commands.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class MoveCommand extends Command {
    // To move we need the subsystem that has the motors
    // A value for forward speed
    // A value for rotating speed
    // DoubleSupplier means that the value is a live/constant changing value
    private DriveSubsystem m_DriveSubsystem;
    private DoubleSupplier v_forwardSpeed;
    private DoubleSupplier v_rotateSpeed;

    public MoveCommand(DriveSubsystem subsystem, DoubleSupplier v_fSpeed, DoubleSupplier v_rSpeed) {
        m_DriveSubsystem = subsystem;
        v_forwardSpeed = v_fSpeed;
        v_rotateSpeed = v_rSpeed;

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
        // Our controls have a bit of stick drift
        // FRC Driver Station can show live values and the highest idle distance when we want zero is 0.09 
        double leftY = MathUtil.applyDeadband(v_forwardSpeed.getAsDouble(), 0.09);
        double rightX = MathUtil.applyDeadband(v_rotateSpeed.getAsDouble(), 0.09);

        // Call the drive subsystem to move
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
