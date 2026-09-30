package org.firstinspires.ftc.teamcode.subsystems.FlowerHood

import androidx.core.math.MathUtils
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx
import com.seattlesolvers.solverslib.util.InterpLUT

class FlowerHood (hardwareMap: HardwareMap) {

    private var flowerHoodServo1: ServoEx

    private var flowerHoodServo2: ServoEx

    init {
        flowerHoodServo1 = ServoEx(hardwareMap, FlowerHoodConstants.Identification.flowerhoodServo1Id)

        flowerHoodServo2 = ServoEx(hardwareMap, FlowerHoodConstants.Identification.flowerhoodServo2Id)

        flowerHoodServo1.setInverted(FlowerHoodConstants.Configuration.isFlowerHoodServo1Inverted)

        flowerHoodServo2.setInverted(FlowerHoodConstants.Configuration.isFlowerHoodServo2Inverted)
    }

    fun closed() {
        flowerHoodServo1.set(FlowerHoodConstants.HoodPosition.minPosition)
        flowerHoodServo2.set(FlowerHoodConstants.HoodPosition.minPosition)
    }

    fun open() {
        flowerHoodServo1.set(FlowerHoodConstants.HoodPosition.maxPosition)
        flowerHoodServo2.set(FlowerHoodConstants.HoodPosition.maxPosition)
    }

    fun closedCMD(): Command {
        return InstantCommand({closed()})
    }

    fun openCMD (): Command {
        return InstantCommand({open()})
    }
}