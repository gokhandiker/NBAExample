package com.gkhn.nbaexample


import com.facebook.crypto.util.Assertions
import junit.framework.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

class MyTest {

    @Test
    fun testFun() {
        assert(true)
    }

    @Test
    fun whenAdding1and3_thenAnswerIs4() {
        assertEquals(4, 4)
    }

    @Test fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertEquals(4, 2 * 2)
    }

    @Test
    fun `Adding 1 and 3 should be equal to 4`() {
        assertEquals(4, 2 * 2)
    }


}