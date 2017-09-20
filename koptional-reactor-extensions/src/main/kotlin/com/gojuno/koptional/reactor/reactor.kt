package com.gojuno.koptional.reactor

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import reactor.core.publisher.Flux

private inline fun <reified R : Any> Flux<*>.ofType(): Flux<R> = ofType(R::class.java)

/**
 * Filters items emitted by a Flux by only emitting those that are `Some`.
 * <p>
 * <img width="640" height="310" src="https://raw.githubusercontent.com/reactor/reactor-core/v3.1.0.M2/src/docs/marble/filter.png" alt="">
 *
 * @return a Flux that emits `Some.value` of those items emitted by the source Flux that are `Some`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Flux<out Optional<T>>.filterSome(): Flux<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a Flux by only emitting those that are `None`.
 * <p>
 * <img width="640" height="310" src="https://raw.githubusercontent.com/reactor/reactor-core/v3.1.0.M2/src/docs/marble/filter.png" alt="">
 *
 * @return a Flux that emits `Unit` for each item emitted by the source Flux that is `None`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Flux<out Optional<T>>.filterNone(): Flux<Unit> = ofType<None>().map { Unit }
