package bcp.designpatterns.localdatasource

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.BatteryManager
import android.os.Build
import bcp.designpatterns.core.singleton.BCPSimpleSingletonManager
import bcp.designpatterns.core.singleton.BCPWithArgumentsSingletonManager
import com.blankj.utilcode.util.DeviceUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.FileNotFoundException
import javax.inject.Inject

/**   Project property of BCP
 *   Created by Dazzord.
 */

class LocalDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalDataSource {

    private var intent: Intent? = null

    init {
        registerBatteryReceiver()
    }

    private fun registerBatteryReceiver() {
        intent = BCPWithArgumentsSingletonManager.getInstance(context).getRegisteredBatteryReceiver()
    }

    override fun getHomeHeaderTitle(): Pair<String, String> =
        Pair(
            context.getString(R.string.bcp_battery),
            context.getString(R.string.design_patterns)
        )


    private fun getAndroidVersion(): String {
        return "Android OS: ${Build.VERSION.RELEASE} | SDK ${Build.VERSION.SDK_INT}"
    }

    private fun getAccelerometerInfo(): String {
        val info = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return info.getDefaultSensor(BCPSimpleSingletonManager.instance.getAccelerometerSensorType())?.let { context.getString(R.string.yes) }
            ?: context.getString(R.string.no)

    }

    private fun getProcessorCoreNumber(): Int {
        return try {
            Runtime.getRuntime().availableProcessors()
        } catch (ex: Exception) {
            1
        }
    }

    private fun getTotalMemory(): Double {
        return try {
            val memoryInfo = ActivityManager.MemoryInfo()
            val actManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            actManager.getMemoryInfo(memoryInfo)
            val double = memoryInfo.totalMem.toDouble() / (1000 * 1024 * 1024)
            String.format("%.2f", double).toDouble()
        } catch (ex: FileNotFoundException) {
            0.0
        } catch (ex: Exception) {
            0.0
        }
    }

    private fun getAGyroscopeInfo(): String {
        val info = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return info.getDefaultSensor(GYROSCOPE_TYPE)?.let { context.getString(R.string.yes) }
            ?: context.getString(R.string.no)

    }

    override fun getSystemInfo(): List<Pair<String, String>> = listOf(
        context.getString(R.string.deviceModel) to DeviceUtils.getUniqueDeviceId(),
        context.getString(R.string.operatingSystem) to getAndroidVersion(),
        context.getString(R.string.memory) to "${getTotalMemory()} GB",
        context.getString(R.string.processor) to getProcessorCoreNumber().toString(),
        context.getString(R.string.accelerometer) to getAccelerometerInfo(),
        context.getString(R.string.gyroscope) to getAGyroscopeInfo()
    )

    override fun getBatteryInfo(): List<BatteryInfoModel> {
        registerBatteryReceiver()
        return listOf(
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_battery,
                context.getString(R.string.battery),
                getBatteryLevel()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_temperture,
                context.getString(R.string.temperature),
                getBatteryTemperature()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_voltage,
                context.getString(R.string.voltage),
                getBatteryVoltage()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_health,
                context.getString(R.string.health),
                getBatteryHealth()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_plugged,
                context.getString(R.string.plugged),
                getBatteryPlugged()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_status,
                context.getString(R.string.status),
                getBatteryCharginStatus()
            ),
            BatteryInfoModel(
                bcp.designpatterns.coreui.R.drawable.ic_technology,
                context.getString(R.string.technology),
                getBatteryTechnology()
            )
        )
    }

    private fun getBatteryCharginStatus(): String {
        val chargin = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        return when (chargin) {
            BatteryManager.BATTERY_STATUS_CHARGING -> context.getString(R.string.charging)
            BatteryManager.BATTERY_STATUS_DISCHARGING -> context.getString(R.string.discharging)
            BatteryManager.BATTERY_STATUS_FULL -> context.getString(R.string.full)
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> context.getString(R.string.discharging)
            else -> context.getString(R.string.discharging)
        }

    }

    private fun getBatteryVoltage(): String {
        val vol = intent?.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0)
        return vol?.let { "$it V" } ?: context.getString(R.string.unknown)
    }

    private fun getBatteryTemperature(): String {
        val temp = intent?.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)
        val inf = temp?.div(10f)
        return inf?.let { "$inf °C" } ?: context.getString(R.string.unknown)
    }

    private fun getBatteryTechnology(): String {
        return intent?.extras?.getString(BatteryManager.EXTRA_TECHNOLOGY)
            ?: context.getString(R.string.unknown)
    }

    private fun getBatteryPlugged(): String {
        val plugged = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
        return when (plugged) {
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> context.getString(R.string.pluggedWireless)
            BatteryManager.BATTERY_PLUGGED_USB -> context.getString(R.string.pluggedUsb)
            BatteryManager.BATTERY_PLUGGED_AC -> context.getString(R.string.pluggedAc)
            else -> context.getString(R.string.none)
        }
    }

    private fun getBatteryLevel(): String {
        val value = intent?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            (level * 100 / scale.toFloat()).toInt()
        } ?: return context.getString(R.string.unknown)

        return "$value%"
    }

    private fun getBatteryHealth(): String {
        val health = intent?.getIntExtra(BatteryManager.EXTRA_HEALTH, 0)
        return when (health) {
            BatteryManager.BATTERY_HEALTH_COLD -> context.getString(R.string.cold)
            BatteryManager.BATTERY_HEALTH_DEAD -> context.getString(R.string.death)
            BatteryManager.BATTERY_HEALTH_GOOD -> context.getString(R.string.cold)
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> context.getString(R.string.overVoltage)
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> context.getString(R.string.overheat)
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> context.getString(R.string.unknown)
            else -> context.getString(R.string.unknown)
        }
    }
}

private const val ACCELEROMETER_TYPE = 1
private const val GYROSCOPE_TYPE = 4