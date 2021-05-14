package ru.ar2code.multimodulenavexample

import android.app.Application
import org.koin.core.context.startKoin
import ru.ar2code.feature_a_impl.api.FeatureAImplKoinModule
import ru.ar2code.feature_a_impl_2.api.api.FeatureACustomImplKoinModule
import ru.ar2code.feature_a_ui.api.FeatureAUiKoinModule
import ru.ar2code.feature_b_impl.api.FeatureBImplKoinModule
import ru.ar2code.feature_b_ui.api.FeatureBUiKoinModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /**
         * Construct your application by injection needed modules.
         */
        startKoin {
            modules(
                listOf(
                    AppKoinModule.create(),
                    /**
                     * Change Feature A Impl with a single DI line.
                     */
                    FeatureAImplKoinModule.create(),
                    //FeatureACustomImplKoinModule.create(),
                    FeatureAUiKoinModule.create(),
                    FeatureBImplKoinModule.create(),
                    FeatureBUiKoinModule.create()
                )
            )
        }
    }
}