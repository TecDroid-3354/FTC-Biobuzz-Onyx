package org.firstinspires.ftc.teamcode.subsystems.Shooter

import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.RunCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import com.seattlesolvers.solverslib.util.InterpLUT
import com.seattlesolvers.solverslib.util.get
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.units.Distance

class Shooter (hardwareMap: HardwareMap) {

    private val shooterMotor1: MotorEx
    private val shooterMotor2: MotorEx

    private val interpolation: InterpLUT


    init {
        shooterMotor1 = MotorEx(hardwareMap, ShooterConstants.identification.shooterMotor1Id)
        shooterMotor2 = MotorEx(hardwareMap, ShooterConstants.identification.shooterMotor2Id)

        shooterMotor1.setInverted(ShooterConstants.configuration.isShooterMotor1Inverted)
        shooterMotor1.setRunMode(ShooterConstants.configuration.shooterMotor1Mode)
        shooterMotor1.setZeroPowerBehavior(ShooterConstants.configuration.shooterMotor1ZeroBeheavior)

        shooterMotor2.setInverted(ShooterConstants.configuration.isShooterMotor2Inverted)
        shooterMotor2.setRunMode(ShooterConstants.configuration.shooterMotor2Mode)
        shooterMotor2.setZeroPowerBehavior(ShooterConstants.configuration.shooterMotor2ZeroBeheavior)

        interpolation = InterpLUT()


        interpolation.add(0.0,5.0)
        interpolation.add(1.0,6.0)
        interpolation.add(2.0,7.0)
        interpolation.add(3.0,8.0)
        interpolation.add(4.0,9.0)
        interpolation.add(5.0,10.0)
        interpolation.add(6.0,11.0)
        interpolation.add(7.0,12.0)
        interpolation.add(8.0,13.0)
        interpolation.add(9.0,14.0)
        interpolation.add(10.0,15.0)

        interpolation.createLUT()
    }

    fun shoot () {
        shooterMotor1.velocity = 28 * 5000.0
        shooterMotor2.velocity = 28 * 5000.0
    }

    fun shootWithLimelight (distance: Double) {
        shooterMotor1.setVelocity(interpolation.get(distance))
        shooterMotor2.setVelocity(interpolation.get(distance))
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
        return InstantCommand({shoot()})
    }

    fun setShooterVelocityCMD(velocity: AngularVelocity): Command {
        return RunCommand({calibrateShooter(velocity)})
    }

    fun stopShooterCMD(): Command {
        return InstantCommand({stopShooter()})
    }

    fun shootWithLimelightCMD(distance: Double): Command {
        return InstantCommand({shootWithLimelight(distance)})
    }


}