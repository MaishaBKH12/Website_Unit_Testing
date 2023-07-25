import org.junit.jupiter.api.*;

import java.util.List;

import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

    public class Website {


        WebDriver driver;
        @BeforeAll

        public void setup(){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(ofSeconds(120));

        }
        @Test
        public void getTitle(){
            driver.get("https://www.digitalunite.com/practice-webform-learners");
            String title_actual=driver.getTitle();
            System.out.println(title_actual);
        }
        @Test
        public void submitForm(){
            driver.get("https://www.digitalunite.com/practice-webform-learners");
            List<WebElement> txtBoxElement=driver.findElements(By.id("edit-name"));
            txtBoxElement.get(0).sendKeys("Maisha Tasnim");
            List<WebElement>txtBoxElement2=driver.findElements(By.id("edit-number"));
            txtBoxElement2.get(0).sendKeys("01905120167");

        }
    @Test
    public void Email(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        List<WebElement> txtBoxElement=driver.findElements(By.xpath("//input[@id='edit-email']"));
        txtBoxElement.get(0).sendKeys("maisha@test.com");


    }
        @Test
        public void Age(){
            driver.get("https://www.digitalunite.com/practice-webform-learners");
            driver.findElement(By.xpath("//label[normalize-space()='20-30']")).click();


        }
        @Test
        public void selectDate() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.name("date")).click();
        driver.findElement(By.name("date")).sendKeys(Keys.CONTROL + "A" + Keys.BACK_SPACE);
        driver.findElement(By.name("date")).sendKeys("05/08/1993", Keys.ENTER);

    }

    @Test
        public void WriteAboutYourself(){
            driver.get("https://www.digitalunite.com/practice-webform-learners");
            List<WebElement> txtBoxElement=driver.findElements(By.xpath("//textarea[@id='edit-tell-us-a-bit-about-yourself-']"));
            txtBoxElement.get(0).sendKeys("Hi, this is a automation Testing process.");
        }


    @Test
    public void Browse() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement uploadElement = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadElement.sendKeys("C:\\Users\\USER\\Pictures\\one.jpg");

    }

    @Test
    public void Check() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.xpath("//label[@for='edit-age']")).click();

    }

        @AfterAll
        public void closeDriver(){
            //driver.quit();
        }
    }

