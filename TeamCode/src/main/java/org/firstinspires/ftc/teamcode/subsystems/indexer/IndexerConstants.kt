package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.Motor

object IndexerConstants {
    object identification {
        val leftIndServoId = "leftIndexerServo"
        val rightIndServoId = "rightIndexerServo"
    }

    object configuration {
        val isLeftIndServoInverted = true
        val leftIndServoMode = CRServoEx.RunMode.RawPower

        val isRightIndServoInverted = false
        val rightIndServoMode = CRServoEx.RunMode.RawPower
    }
}