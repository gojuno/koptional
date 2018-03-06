package com.gojuno.koptional

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class OptionalSpec : Spek({

    describe("toNullable") {

        context("Some.toNullable") {

            val result = Some("string").toNullable()

            it("converts it to value") {
                assertThat(result).isEqualTo("string")
            }
        }

        context("None.toNullable") {

            val result = None.toNullable()

            it("converts it to null") {
                assertThat(result as Any?).isNull()
            }
        }
    }

    describe("toOptional") {

        context("NonNull.toOptional") {

            val result = "string".toOptional()

            it("converts it to Some") {
                assertThat(result).isEqualTo(Some("string"))
            }
        }

        context("null.toOptional") {

            val result = null.toOptional()

            it("converts it to None") {
                assertThat(result).isEqualTo(None)
            }
        }
    }

    describe("toString") {

        context("Some<Int>.toString") {

            val result = Some(42).toString()

            it("converts it to String") {
                assertThat(result).isEqualTo("Some(42)")
            }

        }

        context("Some<Object>.toString") {

            val obj = Object()
            val result = Some(obj).toString()

            it("converts it to String") {
                assertThat(result).isEqualTo("Some($obj)")
            }

        }

        context("None.toString") {

            val result = None.toString()

            it("converts it to String") {
                assertThat(result).isEqualTo("None")
            }

        }
    }
})
