package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;



public class ClimbSubsystem extends SubsystemBase {
    private DoubleSolenoid[] s_climbSolenoid = new DoubleSolenoid[]//assume 2 solenoids can add more or less
    { new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ClimbConstants.kSolenoidPins[0], ClimbConstants.kSolenoidPins[1]),
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ClimbConstants.kSolenoidPins[2], ClimbConstants.kSolenoidPins[3]) };


// Initialize the DoubleSolenoids so it knows where to start.  Not required for single solenoids.
public ClimbSubsystem(){
for (DoubleSolenoid solenoid : s_climbSolenoid) {
  solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

public void ToggleSolenoid() {
        for (DoubleSolenoid solenoid : s_climbSolenoid) {
            solenoid.toggle();  
            }
                }
    }
    // DoubleSolenoid exampleDouble = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2); example setips
//exampleDouble.set(kReverse);