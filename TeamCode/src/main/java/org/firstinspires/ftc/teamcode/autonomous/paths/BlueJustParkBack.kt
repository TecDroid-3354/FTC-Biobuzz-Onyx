package org.firstinspires.ftc.teamcode.autonomous.paths

import com.pedropathing.api.Paths
import com.pedropathing.api.PoseFactory
import com.pedropathing.paths.Path
import org.firstinspires.ftc.teamcode.utils.Alliance

class BlueJustParkBack(alliance: Alliance) {

    private val poseFactory = PoseFactory.degrees()

    val start = poseFactory.of(62.0, 133.0, -90.0)
    private val path1 = poseFactory.of(62.0, 115.0, 0.0)
    private val point2 = poseFactory.of(8.0, 91.0, 0.0)

    fun path1(): Path = Paths.line(start, path1).linear(start, path1)

    fun path2(): Path = Paths.line(path1, point2).constant(point2)
}
