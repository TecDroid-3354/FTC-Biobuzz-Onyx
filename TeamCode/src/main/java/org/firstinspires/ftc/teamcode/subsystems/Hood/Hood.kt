//package org.firstinspires.ftc.teamcode.subsystems.Hood
//
//import com.qualcomm.robotcore.hardware.HardwareMap
//import com.seattlesolvers.solverslib.command.Command
//import com.seattlesolvers.solverslib.command.InstantCommand
//import com.seattlesolvers.solverslib.hardware.servos.ServoEx
//import com.seattlesolvers.solverslib.util.InterpLUT
//import org.firstinspires.ftc.teamcode.utils.units.Angle
//
//
//class Hood(hardwareMap: HardwareMap) {
//
//    private val leftHoodServo: ServoEx
//
//    private val rightHoodServo: ServoEx
//    val interpolation = InterpLUT()
//    var distance = 10.0
//
//    init {
//        leftHoodServo = ServoEx(hardwareMap, HoodConstants.Identification.leftHoodServoId)
//        rightHoodServo = ServoEx(hardwareMap, HoodConstants.Identification.rightHoodServoId)
//
//        leftHoodServo.setInverted(HoodConstants.Configuration.isLeftHoodServoInverted)
//        rightHoodServo.setInverted(HoodConstants.Configuration.isRightHoodServoInverted)
//
//    }
//    fun getHoodsAngle (): Angle {
//        return Angle.fromDegrees(((leftHoodServo.get())+(rightHoodServo.get()))/2)
//    }
//
//    fun setManualPosition () {
//        leftHoodServo.set(HoodConstants.Tunables.manualPosition)
//        rightHoodServo.set(HoodConstants.Tunables.manualPosition)
//    }
//
//    fun moveHoodDownPosition() {
//        leftHoodServo.set(HoodConstants.PhysicalLimits.minAngle)
//        rightHoodServo.set(HoodConstants.PhysicalLimits.minAngle)
//    }
//
//    fun moveHoodDownPositionCMD(): Command{
//        return InstantCommand({moveHoodDownPosition()})
//    }
//
//    fun setManualPositionCMD(): Command {
//        return InstantCommand({setManualPosition()})
//    }
//}
