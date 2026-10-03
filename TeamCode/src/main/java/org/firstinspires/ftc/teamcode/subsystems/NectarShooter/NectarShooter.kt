package org.firstinspires.ftc.teamcode.subsystems.NectarShooter

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.RunCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity

class NectarShooter (hardwareMap: HardwareMap) {

    private val nectarShooterMotor : MotorEx

    init {
        nectarShooterMotor = MotorEx(hardwareMap, NectarShooterConstants.identification.nectarShooterMotorId)

        nectarShooterMotor.setInverted(NectarShooterConstants.configuration.isNectarShooterMotorInverted)
        nectarShooterMotor.setRunMode(NectarShooterConstants.configuration.NectarShooterMotorMode)
        nectarShooterMotor.setZeroPowerBehavior(NectarShooterConstants.configuration.NectarShooterMotorZeroBeheavior)
    }

    fun shootNectar () {
        nectarShooterMotor.velocity = 28 * 5000.0
    }

    fun calibrateNectarShooter(velocity: AngularVelocity) {
        nectarShooterMotor.velocity = velocity.rps * 28
    }

    fun stopNectarShooter() {
        nectarShooterMotor.set(0.0)
    }
    //this will not have CMD because we are going to return the shooter's velocity to print it
    fun getNectarVelocity(): AngularVelocity {
        return AngularVelocity.fromRps(nectarShooterMotor.velocity/28)//Change formula to solve gear ratio
    }


    fun shootNectarCMD(): Command {
        return InstantCommand({shootNectar()})
    }

    fun setNectarShooterVelocityCMD(velocity: AngularVelocity): Command {
        return RunCommand({calibrateNectarShooter(velocity)})
    }

    fun stopNectarShooterCMD(): Command {
        return InstantCommand({stopNectarShooter()})
    }


}