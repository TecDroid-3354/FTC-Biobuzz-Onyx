package org.firstinspires.ftc.teamcode.subsystems.Shooter

import com.bylazar.configurables.annotations.Configurable
import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.seattlesolvers.solverslib.controller.wpilibcontroller.SimpleMotorFeedforward
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.configurations.OpMotorExConfiguration
import org.firstinspires.ftc.teamcode.utils.devices.configurations.genericConfigurations.GenericMotorConfiguration
import org.firstinspires.ftc.teamcode.utils.devices.configurations.motorControlModeConfiguration.MotorVelocityModeConfiguration
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity

object ShooterConstants {

    object identification {
        val shooterMotor1Id = "shooterMotor1"
        val shooterMotor2Id = "shooterMotor2"
    }

    object configuration {
        private val isShooterMotor1Inverted = false //Update later pls
        private val shooterMotor1ZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT
        private val isShooterMotor2Inverted = true //Update later pls
        private val shooterMotor2ZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT

        private val genericConfigShooter1 = GenericMotorConfiguration()
            .withInverted(isShooterMotor1Inverted)
            .withZeroPowerBehavior(shooterMotor1ZeroBeheavior)

        private  val genericConfigShooter2 = GenericMotorConfiguration()
            .withInverted(isShooterMotor2Inverted)
            .withZeroPowerBehavior(shooterMotor2ZeroBeheavior)


        private val controlConf = MotorVelocityModeConfiguration()
            .withVelocityCoefficients(Tunables.pidCoefficients)
            .withFeedforwardCoefficients(Tunables.feedforward)

        val confShooter1 = OpMotorExConfiguration(genericConfigShooter1, controlConf)
        val confShooter2 = OpMotorExConfiguration(genericConfigShooter2, controlConf)
    }

    @Configurable

    object Tunables {
        @JvmField
        var pidCoefficients = PIDCoefficients(1.0, 0.0, 0.02)
        @JvmField
        var feedforward = SimpleMotorFeedforward(1.0,0.0)
        var manualRPM = AngularVelocity.fromRpm(4500.0)
    }

}