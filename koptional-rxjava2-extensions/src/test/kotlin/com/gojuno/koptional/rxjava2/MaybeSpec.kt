package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Maybe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable

@Testable
class MaybeSpec : Spek({

    context("value is Some") {

        val maybe: Maybe<out Optional<String>> by memoized {
            Maybe.just(Some("a"))
        }

        it("passes Some value on filterSome") {
            maybe
                .filterSome()
                .test()
                .assertResult("a")
        }

        it("does not pass value on filterNone") {
            maybe
                .filterNone()
                .test()
                .assertNoValues()
                .assertComplete()
                .assertNoErrors()
        }
    }

    context("value is None") {

        val maybe: Maybe<out Optional<String>> by memoized {
            Maybe.just(None)
        }

        it("does not pass Some value on filterSome") {
            maybe
                .filterSome()
                .test()
                .assertNoValues()
                .assertComplete()
                .assertNoErrors()
        }

        it("passes None value as Unit on filterNone") {
            maybe
                .filterNone()
                .test()
                .assertResult(Unit)
        }
    }

})
