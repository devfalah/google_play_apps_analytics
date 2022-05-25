import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HelperTest {

    @Test
    fun convertGBToMB() {
        // given size in GB
        val size : String = "5G"
        // when convert to MB
        val sizeInGB = size.replace("G","").toInt()
        val sizeInMB = sizeInGB * 1024
        // then
        kotlin.test.assertEquals(5120, sizeInMB)
    }
}