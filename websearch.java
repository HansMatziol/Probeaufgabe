import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class websearch 
{
    public static void main (String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/home/hans");
    
        String term = args[0]; // Such-Parameter
        
        search(term);
    }

	
	public static void search(String term)
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.de/");
		
		WebElement searchBox = driver.findElement(By.name("q")); // q: Name des Suchfeldes von Google 
		WebElement button = driver.findElement(By.name("btnK")); // btnk: Name des Buttons: Google Suche 
		
		searchBox.sendKeys(term);
		button.click();
		
		WebElement stats = driver.findElement(By.id("result-stats")); // Anzahl der Ergebnisse
		String temp = stats.getText();
		
		int a = temp.indexOF("<nobr>");
		String results = temp.substring(0, a); // Entfernt den unerwünschten HTML ausdruck 
		
		System.out.println(results + " Die ersten 3 sind:" ); 
		
		List<WebElement> findElements = driver.findElements(By.tagName(<a>)); // Findet alle links
		
		for(int i = 0; i < 3; i++)
		{
		    String url = findElements.get(i).getAttribute("href"); 
		    System.out.println("- " + url);                         //Liefert die url der ersten 3 links 
		}
		
		driver.quit();
		
		return;
		
	}


}
