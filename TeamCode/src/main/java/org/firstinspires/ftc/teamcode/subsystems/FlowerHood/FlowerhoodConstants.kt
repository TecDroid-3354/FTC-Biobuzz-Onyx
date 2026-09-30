package org.firstinspires.ftc.teamcode.subsystems.FlowerHood

object FlowerHoodConstants {
    object Identification {
        val flowerhoodServo1Id = "flowerHoodServo1"
        val flowerhoodServo2Id = "flowerHoodServo2"
    }
    object PhysicalLimits {
        val gearRatio = 8.0
        //*cambiar
        val minAngle = 1.0 * gearRatio
        //* cambiar
        val maxAngle = 1.0 * gearRatio
        //* cambiar
    }
    object Configuration {
        val isFlowerHoodServo1Inverted = false
        //* todavia no tenemos esa informacion

        val isFlowerHoodServo2Inverted = false
    }

    object HoodPosition {

        val minPosition = 0.0

        val maxPosition = 90.0


    }
}