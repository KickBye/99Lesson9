package seleniumTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObject.google.InitPageObject;
import pageObject.google.SearchResultPageObject;

public class SelTest extends BaseTest{
    @Test
    @Epic("Селениум")
    @Feature("Гугл тесты")
    @Story("Проверяем поиск")

    public void startTest(){
        getDriver().get("https://www.google.ru/");
        getDriver().manage().window().maximize();

        InitPageObject in = new InitPageObject(getDriver());
        in.setSearchText("Привет");
        in.clickSubmitsSearch();
        SearchResultPageObject sr = new SearchResultPageObject(getDriver());
        Assertion as=new Assertion();
        as.assertTrue(sr.isImagesTabButtonIsExist());

    }

}
