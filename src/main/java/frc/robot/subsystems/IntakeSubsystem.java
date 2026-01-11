package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    // This is the motor we will control, design has 2 motors
    // Meaning that a second motor is set in the firmware to follow this motor
    private SparkMax m_motorLeader = new SparkMax(IntakeConstants.kLeadMotorPort, MotorType.kBrushless);

    // Empty Constructor since we do not require anything but a single motor
    public IntakeSubsystem() { }

    // This will spin our motors at the set speed to intake the fuel
    public void IntakeFuel() {
        m_motorLeader.set(IntakeConstants.kMotorSpeed);
    }

    // Incase something is stuck just simply go reverse 
    public void StuckFuel() {
        m_motorLeader.set(-IntakeConstants.kMotorSpeed);
    }

    // Stop the motor when we are doing nothing
    public void StopMotor() {
        m_motorLeader.set(0);
    }
}
