package org.firstinspires.ftc.teamcode.subsystems.NectarShooter

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor

object NectarShooterConstants {

    object identification {
        val nectarShooterMotorId = "nectarShooterMotor"
    }

    object configuration {
        val isNectarShooterMotorInverted = false //Update later pls
        val NectarShooterMotorMode = Motor.RunMode.VelocityControl //Change mode to RawPower after testing
        val NectarShooterMotorZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
    }

    @Configurable

    object Tunables {
        @JvmField
        var pidCoefficients = PIDCoefficients(1.0, 0.0, 0.0) //NEED TO UPDATE
        @JvmField
        var feedforward = SimpleMotorFeedforward(0.0,15.5) //NEED TO UPDATE
    }

}