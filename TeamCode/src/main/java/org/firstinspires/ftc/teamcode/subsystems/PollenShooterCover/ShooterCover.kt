package org.firstinspires.ftc.teamcode.subsystems.PollenShooterCover

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx

class ShooterCover(hardwareMap: HardwareMap) {

    private var shooterCover: ServoEx

    init {
        shooterCover =
            ServoEx(hardwareMap, ShooterCoverConstants.identification.shooterCoverId)

        shooterCover.setInverted(ShooterCoverConstants.configuration.isShooterCoverInverted)
    }

    fun openShooterCover() {
        shooterCover.set(90.0)
    }

    fun closeShooterCover() {
        shooterCover.set(0.0)
    }


    fun openShooterCoverCMD(): Command {
        return InstantCommand({openShooterCover()})
    }

    fun closeShooterCoverCMD(): Command {
        return InstantCommand({closeShooterCover()})
    }
}