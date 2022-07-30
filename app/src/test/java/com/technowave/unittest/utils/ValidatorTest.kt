package com.technowave.unittest.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest {
    private val validator:Validator = Validator()

    @Test
    fun validateUsername() {
        assertThat(validator.validateUsername("")).isEqualTo(false)
        assertThat(validator.validateUsername("syed")).isEqualTo(true)
    }

    @Test
    fun validatePassword() {
        assertThat(validator.validatePassword("")).isEqualTo(false)
        assertThat(validator.validatePassword("123")).isEqualTo(true)
    }

    @Test
    fun validateSum()
    {
        assertThat(validator.calculateSum(1,2)).isEqualTo(3)
        assertThat(validator.calculateSum(5,5)).isNotEqualTo(1)
    }


}