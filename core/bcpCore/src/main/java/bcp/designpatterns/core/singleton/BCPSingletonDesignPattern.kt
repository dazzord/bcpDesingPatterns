package bcp.designpatterns.core.singleton

import android.content.Context
import android.content.Intent
import android.content.IntentFilter

/**   Project property of BCP
 *   Created by Dazzord.
 */

/**
 * Bcp Simple singlenton manager without arguments constructor
 * @constructor Create empty BCP simple singleton manager
 */
class BCPSimpleSingletonManager private constructor() {

    companion object {
        val instance: BCPSimpleSingletonManager by lazy { BCPSimpleSingletonManager() }
    }

    fun getAccelerometerSensorType(): Int = 1
}

/**
 * Bcp Singleton manager with arguments constructor
 *
 * @property context is needed for register receiver
 * @constructor is private to avoid direct instantiation
 */
class BCPWithArgumentsSingletonManager private constructor(private val context: Context) {

    companion object : SingletonHolder<BCPWithArgumentsSingletonManager, Context>(::BCPWithArgumentsSingletonManager)

    fun getRegisteredBatteryReceiver(): Intent? = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
}

/** !!!!!!! Bad Implementation !!!!!!! -------------------------------------------------------------------------------------------*/
/**
* The problem with the above code is that it may produce more than
* one instance of your Singleton class in a multi-threaded environment.
 */
class BCPSingletonBadImplementation private constructor() {

    companion object {
        private var INSTANCE: BCPSingletonBadImplementation ? = null //Imagine Thread A is here
        fun getInstance(): BCPSingletonBadImplementation{
            if(INSTANCE == null){
                INSTANCE = BCPSingletonBadImplementation() //Imagine Thread B is here
            }
            return INSTANCE!!
        }
    }
    /**
     * In the above code, both Thread 1 and Thread 2 will produce two distinct objects,
     * defeating the purpose of a singleton class
     */
}