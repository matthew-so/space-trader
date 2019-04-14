package com.example.spacetrader

import org.junit.Test

import org.junit.Assert.*

import com.example.spacetrader.entity.Good

import com.example.spacetrader.entity.RandomSolarEvent

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun specialResourcesNoCROrER() {
        assertEquals(Good.WATER.specialEvent(RandomSolarEvent.DROUGHT, 50), 75)
    }

    @Test
    fun specialResourcesNoERWithCR() {
        assertEquals(Good.WATER.specialEvent(RandomSolarEvent.CROPFAIL, 50), 50)
    }

    @Test
    fun specialResourcesNoERWithCRFalse() {
        assertEquals(Good.WATER.specialEvent(RandomSolarEvent.CROPFAIL, 50), 50)
    }

    @Test
    fun specialResourcesNoER() {
        assertEquals(Good.WATER.specialEvent(RandomSolarEvent.CROPFAIL, 50), 50)
    }
}
