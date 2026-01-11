package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;;

public class DriveSubsystem extends SubsystemBase {
    /* Motor controllers to move the tank */
    private PWMSparkMax m_leftMotorFollower = new PWMSparkMax(DriveConstants.kLeftMotorPort1);
    public PWMSparkMax m_leftMotor = new PWMSparkMax(DriveConstants.kLeftMotorPort2);
    private PWMSparkMax m_rightMotorFollower = new PWMSparkMax(DriveConstants.kRightMotorPort2);
    public PWMSparkMax m_rightMotor = new PWMSparkMax(DriveConstants.kRightMotorPort1);
    
    private final DifferentialDrive m_Drive;

    /* Constructor for the drive subsystem */
    public DriveSubsystem() {
        /* Sets the motors up and add the followers */
        m_leftMotor.addFollower(m_leftMotorFollower);
        m_rightMotor.addFollower(m_rightMotorFollower);

        m_Drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    }

    public void Move(Double x, Double y)  {
        m_Drive.arcadeDrive(x, y);
        double[] receive = {m_leftMotorFollower.get(), m_rightMotorFollower.get(), m_leftMotor.get(), m_rightMotor.get()};
        SmartDashboard.putNumberArray("RobotDrive Motors", receive);
    }
}
