package bcp.designpatterns.featurebatteryinfo.domain.repository

import bcp.designpatterns.featurebatteryinfo.domain.entity.BatteryInfoEntity

/**   Project property of BCP
 *   Created by Dazzord.
 */
interface BatteryInfoRepository {

    fun getBatteryInfo(): List<BatteryInfoEntity>
}