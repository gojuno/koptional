package com.gojuno.koptional.rxjava2

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import io.reactivex.Observable
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable

@Testable
class ObservableSpec : Spek({

    val observable: Observable<out Optional<String>> by memoized {
        Observable.just(Some("a"), None, Some("b"), Some("c"), None)
    }

    it("passes Some values on filterSome") {
        observable
            .filterSome()
            .test()
            .assertResult("a", "b", "c")
    }

    it("passes None values as Unit on filterNone") {
        observable
            .filterNone()
            .test()
            .assertResult(Unit, Unit)
    }

})
