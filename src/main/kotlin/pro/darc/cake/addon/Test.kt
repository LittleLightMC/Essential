package pro.darc.cake.addon

import pro.darc.cake.core.addon.CakeAddon
import pro.darc.cake.module.extensions.Log

class Test: CakeAddon() {

    override fun init() {
        Log.info("Test addon loaded")
    }
}