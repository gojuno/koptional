## Koptional — Minimalistic Optional type for Kotlin

The goal of this implementation is to be convenient to use and fit Kotlin's null-safe type system, which resulted in:

* Only two functions (mimics Kotlin std `toInt()`/`toBoolean()`/etc):
  - `fun <T : Any> T?.toOptional(): Optional<T>`
  - `fun Optional.toNullable(): T?`
* `Some` and `None` are declared as **top level types** — no need to write `Optional.Some` or `Optional.None`

### Usage

```kotlin

// Create Some.
val some = Some(value)

// Use None.
val none = None // It's object.

// Convert T? to Optional<T>.
// If something is null — you'll get None, otherwise you'll get Some(something).
val o = something.toOptional()

// Convert Optional<T> to T?.
// If Optional is None — you'll get null, otherwise you'll get not null T value.
val t = optional.toNullable()

// Check if Optional is Some or None.
val v = when (optional) {
    is Some -> optional.value // Smart Casts Optional to Some and allows you access its value.
    is None -> "fallback"
}
```

### Download

Koptional is [available on jcenter](https://jcenter.bintray.com/com/gojuno/koptional).

```groovy
compile 'com.gojuno.koptional:koptional:put-some-version'
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
