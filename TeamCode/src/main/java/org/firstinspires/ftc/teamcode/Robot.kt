package org.firstinspires.ftc.teamcode

import ShooterHood
import com.pedropathing.follower.Follower
import com.pedropathing.math.Pose
import com.pedropathing.paths.Path
import com.qualcomm.hardware.sparkfun.SparkFunOTOS
import com.qualcomm.robotcore.hardware.HardwareMap
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.SequentialCommandGroup
import com.seattlesolvers.solverslib.command.WaitCommand
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.autonomous.pedroPathing.Constants
import org.firstinspires.ftc.teamcode.subsystems.FlowerHood.FlowerHood
import org.firstinspires.ftc.teamcode.subsystems.Indexer.Indexer
import org.firstinspires.ftc.teamcode.subsystems.Intake.Intake
import org.firstinspires.ftc.teamcode.subsystems.Shooter.Shooter
import org.firstinspires.ftc.teamcode.subsystems.PollenShooterCover.ShooterCover
import org.firstinspires.ftc.teamcode.subsystems.mecanum.Mecanum
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.TecDroidRobot
import org.firstinspires.ftc.teamcode.utils.autonomous.PoseStorage
import org.firstinspires.ftc.teamcode.utils.extensions.dpadDown
import org.firstinspires.ftc.teamcode.utils.extensions.dpadUp
import org.firstinspires.ftc.teamcode.utils.extensions.leftBumper
import org.firstinspires.ftc.teamcode.utils.extensions.leftTrigger
import org.firstinspires.ftc.teamcode.utils.extensions.onFalse
import org.firstinspires.ftc.teamcode.utils.extensions.onTrue
import org.firstinspires.ftc.teamcode.utils.extensions.rightTrigger

class Robot(
    private val alliance: Alliance,
    private val hardwareMap: HardwareMap,
    private val controller: GamepadEx,
    telemetry: Telemetry
): TecDroidRobot(telemetry, hardwareMap) {

    /* Declare your Pedro Pathing's Follower here */
    private lateinit var follower: Follower
    /* Declare your subsystems here */

    private lateinit var flowerHood : FlowerHood
    private lateinit var indexer : Indexer
    private lateinit var intake: Intake
    private lateinit var shooter: Shooter
    private lateinit var shooterCover: ShooterCover
    private lateinit var shooterHood : ShooterHood

    private lateinit var otos : SparkFunOTOS
    private lateinit var drive: Mecanum

    init {
        subsystemInitialization()
    }

    /* Initialize your subsystems and follower here */
    override fun subsystemInitialization() {
        // Follower initialization
        follower = Constants.createFollower(hardwareMap)
        // Subsystem initialization
        flowerHood = FlowerHood(hardwareMap)
        indexer = Indexer(hardwareMap)
        intake = Intake(hardwareMap)
        shooter = Shooter(hardwareMap)
        shooterCover = ShooterCover(hardwareMap)
        shooterHood = ShooterHood(hardwareMap)

        drive = Mecanum(follower, controller, alliance)

        otos = hardwareMap.get(SparkFunOTOS::class.java,"otos")
    }

    /* Runs indefinitely after the init button on the DS is pressed. Stops when play button is pressed */
    override fun initLoop() {}

    /* Initialize your teleop controller commands here */
    override fun initTeleOp() {
        // Chassis default command
        drive.setPose(PoseStorage.autonomousEndPose)
        drive.defaultCommand = drive.driveFollowingDriverInput()
        // Build Commands:

        controller.dpadUp()
            .onTrue(flowerHood.openCMD())
        controller.dpadDown()
            .onTrue(flowerHood.closedCMD())

        controller.rightTrigger()
            .onTrue(SequentialCommandGroup(
                shooterHood.moveHoodToPositionCMD(),
                shooterCover.openShooterCoverCMD(),
                WaitCommand(500),
                shooter.shootCMD(),
                indexer.enableIndexerCMD()
            ))
            .onFalse(SequentialCommandGroup(
                indexer.disableIndexerCMD(),
                shooter.stopShooterCMD(),
                WaitCommand(200),
                shooterCover.closeShooterCoverCMD(),
                shooterHood.moveHoodDownPositionCMD()
            ))

        controller.leftTrigger()
            .onTrue(SequentialCommandGroup(
                indexer.enableIndexerCMD(),
                intake.enableIntakeCMD()
            ))
            .onFalse(SequentialCommandGroup(
                indexer.disableIndexerCMD(),
                intake.disableIntakeCMD()
            ))

        controller.leftBumper()
            .onTrue(SequentialCommandGroup(
                indexer.reverseIndexerCMD(),
                intake.reverseIntakeCMD()
            ))
            .onFalse(SequentialCommandGroup(
                indexer.disableIndexerCMD(),
                intake.disableIntakeCMD()
            ))
    }

    override fun preLoopTeleOp() {
        /**
         * Runs once before the main loop of the robot [loopTeleOp]
         */
    }

    /**
     * Runs periodically, useful for updating variables or configurables.
     */
    override fun loopTeleOp() {}

    /**
     * Runs once when init is pressed during auto.
     * Initialize auto commands and set starting pose.
     */
    override fun initAuto(startingPose: Pose) {
        drive.setPose(startingPose)
    }

    /**
     * Runs once on the end of OpModes.
     */
    override fun onEnd() {
        PoseStorage.autonomousEndPose = follower.pose()
    }

    /**
     * Runs inside the main loop of the robot. Print telemetry ONLY.
     */
    override fun printTelemetry() {
        pTelemetry.addData("otos x", otos.position.x)
        pTelemetry.addData("otos y", otos.position.y)
        pTelemetry.addData("otos heading", otos.position.h)

        pTelemetry.update()
    }

    /**
     * @return the Pedro's Follower
     */
    override fun getFollower(): Follower { return follower }

    /* Common method to follow any path */
    override fun followPathCMD(path: Path, holdEnd: Boolean, maxPower: Double): Command {
        return drive.followPathCMD(path, holdEnd, maxPower)
    }
}