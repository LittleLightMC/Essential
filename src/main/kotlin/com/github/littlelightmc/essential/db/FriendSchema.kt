@file:UseSerializers(OfflinePlayerSerializer::class)

package com.github.littlelightmc.essential.db

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import org.bukkit.OfflinePlayer
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import pro.darc.cake.module.db.OfflinePlayerSerializer

@Serializable
data class FriendRequest(
    @SerialName("_id") val key: @Contextual Id<FriendRequest> = newId(),
    val sender: OfflinePlayer,
    val receiver: OfflinePlayer,
)

@Serializable
data class FriendRelation(
    @SerialName("_id") val key: @Contextual Id<FriendRequest> = newId(),
    val player1: OfflinePlayer,
    val player2: OfflinePlayer,
)
