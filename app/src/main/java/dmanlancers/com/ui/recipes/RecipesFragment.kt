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
import dmanlancers.com.network.Resource
import dmanlancers.com.di.di.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class RecipesFragment : DaggerFragment() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    private lateinit var viewModel: RecipesViewModel
   // private lateinit var ldClient : LDClient
   // private lateinit var listenerFlag : FeatureFlagChangeListener

    companion object {
        fun newInstance() = RecipesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.recipes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, providerFactory).get(RecipesViewModel::class.java)


      /*  val ldConfig = LDConfig.Builder()
            .setMobileKey("mob-52a4c6d5-1b94-4ca3-8304-7267f4e19555")
            .build()

        val ldUser = LDUser.Builder("user_key")
                    .email("example@gmail.com")
                    .build()

        ldClient = LDClient.init(activity?.application, ldConfig, ldUser, 5)

        listenerFlag = FeatureFlagChangeListener { flagKey ->
            val value = LDClient.get().boolVariation(flagKey, false)
            if (!value){
                recipes.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorAccent))
            }else{
                recipes.setBackgroundColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
            }
        }*/

       // LDClient.get().registerFeatureFlagListener("manage-mqtt-connection", listenerFlag)
        viewModel.getMenus().observe(this, Observer {menus ->
            if (menus != null){
                when(menus.status){

                    Resource.Status.SUCCESS -> {
                        menus.data?.forEach {
                            Log.e("nomes", it.name)
                        }
                    }

                    Resource.Status.ERROR -> {
                        Log.e("erro", menus.message)
                    }

                    else -> Log.d("loading", "depois colocar o loading")
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
       // ldClient.close()
       // ldClient.unregisterFeatureFlagListener("manage-mqtt-connection", listenerFlag)
    }
}
