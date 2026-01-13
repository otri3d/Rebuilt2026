package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    // This is the motor we will control, design has 2 motors
    // Meaning that a second motor is set in the firmware to follow this motor
    private SparkMax m_motorSpark = new SparkMax(IntakeConstants.kFollowMotorPort, MotorType.kBrushless);
    private WPI_VictorSPX m_motorLeader = new WPI_VictorSPX(IntakeConstants.kLeadMotorPort);
    // private WPI_VictorSPX m_motorFollower = new WPI_VictorSPX(IntakeConstants.kFollowMotorPort);//

    // Constructor, so that the follower follows lead
    public IntakeSubsystem() {
        //  m_motorFollower.follow(m_motorLeader); 
    }

    // This will spin our motors at the set speed to intake the fuel
    public void IntakeFuel() {
        m_motorLeader.set(IntakeConstants.kMotorSpeedSpark);
        m_motorSpark.set(IntakeConstants.kMotorSpeedTalon);
    }

    // Incase something is stuck just simply go reverse 
    public void StuckFuel() {
        m_motorLeader.set(-IntakeConstants.kMotorSpeedSpark);
        m_motorSpark.set(-IntakeConstants.kMotorSpeedTalon);
    }

    // Stop the motor when we are doing nothing
    public void StopMotor() {
        m_motorLeader.set(0);
        m_motorSpark.set(0);
    }
}
