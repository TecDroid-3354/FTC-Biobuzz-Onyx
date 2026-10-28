package org.firstinspires.ftc.teamcode.subsystems.Feeder

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Feeder (hardwareMap: HardwareMap) {

    private val feederMotor: MotorEx

    init {
        feederMotor = MotorEx(hardwareMap, FeederConstants.identification.feederMotorId)

        feederMotor.setInverted(FeederConstants.configuration.isFeederMotorInverted)
        feederMotor.setRunMode(FeederConstants.configuration.feederMotorMode)
        feederMotor.setZeroPowerBehavior(FeederConstants.configuration.feederMotorZeroBeheavior)
    }

    fun feed () {
        feederMotor.set(1.0)
    }

    fun remove () {
        feederMotor.set(-1.0)
    }

    fun stopFeeding () {
        feederMotor.set(0.0)
    }

    fun feedCMD (): Command {
        return InstantCommand({feed()})
    }

    fun removeCMD (): Command {
        return InstantCommand({remove()})
    }

    fun stopFeedingCMD ():Command {
        return InstantCommand({stopFeeding()})
    }

}