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
  private final DifferentialDrive m_robotDrive;

  private final SparkMax m_leftMotor1 = new SparkMax(9, kBrushless);
  private final SparkMax m_leftMotor2 = new SparkMax(1, kBrushless);
  private final SparkMax m_rightMotor1 = new SparkMax(3, kBrushless);
  private final SparkMax m_rightMotor2 = new SparkMax(4, kBrushless);

  private final XboxController m_DriverController;
  private final XboxController m_OperatorController;

  /** Called once at the beginning of the robot program. */
  public TimeBased() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_ClawSolenoid.set(Value.kForward);
    //m_OperatorController = new PS4Controller(1);
    m_DriverController = new XboxController(0);

    m_leftMotor2.follow(m_leftMotor1);
    m_rightMotor2.follow(m_rightMotor1);

    m_robotDrive = new DifferentialDrive(m_leftMotor1::set, m_rightMotor1::set);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.tankDrive(-m_DriverController.getLeftY(), -m_DriverController.getRightY());

    /*
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