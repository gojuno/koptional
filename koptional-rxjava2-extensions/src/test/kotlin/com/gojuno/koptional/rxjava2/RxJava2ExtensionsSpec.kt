package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Some
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it

class RxJava2ExtensionsSpec : Spek({

    val stream by memoized {
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
})
