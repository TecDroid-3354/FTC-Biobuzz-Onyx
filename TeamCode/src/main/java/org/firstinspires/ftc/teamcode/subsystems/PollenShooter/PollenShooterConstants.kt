package org.firstinspires.ftc.teamcode.subsystems.PollenShooter

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor

object PollenShooterConstants {

    object identification {
        val pollenShooterMotorId = "pollenShooterMotor"
    }

    object configuration {
        val isPollenShooterMotorInverted = false //Update later pls
        val PollenShooterMotorMode = Motor.RunMode.VelocityControl //Change mode to RawPower after testing
        val pollenShooterMotorZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
    }

    @Configurable

    object Tunables {
        @JvmField
        var pidCoefficients = PIDCoefficients(1.0, 0.0, 0.0) //NEED TO UPDATE
        @JvmField
        var feedforward = SimpleMotorFeedforward(0.0,15.5) //NEED TO UPDATE
    }

}