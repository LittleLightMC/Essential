package com.github.littlelightmc.essential.distribute

import org.bukkit.entity.Player
import java.lang.RuntimeException

class NotTeamMemberError(player: Player): RuntimeException("Player ${player.name} is not a member of a fireteam")

class FireTeamSchema(
    creator: Player,
) {

    var leader: Player
        private set

    private val members: MutableList<Player> = mutableListOf()

    init {
        leader = creator
        members.add(creator)
    }

    fun changeLeader(newLeader: Player) {
        if (members.find { player -> player.uniqueId == newLeader.uniqueId } != null) {
            leader = newLeader
        } else {
            throw NotTeamMemberError(newLeader)
        }
    }
}
