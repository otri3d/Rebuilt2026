package frc.robot.commands;


import java.util.function.Supplier;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;


public class ShooterCommand extends Command {
    private final ShooterSubsystem m_ShooterSubsystem;
    public final Supplier<Double> shooterSpeedSupplier;
   
    public ShooterCommand(
        ShooterSubsystem ShooterSubsystem, 
        /*Controller input into shooter command.*/
         Supplier<Double> shooterInputSpeedSupplier) {
        m_ShooterSubsystem = ShooterSubsystem;
        this.shooterSpeedSupplier = shooterInputSpeedSupplier;
    
        addRequirements(m_ShooterSubsystem);

    }

    @Override
    public void initialize() {

        /* When command starts, stop the Shooter  motor. */
        m_ShooterSubsystem.StopMotors();

    }

    @Override
    public void execute() {
        /* power intake consumer motor */
        if( shooterSpeedSupplier.get() > ShooterConstants.kMinShooterInput)
        {
            m_ShooterSubsystem.setShooterMotorsPower(ShooterConstants.kShootingSpeed);
        }
        else{
            m_ShooterSubsystem.StopMotors();
        }
    }

    @Override
    public void end(boolean interrupted) {
        /* when command ends, stop the shooter motors. */
        m_ShooterSubsystem.StopMotors();

    }

    @Override
    public boolean isFinished() {

        return false;
    }
}