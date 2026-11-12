package org.firstinspires.ftc.teamcode.subsystems.Vision

import org.firstinspires.ftc.teamcode.utils.units.Angle
import org.firstinspires.ftc.teamcode.utils.units.Distance

object LimelightConstants {

    object Identification {
        val limelightId = "limelight"
    }

    object Configuration {
        val polRateHZ = 200
        val aprilTagPipeline = 0
        val stalenessThreshold = 100
    }

    object Mecanical {
        val pitch = Angle.fromDegrees(40.0)
        val limelightHeight = Distance.fromInches(6.086)

        val aprilTagHeight = Distance.fromInches(49.36)
    }

}