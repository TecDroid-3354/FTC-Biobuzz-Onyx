package org.firstinspires.ftc.teamcode.subsystems.PollenShooterCover

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx

class PollenShooterCover(hardwareMap: HardwareMap) {

    private var pollenShooterCover: ServoEx

    init {
        pollenShooterCover =
            ServoEx(hardwareMap, PollenShooterCoverConstants.identification.pollenShooterCoverId)

        pollenShooterCover.setInverted(PollenShooterCoverConstants.configuration.isPollenShooterCoverInverted)
    }

    fun openPollenShooterCover() {
        pollenShooterCover.set(90.0)
    }

    fun closePollenShooterCover() {
        pollenShooterCover.set(0.0)
    }


    fun openPollenShooterCoverCMD(): Command {
        return InstantCommand({openPollenShooterCover()})
    }

    fun closePollenShooterCoverCMD(): Command {
        return InstantCommand({closePollenShooterCover()})
    }
}