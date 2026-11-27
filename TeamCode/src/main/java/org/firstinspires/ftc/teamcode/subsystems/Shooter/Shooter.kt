package org.firstinspires.ftc.teamcode.subsystems.Shooter

import androidx.core.util.Supplier
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.RunCommand
import com.seattlesolvers.solverslib.hardware.motors.MotorEx
import com.seattlesolvers.solverslib.util.InterpLUT
import com.seattlesolvers.solverslib.util.get
import org.firstinspires.ftc.teamcode.utils.devices.OpMotorEx
import org.firstinspires.ftc.teamcode.utils.units.AngularVelocity
import org.firstinspires.ftc.teamcode.utils.units.Distance

class Shooter (hardwareMap: HardwareMap) {

    private lateinit var shooterMotor1: OpMotorEx
    private lateinit var shooterMotor2: OpMotorEx


    init {
        shooterMotor1 = OpMotorEx(hardwareMap, ShooterConstants.identification.shooterMotor1Id)
        shooterMotor2 = OpMotorEx(hardwareMap, ShooterConstants.identification.shooterMotor2Id)

        shooterMotor1.applyConfigurationAndResetEncoder(ShooterConstants.configuration.confShooter1)

        shooterMotor2.applyConfigurationAndResetEncoder(ShooterConstants.configuration.confShooter2)
    }


    private fun stopShooter() {
        shooterMotor1.setVelocity(AngularVelocity.fromRpm(0.0))
        shooterMotor2.setVelocity(AngularVelocity.fromRpm(0.0))
    }

    private fun shootWithManualRPM () {
        shooterMotor1.setVelocity(ShooterConstants.Tunables.manualRPM)
    }


    private fun getShooterSpeed() : AngularVelocity{
        return shooterMotor1.getVelocity().get()
    }

    fun isShooterAtTargetSpeed() : Boolean {
        if(getShooterSpeed() >= ShooterConstants.Tunables.manualRPM){
            return true
        }else{
            return false
        }
    }
    fun shootWithManualRpmCMD (): Command {
        return InstantCommand({shootWithManualRPM()})
    }
    fun stopShooterCMD(): Command {
        return InstantCommand({stopShooter()})
    }


}