package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Indexer(hardwareMap: HardwareMap) {

    private val leftIndServo : CRServoEx
    private val rightIndServo : CRServoEx


    init {
        leftIndServo = CRServoEx(hardwareMap, IndexerConstants.identification.leftIndServoId)
        rightIndServo = CRServoEx(hardwareMap, IndexerConstants.identification.rightIndServoId)

        leftIndServo.setInverted(IndexerConstants.configuration.isLeftIndServoInverted)
        leftIndServo.setRunMode(IndexerConstants.configuration.leftIndServoMode)
        leftIndServo.setPIDF(IndexerConstants.configuration.PIDF)

        rightIndServo.setInverted(IndexerConstants.configuration.isRightIndServoInverted)
        rightIndServo.setRunMode(IndexerConstants.configuration.rightIndServoMode)
        rightIndServo.setPIDF(IndexerConstants.configuration.PIDF)
    }

    private fun enableIndexer () {
        leftIndServo.set(1.0)
        rightIndServo.set(1.0)
    }

    private fun disableIndexer () {
        leftIndServo.set(0.0)
        rightIndServo.set(0.0)
    }

    private fun reverseIndexer () {
        leftIndServo.set(-1.0)
        rightIndServo.set(-1.0)
    }

    fun enableIndexerCMD(): Command {
        return InstantCommand({enableIndexer()})
    }
    fun disableIndexerCMD(): Command {
        return InstantCommand({disableIndexer()})
    }

    fun reverseIndexerCMD(): Command {
        return InstantCommand({reverseIndexer()})
    }

    fun testRightCMD() : Command {
        return InstantCommand(
            {rightIndServo.set(1.0)}
        )
    }

    fun testLeftCMD() : Command {
        return InstantCommand(
            {leftIndServo.set(1.0)}
        )
    }
    fun inverseTestRightCMD() : Command {
        return InstantCommand(
            {rightIndServo.set(-1.0)}
        )
    }

    fun inverseTestLeftCMD() : Command {
        return InstantCommand(
            {leftIndServo.set(-1.0)}
        )
    }
}