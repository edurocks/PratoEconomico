package dmanlancers.com.ui.recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dmanlancers.com.data.Menus
import dmanlancers.com.repository.RecipesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipesViewModel @Inject constructor(): ViewModel() {

    @set:Inject
    var repository : RecipesRepository? = null
    private val dataMenus = MutableLiveData<List<Menus>>()
    private val job = Job()
    private val ioScope = CoroutineScope(Dispatchers.IO + job)

    private fun fetchMenusCoroutines(){

        ioScope.launch {
            dataMenus.postValue(repository?.getMenusCoroutines())
        }
    }

    fun getMenus() : LiveData<List<Menus>>{
        if(dataMenus.value == null){
            fetchMenusCoroutines()
        }
        return dataMenus
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
