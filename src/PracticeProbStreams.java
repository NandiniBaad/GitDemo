import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PracticeProbStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Nandini\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all webelements in List
		List<WebElement> origVeggies = driver.findElements(By.xpath("//tr/td[1]"));
				//capture text of all webelements in new list - original list
		List<String> origvegitablesText = origVeggies.stream().map(s->s.getText()).collect(Collectors.toList());
				//sort in the list of step3(original list) - sortedList
		List<String> sortedvegitablesText	=origvegitablesText.stream().sorted().collect(Collectors.toList());
				//original list v/s sorted list compare
				Assert.assertEquals(origvegitablesText, sortedvegitablesText);
		
	}

}
