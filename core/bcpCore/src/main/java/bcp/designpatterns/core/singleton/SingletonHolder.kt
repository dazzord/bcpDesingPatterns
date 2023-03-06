package bcp.designpatterns.core.singleton

/**   Project property of BCP
 *   Created by Dazzord.
 */

/**
 * Singleton holder
 *
 * @param T
 * @param A
 * @constructor
 *
 * @param creator
 *  Whatever point you need
 * a singleton class with arguments at that point you'll be able utilize
 * the SingletonHolder class
 */
open class SingletonHolder<out T: Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A): T {
        val checkInstance = instance
        if (checkInstance != null) {
            return checkInstance
        }

        return synchronized(this) {
            val checkInstanceAgain = instance
            /**
             * The above code is the foremost effective code for double-checked locking framework
             * and the code is by one means or another comparative to the lazy() work in Kotlin
             * and that’s why it is called lazy initialization. So, at whatever point you need
             * a singleton class with arguments at that point you'll be able utilize
             * the SingletonHolder class
             */
            if (checkInstanceAgain != null) {
                checkInstanceAgain
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}