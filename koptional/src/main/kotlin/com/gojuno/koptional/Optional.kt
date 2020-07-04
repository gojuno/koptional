package com.gojuno.koptional

sealed class Optional<out T : Any> {

    /**
     * Converts [Optional] to either its non-`null` value if it’s [Some] or `null` if it’s [None].
     */
    abstract fun toNullable(): T?

    /**
     * Unwraps this [Optional] to either its non-`null` value if it’s [Some] or `null` if it’s [None].
     */
    @JvmSynthetic
    abstract operator fun component1(): T?

    companion object {

        /**
         * Wraps an instance of `T` (or `null`) into an [Optional]:
         *
         * ```java
         * Optional<String> some = Optional.toOptional("value"); // Some("value")
         * Optional<String> none = Optional.toOptional(null);    // None
         * ```
         *
         * This is the preferred method of obtaining an instance of [Optional] in Java. In Kotlin,
         * prefer using the [toOptional][com.gojuno.koptional.toOptional] extension function.
         */
        @JvmStatic
        fun <T : Any> toOptional(value: T?): Optional<T> = if (value == null) None else Some(value)
    }
}

data class Some<out T : Any>(val value: T) : Optional<T>() {
    override fun toNullable(): T = value
    override fun toString() = "Some($value)"
}

object None : Optional<Nothing>() {
    override fun component1(): Nothing? = null
    override fun toNullable(): Nothing? = null
    override fun toString() = "None"
}

/**
 * Wraps an instance of `T` (or `null`) into an [Optional]:
 *
 * ```kotlin
 * val someValue: String? = "value"
 * val noneValue: String? = null
 *
 * val some = someValue.toOptional() // Some("value")
 * val none = noneValue.toOptional() // None
 * ```
 *
 * This is the preferred method of obtaining an instance of [Optional] in Kotlin. In Java, prefer
 * using the static [Optional.toOptional] method.
 */
fun <T : Any> T?.toOptional(): Optional<T> = if (this == null) None else Some(this)
