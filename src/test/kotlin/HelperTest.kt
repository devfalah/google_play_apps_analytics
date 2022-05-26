import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class HelperTest {

    private
    lateinit var helper: Helper
    @BeforeAll
    fun setup () {
        this.helper = Helper()
    }
    @Test
    fun shouldReturnCorrectSize_When_HaveSizeInGB() {
        // given size in GB
        val size : String = "5G"
        // when convert to MB
        val sizeInMB = helper.convertSize(size)
        // then
        assertEquals(5120.0, sizeInMB)
    }

    @Test
    fun shouldReturnCorrectSize_When_HaveSizeInMB() {
        // given size in GB
        val size : String = "5M"
        // when convert to MB
        val sizeInMB = helper.convertSize(size)
        // then
        assertEquals(5.0, sizeInMB)
    }

    @Test
    fun shouldReturnCorrectSize_When_HaveSizeInKB() {
        // given size in GB
        val size : String = "1000k"
        // when convert to MB
        val sizeInMB = helper.convertSize(size)
        // then
        assertEquals(0.9765625, sizeInMB)
    }

    @Test
    fun shouldReturnZero_When_HaveInvalidSize() {
        // given size in GB
        val size : String = "no size"
        // when convert to MB
        val sizeInMB = helper.convertSize(size)
        // then
        assertEquals(0.0, sizeInMB)
    }

    @Test
    fun shouldReturnCorrectSize_When_HaveSizeSymbolInAnyLetterCases() {
        // given size in GB
        val size : String = "5m"
        // when convert to MB
        val sizeInMB = helper.convertSize(size)
        // then
        assertEquals(5.0, sizeInMB)
    }

}