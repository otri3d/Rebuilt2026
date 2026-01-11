package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.IntakeSubsystem;

public class ClearSystemCommand extends Command {
    private IntakeSubsystem m_intakeSubsystem;
    private ShooterSubsystem m_shooterSubsystem;

    public ClearSystemCommand(IntakeSubsystem intake, ShooterSubsystem shooter) {
        m_intakeSubsystem = intake;
        m_shooterSubsystem = shooter;

        addRequirements(intake);
        addRequirements(shooter);
    } 
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // Call the intake to run in reverse
        m_intakeSubsystem.StuckFuel();

        m_shooterSubsystem.setShooterMotorsPower(-ShooterConstants.kShootingSpeed, -ShooterConstants.kFeedingSpeed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() { 
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Since it ended we want to stop the intake
        m_intakeSubsystem.StopMotor();
        m_shooterSubsystem.StopMotors();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
