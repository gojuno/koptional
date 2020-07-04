package com.gojuno.koptional.reactor

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import reactor.core.publisher.Flux

private inline fun <reified R : Any> Flux<*>.ofType(): Flux<R> = ofType(R::class.java)

/**
 * Filters items emitted by a [Flux] by only emitting those that are [Some].
 *
 * @return a [Flux] that emits [Some.value] of those items emitted by the source [Flux] that are [Some].
 * @see [Flux.filter]
 */
fun <T : Any> Flux<out Optional<T>>.filterSome(): Flux<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a [Flux] by only emitting those that are [None].
 *
 * @return a [Flux] that emits [Unit] for each item emitted by the source [Flux] that is [None].
 * @see [Flux.filter]
 */
fun <T : Any> Flux<out Optional<T>>.filterNone(): Flux<Unit> = ofType<None>().map { Unit }
