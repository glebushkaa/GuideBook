package com.gm.ai.guidebook.domain.usecase.core

/**
 * Created by gle.bushkaa email(gleb.mokryy@gmail.com) on 10/26/2023
 */

abstract class ResultSuspendUseCase<Type : Any, in Params : UseCase.Params>(
    private val useCaseLogger: UseCaseLogger,
) : UseCase<Type, Params> {

    abstract suspend operator fun invoke(params: Params): Result<Type>

    @Suppress("TooGenericExceptionCaught")
    suspend fun <T, P> T.runCatching(block: suspend T.() -> P): Result<P> {
        return try {
            Result.success(block())
        } catch (throwable: Throwable) {
            useCaseLogger.logException(javaClass.simpleName, throwable)
            Result.failure(throwable)
        }
    }
}
