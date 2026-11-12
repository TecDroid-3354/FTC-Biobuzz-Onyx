package org.firstinspires.ftc.teamcode.subsystems.vision

import com.qualcomm.hardware.limelightvision.LLResult
import com.qualcomm.hardware.limelightvision.Limelight3A
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.SubsystemBase
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.subsystems.Vision.LimelightConstants
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.units.Angle
import org.firstinspires.ftc.teamcode.utils.units.Distance
import java.util.function.Supplier
import kotlin.math.tan

class Limelight(
    hardwareMap: HardwareMap,
    val telemetry: Telemetry,
    val rotationSupplier: Supplier<Angle>
) : SubsystemBase() {

    private var limelight: Limelight3A? = null
    var llResult: LLResult? = null

    private var obeliskId = 0

    private var ty = 0.0
    private var tx = 0.0
    private var ta = 0.0

    private var distanceFromLimelightToGoalInches = Distance.fromInches(0.0)

    init {
        limelight = hardwareMap.get(
            Limelight3A::class.java,
            LimelightConstants.Identification.limelightId
        )

        // Retrieves pipeline
        limelight!!.pipelineSwitch(LimelightConstants.Configuration.aprilTagPipeline) // Gets the limelight pipeline
        // How many times per second the limelight receives data in seconds
        limelight!!.setPollRateHz(LimelightConstants.Configuration.polRateHZ)
        // Starts the limelight's readings
        limelight!!.start()
    }

    fun getTx(): Double = tx
    fun getTy(): Double = ty
    fun getTa(): Double = ta

    /**
     * Gets the distance from the limelight lenses to a filtered id and returns the distance in any unit desired
     *  @param filterArray the desired ids for the limelight to follow
     *  @return the distance from the filtered id to the limelight lenses
     */
    fun getDistanceToGoal(filterArray: IntArray): Distance {
        if (llResult!!.isValid && llResult != null) {
            val fiducialResult = llResult!!.fiducialResults

            for (detectedId in fiducialResult) {
                for (id in filterArray) {
                    if (detectedId.fiducialId == id) {
                        return distanceFromLimelightToGoalInches
                    }
                }
            }
        }

        return Distance.fromInches(0.0)
    }


    fun llResultIsValid(): Boolean {
        return llResult != null && llResult!!.isValid
    }

    override fun periodic() {

        // Updating limelights' robot orientation with the Yaw
        limelight!!.updateRobotOrientation(rotationSupplier.get().degrees)

        // LLResult is like a container full of information about what Limelight sees
        llResult = limelight!!.getLatestResult()

        val fiducialResult = llResult!!.fiducialResults

        // Math to calculate distance was taken from documentation:
        // https://docs.limelightvision.io/docs/docs-limelight/tutorials/tutorial-estimating-distance#using-area-to-estimate-distance
        // The condition verifies whether the LimeLight Result is a valid statement
        if (llResult != null && llResult!!.isValid()) {

            // Obelisk ID detection
            // Offset to target in degrees (from crosshair)
            val targetOffsetAngle_Vertical = Angle.fromDegrees(llResult!!.getTy())
            // Needs to be in radians for tan() method
            val angleToGoalRadians =
                Math.toRadians(LimelightConstants.Mecanical.pitch.degrees + targetOffsetAngle_Vertical.degrees)

            // Calculated distance from limelight lens to goal (in inches)
            distanceFromLimelightToGoalInches =
                Distance.fromInches(LimelightConstants.Mecanical.aprilTagHeight.inches - LimelightConstants.Mecanical.limelightHeight.inches) / tan(
                    angleToGoalRadians
                )
            telemetry.addData(
                "Limelight TargetDistanceInches",
                distanceFromLimelightToGoalInches.inches
            )

            // We will first get a (MetaTag2) Pose3D. From here, we will extract its Tx, Ty & Ta components
            tx = llResult!!.tx
            ty = llResult!!.ty
            ta = llResult!!.ta

            /*
             * It is important to notice that the Full3D option should be enabled
             * */
        } else {
            tx = 0.0
            ty = 0.0
            ta = 0.0
        }
    }

    fun start(): Runnable {
        return {limelight!!.start()}
    }

    fun pause(): Runnable {
        return {limelight!!.pause()}
    }

}