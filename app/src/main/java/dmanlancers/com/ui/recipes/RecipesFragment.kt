package dmanlancers.com.ui.recipes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import dmanlancers.com.R
import dmanlancers.com.di.di.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class RecipesFragment : DaggerFragment() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    private lateinit var viewModel: RecipesViewModel

    companion object {
        fun newInstance() = RecipesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, providerFactory).get(RecipesViewModel::class.java)
        viewModel.getMenus().observe(this, Observer {menus ->
            menus.forEach {
                Log.e("names", it.name)
            }
        })
    }

}
