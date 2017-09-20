package com.gojuno.koptional.reactor

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.Some
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class ReactorExtensionsSpec : Spek({

    val stream: Flux<out Optional<String>> by memoized {
        Flux.just(Some("a"), None, Some("b"), Some("c"), None)
    }

    context("filterSome") {

        val stepVerifier by memoized {
            StepVerifier.create(
                    stream
                            .filterSome()
            )
        }

        it("passes only Some values") {
            stepVerifier
                    .expectNext("a", "b", "c")
                    .verifyComplete()
        }
    }

    context("filterNone") {

        val subscriber by memoized {
            StepVerifier.create(
                    stream
                            .filterNone()
            )
        }

        it("passes only None values as Unit") {
            subscriber
                    .expectNext(Unit, Unit)
                    .verifyComplete()
        }
    }
})
