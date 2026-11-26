package org.firstinspires.ftc.teamcode.autonomous.paths
import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.paths.Path
import org.firstinspires.ftc.teamcode.utils.Alliance

class RedStartInNormal_NoAllianceAuto(alliance: Alliance) {

    private val poseFactory = PoseFactory.degrees()

    val start = poseFactory.of(56.0, 8.0, 90.0)
    private val path1 = poseFactory.of(56.0, 30.0, 270.0)
    private val point2Start = poseFactory.of(56.0, 30.0, -90.0)
    private val point2 = poseFactory.of(31.1519, 8.4, 180.0)
    private val point3 = poseFactory.of(8.0, 8.4, 180.0)
    private val point4Start = poseFactory.of(8.0, 8.4, 180.0)
    private val point4 = poseFactory.of(34.5626, 107.2328, 0.0)
    private val point5Start = poseFactory.of(34.5626, 107.2328, 0.0)
    private val point5 = poseFactory.of(57.0136, 111.3685, 90.0)
    private val point6Start = poseFactory.of(57.0136, 111.3685, 90.0)
    private val point6 = poseFactory.of(47.0, 132.0, 90.0)
    private val point7 = poseFactory.of(47.0, 125.0, 90.0)
    private val point8 = poseFactory.of(47.0, 132.0, 90.0)
    private val point9 = poseFactory.of(47.0, 125.0, 90.0)
    private val point10 = poseFactory.of(47.0, 132.0, 90.0)
    private val point11 = poseFactory.of(47.0, 125.0, 90.0)
    private val point12 = poseFactory.of(47.0, 132.0, 90.0)
    private val point13Start = poseFactory.of(47.0, 132.0, 90.0)
    private val point13 = poseFactory.of(32.0, 131.0, -63.0)
    private val point13Control1 = poseFactory.of(37.9591, 118.2594, 0.0)
    private val point14 = poseFactory.of(62.0, 131.0, 68.5306)
    private val point14Control1 = poseFactory.of(48.628, 97.0, 0.0)
    private val point15Start = poseFactory.of(62.0, 131.0, 66.0)
    private val point15 = poseFactory.of(53.7881, 127.3852, 0.0)
    private val point16 = poseFactory.of(8.0, 120.0, 0.0)

    fun path1(): Path = Paths.line(start, path1).linear(start, path1)

    fun path2(): Path = Paths.line(point2Start, point2).linear(point2Start, point2)

    fun path3(): Path = Paths.line(point2, point3).tangent()

    fun path4(): Path = Paths.line(point4Start, point4).linear(point4Start, point4)

    fun path5(): Path = Paths.line(point5Start, point5).linear(point5Start, point5)

    fun path6(): Path = Paths.line(point6Start, point6).linear(point6Start, point6)

    fun path7(): Path = Paths.line(point6, point7).reverseTangent()

    fun path8(): Path = Paths.line(point7, point8).tangent()

    fun path9(): Path = Paths.line(point8, point9).reverseTangent()

    fun path10(): Path = Paths.line(point9, point10).tangent()

    fun path11(): Path = Paths.line(point10, point11).reverseTangent()

    fun path12(): Path = Paths.line(point11, point12).tangent()

    fun path13(): Path = Paths.curve(point13Start, point13Control1, point13).linear(point13Start, point13)

    fun path14(): Path = Paths.curve(point13, point14Control1, point14).tangent()

    fun path15(): Path = Paths.line(point15Start, point15).linear(point15Start, point15)

    fun path16(): Path = Paths.line(point15, point16).constant(point16)
}
