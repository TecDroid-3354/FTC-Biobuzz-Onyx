package org.firstinspires.ftc.teamcode.subsystems.Intake

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Intake (hardwareMap: HardwareMap) {
    private val intakeMotor: MotorEx

    init {
        intakeMotor = MotorEx(hardwareMap, IntakeConstants.identification.intakeMotorId)
        
        intakeMotor.setRunMode(IntakeConstants.configuration.inMotorMode)
        intakeMotor.setInverted(IntakeConstants.configuration.isInMotorInverted)
        intakeMotor.setZeroPowerBehavior(IntakeConstants.configuration.inMotorZeroBeheaviour)
    }

    fun enableIntake(){
        intakeMotor.set(1.0)
    }
    fun disableIntake(){
        intakeMotor.set(0.0)
    }
    fun reverseIntake(){
        intakeMotor.set(-1.0)
    }
    
fun enableIntakeCMD(): Command {
    return InstantCommand({ enableIntake() })
}
fun disableIntakeCMD(): Command {
    return InstantCommand({ disableIntake() })
    }
    
fun reverseIntakeCMD(): Command {
    return InstantCommand({reverseIntake()})
}
}
