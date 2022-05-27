import models.App
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import kotlin.test.assertNull


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    val fakeApps = FakeData().fakeApps
    private lateinit var analyzer: Analyzer



    @BeforeAll
    fun setup() {
        this.analyzer = Analyzer()
    }


    @Test
    fun should_returnCorrectValue_When_GiveCorrect() {
        //give
        val apps = fakeApps
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)
        println(result[0].name)
        val exceptedAPPS = listOf<App>(
            fakeApps[6],
            fakeApps[16],
            fakeApps[17],
            fakeApps[10],
            fakeApps[5],
            fakeApps[8],
            fakeApps[18],
            fakeApps[4],
            fakeApps[9],
            fakeApps[11]

        )
        //then
        assertEquals(exceptedAPPS, result)

    }

    @Test
    fun should_returnEmpty_When_EmptyList() {
        //give
        val apps = listOf<App>()
        //when
        val result = analyzer.getTop10InstalledApps(apps)
        //then
        assertEquals(emptyList<App>(), result)

    }

    @Test
    fun should_returnNull_When_TheListLessThan10() {
        //give
        val apps = listOf(App(
            name = "App 19",
            company = "TIMEFLIK (ex MR TIME)",
            category = "Personalization",
            updatedAt = "December 15 2021",
            size = "4.7M",
            installsCount = 5000000,
            currentVersion = "10, 1.0.0",
            requiresAndroid = "9 and up",

            ))
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)

        //then
        assertEquals(emptyList<App>(), result)


    }
    @Test
    fun should_returnNull_When_GiveNegativeValue() {
        //give
        val apps = listOf(App(
            name = "App 19",
            company = "TIMEFLIK (ex MR TIME)",
            category = "Personalization",
            updatedAt = "December 15 2021",
            size = "4.7M",
            installsCount = -5000000,
            currentVersion = "10, 1.0.0",
            requiresAndroid = "9 and up",

            ))
        //when
        val result = analyzer.getTop10InstalledApps(apps).take(10)

        //then
        assertEquals(emptyList<App>(), result)

    }









}