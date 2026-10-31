package org.firstinspires.ftc.teamcode.autonomous.paths

import com.pedropathing.api.Paths.*
import com.pedropathing.api.Paths
import com.pedropathing.paths.Path
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.teamcode.utils.Alliance
import org.firstinspires.ftc.teamcode.utils.autonomous.MirroredPoseFactory


class TestPath(alliance: Alliance): MirroredPoseFactory(AngleUnit.DEGREES,alliance) {

    val start = poseFactory.of(56.0, 9.0, 90.0)
    private val path1 = poseFactory.of(56.0, 22.0, 90.0)
    private val point2Start = poseFactory.of(56.0, 22.0, 90.0)
    private val point2 = poseFactory.of(24.0, 8.0, 180.0)
    private val point3 = poseFactory.of(8.5, 8.0, 180.0)
    private val point4Start = poseFactory.of(8.5, 8.0, 180.0)
    private val point4 = poseFactory.of(21.0, 43.0, 90.0)
    private val point5 = poseFactory.of(42.0, 108.0, 72.0956)
    private val point6Start = poseFactory.of(42.0, 108.0, 90.0)
    private val point6 = poseFactory.of(58.0, 108.0, 270.0)
    private val point7 = poseFactory.of(48.707, 126.8, 116.3035)
    private val point8Start = poseFactory.of(48.707, 126.8, 90.0)
    private val point8 = poseFactory.of(58.0, 124.0, 270.0)
    private val point9 = poseFactory.of(57.707, 23.0, 270.0)
    private val point10 = poseFactory.of(58.0, 28.0, 90.0)
    private val point11 = poseFactory.of(24.0, 47.0, 150.8025)
    private val point12 = poseFactory.of(24.0, 106.0, 90.0)
    private val point13 = poseFactory.of(9.0, 106.0, 0.0)

    fun path1(): Path = Paths.line(start, path1).constant(path1)

    fun path2(): Path = Paths.line(point2Start, point2).linear(point2Start, point2)

    fun path3(): Path = Paths.line(point2, point3).constant(point3)

    fun path4(): Path = Paths.line(point4Start, point4).linear(point4Start, point4)

    fun path5(): Path = Paths.line(point4, point5).tangent()

    fun path6(): Path = Paths.line(point6Start, point6).linear(point6Start, point6)

    fun path7(): Path = Paths.line(point6, point7).tangent()

    fun path8(): Path = Paths.line(point8Start, point8).linear(point8Start, point8)

    fun path9(): Path = Paths.line(point8, point9).constant(point9)

    fun path10(): Path = Paths.line(point9, point10).constant(point10)

    fun path11(): Path = Paths.line(point10, point11).tangent()

    fun path12(): Path = Paths.line(point11, point12).constant(point12)

    fun path13(): Path = Paths.line(point12, point13).constant(point13)
}