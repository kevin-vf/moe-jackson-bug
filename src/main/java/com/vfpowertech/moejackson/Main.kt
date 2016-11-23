package com.vfpowertech.moejackson

import apple.NSObject
import apple.foundation.NSDictionary
import apple.uikit.UIApplication
import apple.uikit.UIWindow
import apple.uikit.c.UIKit
import apple.uikit.protocol.UIApplicationDelegate
import com.fasterxml.jackson.databind.ObjectMapper
import org.moe.natj.general.Pointer
import org.moe.natj.general.ann.RegisterOnStartup
import org.moe.natj.objc.ann.Selector

@RegisterOnStartup
class Main private constructor(peer: Pointer) : NSObject(peer), UIApplicationDelegate {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            UIKit.UIApplicationMain(0, null, null, Main::class.java.name)
        }

        @Selector("alloc")
        external fun alloc(): Main
    }

    private var window: UIWindow? = null

    override fun applicationDidFinishLaunchingWithOptions(application: UIApplication, launchOptions: NSDictionary<*, *>?): Boolean {
        val installationData = InstallationData("installationId")

        val objectMapper = ObjectMapper()

        println(objectMapper.writeValueAsBytes(installationData).toString(Charsets.UTF_8))

        return true
    }

    override fun setWindow(value: UIWindow?) {
        window = value
    }

    override fun window(): UIWindow? {
        return window
    }
}
