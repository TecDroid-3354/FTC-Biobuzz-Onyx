package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Indexer(hardwareMap: HardwareMap) {
    private val indexerMotor: MotorEx

    private val leftIndServo: CRServoEx
    private val rightIndServo : CRServoEx


    init {
        indexerMotor = MotorEx(hardwareMap, IndexerConstants.identification.indexerMotorId)
        leftIndServo = CRServoEx(hardwareMap, IndexerConstants.identification.leftIndServoId)
        rightIndServo = CRServoEx(hardwareMap, IndexerConstants.identification.rightIndServoId)

        indexerMotor.setInverted(IndexerConstants.configuration.isIndexMotorInverted)
        indexerMotor.setRunMode(IndexerConstants.configuration.indexMotorMode)
        indexerMotor.setZeroPowerBehavior(IndexerConstants.configuration.indexMotorZeroBeheavior)

        leftIndServo.setInverted(IndexerConstants.configuration.isLeftIndServoInverted)
        leftIndServo.setRunMode(IndexerConstants.configuration.leftIndServoMode)

        rightIndServo.setInverted(IndexerConstants.configuration.isRightIndServoInverted)
        rightIndServo.setRunMode(IndexerConstants.configuration.rightIndServoMode)
    }

    fun enableIndexer() {
        indexerMotor.set(1.0)
        leftIndServo.set(1.0)
        rightIndServo.set(1.0)
    }

    fun disableIndexer() {
        indexerMotor.set(0.0)
        leftIndServo.set(0.0)
        rightIndServo.set(0.0)
    }

    fun reverseIndexer() {
        indexerMotor.set(-1.0)
        leftIndServo.set(-1.0)
        rightIndServo.set(-1.0)
    }

    fun enableIndexerCMD(): Command {
        return InstantCommand({ enableIndexer() })
    }

    fun disableIndexerCMD(): Command {
        return InstantCommand({ disableIndexer() })
    }

    fun reverseIntakeCMD(): Command {
        return InstantCommand({ reverseIndexer() })
    }
}