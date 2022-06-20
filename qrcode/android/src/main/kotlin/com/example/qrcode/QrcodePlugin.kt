package com.example.qrcode

import io.flutter.plugin.common.PluginRegistry.Registrar

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.embedding.engine.plugins.activity.ActivityAware

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

public class QrcodePlugin: FlutterPlugin, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  // private lateinit var channel : MethodChannel
  private lateinit var pFlutterPluginBinding: FlutterPlugin.FlutterPluginBinding;

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {

    pFlutterPluginBinding = flutterPluginBinding

  }

  override fun onAttachedToActivity(activityPluginBinding: ActivityPluginBinding) {
    if(pFlutterPluginBinding != null) {
      // TODO: your plugin is now attached to an Activity
      pFlutterPluginBinding.getPlatformViewRegistry().registerViewFactory("plugins/qr_capture_view", NewQRCaptureViewFactory(pFlutterPluginBinding.getBinaryMessenger(), activityPluginBinding))
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    // channel.setMethodCallHandler(null)
  }

  override fun onDetachedFromActivityForConfigChanges() {
    // TODO: the Activity your plugin was attached to was
    // destroyed to change configuration.
    // This call will be followed by onReattachedToActivityForConfigChanges().
  }


  override fun onReattachedToActivityForConfigChanges(activityPluginBinding: ActivityPluginBinding) {
    // TODO: your plugin is now attached to a new Activity
    // after a configuration change.
  }

  override fun onDetachedFromActivity() {
    // TODO: your plugin is no longer associated with an Activity.
    // Clean up references.
  }

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      registrar.platformViewRegistry().registerViewFactory("plugins/qr_capture_view", QRCaptureViewFactory(registrar))
    }
  }
}
