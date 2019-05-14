package dmanlancers.com.network

import dmanlancers.com.data.Menus
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RecipesApi {

    @GET("menus")
    fun getMenuAsync() : Deferred<Response<List<Menus>>>
}