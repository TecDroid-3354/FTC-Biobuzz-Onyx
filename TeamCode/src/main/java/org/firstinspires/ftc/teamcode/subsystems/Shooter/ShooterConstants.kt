package org.firstinspires.ftc.teamcode.subsystems.Shooter

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor

object ShooterConstants {

    object identification {
        val shooterMotor1Id = "shooterMotor1"
        val shooterMotor2Id = "shooterMotor2"
    }

    object configuration {
        val isShooterMotor1Inverted = false //Update later pls
        val shooterMotor1Mode = Motor.RunMode.VelocityControl //Change mode to RawPower after testing
        val shooterMotor1ZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
        val isShooterMotor2Inverted = true //Update later pls
        val shooterMotor2Mode = Motor.RunMode.VelocityControl //Change mode to RawPower after testing
        val shooterMotor2ZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
    }

    @Configurable

    object Tunables {
        @JvmField
        var pidCoefficients = PIDCoefficients(1.0, 0.0, 0.0) //NEED TO UPDATE
        @JvmField
        var feedforward = SimpleMotorFeedforward(0.0,15.5) //NEED TO UPDATE
    }

}