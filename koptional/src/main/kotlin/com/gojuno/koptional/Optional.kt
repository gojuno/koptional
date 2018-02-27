package com.gojuno.koptional

sealed class Optional<out T : Any> {

    fun toNullable(): T? = when (this) {
        is Some -> value
        is None -> null
    }
}

data class Some<out T : Any>(val value: T) : Optional<T>() {
    override fun toString() = "Some($value)"
}

object None : Optional<Nothing>() {
    override fun toString() = "None"
}

fun <T : Any> T?.toOptional(): Optional<T> = if (this == null) None else Some(this)
