package org.firstinspires.ftc.teamcode.subsystems.ShooterHood

object ShooterHoodConstants {

    object Identification {
        val shooterHoodServoId = "shooterHoodServo"
    }

    object PhysicalLimits {
        val gearRatio = 1/2
        val minAngle = 5.0 * gearRatio
        val maxAngle = 30.0 * gearRatio
    }
    object Configuration {
        val isShooterHoodServoInverted = false
    }
}