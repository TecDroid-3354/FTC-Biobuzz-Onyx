package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.Motor

object IndexerConstants {
    object identification {
        val indexerMotorId = "indexerMotor"
        val leftIndServoId = "leftIndexerServo"
        val rightIndServoId = "rightIndexerServo"
    }

    object configuration {
        val isIndexMotorInverted = false
        val indexMotorMode = Motor.RunMode.RawPower
        val indexMotorZeroBeheavior = Motor.ZeroPowerBehavior.FLOAT

        val isLeftIndServoInverted = true
        val isRightIndServoInverted = false
        val leftIndServoMode = CRServoEx.RunMode.RawPower
        val rightIndServoMode = CRServoEx.RunMode.RawPower
    }
}