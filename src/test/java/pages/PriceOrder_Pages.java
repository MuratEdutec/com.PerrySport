package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PriceOrder_Pages {

    public PriceOrder_Pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//button[@class='btn btn-level1 accept-all-cookies'])[1]")
    public WebElement popupclose;


    @FindBy(xpath = "//a[normalize-space()='SALE']")
    public WebElement sale_button;


    @FindBy(xpath = "//select[@class='sort']")
    public WebElement sorteerOp;


    @FindBy(xpath = "//span[contains(text(),'SALE PRIJS €')]")
    public List<WebElement> salePrijs;


















}
