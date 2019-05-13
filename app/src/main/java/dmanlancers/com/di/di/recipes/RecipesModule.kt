package dmanlancers.com.di.di.recipes

import dagger.Module
import dagger.Provides
import dmanlancers.com.network.RecipesApi
import dmanlancers.com.repository.RecipesRepository
import retrofit2.Retrofit

@Module
class RecipesModule {

    @Provides
    fun providesRecipesApi(retrofit: Retrofit) : RecipesApi{
        return retrofit.create(RecipesApi::class.java)
    }

    @Provides
    fun providesRepository(recipesApi: RecipesApi) : RecipesRepository{
        return RecipesRepository(recipesApi)
    }
}