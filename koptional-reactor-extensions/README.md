## Koptional Extensions for Project Reactor

### Usage

```kotlin
// Filter only Some values emitted by Project Reactor's Flux.
val values: Flux<String> = Flux
    .just(Some("a"), None, Some("b"))
    .filterSome()

// Filter only None signals emitted by Project Reactor's Flux.
val noneSignals: Flux<Unit> = Flux
    .just(Some("a"), None, Some("b"))
    .filterNone() 
```

### Download

Koptional is [available on jcenter](https://jcenter.bintray.com/com/gojuno/koptional).

[Project Reactor Extensions](https://projectreactor.io/) extensions:

```groovy
compile 'com.gojuno.koptional:koptional-reactor-extensions:put-some-version'
```
