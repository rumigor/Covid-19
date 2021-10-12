package ru.rumigor.covid_19.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ru.rumigor.covid_19.R
import ru.rumigor.covid_19.data.network.NetworkState
import ru.rumigor.covid_19.data.network.NetworkStateObservable
import ru.rumigor.covid_19.view.abs.AbsActivity
import ru.rumigor.covid_19.view.countriesList.CountriesListScreen
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(CountriesListScreen)

        val connect =
            NetworkStateObservable(this)
                .doOnNext { onNext(0, it) }
                .publish()

        connect.connect()

        disposables +=
            connect.delay(32L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe { onNext(1, it) }
        disposables += connect.delay(16L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(2, it) }
        disposables += connect.delay(8L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .subscribe { onNext(3, it) }
    }

    private fun onNext(no: Int, state: NetworkState) {
        Toast.makeText(this, "$no: NetworkState: $state", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()

        disposables.dispose()
    }

}