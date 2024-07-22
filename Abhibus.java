package Marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abhibus {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
		// implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);

		String optionToSelect = "Chennai";
		// Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		Thread.sleep(3000);
		// getting all list
		List<WebElement> fromList = driver
				.findElements(By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li"));
		for (WebElement element : fromList) {
			String currentoption = element.getText();
			if (currentoption.contains(optionToSelect)) {
				element.click();
				break;
			}
		}
		Thread.sleep(2000);
		String optionToSelectTo = "Bangalore";
		// Type "Bangalore" in the FROM text box
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		List<WebElement> ToList = driver
				.findElements(By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li"));
		for (WebElement Toelement : ToList) {
			String currentoption = Toelement.getText();
			if (currentoption.contains(optionToSelectTo)) {
				Toelement.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[contains(text(), 'Tomorrow')]")).click();
		Thread.sleep(6000);
		// Print the name of the first resulting bus (use .getText())
		System.out.println("Bus Name: "+ driver.findElement(By.xpath("(//h5[@class='title'])[1]")).getText() );	
		Thread.sleep(2000);

		// 09) Choose SLEEPER in the left menu from Bus Type

		driver.findElement(By.xpath("(//a[contains(@class,'outlined tertiary sm inactive button')])[4]")).click();
		Thread.sleep(2000);

		//10) Print the first resulting bus seat count(Example:35 Seats Available)(use .getText())
		driver.findElement(By.xpath("//button[contains(text(), 'Show Seats')][1]")).click();
		//Choose any one Available seat
		
		
		//Get the Title of the page(use .getTitle())
		String title = driver.getTitle();
		System.out.println("Title of the page" + title);
		
	}

}
