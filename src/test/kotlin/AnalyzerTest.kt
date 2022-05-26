import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    val fakeApps=FakeData().fakeApps
    private lateinit var analyzer :Analyzer

    @BeforeAll
    fun setup(){
        this.analyzer =Analyzer()
    }

    // Test Cases for : ((getOldestApp method))
    //=========================================
    @Test
    fun should_ReturnOldestApp_When_ListOfAppsIsCorrect(){
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(fakeApps)
        // then
        assertEquals(fakeApps[1], oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasNoSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneLeftSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[4].updatedAt = "May 152020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatHasOneRightSpace(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "March18 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthIsAnumber(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[2].updatedAt = "6 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthNotCapitalized(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[5].updatedAt = "march 19 2021"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthMisspelled(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "Arpil 10 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsLessThan_1(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[1].updatedAt = "June 0 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DayIsGreaterThan_31(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[6].updatedAt = "Arpil 35 2022"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_YearLessThan2008(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "Arpil 10 2006"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_DateFormatIsReversed(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "2020 10 Arpil"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

    @Test
    fun should_ReturnNull_When_MonthReversedWithDay(){
        // given list of apps
        var newFakeApps = fakeApps.toMutableList()
        newFakeApps[7].updatedAt = "10 Arpil 2020"
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(newFakeApps)
        // then
        assertEquals(null,oldestApp)
    }

}