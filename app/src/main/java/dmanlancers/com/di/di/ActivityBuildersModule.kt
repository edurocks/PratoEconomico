package dmanlancers.com.di.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dmanlancers.com.di.di.recipes.MainFragmentBuildersModule
import dmanlancers.com.ui.recipes.RecipesActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class])
    abstract fun contributeRecipesAcitivty() : RecipesActivity
}