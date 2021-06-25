package com.github.littlelightmc.essential

import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import pro.darc.cake.core.addon.AddonManager
import pro.darc.cake.core.addon.CakeAddon
import pro.darc.cake.module.locale.LocaleUnit
import pro.darc.cake.module.locale.getDefaultLocale

val essential get() = AddonManager.getAddon("EssentialAddon")!!.instance
val defaultLocale get() = (essential as EssentialAddon).defaultLocale
val config get() = (essential as EssentialAddon).yamlConfiguration

class EssentialAddon: CakeAddon() {

    val defaultLocale: LocaleUnit by lazy {
        getDefaultLocale()!!
    }

    val yamlConfiguration: YamlConfiguration by lazy {
        dataFolder.mkdirs()
        saveDefaultAndGetConfig()!!
    }

    override fun init() {
        defaultLocale.sendTo(Bukkit.getConsoleSender(), "text addon loaded")
    }
}
