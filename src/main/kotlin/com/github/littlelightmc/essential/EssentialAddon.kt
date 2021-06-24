package com.github.littlelightmc.essential

import org.bukkit.Bukkit
import pro.darc.cake.core.addon.CakeAddon
import pro.darc.cake.module.command.command
import pro.darc.cake.module.extensions.cake
import pro.darc.cake.module.locale.LocaleUnit
import pro.darc.cake.module.locale.getDefaultLocale

class EssentialAddon: CakeAddon() {

    val defaultLocale: LocaleUnit by lazy {
        getDefaultLocale()!!
    }

    override fun init() {
        defaultLocale.sendTo(Bukkit.getConsoleSender(), "text addon loaded")
        command("essential", plugin = cake) {
            command("version") {
                executor {
                    defaultLocale.sendTo(sender, "info addon version")
                }
            }
        }
    }
}
