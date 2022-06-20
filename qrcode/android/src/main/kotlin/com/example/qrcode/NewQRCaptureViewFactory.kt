package com.example.qrcode

import androidx.annotation.NonNull

import android.app.Activity
import android.content.Context
import com.example.qrcode.NewQRCaptureView

import io.flutter.plugin.common.BinaryMessenger
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding

import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory


class NewQRCaptureViewFactory(private val messenger: BinaryMessenger, private val activityPluginBinding: ActivityPluginBinding?) :
        PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context?, id: Int, obj: Any?): PlatformView {
        return NewQRCaptureView(messenger, activityPluginBinding ,id)
    }

}
