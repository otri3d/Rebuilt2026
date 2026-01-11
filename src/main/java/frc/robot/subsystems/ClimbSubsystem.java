package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {
  // DoubleSolenoid ds = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
  // ClimbConstants.kSolenoidPins[0],
  // ClimbConstants.kSolenoidPins[1]);

  // assume 2 solenoids can add more or less
  private DoubleSolenoid[] s_climbSolenoid = new DoubleSolenoid[] {
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ClimbConstants.kSolenoidPins[0],
          ClimbConstants.kSolenoidPins[1]),
      new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ClimbConstants.kSolenoidPins[2],
          ClimbConstants.kSolenoidPins[3]) };

  // Initialize the DoubleSolenoids so it knows where to start. Not required for
  // single solenoids.
  public ClimbSubsystem() {
    // ds.set(DoubleSolenoid.Value.kReverse);
    for (DoubleSolenoid solenoid : s_climbSolenoid) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }

  public void ToggleSolenoid() {
    // ds.toggle();
    for (DoubleSolenoid solenoid : s_climbSolenoid) {
      solenoid.toggle();
      System.out.print(solenoid.get());
    }
    System.out.println();
  }
}
// DoubleSolenoid exampleDouble = new
// DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2); example setips
// exampleDouble.set(kReverse);
