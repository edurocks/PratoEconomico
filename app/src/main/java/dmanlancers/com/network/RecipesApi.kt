package dmanlancers.com.network

import dmanlancers.com.data.Menus
import io.reactivex.Flowable
import retrofit2.http.GET

interface RecipesApi {

    @GET("menus")
    fun getMenu() : Flowable<List<Menus>>
}