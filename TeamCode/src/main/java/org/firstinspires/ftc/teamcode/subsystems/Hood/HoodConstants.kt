package org.firstinspires.ftc.teamcode.subsystems.Hood

object HoodConstants {

    object Identification {
        val hoodServoId = "shooterHoodServo"
    }

    object PhysicalLimits {
        val gearRatio = 1/2
        val minAngle = 5.0 * gearRatio
        val maxAngle = 30.0 * gearRatio
    }
    object Configuration {
        val isHoodServoInverted = false
    }
}