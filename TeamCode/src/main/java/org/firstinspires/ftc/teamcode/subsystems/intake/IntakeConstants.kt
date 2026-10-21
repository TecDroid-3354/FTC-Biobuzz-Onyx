package org.firstinspires.ftc.teamcode.subsystems.Intake

import com.seattlesolvers.solverslib.hardware.motors.Motor

object IntakeConstants {

    object identification {
        val intakeMotorId = "intakeMotor"
    }
    
    object configuration{
        val isInMotorInverted = false
        val inMotorMode = Motor.RunMode.RawPower
        val inMotorZeroBeheaviour = Motor.ZeroPowerBehavior.FLOAT
    }
}
