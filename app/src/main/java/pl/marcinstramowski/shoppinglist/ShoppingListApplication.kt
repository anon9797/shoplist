package pl.marcinstramowski.shoppinglist

import com.squareup.leakcanary.BuildConfig
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import pl.marcinstramowski.shoppinglist.di.components.DaggerAppComponent
import dagger.android.DaggerApplication
import dagger.android.support.DaggerAppCompatActivity
import pl.marcinstramowski.shoppinglist.di.components.AppComponent
import timber.log.Timber

/**
 * Class for maintaining global Shopping List application state
 */
class ShoppingListApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

    }




//    override fun applicationInjector() = AppComponent.builder().application(this).build()

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()
}