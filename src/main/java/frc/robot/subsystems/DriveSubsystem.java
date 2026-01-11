package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;;

public class DriveSubsystem extends SubsystemBase {
    /* Motor controllers to move the tank */
    public SparkMax m_leftMotorLead = new SparkMax(DriveConstants.kLeftMotorPort2, MotorType.kBrushless);
    public SparkMax m_rightMotorLead = new SparkMax(DriveConstants.kRightMotorPort1, MotorType.kBrushless);
    
    private final DifferentialDrive m_Drive;

    /* Constructor for the drive subsystem */
    public DriveSubsystem() {
        // Since 1 side is opposite that means rotation will also change, thus inverse
        // THIS IS TODO CAUSE I DON'T KNOW HOW TO DO IT, .setInverted() is deprecated

        // This will set the motors in a differential drive, another way of saying tank drive
        // The motors will run differentially from each other
        m_Drive = new DifferentialDrive(m_leftMotorLead, m_rightMotorLead);
    }

    // Move the wheels according to the values given
    // F is for the forward speed
    // R is for the rotating speed
    public void Move(Double f, Double r)  {
        m_Drive.tankDrive(f, r);
    }
}
