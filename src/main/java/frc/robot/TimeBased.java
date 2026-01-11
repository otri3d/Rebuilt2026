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
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * This is the TimeBased class that will be used for backup if the command
 * project doesn't work as intended. This uses a TimeBased constructor and
 * a teleop periodic function.
 */
public class TimeBased extends TimedRobot {
  private final DifferentialDrive m_robotDrive; //Used for drivetrain

  //Replace IDs later on, subject to change depending on elec (Cass)
  // Follow through FW.
  //SparkMax
  private final SparkMax m_leftMotor = new SparkMax(9, MotorType.kBrushless);
  private final SparkMax m_rightMotor = new SparkMax(3, MotorType.kBrushless);

  //CTRE
  private final WPI_VictorSPX m_intake1 = new WPI_VictorSPX(6);
  private final WPI_VictorSPX m_intake2 = new WPI_VictorSPX(7);
  //private final SparkMax m_shooter = new SparkMax(8, MotorType.kBrushless);

  //Solenoid
  private final DoubleSolenoid m_climber = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  
  //Controller Variable
  private final XboxController m_controller;

  /** Timer Based Robot Constructor. */
  public TimeBased() {
    m_controller = new XboxController(0);
    m_climber.set(Value.kForward);

    /*
     * AWD, Left motors must follow together, same with right.
     * Unlike last year, the follow method does not work, meaning 
     * that the follower must be set in REV Hardware. As such, the 
     * code to initialize motors 
     * Motor ID 1 follows 9 - left
     * Motor ID 4 follows 3 - right
     */
    m_robotDrive = new DifferentialDrive(m_leftMotor::set, m_rightMotor::set);

    //For CTRE, we must use .follow.
    m_intake2.follow(m_intake1);
  }

  /** Overridden teleop periodic function, This will be executed at 50Hz/20ms */
  @Override
  public void teleopPeriodic() {
    //Tank Drive Controls
    m_robotDrive.tankDrive(-m_controller.getLeftY(), -m_controller.getRightY());

    // Ball intake, when trigger is over half way intake the speed.
    if (m_controller.getLeftTriggerAxis() >= 0.5) {
      m_intake1.set(0.8);
    }
    else{
      m_intake1.set(0);
    }

    // Shooter conditional. When RT is pressed, shooter activates
    if (m_controller.getRightTriggerAxis() >= 0.5) {
      //m_shooter.set(0.8); //Test
    }
    else{
      //m_shooter.set(0);
    }

    //Unjam function, in case it intake and shooter are stuck
    if(m_controller.getBButtonPressed())
    {
      m_intake1.set(-0.8);
      //m_shooter.set(-0.8);
    }


    // Conditional for the climber solenoid. Assuming double, might change in future.
    if (m_controller.getRightBumperButtonPressed()) {
      if (m_climber.get() == Value.kForward) {
        m_climber.set(Value.kReverse);
      } else {
        m_climber.set(Value.kForward);
      }
    }
  }
}