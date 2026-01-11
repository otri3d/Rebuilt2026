// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kShooterForwardPowerAxis = 3;
  }

  // 4 sparks
  public static class DriveConstants {
    public static final int kLeftMotorPort1 = 1;
    public static final int kLeftMotorPort2 = 2;
    public static final int kRightMotorPort1 = 3;
    public static final int kRightMotorPort2 = 4;
  }

  // 2 talons
  public static class IntakeConstants {
    public static final int kLeadMotorPort = 5;
    public static final int kFollowMotorPort = 6;
    public static final double kMotorSpeed = 1.0;
  }


  // 2 talons 1 spark
  public static class ShooterConstants{
    public static final int kLeftShooterConstant = 7;
    public static final int kRightShooterConstant= 8;
    public static final int kFinalMotorPort = 9;
    public static final double kMinShooterInput = 0.5;
    public static final Double kShootingSpeed = 1.0;
  }


  // air
  public static class ClimbConstants {// assuming dual action solenoids
    public static final int[] kSolenoidPins = {1,2,3,4};
                                  // {forward1, reverse1, forward2, reverse2}
  }

  public static class ConveyorConstants {
    public static final int kLeadMotorPort = 1;
    public static final int kMotorPort1 = 3;
    public static final double kMotorSpeed = 1.0;
  }
}
