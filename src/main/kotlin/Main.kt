import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.net.HttpURLConnection

val webDriver: WebDriver = startBrowser()

fun handleRequest(request: APIGatewayV2HTTPEvent, context: Context): APIGatewayV2HTTPResponse {
    println("Hello World!")
    startBrowser()
    webDriver.get("https://example.com")
    val webPageText = webDriver.findElement(By.xpath("//html")).text
    println(webPageText)
    val map = hashMapOf<String, String>()
    map["1"] = "SomeHeader"
    return APIGatewayV2HTTPResponse.builder()
        .withStatusCode(HttpURLConnection.HTTP_OK)
        .withBody("somebody $webPageText")
        .withHeaders(map)
        .build();
}

fun startBrowser(): ChromeDriver {
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
    return ChromeDriver(chromeOptions)
}