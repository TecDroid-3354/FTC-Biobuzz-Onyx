package org.firstinspires.ftc.teamcode.subsystems.Hood

object HoodConstants {

    object Identification {
        val leftHoodServoId = "leftHoodServo"
        val rightHoodServoId = "rightHoodServo"
    }

    object PhysicalLimits {
        val gearRatio = 1/2
        val minAngle = 5.0 * gearRatio
        val maxAngle = 30.0 * gearRatio
    }
    object Configuration {
        val isLeftHoodServoInverted = false
        val isRightHoodServoInverted = true
    }
    object Tunables {
        @JvmField
        var manualPosition = 45.0
    }
}