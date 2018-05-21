package com.gojuno.koptional

sealed class Optional<out T : Any> {

    fun toNullable(): T? = when (this) {
        is Some -> value
        is None -> null
    }

    companion object {

        /**
         * Wrap an instance of T (or null) into an [Optional]:
         *
         * ```
         * String a = "str";
         * String b = null;
         *
         * Optional<String> optionalA = Optional.toOptional(a); // Some("str")
         * Optional<String> optionalB = Optional.toOptional(b); // None
         * ```
         *
         * This is the preferred method of obtaining an instance of [Optional] in Java. In Kotlin,
         * prefer using the [toOptional][com.gojuno.koptional.toOptional] extension function.
         */
        @JvmStatic
        fun <T : Any> toOptional(t: T?): Optional<T> = t.toOptional()
    }
}

data class Some<out T : Any>(val value: T) : Optional<T>() {
    override fun toString() = "Some($value)"
}

object None : Optional<Nothing>() {
    override fun toString() = "None"
}

/**
 * Wrap an instance of T (or null) into an [Optional]:
 *
 * ```
 * val a: String? = "str"
 * val b: String? = null
 *
 * val optionalA = a.toOptional() // Some("str")
 * val optionalB = b.toOptional() // None
 * ```
 *
 * This is the preferred method of obtaining an instance of [Optional] in Kotlin. In Java, prefer
 * using the static [Optional.toOptional] method.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <T : Any> T?.toOptional(): Optional<T> = if (this == null) None else Some(this)
