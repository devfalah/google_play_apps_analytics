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
        analyzer = Analyzer()
    }

    @BeforeEach
    fun initial(){
        fakeApps = FakeData().fakeApps
    }


    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CopmanyNameIsValid(){
        //given
        fakeApps
        //when calculate the app that developed by specific company with a valid name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Google")
        //then find the result
        assertEquals(5,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CompanyNameIsEmpity(){
        //given
        //when count the app that developed by specific company with a empity company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"")
        //then find the result
        assertEquals(-1,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CompanyNameIsSepratedBySpace(){
        //given
        fakeApps
        //when count the app that developed by specific company with a space in the middle
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Goo gle")
        //then find the result
        assertEquals(0,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CompanyNameContainSpaceAtTheEnd(){
        //given
        fakeApps
        //when count the app that developed by specific company with a space at the end
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"Google ")
        //then find the result
        assertEquals(5,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CompanyNameNotValid(){
        //given
        fakeApps
        //when count the app that developed by specific company with not valid company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"AliZainy")
        //then find the result
        assertEquals(0,result)
    }

    //test fun_1
    @Test
    fun should_ReturnTheCountOfAppDevelopedByspecificCompany_when_CompanyName(){
        //given
        fakeApps
        //when count the app that developed by specific company with upper case company name
        val result=analyzer.countAppsDevelopedBySpecificCompany(fakeApps,"GOOGLE")
        //then find the result
        assertEquals(0,result)
    }



}
