import androidx.core.math.MathUtils
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx
import com.seattlesolvers.solverslib.util.InterpLUT
import org.firstinspires.ftc.teamcode.subsystems.Hood.HoodConstants
import org.firstinspires.ftc.teamcode.utils.units.Angle
import org.firstinspires.ftc.teamcode.utils.units.Distance


class Hood(hardwareMap: HardwareMap) {

    private val leftHoodServo: ServoEx

    private val rightHoodServo: ServoEx
    val interpolation = InterpLUT()
    var distance = 10.0

    init {
        leftHoodServo = ServoEx(hardwareMap, HoodConstants.Identification.leftHoodServoId)
        rightHoodServo = ServoEx(hardwareMap, HoodConstants.Identification.rightHoodServoId)

        leftHoodServo.setInverted(HoodConstants.Configuration.isLeftHoodServoInverted)
        rightHoodServo.setInverted(HoodConstants.Configuration.isRightHoodServoInverted)

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
        interpolation.add(10.0,60.0)

        interpolation.createLUT()

    }
    fun moveHoodToPosition(distance: Double){
        leftHoodServo.set(interpolation.get(distance))
        rightHoodServo.set(interpolation.get(distance))
    }

    fun getHoodsAngle (): Angle {
        return Angle.fromDegrees(((leftHoodServo.get())+(rightHoodServo.get()))/2)
    }

    fun setManualPosition () {
        leftHoodServo.set(HoodConstants.Tunables.manualPosition)
        rightHoodServo.set(HoodConstants.Tunables.manualPosition)
    }


    fun moveHoodToPositionCMD(distance: Double): Command {
        return InstantCommand({moveHoodToPosition(distance)})

    }
    fun moveHoodDownPosition() {
        leftHoodServo.set(HoodConstants.PhysicalLimits.minAngle)
        rightHoodServo.set(HoodConstants.PhysicalLimits.minAngle)
    }

    fun moveHoodDownPositionCMD(): Command{
        return InstantCommand({moveHoodDownPosition()})
    }

    fun setManualPositionCMD(): Command {
        return InstantCommand({setManualPosition()})
    }
}
