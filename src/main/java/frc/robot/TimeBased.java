// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/**
 * This is the TimeBased class that will be used for backup if the command
 * project doesn't work as intended. This uses a TimeBased constructor and
 * a teleop periodic function. Everything in here is hard coded to reduce 
 * external impact on the file.
 * 
 * @author Ri3D Programming Subteam
 */

package frc.robot;

//New for 2026 Ri3D - Spark Max
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController; 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is the TimeBased class that will be used for backup if the command
 * project doesn't work as intended. This uses a TimeBased constructor and
 * a teleop periodic function.
 */
public class TimeBased extends TimedRobot {
  private final DifferentialDrive m_robotDrive; //Used for drivetrain

  //Replace IDs later on, subject to change depending on elec (Cass)
  // Follow through FW.
  private final SparkMax m_leftMotor = new SparkMax(9, MotorType.kBrushless);
  private final SparkMax m_rightMotor = new SparkMax(3, MotorType.kBrushless);
  private final SparkMax m_intake = new SparkMax(6, MotorType.kBrushless);
  // private final SparkMax m_shooter = new SparkMax(7, MotorType.kBrushless);

  //Controller Variable
  private final XboxController m_controller;

  /** Timer Based Robot Constructor. */
  public TimeBased() {
    m_controller = new XboxController(0);

    //AWD, Left motors must follow together, same with right
    // The follow method does not work, meaning that the follower is set in the REV Hardware
    // Motor ID 1 follows 9 - left
    // Motor ID 4 follows 3 - right

    m_robotDrive = new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);
  }

  /** Overridden teleop periodic function, This will be executed at 50Hz/20ms */
  @Override
  public void teleopPeriodic() {
    //Tank Drive Controls
    m_robotDrive.tankDrive(-m_controller.getLeftY(), -m_controller.getRightY());

    // Ball intake, when trigger is over half way intake the speed.
    if (m_controller.getLeftTriggerAxis() >= 0.5) {
      m_intake.set(0.8);
    }
    else{
      m_intake.set(0);
    }

    // Shooter conditional. When RT is pressed, shooter activates
    if (m_controller.getRightTriggerAxis() >= 0.5) {
      m_intake.set(0.8); //Test
    }
    else{
      m_intake.set(0);
    }

    /* Temp code from last year
    m_rotateLowerLeft.set(m_OperatorController.getLeftY());
    m_rorateUpeer.set(m_OperatorController.getRightY() * 0.4);

    if (m_OperatorController.getL2ButtonPressed()) {
      m_intake.set(0.8);
    }
    if (m_OperatorController.getR2ButtonPressed()) {
      m_intake.set(-0.8);
    }
    if (m_OperatorController.getR2Button() == m_OperatorController.getL2Button()) {
      m_intake.set(0);
    }

    if (m_OperatorController.getR1ButtonPressed()) {
      if (m_ClawSolenoid.get() == Value.kForward) {
        m_ClawSolenoid.set(Value.kReverse);
      } else {
        m_ClawSolenoid.set(Value.kForward);
      }
    }
    */
  }
}