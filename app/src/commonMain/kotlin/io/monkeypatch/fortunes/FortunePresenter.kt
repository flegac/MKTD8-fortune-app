package io.monkeypatch.fortunes

import io.monkeypatch.mvp.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class FortunePresenter(
    private val fortuneView: FortuneView,
    private val fortuneRepository: FortuneRepository,
    private val favoriteFortuneRepository: FavoriteFortuneRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter(fortuneView) {
    private var currentFortune: Fortune? = null

    override fun onCreate() {
        super.onCreate()
        //TODO("implement this")
        loadFortune()
    }

    fun loadFortune() {
        launch(uiDispatcher) {
            //TODO("implement this")
            try {
                fortuneView.showLoading(true)
                currentFortune = fortuneRepository.getRandomFortune()
                fortuneView.showLoading(false)
                currentFortune?.let { fortuneView.displayFortune(it.quote) }
            } catch (e: Exception) {
                fortuneView.displayError(e)
                fortuneView.showLoading(false)

            }

        }
    }

    fun saveAsFavorite() {
        // TODO("implement this")
        currentFortune?.let { favoriteFortuneRepository.saveToFavorite(it) }

    }
}