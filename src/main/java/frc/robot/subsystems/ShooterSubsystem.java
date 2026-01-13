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
    private SparkMax m_shooter2 = new SparkMax(ShooterConstants.kShooter2Port, MotorType.kBrushless);
    private WPI_VictorSPX m_shooter1 = new WPI_VictorSPX(ShooterConstants.kShooter1Port);
    // private WPI_VictorSPX m_feederLeader = new WPI_VictorSPX(ShooterConstants.kLeftFeederConstant);
    // private WPI_VictorSPX m_feederFollower = new WPI_VictorSPX(ShooterConstants.kRightFeederConstant);

    public ShooterSubsystem() {
        // m_feederFollower.follow(m_feederLeader);
    }

    // *TODO figure out direction of motors relative to direction of current. */
    public void setShooterMotorsPower(double talonPower, double sparkPower) {
        /*
         * power left lead motor, right motor will
         * follow if set correctly in REV hardware correctly
         */
        m_shooter2.set(sparkPower);
        m_shooter1.set(talonPower);

    }

    public void StopMotors() {
        /* Stop shooter motors. */
        m_shooter2.set(0.0);
        m_shooter1.set(0.0);

        m_shooter2.stopMotor();
        m_shooter1.stopMotor();

    }
}
