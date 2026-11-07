import androidx.core.math.MathUtils
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.hardware.servos.ServoEx
import com.seattlesolvers.solverslib.util.InterpLUT
import org.firstinspires.ftc.teamcode.subsystems.Hood.HoodConstants


class Hood(hardwareMap: HardwareMap) {

    private val hoodServo: ServoEx
    val interpolation = InterpLUT()
    var distance = 10.0

    init {
        hoodServo = ServoEx(hardwareMap, HoodConstants.Identification.hoodServoId)

        hoodServo.setInverted(HoodConstants.Configuration.isHoodServoInverted)

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
    fun moveHoodToPosition() {
        distance = 10.0

        var targetPosition = interpolation.get(distance)

        targetPosition = targetPosition * HoodConstants.PhysicalLimits.gearRatio

        targetPosition = MathUtils.clamp(targetPosition, HoodConstants.PhysicalLimits.minAngle,
            HoodConstants.PhysicalLimits.maxAngle)

        hoodServo.set(targetPosition)
    }

    fun moveHoodToPositionCMD(): Command {
        return InstantCommand({moveHoodDownPosition()})

    }
        fun moveHoodDownPosition() {
            hoodServo.set(HoodConstants.PhysicalLimits.minAngle)
        }

    fun moveHoodDownPositionCMD(): Command{
        return InstantCommand({moveHoodDownPosition()})
    }
}
