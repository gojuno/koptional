package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Maybe

private inline fun <reified R : Any> Maybe<*>.ofType(): Maybe<R> = ofType(R::class.java)

/**
 * Filters items emitted by a [Maybe] by only emitting those that are [Some].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return a [Maybe] that emits [Some.value] of those items emitted by the source [Maybe] that are [Some].
 * @see [Maybe.filter]
 */
fun <T : Any> Maybe<out Optional<T>>.filterSome(): Maybe<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a [Maybe] by only emitting those that are [None].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return a [Maybe] that emits [Unit] for each item emitted by the source [Maybe] that is [None].
 * @see [Maybe.filter]
 */
fun <T : Any> Maybe<out Optional<T>>.filterNone(): Maybe<Unit> = ofType<None>().map { Unit }
