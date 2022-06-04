import models.App
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test


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
    fun initial(){
        fakeApps = FakeData().fakeApps
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameIsValid(){
        //given
        //when calculate the percentage of valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"Medical")
        //then find the result
        assertEquals(25.0,result)
}



    //test fun_2
    @Test
    fun should_ReturnZero_when_calculateThePercentageOfNotValidCategoryName(){
        //given
        // when calculate the percentage of Not valid category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnZero_when_CategoryIsEmpty(){
        //given
        //when calculate empty category
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"")
        //then find the result
        assertEquals(0.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryIsUpperOrLowerCase(){
        //given
        //when calculate the percentage of category name with upper or lower case
        val result = analyzer.findPercentageOfSpecificApp(fakeApps,"MEDICAL")
        //then find the result
        assertEquals(25.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnPercentageAppsOfSpecificCategory_when_CategoryNameWithSpaces(){
        //given
        //when calculate the percentage of category name with spaces
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(25.0,result)
    }



    //test fun_2
    @Test
    fun should_ReturnNan_when_ListOfFakeAppsIsEmpty(){
        //given
        fakeApps= listOf()
        //when calculate the percentage of category name
        val result = analyzer.findPercentageOfSpecificApp(fakeApps," Medical ")
        //then find the result
        assertEquals(Double.NaN,result)
    }




}
