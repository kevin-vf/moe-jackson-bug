package com.vfpowertech.moejackson.ui

import apple.NSObject
import apple.uikit.UIButton
import apple.uikit.UILabel
import apple.uikit.UIViewController
import org.moe.natj.general.Pointer
import org.moe.natj.general.ann.Owned
import org.moe.natj.general.ann.RegisterOnStartup
import org.moe.natj.objc.ObjCRuntime
import org.moe.natj.objc.ann.ObjCClassName
import org.moe.natj.objc.ann.Property
import org.moe.natj.objc.ann.Selector

@org.moe.natj.general.ann.Runtime(ObjCRuntime::class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
class AppViewController private constructor(peer: Pointer) : UIViewController(peer) {
    companion object {
        @Owned
        @Selector("alloc")
        external fun alloc(): AppViewController
    }

    private lateinit var statusText: UILabel

    private lateinit var helloButton: UIButton

    @Selector("init")
    override external fun init(): AppViewController

    override fun viewDidLoad() {
        statusText = getLabel()
        helloButton = getHelloButton()
    }

    @Selector("statusText")
    @Property
    external fun getLabel(): UILabel

    @Selector("helloButton")
    @Property
    external fun getHelloButton(): UIButton

    @Selector("BtnPressedCancel_helloButton:")
    fun BtnPressedCancel_button(sender: NSObject) {
        statusText.setText("Hello Intel Multi-OS Engine!")
    }
}
