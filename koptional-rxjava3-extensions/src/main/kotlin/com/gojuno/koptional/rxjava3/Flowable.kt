package com.gojuno.koptional.rxjava3

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.rxjava3.core.Flowable

private inline fun <reified R : Any> Flowable<*>.ofType(): Flowable<R> = ofType(R::class.java)

/**
 * Filters items emitted by a [Flowable] by only emitting those that are [Some].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return a [Flowable] that emits [Some.value] of those items emitted by the source [Flowable] that are [Some].
 * @see [Flowable.filter]
 */
fun <T : Any> Flowable<out Optional<T>>.filterSome(): Flowable<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a [Flowable] by only emitting those that are [None].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return a Flowable that emits [Unit] for each item emitted by the source [Flowable] that is [None].
 * @see [Flowable.filter]
 */
fun <T : Any> Flowable<out Optional<T>>.filterNone(): Flowable<Unit> = ofType<None>().map { Unit }
