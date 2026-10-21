package org.firstinspires.ftc.teamcode.subsystems.Shooter

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.RunCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity

class Shooter (hardwareMap: HardwareMap) {

    private val shooterMotor1: MotorEx
    private val shooterMotor2: MotorEx


    init {
        shooterMotor1 = MotorEx(hardwareMap, ShooterConstants.identification.shooterMotor1Id)
        shooterMotor2 = MotorEx(hardwareMap, ShooterConstants.identification.shooterMotor2Id)

        shooterMotor1.setInverted(ShooterConstants.configuration.isShooterMotor1Inverted)
        shooterMotor1.setRunMode(ShooterConstants.configuration.shooterMotor1Mode)
        shooterMotor1.setZeroPowerBehavior(ShooterConstants.configuration.shooterMotor1ZeroBeheavior)

        shooterMotor2.setInverted(ShooterConstants.configuration.isShooterMotor2Inverted)
        shooterMotor2.setRunMode(ShooterConstants.configuration.shooterMotor2Mode)
        shooterMotor2.setZeroPowerBehavior(ShooterConstants.configuration.shooterMotor2ZeroBeheavior)
    }

    fun shootPollen () {
        shooterMotor1.velocity = 28 * 5000.0
        shooterMotor2.velocity = 28 * 5000.0
    }

    fun calibrateShooter(velocity: AngularVelocity) {
        shooterMotor1.velocity = velocity.rps * 28
        shooterMotor2.velocity = velocity.rps * 28
    }

    fun stopShooter() {
        shooterMotor1.set(0.0)
        shooterMotor2.set(0.0)
    }
    //this will not have CMD because we are going to return the shooter's velocity to print it
    fun getShooterMotor1Velocity(): AngularVelocity {
        return AngularVelocity.fromRps(shooterMotor1.velocity/28)//Change formula to solve gear ratio
    }

    //this will not have CMD because we are going to return the shooter's velocity to print it
    fun getShooterMotor2Velocity(): AngularVelocity {
        return AngularVelocity.fromRps(shooterMotor2.velocity/28)//Change formula to solve gear ratio
    }


    fun shootCMD(): Command {
        return InstantCommand({shootPollen()})
    }

    fun setShooterVelocityCMD(velocity: AngularVelocity): Command {
        return RunCommand({calibrateShooter(velocity)})
    }

    fun stopShooterCMD(): Command {
        return InstantCommand({stopShooter()})
    }


}