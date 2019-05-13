package dmanlancers.com.ui.recipes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dmanlancers.com.data.Menus
import dmanlancers.com.repository.RecipesRepository
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class RecipesViewModel @Inject constructor(): ViewModel() {

    @set:Inject
    var repository : RecipesRepository? = null
    private val dataMenus = MutableLiveData<List<Menus>>()
    private var disposable : Disposable? = null

    private fun fetchMenus(){
        disposable = repository?.getMenus()?.subscribe({
            dataMenus.postValue(it)
        },{
            Log.e("erro", it.message)
        })
    }

    fun getMenus() : LiveData<List<Menus>>{
        if(dataMenus.value == null){
            fetchMenus()
        }

        return dataMenus
    }
}
