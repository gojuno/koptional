package com.gojuno.koptional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTests {

    @Test
    public void toNullableSome() {
        assertThat(new Some<>("value").toNullable()).isEqualTo("value");
    }

    @Test
    public void toNullableNone() {
        assertThat(None.INSTANCE.toNullable()).isNull();
    }

    @Test
    public void toOptionalSome() {
        assertThat(Optional.toOptional("value")).isEqualTo(new Some<>("value"));
    }

    @Test
    public void toOptionalSomeCompat() {
        assertThat(OptionalKt.toOptional("value")).isEqualTo(new Some<>("value"));
    }

    @Test
    public void toOptionalNone() {
        assertThat(Optional.toOptional(null)).isEqualTo(None.INSTANCE);
    }

    @Test
    public void toOptionalNoneCompat() {
        assertThat(OptionalKt.toOptional(null)).isEqualTo(None.INSTANCE);
    }
}
