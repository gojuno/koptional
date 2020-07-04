package com.gojuno.koptional.rxjava3

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.rxjava3.core.Flowable
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable

@Testable
class FlowableSpec : Spek({

    val flowable: Flowable<out Optional<String>> by memoized {
        Flowable.just(Some("a"), None, Some("b"), Some("c"), None)
    }

    it("passes Some values on filterSome") {
        flowable
            .filterSome()
            .test()
            .assertResult("a", "b", "c")
    }

    it("passes None values as Unit on filterNone") {
        flowable
            .filterNone()
            .test()
            .assertResult(Unit, Unit)
    }

})
