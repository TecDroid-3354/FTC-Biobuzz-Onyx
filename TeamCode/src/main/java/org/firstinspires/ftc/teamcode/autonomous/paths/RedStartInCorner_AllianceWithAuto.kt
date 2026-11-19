package org.firstinspires.ftc.teamcode.autonomous.paths

import com.pedropathing.api.Paths.*
import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.math.Pose
import com.pedropathing.paths.Path
import org.firstinspires.ftc.teamcode.utils.Alliance

class RedStartInCorner_AllianceWithAuto(alliance: Alliance) {


    private val poseFactory = PoseFactory.degrees()

    val start = poseFactory.of(8.7349, 132.071, 0.0)
    private val point1 = poseFactory.of(8.7349, 132.1211, 0.0)
    private val point2Start = poseFactory.of(8.7349, 132.1211, 0.0)
    private val point2 = poseFactory.of(58.1952, 118.1628, -90.0)
    private val point3 = poseFactory.of(20.0877, 89.5084, -90.0)
    private val point4 = poseFactory.of(10.0438, 55.8319, -106.607)
    private val point5Start = poseFactory.of(10.0438, 55.8319, -160.0)
    private val point5 = poseFactory.of(25.1096, 39.88, -90.0)
    private val point6Start = poseFactory.of(25.1096, 39.88, -90.0)
    private val point6 = poseFactory.of(55.2411, 25.7004, 90.0)
    private val point7 = poseFactory.of(25.1096, 43.7203, 149.1189)
    private val point8 = poseFactory.of(24.2234, 100.143, 90.8999)
    private val point9 = poseFactory.of(7.0, 100.0, 0.4757)

    fun path1(): Path = Paths.line(start, point1).linear(start, point1)

    fun path2(): Path = Paths.line(point2Start, point2).linear(point2Start, point2)

    fun path3(): Path = Paths.line(point2, point3).constant(point3)

    fun path4(): Path = Paths.line(point3, point4).tangent()

    fun path5(): Path = Paths.line(point5Start, point5).linear(point5Start, point5)

    fun path6(): Path = Paths.line(point6Start, point6).linear(point6Start, point6)

    fun path7(): Path = Paths.line(point6, point7).tangent()

    fun path8(): Path = Paths.line(point7, point8).tangent()

    fun path9(): Path = Paths.line(point8, point9).reverseTangent()
}
