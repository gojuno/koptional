## Koptional — Minimalistic Optional type for Kotlin

Goal of this implementation is to be **convenient to use** and **fit** Kotlin's **null-safe type system**, which resulted in:

* Only two functions (mimics Kotlin std `.toInt()/toBoolean()/etc`):
  - `fun <T : Any> T?.toOptional(): Optional<T>`
  - `fun Optional.toNullable(): T?`
* `Some` and `None` declared as **top level types**, no need to write `Optional.Some` or `Optional.None`

### API

#### Create `Some`

```kotlin
val o = Some(value)
```

#### Use `None`

```kotlin
val o = None // It's an object.
```

#### Convert `T?` to `Optional<T>`

```kotlin
val o = something.toOptional()
```

If `something` is `null` — you'll get `None`, otherwise you'll get `Some(something)`.

#### Convert `Optional<T>` to `T?`

```kotlin
val t = optional.toNullable()
```

If `Optional` is `None` then you'll get `null`, otherwise you'll get `T` value.

#### Check if `Optional` is `Some` or `None`

```kotlin
val v = when (optional) {
    is Some -> optional.value // Kotlin will Smart Cast Optional to Some and allow you to get its value.
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
