package org.firstinspires.ftc.teamcode.opModes.teleoperated
import Hood
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.Robot
import org.firstinspires.ftc.teamcode.TeleOpMode
import org.firstinspires.ftc.teamcode.subsystems.Shooter.Shooter
import org.firstinspires.ftc.teamcode.subsystems.vision.Limelight
import org.firstinspires.ftc.teamcode.utils.Alliance
import kotlin.math.hypot

@TeleOp(group = "TeleOp", name = "TeleOp - Red")
class TestTeleOp(hardwareMap: HardwareMap): TeleOpMode(Alliance.RED) {

    private lateinit var shooter: Shooter
    private lateinit var hood: Hood
    private lateinit var limelight: Limelight

    override fun initialize() {
        super.reset()
        controller = GamepadEx(gamepad1)
        robot = Robot(alliance, hardwareMap, controller, telemetry)

        hood = Hood(hardwareMap)
        shooter = Shooter(hardwareMap)

        robot.initTeleOp()
    }


    override fun initialize_loop() {
        robot.initLoop()
    }

    override fun run() {
        robot.run()
        printTelemetry(telemetry)
    }

    override fun end() {
        robot.onEnd()
        printTelemetry(telemetry)
    }

    fun printTelemetry(telemetry: Telemetry,) {
        telemetry.addData("Winner Team:", "TecDroid-Onyx 32427")
        telemetry.addLine()
        telemetry.addData("Vision Telemetry", limelight.visionTelemetry(telemetry, robot.allianceForAprilTags))
        telemetry.addData("Shooter's motor 1 velocity", shooter.getShooterMotor1Velocity())
        telemetry.addData("Shooter's motor 2 velocity", shooter.getShooterMotor2Velocity())
        telemetry.addData("Shooter's media velocity", shooter.getShooterVelocity())
        telemetry.addData("Hood's Position", hood.getHoodsAngle())

        telemetry.update()
    }
}