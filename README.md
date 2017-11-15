## Koptional — Minimalistic Optional type for Kotlin

Disclaimer:

>We don't think that Kotlin itself needs `Optional` because it has strong null-safe type system that effectively eliminates need in such a wrapper. However there are APIs and libraries like [RxJava 2][rxjava2] which don't accept `null` values. 

>We also think that in many cases you can use `sealed class`es to express absent values, however in simple cases like passing `String?` through Rx stream `Optional` is a more convenient solution.

---

The goal of this implementation is to be convenient to use and fit Kotlin's null-safe type system, which resulted in:

* Only two functions (mimics Kotlin std `toInt()`/`toBoolean()`/etc):
  - `fun <T : Any> T?.toOptional(): Optional<T>`
  - `fun Optional.toNullable(): T?`
* `Some` and `None` are declared as **top level types** — no need to write `Optional.Some` or `Optional.None`
* No functions like `map()`, `getOrElse()`, `filter()`, etc — apply `toNullable()` and use Kotlin sdt functions like `let()`, `takeIf()` and so on.

### Usage

#### Create `Some`

```kotlin
val some = Some(value)
```
#### Use `None`

```kotlin
val none = None // It's an object!
```

#### Convert `T?` to `Optional<T>`

```kotlin
// If something is null — you'll get None, otherwise you'll get Some(something).
val o = something.toOptional()
```

#### Convert `Optional<T>` to `T?`

```kotlin
// If Optional is None — you'll get null, otherwise you'll get not null T value.
val t = optional.toNullable()
```

#### Get `value` or fall back to something else if `None` (`getOrElse()`)

```kotlin
val f = optional.toNullable() ?: "fallback"
```
#### Check if `Optional` is `Some` or `None`

```kotlin
when (optional) {
    is Some -> {}
    is None -> {}
}
```

#### Filter only `Some` values emitted by RxJava 2 or Project Reactor

```kotlin
val values: Observable<String> = Observable
    .just(Some("a"), None, Some("b"))
    .filterSome()
    .map { value: String -> } // filterSome() unwraps value for you.
```

#### Filter only `None` values emitted by RxJava 2 or Project Reactor

```kotlin
val noneSignals: Observable<Unit> = Observable
    .just(Some("a"), None, Some("b"))
    .filterNone()
    .map { none: Unit -> } // filterNone() maps None to Unit.
```

### Download

Koptional is [available on jcenter](https://jcenter.bintray.com/com/gojuno/koptional).

Optional type:

```groovy
compile 'com.gojuno.koptional:koptional:put-some-version'
```

[RxJava 2][rxjava2] extensions:

```groovy
compile 'com.gojuno.koptional:koptional-rxjava2-extensions:put-some-version'
```

All the releases and changelogs can be found on [Releases Page](https://github.com/gojuno/koptional/releases).

### How to build

Dependencies: you only need `docker` and `bash` installed on your machine.

```console
bash ci/build.sh
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

[rxjava2]: https://github.com/ReactiveX/RxJava/
