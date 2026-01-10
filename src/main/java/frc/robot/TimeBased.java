// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/**
 * This is the TimeBased class that will be used for backup if the command
 * project doesn't work as intended. This uses a TimeBased constructor and
 * a teleop periodic function.
 * 
 * @author Ri3D Programming Subteam
 */

package frc.robot;

//New for 2026 Ri3D - Spark Max
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController; //1 for drive, 1 for operator
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is the TimeBased class that will be used for backup if the command
 * project doesn't work as intended. This uses a TimeBased constructor and
 * a teleop periodic function.
 */
public class TimeBased extends TimedRobot {
  private final DifferentialDrive m_robotDrive; //Used for drivetrain

  //Replace IDs later on, subject to change depending on elec (Cass)
  private final SparkMax m_leftMotor1 = new SparkMax(9, kBrushless);
  private final SparkMax m_leftMotor2 = new SparkMax(1, kBrushless);
  private final SparkMax m_rightMotor1 = new SparkMax(3, kBrushless);
  private final SparkMax m_rightMotor2 = new SparkMax(4, kBrushless);

  private final SparkMax m_intake = new SparkMax(6, kBrushless);
  private final SparkMax m_shooter = new SparkMax(7, kBrushless);

  //Controller Variable
  private final XboxController m_controller;

  /** Timer Based Robot Constructor. */
  public TimeBased() {
    m_controller = new XboxController(0);

    //AWD, Left motors must follow together, same with right
    m_leftMotor2.follow(m_leftMotor1);
    m_rightMotor2.follow(m_rightMotor1);

    m_robotDrive = new DifferentialDrive(m_leftMotor1::set, m_rightMotor1::set);
  }

  /** Overridden teleop periodic function, This will be executed at 50Hz/20ms */
  @Override
  public void teleopPeriodic() {
    //Tank Drive Controls
    m_robotDrive.tankDrive(-m_controller.getLeftY(), -m_controller.getRightY());

    // Ball intake. Suck balls with LT
    if (m_OperatorController.getLeftTriggerButtonPressed()) {
      m_intake.set(0.8);
    }
    else{
      m_intake.set(0);
    }

    // Shooter conditional. When RT is pressed, shooter activates
    if (m_OperatorController.getRightTriggerButtonPressed()) {
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