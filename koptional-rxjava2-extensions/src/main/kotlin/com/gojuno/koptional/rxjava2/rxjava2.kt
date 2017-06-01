package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Observable

private inline fun <reified R : Any> Observable<*>.ofType(): Observable<R> = ofType(R::class.java)

/**
 * Filters items emitted by an ObservableSource by only emitting those that are `Some`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Observable that emits `Some.value` of those items emitted by the source ObservableSource that are `Some`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Observable<Optional<T>>.filterSome(): Observable<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by an ObservableSource by only emitting those that are `None`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Observable that emits `Unit` for each item emitted by the source ObservableSource that is `None`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Observable<Optional<T>>.filterNone(): Observable<Unit> = ofType<None>().map { Unit }
