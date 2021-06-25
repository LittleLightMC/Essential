package com.github.littlelightmc.essential.base

import com.github.littlelightmc.essential.defaultLocale
import pro.darc.cake.core.inject.LifeCycle
import pro.darc.cake.core.inject.LifeInject
import pro.darc.cake.module.command.command
import pro.darc.cake.module.extensions.cake

object Essential {
    @LifeInject([LifeCycle.CakeEnable, LifeCycle.CakeReload])
    @JvmStatic
    fun init() {
        command("essential", plugin = cake) {
            command("version") {
                executor {
                    defaultLocale.sendTo(sender, "info addon version")
                }
            }
        }
    }
}