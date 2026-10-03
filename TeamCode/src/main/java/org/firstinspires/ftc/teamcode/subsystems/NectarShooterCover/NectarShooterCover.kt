package org.firstinspires.ftc.teamcode.subsystems.NectarShooterCover

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx
import org.firstinspires.ftc.teamcode.subsystems.PollenShooterCover.PollenShooterCoverConstants

class NectarShooterCover (hardwareMap: HardwareMap) {

    private var nectarShooterCover: ServoEx

    init {
        nectarShooterCover =
            ServoEx(hardwareMap, NectarShooterCoverConstants.identification.nectarShooterCoverId)

        nectarShooterCover.setInverted(NectarShooterCoverConstants.configuration.isNectarShooterCoverInverted)
    }

    fun openNectarShooterFlicker() {
        nectarShooterCover.set(90.0)
    }

    fun closeNectarShooterFlicker() {
        nectarShooterCover.set(0.0)
    }


    fun openNectarShooterFlickerCMD(): Command {
        return InstantCommand({openNectarShooterFlicker()})
    }

    fun closeNectarShooterFlickerCMD(): Command {
        return InstantCommand({closeNectarShooterFlicker()})
    }
}