package bcp.designpatterns.core.mapper

/**   Project property of BCP
 *   Created by Dazzord.
 */

/**
 * Mapper
 *
 * @param INPUT is the source object
 * @param OUTPUT is the result of mapping, the desire object
 * @constructor Create empty Mapper
 */
interface Mapper<in INPUT, out OUTPUT> {

    fun mapperTo(input: INPUT): OUTPUT
}