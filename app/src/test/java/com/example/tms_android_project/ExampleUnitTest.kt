package com.example.tms_android_project

import android.content.Context
import android.util.Log
import org.hamcrest.CoreMatchers.hasItem
import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

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
    @Throws(Exception::class)
    fun addition_isNotCorrect() {
        assertEquals("Numbers isn't equals!", 4, 2 + 2)
    }

    @Test(expected = NullPointerException::class)
    fun nullStringTest() {
        val str: String? = null
        assertTrue(str!!.isEmpty())
    }

    @Test(timeout = 1000)
    fun requestTest() {
        val test = 1..213243566777
        for (i in test) {
            println("Элемент $i")
        }
    }

    @Test
    @Throws(Exception::class)
    fun assertThat_isNotCorrect() {
        val testList = listOf<Int>(1, 2, 3, 4, 5)
        assertThat(testList, hasItem(2))
    }

    private var list: MutableList<String> = mutableListOf()

    @Before
    fun init() {
        list = ArrayList(listOf("Katsapov", "Ivanov"))
    }

    @After
    @Throws(Exception::class)
    fun teardown() {
        if (list.isNotEmpty()) {
            list.clear()
        }
    }

    @Test
    fun whenCheckingListSize_thenSizeEqualsToInit() {
        assertEquals(2, list.size)
        list.add("another test")
    }




//    @Mock
//    var mockedList: ArrayList<String>? = null
//
//    @Before
//    fun initMockedList() {
//     //   MockitoAnnotations.initMocks(this)
//    }
//
//    @Test
//    fun teardownTest() {}
//
//    @Test
//    fun test3() {
//        mockedList?.add("Useless string")
//        mockedList?.clear()
//        verify(mockedList)?.add("one");
//        verify(mockedList)?.clear()
//    }

//    @BeforeClass
//    fun setup() {
//        Log.d("TEST_ANDROID", "startup - creating DB connection")
//    }
//
//    @AfterClass
//    fun tearDown() {
//        Log.d("TEST_ANDROID", "closing DB connection")
//    }
//
//    @Test
//    fun simpleTest() {
//        Log.d("TEST_ANDROID", "simple test")
//    }
//
//    @Test
//    fun anotherSimpleTest() {
//        Log.d("TEST_ANDROID", "another simple test")
//    }
}