package org.firstinspires.ftc.teamcode.subsystems.Vision

import com.qualcomm.hardware.limelightvision.Limelight3A
import com.qualcomm.robotcore.hardware.HardwareMap

class Limelight(hardwareMap: HardwareMap) {

    private var limelight: Limelight3A


    init {
        limelight = hardwareMap.get(Limelight3A::class.java, LimelightConstants.Identification.limelightId)

        limelight.setPollRateHz(LimelightConstants.Configuration.polRateHZ)
        limelight.pipelineSwitch(LimelightConstants.Configuration.aprilTagPipeline)
    }

    fun start(): Runnable {
        return {limelight.start()}
    }

    fun pause(): Runnable {
        return {limelight.pause()}
    }

}