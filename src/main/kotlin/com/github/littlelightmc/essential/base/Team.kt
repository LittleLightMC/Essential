package com.github.littlelightmc.essential.base

import com.github.littlelightmc.essential.defaultLocale
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import org.bukkit.Material
import org.bukkit.event.EventPriority
import org.bukkit.event.player.AsyncPlayerChatEvent
import pro.darc.cake.core.controller.serverNameSafe
import pro.darc.cake.core.inject.LifeCycle
import pro.darc.cake.core.inject.LifeInject
import pro.darc.cake.module.command.command
import pro.darc.cake.module.distribute.SendPlayerToServerRequest
import pro.darc.cake.module.distribute.WithDistributed
import pro.darc.cake.module.distribute.getTopic
import pro.darc.cake.module.extensions.*
import pro.darc.cake.module.flow.eventFlow
import pro.darc.cake.module.locale.sendDefaultLocale
import pro.darc.cake.module.menu.dsl.menu
import pro.darc.cake.module.menu.dsl.slot

@DelicateCoroutinesApi
object Team: WithDistributed {

    val menuInvite = menu(defaultLocale.asString("team menu.invite.title")!!, 4, plugin = cake) {
        slot(1, 1,
            item(Material.ACACIA_BUTTON)
                .displayName(defaultLocale.asString("team menu.invite.button.input name")!!)
        ) {
            onClick {
                defaultLocale.sendTo(player, "text input player name")
                GlobalScope.launch(Dispatchers.Default) {
                    val data = withTimeoutOrNull(10000) {
                        cake.eventFlow<AsyncPlayerChatEvent>(
                            assign = player, priority = EventPriority.LOWEST, ignoreCancelled = false
                        ).filter { it.player.uniqueId == player.uniqueId }.map { it.message }.first()
                    }
                    if (data == null) {
                        defaultLocale.sendTo(player, "text timeout")
                        return@launch
                    }
                }
            }
        }
    }

    @LifeInject([LifeCycle.CakeReload, LifeCycle.CakeEnable])
    @JvmStatic
    fun init() {

        command("fireteam", plugin = cake, aliases = arrayOf("火力战队")) {
            executorPlayer {
                defaultLocale.sendTo(sender, "text command team help")
            }
            command("invite", aliases = arrayOf("邀请")) {
                executorPlayer {
                    menuInvite.openToPlayer(sender)
                }
            }
        }
    }

}