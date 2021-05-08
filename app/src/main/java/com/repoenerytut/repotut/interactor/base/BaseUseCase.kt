package com.repoenerytut.repotut.interactor.base

abstract class BaseUseCase<in Request, Response> {
    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    abstract suspend fun invoke(parameters: Request? = null): Response
}
