package com.github.littlelightmc.essential.base

import com.github.littlelightmc.essential.db.FriendRequest
import pro.darc.cake.core.inject.LifeCycle
import pro.darc.cake.core.inject.LifeInject
import pro.darc.cake.module.command.command
import pro.darc.cake.module.db.client
import pro.darc.cake.module.extensions.cake

object Friend {

    @LifeInject([LifeCycle.CakeReload, LifeCycle.CakeEnable])
    @JvmStatic
    fun init() {
        command("friend", aliases = arrayOf("好友"), plugin = cake) {
        }
    }

}