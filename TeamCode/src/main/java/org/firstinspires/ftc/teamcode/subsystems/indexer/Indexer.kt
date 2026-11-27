package org.firstinspires.ftc.teamcode.subsystems.Indexer

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.CRServoEx
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.utils.devices.OpServoEx

class Indexer(hardwareMap: HardwareMap) {

    private val leftIndServo : OpServoEx
    private val rightIndServo : OpServoEx


    init {
        leftIndServo = OpServoEx(hardwareMap, IndexerConstants.identification.leftIndServoId)
        rightIndServo = OpServoEx(hardwareMap, IndexerConstants.identification.rightIndServoId)

        leftIndServo.applyConfiguration(IndexerConstants.configuration.leftServoConfig)
        rightIndServo.applyConfiguration(IndexerConstants.configuration.rightServoConfig)

    }

    fun enableIndexer () {
        leftIndServo.setContinuousRotationOutput(-1.0)
        rightIndServo.setContinuousRotationOutput(-1.0)
    }

    fun disableIndexer () {
        leftIndServo.setContinuousRotationOutput(0.0)
        rightIndServo.setContinuousRotationOutput(0.0)
    }

    fun reverseIndexer () {
        leftIndServo.setContinuousRotationOutput(0.0)
        rightIndServo.setContinuousRotationOutput(0.0)
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
}