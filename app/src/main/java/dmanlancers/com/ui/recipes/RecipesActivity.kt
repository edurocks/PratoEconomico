package dmanlancers.com.ui.recipes

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import dmanlancers.com.R

class RecipesActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipes_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipesFragment.newInstance())
                .commitNow()
        }
    }

}
