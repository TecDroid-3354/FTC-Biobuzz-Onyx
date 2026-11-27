package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.Motor
import org.firstinspires.ftc.teamcode.utils.devices.configurations.servoControlModeConfiguration.ServoContinuousRotationModeConfiguration

object IndexerConstants {
    object identification {
        val leftIndServoId = "leftIndexerServo"
        val rightIndServoId = "rightIndexerServo"
    }

    object configuration {
        private val isLeftServoInverted = true

        val leftServoConfig = ServoContinuousRotationModeConfiguration()
            .withInverted(isLeftServoInverted)
            .withMaxPower(1.0)

        private val isRightServoInverted = true
        val rightServoConfig = ServoContinuousRotationModeConfiguration()
            .withInverted(isRightServoInverted)
            .withMaxPower(1.0)
    }
}