
import models.App
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import utility.extension.convertSizeToUniqueUnit
import utility.extension.convertStringDateToLocalDateObject
import java.time.LocalDate
import java.time.Month


import kotlin.test.*




@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private lateinit var fakeApps :List<App>
    private lateinit var analyzer: Analyzer

    @BeforeAll
    fun setup() {
        this.analyzer = Analyzer()
    }

    @BeforeEach
    fun initial() {
        fakeApps = FakeData().fakeApps
    }

    val fakeApps= listOf(
        App("App 1", "Google", "Libraries & Demo", "November 18 2020".convertStringDateToLocalDateObject(), size = "5.0M".convertSizeToUniqueUnit(), installsCount = 5, currentVersion = "1", requiresAndroid = "4.4 and up"),


    @Test
    fun should_ReturnOldestApp_When_ListOfAppsIsCorrect() {
        // when finding the oldest app
        val oldestApp = analyzer.getOldestApp(fakeApps)
        // then
        var expected =  App(
            name = "App 2",
            company = "Google LLC",
            category = "Medical",
            updatedAt = LocalDate.of(2001,Month.SEPTEMBER,26),
            size = "22M",
            installsCount = 100000,
            currentVersion = "1.4.4-0e73d19a",
            requiresAndroid = "7.0 and up",
        )
        assertEquals(expected, oldestApp)
    }

    @Nested
    @DisplayName("get largest 10 apps")
    inner class Largest10Apps {
        @Test
        fun shouldReturn_Correct10LargestApp_WhenHaveCorrectData() {
            // given list of apps
            val apps = fakeApps
            // when sort apps descending
            val sortedApps = analyzer.getLargest10Apps(apps).take(2)
            val exceptedApps = listOf(
                fakeApps[4],
                fakeApps[17]
            )
            // then
            assertEquals(exceptedApps, sortedApps)
        }

//        @Test
//        fun shouldReturn_Correct10LargestApp_WhenHaveSizeSymbolINAnyLetterCases() {
//            // given list of apps
//            val apps = listOf(
//                App(
//                    name = "App 5",
//                    company = "Weedmaps",
//                    category = "Medical",
//                    updatedAt = LocalDate.of(2022, Month.MARCH,4),
//                    size = "1.1g",
//                    installsCount = 1800000,
//                    currentVersion = "7.0.2",
//                    requiresAndroid = "5.0 and up",
//
//                    ),
//                App(
//                    name = "App 18",
//                    company = "Game Insight",
//                    category = "Action",
//                    updatedAt =  LocalDate.of(2022, Month.MAY,12),
//                    size = "1.1g",
//                    installsCount = 50000000,
//                    currentVersion = "30.0.271",
//                    requiresAndroid = "5.0 and up",
//
//                    )
//            )
//            // when sort apps descending
//            val sortedApps = analyzer.getLargest10Apps(apps).take(2)
//            val exceptedApps = listOf(
//                fakeApps[17],
//                fakeApps[4]
//            )
//            // then
//            assertEquals(exceptedApps, sortedApps)
//        }

        @Test
        fun shouldReturn_Correct10LargestApp_WhenSizeWithoutNumericValue() {
            // given list of apps
            val apps = listOf(
                App(
                    name = "App 16",
                    company = "Craigpark Limited",
                    category = "Productivity",
                    updatedAt = LocalDate.of(2022, Month.APRIL,17),
                    size = "Varies with device",
                    installsCount = 1000000,
                    currentVersion = "5.3.5",
                    requiresAndroid = "5.0 and up"
                ),
                App(
                    name = "App 5",
                    company = "Weedmaps",
                    category = "Medical",
                    updatedAt = LocalDate.of(2022, Month.MARCH,4),
                    size = "1.1G",
                    installsCount = 1800000,
                    currentVersion = "7.0.2",
                    requiresAndroid = "5.0 and up",

                    )
            )
            // when sort apps descending
            val sortedApps = analyzer.getLargest10Apps(apps).take(2)
            val exceptedApps = listOf(
                fakeApps[4],
                fakeApps[15]
            )
            // then
            assertEquals(exceptedApps.first().size, sortedApps.first().size)
        }


        @Test
        fun shouldReturnEmpty10LargestList_When_HaveEmptyAppList() {
            // given empty list
            val apps = listOf<App>()
            // when sort apps descending
            val resultApps = analyzer.getLargest10Apps(apps)
            // then return empty list
            assertEquals(emptyList(), resultApps)
        }
    }
    @Nested
    @DisplayName("get top 10 installed apps")
    inner class Top10InstalledApps {
        @Test
        fun should_returnCorrectValue_When_GiveCorrect() {
            //give
            val apps = fakeApps
            //when
            val result = analyzer.getTop10InstalledApps(apps).take(10)
            println(result[0].name)
            val exceptedAPPS = listOf(
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
            assertEquals(emptyList(), result)

        }

        @Test
        fun should_returnNull_When_TheListLessThan10() {
            //give
            val apps = listOf(
                App(
                    name = "App 19",
                    company = "TIMEFLIK (ex MR TIME)",
                    category = "Personalization",
                    updatedAt = LocalDate.of(2022, Month.DECEMBER,15),
                    size = "4.7M",
                    installsCount = 5000000,
                    currentVersion = "10, 1.0.0",
                    requiresAndroid = "9 and up",

                    )
            )
            //when
            val result = analyzer.getTop10InstalledApps(apps).take(10)

            //then
            assertEquals(emptyList(), result)


        }

        @Test
        fun should_returnNull_When_GiveNegativeValue() {
            //give
            val apps = listOf(
                App(
                    name = "App 19",
                    company = "TIMEFLIK (ex MR TIME)",
                    category = "Personalization",
                    updatedAt = LocalDate.of(2022, Month.DECEMBER,15),
                    size = "4.7M",
                    installsCount = -5000000,
                    currentVersion = "10, 1.0.0",
                    requiresAndroid = "9 and up",

                    )
            )
            //when
            val result = analyzer.getTop10InstalledApps(apps).take(10)

            //then
            assertEquals(emptyList(), result)

        }
    }
    @Nested
    @DisplayName("calculate percentage of medical apps")
    inner class PercentageOfMedicalApps {
        @Test
        fun should_ReturnPercentageOfMedicalAppsValue_when_ListOfAppsIsCorrect() {
            //give correct list

            //when calculate the percentage of Medical Apps
            val percentage = analyzer.calculatePercentageOfMedicalApps(fakeApps)
            //then check the result
            assertEquals(25.0, percentage)
        }

 @Test
        fun should_ReturnNull_when_ListIsEmpty() {
            //give empty list
            //when calculate the percentage of Medical Apps
            val percentage = analyzer.calculatePercentageOfMedicalApps(emptyList())
            //then check the result

            assertNull(percentage)
        }
    }
    @Nested
    @DisplayName("calculate percentage of apps running on android 9 and up only")
    inner class PercentageOfAppsRunningOnAndroid9AndUpOnly {
        @Test
        fun shpuld_return_MenusOne_when_listIsEmpty() {
            // given list of apps
            val listOfApps = listOf<App>()
            // when finding the app running on android 9 and up
            val result = analyzer.calculatePercentageOfAppsRunningOnAndroid9AndUpOnly(listOfApps)
            //then check the Result between  expeted and actualy
            assertEquals(-1.0, result)
        }
    }
    @Nested
    @DisplayName("calculate count apps developed by google")
    inner class CountAppsDevelopedByGoogle {
        @Test
        fun should_ReturnZero_When_EmptyList() {
            // given list
            // var listCompany = listOf<App>(fakeApps[4], fakeApps[17])
            val listCompany = listOf<App>()
            // when searching for a company
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(0, numOfAppDev)
        }
        @Test
        fun should_ReturnZero_When_NotFindCompane() {
            val listCompany = listOf(
                fakeApps[2], fakeApps[3], fakeApps[4], fakeApps[5]
            )
            // when searching for a company
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(0, numOfAppDev)
        }
        @Test
        fun should_ReturnOne_When_FindOneCompany() {
            val listCompany = listOf(
                fakeApps[0], fakeApps[6]
            )
            // when searching for company
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(1, numOfAppDev)
        }
        @Test
        fun should_ReturnOne_When_FindOneCompanyLowercase() {
            val listCompany = listOf(
                fakeApps[15], fakeApps[6]
            )
            // when searching for company
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(0, numOfAppDev)
        }
        @Test
        fun should_ReturnTow_When_FindTowCompany() {
            // given list
            val listCompany = listOf(
                fakeApps[0], fakeApps[6], fakeApps[7], fakeApps[10]
            )
            // when searching for company
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(2, numOfAppDev)
        }
        @Test
        fun should_ReturnSix_When_FindAllCompany() {
            // given list
            val listCompany = fakeApps
            // when searching for compane
            val numOfAppDev = analyzer.calculateCountAppsDevelopedByGoogle(listCompany)
            // then check
            assertEquals(5, numOfAppDev)
        }
    }

}
