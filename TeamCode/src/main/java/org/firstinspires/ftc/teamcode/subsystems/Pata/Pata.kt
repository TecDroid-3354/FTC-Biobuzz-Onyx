package org.firstinspires.ftc.teamcode.subsystems.Pata

import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.Servo
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx

class Pata(hardwareMap: HardwareMap) {

    private var leftPataServo = ServoEx(hardwareMap, PataConstants.identification.leftPataServoId)
    private var rightPataServo = ServoEx(hardwareMap, PataConstants.identification.rightPataServoId)

    init {
        leftPataServo.setInverted(PataConstants.configuration.isLeftPataServoInverted)
        rightPataServo.setInverted(PataConstants.configuration.isRightPataServoInverted)
    }

    fun lowerPata () {
        leftPataServo.set(90.0)
        rightPataServo.set(90.0)
    }

    fun risePata () {
        leftPataServo.set(0.0)
        rightPataServo.set(0.0)
    }

    fun lowerPataCMD (): Command {
        return InstantCommand({lowerPata()})
    }

    fun risePataCMD (): Command {
        return InstantCommand({risePata()})
    }

}