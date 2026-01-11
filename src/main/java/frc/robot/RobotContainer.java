// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ClearSystemCommand;
import frc.robot.commands.IntakeFuelCommand;
import frc.robot.commands.MoveCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final ClimbSubsystem s_climbSubsystem = new ClimbSubsystem();

  // Drive Controller that uses an XboxOne Controller
  private final CommandXboxController m_controller =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Default command settings to move the robot
    // If nothing is happening at least we are checking to move
    m_driveSubsystem.setDefaultCommand(new MoveCommand(m_driveSubsystem,
    () -> m_controller.getLeftY(),
    () -> m_controller.getRightY()));

    // This will make the controllers shooter output the fuel forwards
    m_shooterSubsystem.setDefaultCommand(
      new ShooterCommand(
        m_shooterSubsystem,
       ()-> m_controller.getRawAxis(OperatorConstants.kShooterForwardPowerAxis)));

    // This will make the controllers left trigger intake a fuel
    m_controller.leftTrigger().whileTrue(new IntakeFuelCommand(m_intakeSubsystem));

    // This will make the controllers right bumper climb
    m_controller.rightBumper().whileTrue(new ClimbCommand(s_climbSubsystem));

    // This will make the controllers left bumper clear the system
    m_controller.leftBumper().whileTrue(new ClearSystemCommand(m_intakeSubsystem, m_shooterSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto();
  }
}
