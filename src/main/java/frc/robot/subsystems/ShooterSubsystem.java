package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;;

public class ShooterSubsystem extends SubsystemBase {
    /*
     * Note: In REV Hardware, the m_rightShooterFollow
     * controller must be configured to follow the m_leftShooterLead controller
     * and be inverted relative to the m_leftShooterLead controller’s direction.*
     * 
     * /* Shoter controllers to shooter fuel
     */
    public SparkMax m_shooter = new SparkMax(ShooterConstants.kShooterConstant, MotorType.kBrushless);
    public WPI_VictorSPX m_feederLeader = new WPI_VictorSPX(ShooterConstants.kLeftFeederConstant);
    public WPI_VictorSPX m_feederFollower = new WPI_VictorSPX(ShooterConstants.kRightFeederConstant);

    public ShooterSubsystem() {
        m_feederFollower.follow(m_feederLeader);
    }

    // *TODO figure out direction of motors relative to direction of current. */
    public void setShooterMotorsPower(double shootpower, double feederpower) {
        /*
         * power left lead motor, right motor will
         * follow if set correctly in REV hardware correctly
         */
        m_feederLeader.set(feederpower);
        m_shooter.set(shootpower);

    }

    public void StopMotors() {
        /* Stop shooter motors. */
        m_feederLeader.set(0.0);
        m_shooter.set(0.0);

        m_feederLeader.stopMotor();
        m_shooter.stopMotor();

    }
}
