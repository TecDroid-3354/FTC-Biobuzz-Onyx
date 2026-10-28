package org.firstinspires.ftc.teamcode.subsystems.Feeder

import com.seattlesolvers.solverslib.hardware.motors.Motor

object FeederConstants {

    object identification {
        val feederMotorId = "feederMotor"
    }

    object configuration {
        val isFeederMotorInverted = false
        val feederMotorMode = Motor.RunMode.RawPower
        val feederMotorZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
    }

}