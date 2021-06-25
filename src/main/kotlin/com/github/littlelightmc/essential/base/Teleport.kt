package com.github.littlelightmc.essential.base

import pro.darc.cake.core.inject.LifeCycle
import pro.darc.cake.core.inject.LifeInject
import pro.darc.cake.module.command.arguments.coordinate
import pro.darc.cake.module.command.arguments.player
import pro.darc.cake.module.command.command
import pro.darc.cake.module.command.failLocale
import pro.darc.cake.module.extensions.cake
import pro.darc.cake.module.extensions.hasPermissionOrStar

object Teleport {

    @LifeInject([LifeCycle.CakeEnable])
    @JvmStatic
    fun init() {
        tpDirectly()
        tpLocation()
    }

    private fun tpDirectly() {
        command("tp", plugin = cake) {
            executorPlayer {
                if (!sender.hasPermissionOrStar("ess.tp")) failLocale("error no permission")
                val target = player(0)

                sender.teleport(target.location)
            }
        }
    }

    private fun tpLocation() {
        command("tppos", plugin = cake) {
            executorPlayer {
                if (!sender.hasPermissionOrStar("ess.tp")) failLocale("error no permission")

                val pos = coordinate(0, 1, 2)
                sender.teleport(pos)
            }
        }
    }

}
