package dmanlancers.com.repository

import dmanlancers.com.network.Resource
import dmanlancers.com.data.Menus
import dmanlancers.com.network.RecipesApi
import java.io.IOException
import javax.inject.Inject

class RecipesRepository @Inject constructor(private val recipesApi: RecipesApi) {

    suspend fun getMenusCoroutines() : Resource<List<Menus>?> {
        return try {
            val response = recipesApi.getMenuAsync().await()
            if (response.isSuccessful){
                Resource.success(response.body())
            }else{
                Resource.error(response.code().toString(), null)
            }
        }catch (e : IOException){
            Resource.error(e.message!!, null)
        }
    }
}