package bcp.designpatterns.featurehome.presentation

/**   Project property of BCP
 *   Created by Dazzord.
 */

data class HomeViewState(
    var homeInfo: HomePresentationModel? = null
) {

    fun homeInfoReady(homeInfo: HomePresentationModel) = copy(
        homeInfo = homeInfo
    )
}
