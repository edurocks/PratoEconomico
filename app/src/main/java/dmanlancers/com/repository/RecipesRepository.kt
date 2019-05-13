package dmanlancers.com.repository

import dmanlancers.com.data.Menus
import dmanlancers.com.network.RecipesApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipesRepository @Inject constructor(private val recipesApi: RecipesApi) {

    fun getMenus() : Observable<List<Menus>>? {
        return recipesApi.getMenu().toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}