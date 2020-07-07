package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Observable

private inline fun <reified R : Any> Observable<*>.ofType(): Observable<R> = ofType(R::class.java)

/**
 * Filters items emitted by an [Observable] by only emitting those that are [Some].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return an [Observable] that emits [Some.value] of those items emitted by the source [Observable] that are [Some].
 * @see [Observable.filter]
 */
fun <T : Any> Observable<out Optional<T>>.filterSome(): Observable<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by an [Observable] by only emitting those that are [None].
 *
 * Does not operate by default on a particular [Scheduler][io.reactivex.Scheduler].
 *
 * @return an [Observable] that emits [Unit] for each item emitted by the source [Observable] that is [None].
 * @see [Observable.filter]
 */
fun <T : Any> Observable<out Optional<T>>.filterNone(): Observable<Unit> = ofType<None>().map { Unit }
