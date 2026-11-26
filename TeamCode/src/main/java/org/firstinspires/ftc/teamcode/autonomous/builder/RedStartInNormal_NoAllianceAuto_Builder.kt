package org.firstinspires.ftc.teamcode.autonomous.builder

import Hood
import com.seattlesolvers.solverslib.command.Command
import com.seattlesolvers.solverslib.command.CommandOpMode
import com.seattlesolvers.solverslib.command.SequentialCommandGroup
import com.seattlesolvers.solverslib.command.ParallelDeadlineGroup
import com.seattlesolvers.solverslib.command.InstantCommand
import com.seattlesolvers.solverslib.command.WaitCommand
import com.seattlesolvers.solverslib.gamepad.GamepadEx
import org.firstinspires.ftc.teamcode.Robot
import org.firstinspires.ftc.teamcode.autonomous.paths.BlueStartInNormal_NoAllianceAuto
import org.firstinspires.ftc.teamcode.autonomous.paths.RedStartInNormal_NoAllianceAuto
import org.firstinspires.ftc.teamcode.subsystems.Feeder.Feeder
import org.firstinspires.ftc.teamcode.subsystems.Indexer.Indexer
import org.firstinspires.ftc.teamcode.subsystems.Intake.Intake
import org.firstinspires.ftc.teamcode.subsystems.Pata.Pata
import org.firstinspires.ftc.teamcode.subsystems.Shooter.Shooter
import org.firstinspires.ftc.teamcode.subsystems.ShooterCover.ShooterCover
import org.firstinspires.ftc.teamcode.subsystems.Vision.Limelight
import org.firstinspires.ftc.teamcode.utils.Alliance

/**
 * The following class was created with the objective of serving as a template for an autonomous routine.
 * This class is similar to the [org.firstinspires.ftc.teamcode.TeleOpMode], however, the [GamepadEx] and its command are inexistent here.
 * Declared below the [org.firstinspires.ftc.teamcode.Robot] is the [autonomousCommand] which is a [SequentialCommandGroup] and is the only command
 * that will be executed along the whole routine. You can nest inside the [autonomousCommand] several [org.firstinspires.ftc.teamcode.Robot.followPathCMD],
 * [SequentialCommandGroup], [ParallelDeadlineGroup], [InstantCommand], etc.
 * You'll need to create an instance of a org.firstinspires.ftc.teamcode.autonomous.paths.examplePaths.Paths class like [ExamplePaths] and initialize it with an [Alliance]. Once initialized
 * the [AutonomousBuilder] can be initialized with both [Alliance.RED] or [Alliance.BLUE] and paths will be mirrored flawlessly.
 * Complete each [TODO] inside [AutonomousBuilder] and the class will be ready to become the inheritor of an [com.qualcomm.robotcore.eventloop.opmode.Autonomous].
 */
open class RedStartInNormal_NoAllianceAuto_Builder(private var alliance: Alliance): CommandOpMode() {

    // The LogiTech controller
    private lateinit var controller: GamepadEx
    // Robot's declaration
    private lateinit var robot: Robot
    private lateinit var paths: RedStartInNormal_NoAllianceAuto

    private lateinit var hood: Hood
    private lateinit var vision: Limelight
    private lateinit var shooterCover: ShooterCover
    private lateinit var feeder: Feeder
    private lateinit var indexer: Indexer

    private lateinit var shooter: Shooter
    private lateinit var intake: Intake
    private lateinit var pata: Pata
    // Autonomous command declaration
    private lateinit var autonomousCommand: SequentialCommandGroup

    private fun shootSequence (): Command {
        return SequentialCommandGroup(
            hood.moveHoodToPositionCMD(vision.getDistanceToGoal(robot.allianceForAprilTags).inches),
            shooterCover.openShooterCoverCMD(),
            shooter.shootWithLimelightCMD(vision.getDistanceToGoal(robot.allianceForAprilTags).inches),
            feeder.feedCMD(),
            indexer.enableIndexerCMD(),
            WaitCommand(1000),
            indexer.disableIndexerCMD(),
            feeder.stopFeedingCMD(),
            shooter.stopShooterCMD(),
            shooterCover.closeShooterCoverCMD(),
            hood.moveHoodDownPositionCMD(),
        )
    }

    private fun startIntakingSequence (): Command {
        return SequentialCommandGroup(
            indexer.enableIndexerCMD(),
            intake.enableIntakeCMD()
        )
    }

    private fun stopIntakingSequence (): Command {
        return SequentialCommandGroup(
            indexer.disableIndexerCMD(),
            intake.disableIntakeCMD()
        )
    }


    // Executed after the init button is pressed.
    override fun initialize() {
        super.reset()
        controller = GamepadEx(gamepad1)
        robot = Robot(alliance, hardwareMap, controller, telemetry)
        paths = RedStartInNormal_NoAllianceAuto(alliance)
        robot.initAuto(paths.start)
        alliance = Alliance.RED

        // Chain commands inside the autonomous command //
        // TODO IMPORTANT. Fill out the requirements of each command nested in here, if not, the robot won't follow any path.
        autonomousCommand = SequentialCommandGroup(
            robot.followPathCMD(paths.path1(),true,.9),
            shootSequence(),
            robot.followPathCMD(paths.path2(),false,.9),
            startIntakingSequence(),
            robot.followPathCMD(paths.path3(),false,.9),
            stopIntakingSequence(),
            robot.followPathCMD(paths.path4(),false,.9),
            robot.followPathCMD(paths.path5(),false,.9),
            robot.followPathCMD(paths.path5(),true,.9),
            shootSequence(),
            pata.lowerPataCMD(),
            startIntakingSequence(),
            robot.followPathCMD(paths.path6(),false,.9),
            robot.followPathCMD(paths.path7(),true,.9),
            robot.followPathCMD(paths.path8(),false,.9),
            robot.followPathCMD(paths.path9(),true,.9),
            robot.followPathCMD(paths.path10(),true,.9),
            robot.followPathCMD(paths.path11(),false,.9),
            robot.followPathCMD(paths.path12(),false,.9),
            robot.followPathCMD(paths.path13(),false,.9),
            pata.risePataCMD(),
            robot.followPathCMD(paths.path14(),false,.9),
            stopIntakingSequence(),
            robot.followPathCMD(paths.path15(),false,.9),
            robot.followPathCMD(paths.path16(),false,.9)
            )

        // Wait for start to schedule command
        waitForStart()

        // Schedule autonomous command
        autonomousCommand.schedule()
    }

    // Executed indefinitely after the init button is pressed
    override fun initialize_loop() {
        robot.initLoop()
    }

    // Executed after the play button is pressed
    override fun run() {
        robot.run()
    }

    // Executed when the OpMode ends
    override fun end() {
        robot.onEnd()
    }
}