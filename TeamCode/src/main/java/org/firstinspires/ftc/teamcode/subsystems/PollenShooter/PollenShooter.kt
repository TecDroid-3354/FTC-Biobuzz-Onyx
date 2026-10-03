package org.firstinspires.ftc.teamcode.subsystems.PollenShooter

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.RunCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity

class PollenShooter (hardwareMap: HardwareMap) {

    private val pollenShooterMotor: MotorEx

    init {
        pollenShooterMotor = MotorEx(hardwareMap, PollenShooterConstants.identification.pollenShooterMotorId)

        pollenShooterMotor.setInverted(PollenShooterConstants.configuration.isPollenShooterMotorInverted)
        pollenShooterMotor.setRunMode(PollenShooterConstants.configuration.PollenShooterMotorMode)
        pollenShooterMotor.setZeroPowerBehavior(PollenShooterConstants.configuration.pollenShooterMotorZeroBeheavior)
    }

    fun shootPollen () {
        pollenShooterMotor.velocity = 28 * 5000.0
    }

    fun calibratePollenShooter(velocity: AngularVelocity) {
        pollenShooterMotor.velocity = velocity.rps * 28
    }

    fun stopPollenShooter() {
        pollenShooterMotor.set(0.0)
    }
    //this will not have CMD because we are going to return the shooter's velocity to print it
    fun getPollenVelocity(): AngularVelocity {
        return AngularVelocity.fromRps(pollenShooterMotor.velocity/28)//Change formula to solve gear ratio
    }


    fun shootPollenCMD(): Command {
        return InstantCommand({shootPollen()})
    }

    fun setPollenShooterVelocityCMD(velocity: AngularVelocity): Command {
        return RunCommand({calibratePollenShooter(velocity)})
    }

    fun stopPollenShooterCMD(): Command {
        return InstantCommand({stopPollenShooter()})
    }


}