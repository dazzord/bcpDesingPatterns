package bcp.designpatterns.coreui.atomicdesign.atoms.icon.builderdesignpattern

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bcp.designpatterns.coreui.R
import bcp.designpatterns.coreui.atomicdesign.atoms.icon.BcpIconParams
import bcp.designpatterns.coreui.colors.white

/**   Project property of BCP
 *   Created by Dazzord.
 */

/**
 * Bcp icon params with builder pure implementation
 *
 * @constructor Create empty Bcp icon params with builder
 */
class BcpIconParamsWithBuilder private constructor() {

    class Builder {
        private var resourceId: Int = R.drawable.ic_battery
        private var tintColor: Color = white
        private var iconSize: Dp = 30.dp
        private var iconBottomPadding: Dp = 0.dp


        fun build(): BcpIconParams {
            return BcpIconParams(
                resourceId = this.resourceId,
                tintColor = this.tintColor,
                iconSize = this.iconSize,
                iconBottomPadding = this.iconBottomPadding
            )
        }

        fun setResourceId(resourceId: Int): Builder {
            this.resourceId = resourceId
            return this
        }

        fun setTintColor(tintColor: Color): Builder {
            this.tintColor = tintColor
            return this
        }

        fun setIconSize(iconSize: Dp): Builder {
            this.iconSize = iconSize
            return this
        }

        fun setIconBottomPadding(iconBottomPadding: Dp): Builder {
            this.iconBottomPadding = iconBottomPadding
            return this
        }
    }
}

/**
 * Bcp icon params with builder pure implementation with
 * kotlin apply scope function
 */
class BcpIconParamsWithApplyBuilder() {

    data class Builder private constructor(
        private var resourceId: Int = R.drawable.ic_battery,
        private var tintColor: Color = white,
        private var iconSize: Dp = 30.dp,
        private var iconBottomPadding: Dp = 0.dp,
    ) {

        fun build(): BcpIconParams = BcpIconParams(
            resourceId = this.resourceId,
            tintColor = this.tintColor,
            iconSize = this.iconSize,
            iconBottomPadding = this.iconBottomPadding
        )

        fun setResourceId(resourceId: Int) = apply { this.resourceId = resourceId }
        fun setTintColor(tintColor: Color) = apply { this.tintColor = tintColor }
        fun setIconSize(iconSize: Dp) = apply { this.iconSize = iconSize }
        fun setIconBottomPadding(iconBottomPadding: Dp) =
            apply { this.iconBottomPadding = iconBottomPadding }
    }
}


/** -----------------------------------------------------------------------------------------------------
 * Bad Implementation
 */

/**
 * Problem 1: Non-private Constructor
 * A client that uses this class can still construct it by using the constructor instead of
 * the builder. Since using a constructor is the natural way of initializing an Object another
 * developer might do this and therefore bypass the builder in the first place which could lead to
 * inconsistent objects when you do validation in your builder.
 */
data class BcpIconParamsBuilderBadImplementation(
    val resourceId: Int = R.drawable.ic_battery,
    val tintColor: Color,
    val iconSize: Dp,
    val iconBottomPadding: Dp,
){
    class Builder(
        /**
         * Probmen 2: Omitted Default Values
         * Looking at the constructor of the object you see that resourceId has a default value with
         * R.drawable.ic_battery. But when using the Builder you are forced to reassign the id.
         */
        var resourceId: Int?=null,
        var tintColor: Color? = null,
        var iconSize: Dp? = null,
        var iconBottomPadding: Dp? = null,
    ) {
        fun build(): BcpIconParamsBuilderBadImplementation {

            /**
             * Problem 3: NullPointerExceptions
             * This is problematic. Imagine you extend this class at some point with another
             * attribute. At this point the compiler won’t tell you where you need to adjust the
             * creation of this object, but you would experience a NullPointerException at runtime.
             * You could solve it by applying the Robust Builder Pattern, but it would mean a lot
             * more code that is required to achieve that.
             */
            return BcpIconParamsBuilderBadImplementation(
                resourceId = this.resourceId!!,
                tintColor = this.tintColor!!,
                iconSize = this.iconSize!!,
                iconBottomPadding = this.iconBottomPadding!!
            )
        }

        fun setResourceId(resourceId: Int): Builder {
            this.resourceId = resourceId
            return this
        }

        fun setTintColor(tintColor: Color): Builder {
            this.tintColor = tintColor
            return this
        }

        fun setIconSize(iconSize: Dp): Builder {
            this.iconSize = iconSize
            return this
        }

        fun setIconBottomPadding(iconBottomPadding: Dp): Builder {
            this.iconBottomPadding = iconBottomPadding
            return this
        }
    }
    /**
     * Problem 4: Borlerplate Code
     * As you can see for a single attribute in the class you need to write a lot of duplicated
     * code. I don’t want to do that.
     */
}
