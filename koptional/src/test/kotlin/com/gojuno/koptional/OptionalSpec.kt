package com.gojuno.koptional

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.commons.annotation.Testable

@Testable
class OptionalSpec : Spek({

    describe("toNullable") {

        it("converts Some to value") {
            val some: Optional<String> = Some("value")

            assertThat(some.toNullable()).isEqualTo("value")
        }

        it("converts None to null") {
            val none: Optional<String> = None

            assertThat(none.toNullable()).isNull()
        }
    }

    describe("toOptional") {

        it("converts value to Some") {
            val value = "value"

            assertThat(value.toOptional()).isEqualTo(Some(value))
        }

        it("converts null to None") {
            val value: String? = null

            assertThat(value.toOptional()).isEqualTo(None)
        }
    }

    describe("toString") {

        it("produces Some representation") {
            assertThat(Some("value").toString()).isEqualTo("Some(value)")
        }

        it("produces None representation") {
            assertThat(None.toString()).isEqualTo("None")
        }
    }

    describe("destructuring") {

        it("destructures Some to value") {
            val some: Optional<String> = Some("value")
            val (destructure) = some

            assertThat(destructure).isEqualTo("value")
        }

        it("destructures None to null") {
            val none: Optional<String> = None
            val (destructure) = none

            assertThat(destructure).isNull()
        }
    }

})
