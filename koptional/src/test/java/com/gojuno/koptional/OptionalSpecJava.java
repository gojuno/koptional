package com.gojuno.koptional;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalSpecJava {

    @Test public void someToNullable() {
        String result = new Some<>("string").toNullable();
        assertThat(result).isEqualTo("string");
    }

    @Test public void noneToNullable() {
        Object result = None.INSTANCE.toNullable();
        assertThat(result).isNull();
    }

    @Test public void nonNullToOptional() {
        Optional<String> result = Optional.toOptional("string");
        assertThat(result).isEqualTo(new Some<>("string"));
    }

    @Test public void nonNullToOptionalCompat() {
        Optional<String> result = OptionalKt.toOptional("string");
        assertThat(result).isEqualTo(new Some<>("string"));
    }

    @Test public void nullToOptional() {
        Optional<Object> result = Optional.toOptional(null);
        assertThat(result).isEqualTo(None.INSTANCE);
    }

    @Test public void nullToOptionalCompat() {
        Optional<Object> result = OptionalKt.toOptional(null);
        assertThat(result).isEqualTo(None.INSTANCE);
    }
}
