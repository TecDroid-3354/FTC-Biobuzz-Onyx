package org.firstinspires.ftc.teamcode.autonomous.paths
import com.pedropathing.api.Paths.*
import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.math.Pose
import com.pedropathing.paths.Path
import org.firstinspires.ftc.teamcode.utils.Alliance

class Red2Tips_NoAllianceAuto(alliance: Alliance) {

        private val poseFactory = PoseFactory.degrees()

        val start = poseFactory.of(56.0, 8.0, 90.0)
        private val path1 = poseFactory.of(56.0, 30.0, 90.0)
        private val point2Start = poseFactory.of(56.0, 30.0, 90.0)
        private val point2 = poseFactory.of(31.1519, 8.4, 180.0)
        private val point3 = poseFactory.of(8.0, 8.4, 180.0)
        private val point4Start = poseFactory.of(8.0, 8.4, 180.0)
        private val point4 = poseFactory.of(34.5626, 107.2328, 0.0)
        private val point5Start = poseFactory.of(34.5626, 107.2328, 0.0)
        private val point5 = poseFactory.of(57.0136, 111.3685, -90.0)
        private val point6Start = poseFactory.of(57.0136, 111.3685, -90.0)
        private val point6 = poseFactory.of(47.2651, 130.0, 90.0)
        private val point7Start = poseFactory.of(47.2651, 130.0, 90.0)
        private val point7 = poseFactory.of(57.0136, 117.2766, -90.0)
        private val point8Start = poseFactory.of(57.0136, 117.2766, -90.0)
        private val point8 = poseFactory.of(8.0, 105.0, 0.0)

        fun path1(): Path = Paths.line(start, path1).tangent()

        fun path2(): Path = Paths.line(point2Start, point2).linear(point2Start, point2)

        fun path3(): Path = Paths.line(point2, point3).tangent()

        fun path4(): Path = Paths.line(point4Start, point4).linear(point4Start, point4)

        fun path5(): Path = Paths.line(point5Start, point5).linear(point5Start, point5)

        fun path6(): Path = Paths.line(point6Start, point6).linear(point6Start, point6)

        fun path7(): Path = Paths.line(point7Start, point7).linear(point7Start, point7)

        fun path8(): Path = Paths.line(point8Start, point8).linear(point8Start, point8)
}

