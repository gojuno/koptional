package com.gojuno.koptional

sealed class Optional<out T : Any> {

    /**
     * Converts [Optional] to either its non-null value if it's [Some] or `null` if it's [None].
     */
    abstract fun toNullable(): T?
}

data class Some<out T : Any>(val value: T) : Optional<T>() {
    override fun toString() = "Some($value)"
    override fun toNullable(): T = value
}

object None : Optional<Nothing>() {
    override fun toString() = "None"
    override fun toNullable(): Nothing? = null
}

fun <T : Any> T?.toOptional(): Optional<T> = if (this == null) None else Some(this)
