package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;;

public class ShooterSubsystem extends SubsystemBase {
    /*Note: In REV Hardware, the m_rightShooterFollow
     controller must be configured to follow the m_leftShooterLead controller 
     and be inverted relative to the m_leftShooterLead controller’s direction.*

    /* Shoter controllers to shooter fuel */
    public SparkMax m_leftShooterLead= new SparkMax(ShooterConstants.kLeftShooterConstant, MotorType.kBrushless);
    public SparkMax m_rightShooterFollow = new SparkMax(ShooterConstants.kRightShooterConstant, MotorType.kBrushless);


    //*TODO figure out direction of motors relative to direction of current. */
    public void setShooterMotorsPower(Double power)  {
        /*power left lead motor, right motor will 
        follow if set correctly in REV hardware correctly */
        m_leftShooterLead.set(1);
       
    }
        public void StopMotors()  {
        /*Stop shooter motors.*/
        m_leftShooterLead.set(0);
        m_leftShooterLead.stopMotor();
       
    }
}
