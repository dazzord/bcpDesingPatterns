package bcp.designpatterns.localdatasource

/**   Project property of BCP
 *   Created by Dazzord.
 */

interface LocalDataSource {
    fun getHomeHeaderTitle(): Pair<String, String>
    fun getBatteryInfo(): List<BatteryInfoModel>
    fun getSystemInfo(): List<Pair<String, String>>
}