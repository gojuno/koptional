package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.subscribers.TestSubscriber
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it

class RxJava2ExtensionsSpec : Spek({

    context("Observable") {

        val stream: Observable<out Optional<String>> by memoized {
            Observable.just(Some("a"), None, Some("b"), Some("c"), None)
        }

        context("filterSome") {

            val subscriber by memoized {
                TestObserver<String>().apply {
                    stream
                            .filterSome()
                            .subscribe(this)
                }
            }

            it("passes only Some values") {
                subscriber.assertValues("a", "b", "c")
            }

            it("completes stream") {
                subscriber.assertComplete()
            }

            it("does not emit error") {
                subscriber.assertNoErrors()
            }
        }

        context("filterNone") {

            val subscriber by memoized {
                TestObserver<Unit>().apply {
                    stream
                            .filterNone()
                            .subscribe(this)
                }
            }

            it("passes only None values as Unit") {
                subscriber.assertValues(Unit, Unit)
            }

            it("completes stream") {
                subscriber.assertComplete()
            }

            it("does not emit error") {
                subscriber.assertNoErrors()
            }
        }
    }

    context("Flowable") {

        val stream: Flowable<out Optional<String>> by memoized {
            Flowable.just(Some("a"), None, Some("b"), Some("c"), None)
        }

        context("filterSome") {

            val subscriber by memoized {
                TestSubscriber<String>().apply {
                    stream
                            .filterSome()
                            .subscribe(this)
                }
            }

            it("passes only Some values") {
                subscriber.assertValues("a", "b", "c")
            }

            it("completes stream") {
                subscriber.assertComplete()
            }

            it("does not emit error") {
                subscriber.assertNoErrors()
            }
        }

        context("filterNone") {

            val subscriber by memoized {
                TestSubscriber<Unit>().apply {
                    stream
                            .filterNone()
                            .subscribe(this)
                }
            }

            it("passes only None values as Unit") {
                subscriber.assertValues(Unit, Unit)
            }

            it("completes stream") {
                subscriber.assertComplete()
            }

            it("does not emit error") {
                subscriber.assertNoErrors()
            }
        }
    }

    context("Maybe") {

        context("Stream with Some") {
            val stream: Maybe<out Optional<String>> by memoized {
                Maybe.just(Some("a"))
            }

            context("filterSome") {

                val subscriber by memoized {
                    TestObserver<String>().apply {
                        stream
                                .filterSome()
                                .subscribe(this)
                    }
                }

                it("passes only Some values") {
                    subscriber.assertValues("a")
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

            context("filterNone") {

                val subscriber by memoized {
                    TestObserver<Unit>().apply {
                        stream
                                .filterNone()
                                .subscribe(this)
                    }
                }

                it("do not emit values") {
                    subscriber.assertNoValues()
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

        }

        context("Stream with None") {
            val stream: Maybe<out Optional<String>> by memoized {
                Maybe.just(None)
            }

            context("filterSome") {

                val subscriber by memoized {
                    TestObserver<String>().apply {
                        stream
                                .filterSome()
                                .subscribe(this)
                    }
                }

                it("do not emit values") {
                    subscriber.assertNoValues()
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

            context("filterNone") {

                val subscriber by memoized {
                    TestObserver<Unit>().apply {
                        stream
                                .filterNone()
                                .subscribe(this)
                    }
                }

                it("passes only None value as Unit") {
                    subscriber.assertValue(Unit)
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }
        }
    }

    context("Single") {

        context("Stream with Some") {
            val stream: Single<out Optional<String>> by memoized {
                Single.just(Some("a"))
            }

            context("filterSome") {

                val subscriber by memoized {
                    TestObserver<String>().apply {
                        stream
                                .filterSome()
                                .subscribe(this)
                    }
                }

                it("passes only Some values") {
                    subscriber.assertValues("a")
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

            context("filterNone") {

                val subscriber by memoized {
                    TestObserver<Unit>().apply {
                        stream
                                .filterNone()
                                .subscribe(this)
                    }
                }

                it("do not emit values") {
                    subscriber.assertNoValues()
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

        }

        context("Stream with None") {
            val stream: Single<out Optional<String>> by memoized {
                Single.just(None)
            }

            context("filterSome") {

                val subscriber by memoized {
                    TestObserver<String>().apply {
                        stream
                                .filterSome()
                                .subscribe(this)
                    }
                }

                it("do not emit values") {
                    subscriber.assertNoValues()
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }

            context("filterNone") {

                val subscriber by memoized {
                    TestObserver<Unit>().apply {
                        stream
                                .filterNone()
                                .subscribe(this)
                    }
                }

                it("passes only None value as Unit") {
                    subscriber.assertValue(Unit)
                }

                it("completes stream") {
                    subscriber.assertComplete()
                }

                it("does not emit error") {
                    subscriber.assertNoErrors()
                }
            }
        }
    }
})
