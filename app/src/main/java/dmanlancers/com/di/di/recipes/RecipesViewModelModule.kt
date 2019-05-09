package dmanlancers.com.di.di.recipes

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dmanlancers.com.di.di.viewmodels.ViewModelKey
import dmanlancers.com.ui.recipes.RecipesViewModel

@Module
abstract class RecipesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    abstract fun bindRecipesViewModel(recipesViewModel: RecipesViewModel) : ViewModel
}