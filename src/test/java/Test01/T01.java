package Test01;

import Utilities.TestBase;
import org.bouncycastle.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class T01 extends TestBase {
    //sahibinden.coma gidin
    //anasayfada oldugunuz dogrulayin
    //arama kismina opel astra yazip aratin
    //sonuc sayisini konsala yazdirin
    //anasayfaya geri donun
    //ikici el alisveris kisminda telefonlara  tiklayin
    //ilk urune tiklayip ilan no ve ilan tarihinin gorunurlulugunu test edin

@Test
    public void test01() throws InterruptedException, AWTException {
    driver.get("https://www.sahibinden.com");
  String actual=driver.getCurrentUrl();
    System.out.println(actual);
  String expected="https://www.sahibinden.com/";
  Assert.assertEquals(expected,actual);

 if( driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).isDisplayed()){
     driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();

  }
 WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='searchText']"));
 aramaKutusu.click();
 aramaKutusu.sendKeys("opel astra",Keys.ENTER);
String []snc= driver.findElement(By.xpath("//*[@class='result-text-sub-group']")).getText().split(" ");

    System.out.println(snc[2]);
driver.navigate().back();
Actions actions=new Actions(driver);
actions.sendKeys(Keys.PAGE_DOWN).perform();
driver.findElement(By.xpath("//a[@title='Cep Telefonu']")).click();
    System.out.println(driver.getTitle());
    Thread.sleep(3000);
/*
driver.findElement(By.xpath("//img[@title='airpods 3.nesil temiz']")).click();
 WebElement ilandokum=driver.findElement(By.xpath("//ul[@class='classifiedInfoList']"));
    System.out.println(ilandokum.getText());
    Assert.assertTrue(ilandokum.isDisplayed());
*/
List<WebElement> ceptlflist=driver.findElements(By.xpath("//ul[@class='showCaseList showCaseSubCategory category-showcase-container']"));

    for (WebElement each:ceptlflist) {
        if (each==ceptlflist.get(0)){
            each.click();
            break; }
    }
   WebElement ilandokum=driver.findElement(By.xpath("//ul[@class='classifiedInfoList']"));
    System.out.println(ilandokum.getText());
    Assert.assertTrue(ilandokum.isDisplayed());

}
}

