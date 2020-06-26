# Koptional — Minimalistic `Optional` type for Kotlin

> We don't think that Kotlin itself needs `Optional` because it has strong
> `null`-safe type system that effectively eliminates need in such a wrapper.
> However there are Java APIs and libraries like [RxJava 2][rxjava2] and [RxJava 3][rxjava3] which don't accept `null` values
> and language-level nullability cannot help with that.

> We also think that in many cases you can use `sealed class`es to express absent values,
> however in simple cases like passing `String?` through RxJava stream `Optional` is a more convenient solution.

The goal of this implementation is to be convenient to use and fit Kotlin's `null`-safe type system, which resulted in:

* Only two functions: `toOptional()` and `toNullable()`.
  * Mimics Kotlin functions like `toInt()` and `toBoolean()`.
* `Some` and `None` are declared as **top level types**.
  * No need to write `Optional.Some` or `Optional.None`.
* No functions like `map()`, `getOrElse()`, `filter()`, etc.
  * Use `toNullable()` and Kotlin `stdlib` functions like `let()`, `takeIf()` instead.

## Usage

### Create

```kotlin
val some = Some(value)
val none = None // It's an object!
```

### Convert

```kotlin
// T? → Optional<T>
// If value is null — you'll get None, otherwise you'll get Some(value).
val o = value.toOptional()

// Optional<T> → T?
// If optional is None — you'll get null, otherwise you'll get non-null T value.
val t = optional.toNullable()
```

### Leverage Kotlin Features

#### Fallback from `None` (like `java.util.Optional.getOrElse()`)

```kotlin
val f = optional.toNullable() ?: "fallback"
```
#### [Smart Cast](http://kotlinlang.org/docs/reference/typecasts.html#smart-casts)

```kotlin
when (optional) {
    is Some -> println(optional.value)
    is None -> println("Nope!")
}
```

#### [Destructuring](https://kotlinlang.org/docs/reference/multi-declarations.html)

```kotlin
// If Optional is None — you'll get null, otherwise you'll get non-null T value.
val (value) = optional
```

### Java Interop

Use the static `Optional.toOptional()` to wrap an instance of `T` into `Optional<T>`.

### RxJava Extensions

```kotlin
val values = Observable.just(Some("a"), None, Some("b"))

// Filter Some values.
values
    .filterSome()
    .test()
    .assertValues("a", "b")

// Filter None values.
values
    .filterNone()
    .test()
    .assertValues(Unit) // filterNone() maps None to Unit.
```

### Reactor Extensions

```kotlin
val values = Flux.just(Some("a"), None, Some("b"))

// Filter Some values.
values.filterSome()

// Filter None values.
values.filterNone()
```

## Download

Koptional is [available on jcenter](https://jcenter.bintray.com/com/gojuno/koptional).
All the releases and changelogs can be found on [Releases Page](https://github.com/gojuno/koptional/releases).

### `Optional`

```groovy
implementation "com.gojuno.koptional:koptional:$koptional_version"
```

### [RxJava 2][rxjava2] Extensions

```groovy
implementation "com.gojuno.koptional:koptional-rxjava2-extensions:$koptional_version"
```

### [RxJava 3][rxjava3] Extensions

```groovy
implementation "com.gojuno.koptional:koptional-rxjava3-extensions:$koptional_version"
```

### [Reactor](https://projectreactor.io/) Extensions

```groovy
implementation "com.gojuno.koptional:koptional-reactor-extensions:$koptional_version"
```


## License

```
Copyright 2017 Juno, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[rxjava2]: https://github.com/ReactiveX/RxJava/tree/2.x
[rxjava3]: https://github.com/ReactiveX/RxJava/tree/3.x
