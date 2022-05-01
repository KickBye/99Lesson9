package pageObject.google;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.Base;

public class InitPageObject extends Base{
    public InitPageObject(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath=".//input[@title='Поиск']")
    private WebElement searchText;

    @FindBy(xpath="(.//input[@value='Поиск в Google'])[1]")
    private WebElement submitSearch;


//Вводим текст в строку поиска param text
    @Step("вводим текст в строку поиска")
    public void setSearchText(String text){
        setText(searchText, text);
    }


    //Нажимаем на кнопку поиска
    @Step("Нажимаем на кнопку поиска")
    public void clickSubmitsSearch() {
        click(submitSearch);
    }
    public void setAndClick(String text){
        setSearchText(text);
        clickSubmitsSearch();


    }

}
