package dmanlancers.com.repository

import dmanlancers.com.data.Menus
import dmanlancers.com.network.RecipesApi
import javax.inject.Inject

class RecipesRepository @Inject constructor(private val recipesApi: RecipesApi) {

    suspend fun getMenusCoroutines() : List<Menus> {
        return recipesApi.getMenuAsync().await()
    }
}