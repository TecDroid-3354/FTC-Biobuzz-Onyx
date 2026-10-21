package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Indexer(hardwareMap: HardwareMap) {
    private val indexerMotor : MotorEx


    init {
        indexerMotor = MotorEx(hardwareMap, IndexerConstants.identification.indexerMotorId)

        indexerMotor.setInverted(IndexerConstants.configuration.isIndexMotorInverted)
        indexerMotor.setRunMode(IndexerConstants.configuration.indexMotorMode)
        indexerMotor.setZeroPowerBehavior(IndexerConstants.configuration.indexMotorZeroBeheavior)
    }

    fun enableIndexer () {
        indexerMotor.set(1.0)
    }

    fun disableIndexer () {
        indexerMotor.set(0.0)
    }

    fun reverseIndexer () {
        indexerMotor.set(-1.0)
    }

<<<<<<< HEAD
    fun enableIndexerCMD (): Command {
        return InstantCommand({enableIndexer()})
    }

    fun disableIndexerCMD (): Command {
        return InstantCommand({disableIndexer()})
    }

    fun reverseIndexerCMD (): Command {
=======
    fun enableIndexerCMD(): Command {
        return InstantCommand({enableIndexer()})
    }
    fun disableIndexerCMD(): Command {
        return InstantCommand({disableIndexer()})
    }

    fun reverseIntakeCMD(): Command {
>>>>>>> 34ccf0f4f77a138c91f6bef2a0379ae4aa723d2c
        return InstantCommand({reverseIndexer()})
    }
}