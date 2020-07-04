package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Single
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable

@Testable
class SingleSpec : Spek({

    context("value is Some") {

        val single: Single<out Optional<String>> by memoized {
            Single.just(Some("a"))
        }

        it("passes Some value on filterSome") {
            single
                .filterSome()
                .test()
                .assertResult("a")
        }

        it("does not pass value on filterNone") {
            single
                .filterNone()
                .test()
                .assertNoValues()
                .assertComplete()
                .assertNoErrors()
        }
    }

    context("value is None") {

        val single: Single<out Optional<String>> by memoized {
            Single.just(None)
        }

        it("does not pass Some value on filterSome") {
            single
                .filterSome()
                .test()
                .assertNoValues()
                .assertComplete()
                .assertNoErrors()
        }

        it("passes None value as Unit on filterNone") {
            single
                .filterNone()
                .test()
                .assertResult(Unit)
        }
    }

})
