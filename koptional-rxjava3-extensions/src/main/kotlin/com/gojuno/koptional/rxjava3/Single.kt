package com.gojuno.koptional.rxjava3

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

private inline fun <reified R : Any> Single<*>.ofType(): Maybe<R> = filter { it is R }.cast(R::class.java)

/**
 * Filters items emitted by a [Single] by only emitting those that are [Some].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return a [Maybe] that emits [Some.value] of those items emitted by the source [Single] that are [Some].
 * @see [Single.filter]
 */
fun <T : Any> Single<out Optional<T>>.filterSome(): Maybe<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a [Single] by only emitting those that are [None].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return an [Maybe] that emits [Unit] for each item emitted by the source [Single] that is [None].
 * @see [Single.filter]
 */
fun <T : Any> Single<out Optional<T>>.filterNone(): Maybe<Unit> = ofType<None>().map { Unit }
