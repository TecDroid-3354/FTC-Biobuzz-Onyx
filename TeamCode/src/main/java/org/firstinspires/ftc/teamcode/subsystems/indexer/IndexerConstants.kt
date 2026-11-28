package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.qualcomm.robotcore.hardware.PIDCoefficients
import com.qualcomm.robotcore.hardware.PIDFCoefficients
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
        val PIDF = PIDFCoefficients(1.0, 0.0, 0.001, 1.0)

        val isRightIndServoInverted = false
        val rightIndServoMode = CRServoEx.RunMode.RawPower
    }
}