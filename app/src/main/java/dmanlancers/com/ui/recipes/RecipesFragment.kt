package dmanlancers.com.ui.recipes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import dmanlancers.com.R

class RecipesFragment : DaggerFragment() {

    companion object {
        fun newInstance() = RecipesFragment()
    }

    private lateinit var viewModel: RecipesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
