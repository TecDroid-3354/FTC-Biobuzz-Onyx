package org.firstinspires.ftc.teamcode.subsystems.Feeder

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.hardware.motors.MotorEx

class Feeder (hardwareMap: HardwareMap) {

    private val feeder: MotorEx

    init {
        feeder = MotorEx(hardwareMap, "")
    }

}