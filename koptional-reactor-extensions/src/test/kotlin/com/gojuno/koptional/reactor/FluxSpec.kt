package com.gojuno.koptional.reactor

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

@Testable
class FluxSpec : Spek({

    val flux: Flux<out Optional<String>> by memoized {
        Flux.just(Some("a"), None, Some("b"), Some("c"), None)
    }

    it("passes Some values on filterSome") {
        StepVerifier.create(flux.filterSome())
            .expectNext("a", "b", "c")
            .expectComplete()
            .verify()
    }

    it("passes None values as Unit on filterNone") {
        StepVerifier.create(flux.filterNone())
            .expectNext(Unit, Unit)
            .expectComplete()
            .verify()
    }

})
