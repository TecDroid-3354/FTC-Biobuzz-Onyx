package org.firstinspires.ftc.teamcode.autonomous.paths

import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.paths.Path
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.autonomous.MirroredPoseFactory


class Red2Tips_NoAllianceAuto {

        private val poseFactory = PoseFactory.degrees()

        private val start = poseFactory.of(56.0, 8.0, 90.0)
        private val point1 = poseFactory.of(56.0, 37.0, 90.0)
        private val point2Start = poseFactory.of(56.0, 37.0, 90.0)
        private val point2 = poseFactory.of(32.0, 7.0, 180.0)
        private val point3 = poseFactory.of(7.0, 7.0, 180.0)
        private val point4Start = poseFactory.of(7.0, 7.0, 180.0)
        private val point4 = poseFactory.of(38.0, 113.0, 0.0)
        private val point5Start = poseFactory.of(38.0, 113.0, 0.0)
        private val point5 = poseFactory.of(57.5, 113.0, -90.0)
        private val point6Start = poseFactory.of(57.5, 113.0, 270.0)
        private val point6 = poseFactory.of(52.0, 131.0, 119.0)
        private val point7Start = poseFactory.of(52.0, 131.0, 119.0)
        private val point7 = poseFactory.of(57.0, 111.0, -90.0)
        private val point8Start = poseFactory.of(57.0, 111.0, -90.0)
        private val point8 = poseFactory.of(7.0, 111.0, 0.0)

        fun path1(): Path = Paths.line(start, point1).tangent()

        fun path2(): Path = Paths.line(point2Start, point2).linear(point2Start, point2)

        fun path3(): Path = Paths.line(point2, point3).tangent()

        fun path4(): Path = Paths.line(point4Start, point4).linear(point4Start, point4)

        fun path5(): Path = Paths.line(point5Start, point5).linear(point5Start, point5)

        fun path6(): Path = Paths.line(point6Start, point6).linear(point6Start, point6)

        fun path7(): Path = Paths.line(point7Start, point7).linear(point7Start, point7)

        fun path8(): Path = Paths.line(point8Start, point8).linear(point8Start, point8)
    }
