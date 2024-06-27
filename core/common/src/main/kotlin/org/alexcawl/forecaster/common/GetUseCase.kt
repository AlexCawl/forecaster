package org.alexcawl.forecaster.common

import kotlinx.coroutines.flow.Flow

abstract class GetUseCase<I, O> {
    abstract operator fun invoke(input: I): Flow<O>
}