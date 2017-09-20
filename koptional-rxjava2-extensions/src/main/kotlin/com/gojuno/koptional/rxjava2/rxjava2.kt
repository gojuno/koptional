package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

private inline fun <reified R : Any> Observable<*>.ofType(): Observable<R> = ofType(R::class.java)
private inline fun <reified R : Any> Flowable<*>.ofType(): Flowable<R> = ofType(R::class.java)
private inline fun <reified R : Any> Maybe<*>.ofType(): Maybe<R> = ofType(R::class.java)
private inline fun <reified R : Any> Single<*>.ofType(): Maybe<R> = filter { it is R }.cast(R::class.java)

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
fun <T : Any> Observable<out Optional<T>>.filterSome(): Observable<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by a Publisher by only emitting those that are `Some`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Flowable that emits `Some.value` of those items emitted by the source Publisher that are `Some`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Flowable<out Optional<T>>.filterSome(): Flowable<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by an MaybeSource by only emitting those that are `Some`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Maybe that emits `Some.value` of those items emitted by the source MaybeSource that are `Some`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Maybe<out Optional<T>>.filterSome(): Maybe<T> = ofType<Some<T>>().map { it.value }

/**
 * Filters items emitted by an SingleSource by only emitting those that are `Some`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Maybe that emits `Some.value` of those items emitted by the source SingleSource that are `Some`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Single<out Optional<T>>.filterSome(): Maybe<T> = ofType<Some<T>>().map { it.value }

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
fun <T : Any> Observable<out Optional<T>>.filterNone(): Observable<Unit> = ofType<None>().map { Unit }

/**
 * Filters items emitted by an Publisher by only emitting those that are `None`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Flowable that emits `Unit` for each item emitted by the source Publisher that is `None`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Flowable<out Optional<T>>.filterNone(): Flowable<Unit> = ofType<None>().map { Unit }

/**
 * Filters items emitted by an MaybeSource by only emitting those that are `None`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Maybe that emits `Unit` for each item emitted by the source MaybeSource that is `None`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Maybe<out Optional<T>>.filterNone(): Maybe<Unit> = ofType<None>().map { Unit }

/**
 * Filters items emitted by an SingleSource by only emitting those that are `None`.
 * <p>
 * <img width="640" height="310" src="https://raw.github.com/wiki/ReactiveX/RxJava/images/rx-operators/filter.png" alt="">
 * <dl>
 *  <dt><b>Scheduler:</b></dt>
 *  <dd>{@code filter} does not operate by default on a particular {@link Scheduler}.</dd>
 * </dl>
 *
 * @return an Maybe that emits `Unit` for each item emitted by the source SingleSource that is `None`.
 * @see <a href="http://reactivex.io/documentation/operators/filter.html">ReactiveX operators documentation: Filter</a>
 */
fun <T : Any> Single<out Optional<T>>.filterNone(): Maybe<Unit> = ofType<None>().map { Unit }
