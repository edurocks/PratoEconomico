package dmanlancers.com.di.di.recipes

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dmanlancers.com.ui.recipes.RecipesFragment

@Module
abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector(modules = [RecipesViewModelModule::class, RecipesModule::class])
    abstract fun contributeRecipeFragment() : RecipesFragment
}