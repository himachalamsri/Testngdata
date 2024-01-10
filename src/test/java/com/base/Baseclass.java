package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Baseclass {
	

	public static WebDriver driver;

	public static void broweserlaunch() {
		
		driver=new ChromeDriver();
	}
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static void maximizewindow() {
		
		driver.manage().window().maximize();

	}
	public static String getprojectpath() {
			String path = System.getProperty("user.dir");
			return path;
		}

	
	public static String getpropertyvalue(String Key) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileInputStream(getprojectpath()+"\\config\\config.properties"));
		Object object = properties.get(Key);
		String value=(String)object;
		return value;
	
	}
	
	public static void getdriver(String browserType) {
		switch (browserType) {
		case "Chrome":
			driver=new ChromeDriver();
			
			break;

		case "edge":
			driver=new EdgeDriver();
			
			break;
			case "IE":
				driver=new InternetExplorerDriver();
				
				break;case "firefox":
					driver=new FirefoxDriver();
					
					break;
		default:
			break;
		}

	}
	public void select(WebElement element) {
		Select select=new Select(element);
	}
	public void robot() throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		

	}
	public static void thread(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	public static void sendkeys(WebElement element ,String data) {
		element.sendKeys(data);

	}
	
	
	
	public static void clickbutton(WebElement element) {
		element.click();

	}
	public void allertaccept() {

		driver.switchTo().alert().accept();

	}
	public void alertcancel() {
		driver.switchTo().alert().dismiss();

	}
	public static String gettext(WebElement element ) {
		String text = element.getText();

		return text;
	}
	public String getattribute(WebElement element,String ram) {
	
		String txt = element.getAttribute(ram);
	
		return txt;
	}
	public static void closeallwindows() {

		driver.quit();

	}
	public void currentwindow() {
		driver.close();
	}
	public String gettitle() {

		String title = driver.getTitle();
		
		return title;


	}
	public String getcurrenturl() {

		String currentUrl = driver.getCurrentUrl();
		
		return currentUrl;

	}
	public static void selectvisibletext(WebElement element,String ram) {

		Select select=new Select(element);
		select.selectByVisibleText(ram);

	}
	public void dropdownoption(WebElement element,String name) {
		Select select=new Select(element);
		select.selectByValue(name); 
	}
	public void selectbyindex(WebElement element,int x) {
		Select select=new Select(element);
		select.selectByIndex(0);

	}
	public void insertvalueinjs(WebElement element,String data ) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("argumeents[0].setattribute('value', '"+data+"')",element);
		
	}
	public void clickbuttonjs(WebElement element,String ram) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("argumeents[0].click()",element);

		
				

	}
	public void childwindow() {
		String parrentid = driver.getWindowHandle();
		
		Set<String> allwindow = driver.getWindowHandles();
		for (String eachwondow : allwindow) {
			if (!parrentid.equals(eachwondow)) {
				driver.switchTo().window(eachwondow);
				
			}
			
		}
		
	}
	public void framebyindex(int index) {
		driver.switchTo().frame(index);

	}
	public void frameid(String id) {
		driver.switchTo().frame(id);

	}
	public static WebElement findlocatorsid(String name) {

		WebElement element = driver.findElement(By.id(name));

		return element; 

	}
	public static WebElement locatorsbyname(String name) {
		WebElement element = driver.findElement(By.name(name));
		
		return element;
	}
	
	
	public static  WebElement locatorsbyclassname(String classname) {
		WebElement element = driver.findElement(By.className(classname));
		
		return element;
		

	}
	public static WebElement locatorsxpath(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		
		
		return element;
		

	}
	public void sendkeysEnter(WebElement element,String data) {
		element.sendKeys(data,Keys.ENTER);

	}
	public static void takesscreenshot(String name) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d=new File("C:\\Users\\lakshman\\Desktop\\day1\\"+name+".png");
		FileUtils.copyFile(s, d);

	}
	public static void takesscreenshotelement(WebElement element,String name) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		File d=new File("C:\\Users\\lakshman\\Desktop\\day1\\"+name+".png");
		FileUtils.copyFile(s, d);


	}
	public List<WebElement> alloptiondropdown(WebElement element,String index) {
	Select select=new Select(element);
	List<WebElement> alloptions = select.getAllSelectedOptions();
	
	return alloptions;
		}
		
	public void dropdownasattribute(WebElement element,String attributevalue) {
		Select select=new Select(element);
		select.selectByValue(attributevalue);
		
		}
		
	public WebElement firstselectedoption(WebElement element) {
		Select select=new Select(element);
		WebElement txt = select.getFirstSelectedOption();
		
		return txt;
	}
	public void dropdownmultiselection(WebElement element) {
		Select select=new Select(element);
	
	
	}
	public static void implicitWait(int num) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));

	}
	
	public boolean isdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		
		return displayed;

	}
	public boolean  isenabled(WebElement element) {
		boolean enabled = element.isEnabled();
		
		
		return enabled;
		
	}
	public boolean isselected(WebElement element) {
	
		boolean selected = element.isSelected();
		
		return selected;
	}
	public void deselectbyindex(WebElement element) {
		Select select=new Select(element);
		select.deselectByIndex(0);
		
	}
	public void deselectbytext(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(" ");

	}
	public void deselectattribute(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(" ");
	}
	public void deselectall(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();

	}
	public String getparrentwindow() {

		String parrentwindowid = driver.getWindowHandle();
		
		return parrentwindowid;
	}
	public void allwindow() {
		Set<String> allwindow = driver.getWindowHandles();

	}
	public void mouseoveraction(WebElement element) {

		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	public void draganddrop(WebElement element) {

		Actions actions=new Actions(driver);
		WebElement f = driver.findElement(By.id(" "));
		WebElement d = driver.findElement(By.id(" "));
	
		actions.dragAndDrop(f, d).perform();
	
	}
	public void contextclick() {
		Actions actions=new Actions(driver);
		actions.contextClick().perform();

	}
	public void doubleclick() {
		Actions actions=new Actions(driver);
		actions.doubleClick().perform();
	}
	public void refresh() {
		driver.navigate().refresh();

	}
	public void forward() {
		driver.navigate().forward();

	}
	public void back() {
		driver.navigate().back();
	}
	public void cleartexttextbox(WebElement element) {
		element.clear();
	}
	public static String readdata(String Sheet1 ,int rownum,int cellnum) throws IOException {
		
		String res=null;
		File file=new File("C:\\Users\\lakshman\\eclipse-workspace\\Sample\\excel\\grocerydata.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet= workbook.getSheet(Sheet1);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
	
		switch (type) {
		case STRING:
			
			res = cell.getStringCellValue();
			
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date datecellvalue = cell.getDateCellValue();
				SimpleDateFormat dateformat=new SimpleDateFormat("dd/MMM/YYY");
				String format = dateformat.format(datecellvalue);
				
			}
			double numericcellvalue = cell.getNumericCellValue();
			long check = Math.round(numericcellvalue);
//			long l=(long) numericcellvalue;
			if (numericcellvalue==check) {
				res= String.valueOf(check);
			}
			else {
				res = String.valueOf(numericcellvalue);
				
				
			}
			

		default:
			break;
		}
		
		return res;
		
	}
	public static void writedataincell(String Sheet1 ,int rownum,int cellnum,String data) throws IOException {
		File file=new File("C:\\Users\\lakshman\\eclipse-workspace\\Sample\\excel\\grocerydata.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet= workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		CellType type = cell.getCellType();
		cell.setCellValue(data);
		
		FileOutputStream outputstream=new FileOutputStream(file);
		workbook.write(outputstream);
	

	}
	public void updatedataincell(String Sheet1 ,String rownum,String cellnum,String olddata,String newdata) throws IOException {
		File file=new File("C:\\Users\\lakshman\\eclipse-workspace\\Sample\\excel\\grocerydata.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet= workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		CellType type = cell.getCellType();
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		
		FileOutputStream outputstream=new FileOutputStream(file);
		workbook.write(outputstream);
	}
	
	
	
	
	
	
	
		
	

	}
	
	
	
	
	
	


