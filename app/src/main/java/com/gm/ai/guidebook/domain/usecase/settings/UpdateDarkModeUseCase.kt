package com.gm.ai.guidebook.domain.usecase.settings

import com.gm.ai.guidebook.domain.SettingsDataStore
import com.gm.ai.guidebook.domain.usecase.core.ResultSuspendUseCase
import com.gm.ai.guidebook.domain.usecase.core.UseCase
import com.gm.ai.guidebook.domain.usecase.core.UseCaseLogger
import com.gm.ai.guidebook.domain.usecase.settings.UpdateDarkModeUseCase.Params
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by gle.bushkaa email(gleb.mokryy@gmail.com) on 10/26/2023
 */

class UpdateDarkModeUseCase @Inject constructor(
    private val settingsDataStore: SettingsDataStore,
    useCaseLogger: UseCaseLogger,
) : ResultSuspendUseCase<Unit, Params>(useCaseLogger) {

    override suspend fun invoke(params: Params) = runCatching {
        withContext(Dispatchers.IO) {
            settingsDataStore.updateDarkMode(params.enabled)
        }
    }

    data class Params(
        val enabled: Boolean,
    ) : UseCase.Params
}
