package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ConveyorConstants;

public class ConveyorSubsystem extends SubsystemBase {

private boolean isSpinning = false;

 private WPI_VictorSPX m_motorLeader = new WPI_VictorSPX(ConveyorConstants.kLeadMotorPort);

public ConveyorSubsystem(){
}

public void ToggleConveyor() {
    System.out.println("THE MOTOR is going to be TOGGLED NEW STATE: " + isSpinning);
    isSpinning = !isSpinning;
    System.out.println("THE MOTOR HAS BEEN TOGGLED NEW STATE: " + isSpinning);

    if(isSpinning) StartSpinning();
    else StopSpinning();

}

public void StartSpinning()
{
    System.out.println("THE MOTOR HAS BEEN STARTED");
    m_motorLeader.set(ConveyorConstants.kMotorSpeed);
}

public void StopSpinning()
{
    isSpinning = false;
    m_motorLeader.set(0);
    System.out.println("THE MOTOR HAS BEEN STOPPED");
}
}

