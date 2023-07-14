package stepDef.PerrySport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.PriceOrder_Pages;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class StepDef {

    PriceOrder_Pages pages;

    @Given("Go to perry")
    public void go_to_perry() {
        getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("click cokie")
    public void clickCokie() {
        pages = new PriceOrder_Pages();
        ReusableMethods.waitForClickablility(pages.popupclose, 5);
        pages.popupclose.click();
    }

    @Then("click SALE")
    public void clickSALE() {
        pages = new PriceOrder_Pages();
        pages.sale_button.click();

    }


    @Then("terminate test")
    public void terminateTest() {
        driver.quit();
    }

    @Then("click Sorteer Op_Prijs: Laag naar Hoog")
    public void clickSorteerOp_PrijsLaagNaarHoog() {
        pages = new PriceOrder_Pages();
        pages.sorteerOp.click();
        Select select = new Select(pages.sorteerOp);
        select.selectByVisibleText("Prijs: Laag naar Hoog");
        ReusableMethods.bekle(3);
    }

    @Then("click Sorteer Op_Prijs: Hoog naar Laag")
    public void clickSorteerOp_PrijsHoogNaarLaag() {

        pages = new PriceOrder_Pages();
        pages.sorteerOp.click();
        Select select = new Select(pages.sorteerOp);
        select.selectByVisibleText("Prijs: Hoog naar Laag");
        ReusableMethods.bekle(3);
    }


    @Then("scroll down to see products")
    public void scrollDownToSeeProducts() {
        ReusableMethods.scrolldown_DownViewAll();
        ReusableMethods.bekle(5);

    }


    @Then("verify that the low-to-high sorting is true")
    public void verifyThatTheLowToHighSortingIsTrue() {
        System.out.println("---> Prices must be Low-to-High <---");

        List<WebElement> sale = pages.salePrijs;
        List<Double> saleP3 = new ArrayList<>();

        for (WebElement each : sale) {
            String saleP = each.getText();
            saleP = saleP.replaceAll("[^0-9.]", "");

            double sayi = Double.parseDouble(saleP);
            saleP3.add(sayi);
        }
        SoftAssert softAssert = new SoftAssert();

        int count = 0;

        for (int i = 0; i < saleP3.size() - 1; i++) {
            count++;
            try {
                Assert.assertTrue(saleP3.get(i) <= saleP3.get(i + 1));
            } catch (AssertionError E) {

                System.out.println(count + ".price " + saleP3.get(i) + " < " + (count + 1) + ".price " + saleP3.get(i + 1) + " --> so the order is not true!");

            }
        }

        ReusableMethods.bekle(3);
    }


    @Then("verify that the high-to-low sorting is true")
    public void verifyThatTheHighToLowSortingIsTrue() {
        System.out.println("---> Prices must be High-to-Low <---");
        List<WebElement> sale = pages.salePrijs;
        List<Double> saleP3 = new ArrayList<>();
        for (WebElement each : sale) {
            String saleP = each.getText();
            saleP = saleP.replaceAll("[^0-9.]", "");

            double sayi = Double.parseDouble(saleP);
            saleP3.add(sayi);
        }
        SoftAssert softAssert = new SoftAssert();

        int count = 0;

        for (int i = 0; i < saleP3.size() - 1; i++) {
            count++;
            try {
                Assert.assertTrue(saleP3.get(i) >= saleP3.get(i + 1));
            } catch (AssertionError E) {

                System.out.println(count + ".price " + saleP3.get(i) + " > " + (count + 1) + ".price " + saleP3.get(i + 1) + " --> so the order is not true!");

            }
        }


    }
}
