import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

var webDriver: WebDriver = ChromeDriver()

fun main(args: Array<String>) {
    println("Hello World!")
    startBrowser()
    webDriver.get("https://example.com")
    val webPageText = webDriver.findElement(By.xpath("//html")).text
    println(webPageText)
}

fun startBrowser() {
    val chromeOptions = ChromeOptions()
    chromeOptions.addArguments("--headless")
    chromeOptions.addArguments("--no-sandbox")
    chromeOptions.addArguments("--disable-gpu")
    chromeOptions.addArguments("--window-size=1280x1696")
    chromeOptions.addArguments("--single-process")
    chromeOptions.addArguments("--disable-dev-shm-usage")
    chromeOptions.addArguments("--disable-dev-tools")
    chromeOptions.addArguments("--no-zygote")
    chromeOptions.addArguments("--user-data-dir=/tmp")
    chromeOptions.addArguments("--data-path=/tmp")
    chromeOptions.addArguments("--disk-cache-dir=/tmp")
    chromeOptions.addArguments("--remote-debugging-port=9222")
    chromeOptions.setBinary("/opt/chrome/chrome")
    System.setProperty("webdriver.chrome.driver", "/opt/chromedriver")
    webDriver = ChromeDriver(chromeOptions)
}