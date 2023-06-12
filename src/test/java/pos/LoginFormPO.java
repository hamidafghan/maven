package pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO extends BasePagePO {

	private By username = By.id("username");
	private By password = By.id("password");
	private By submit = By.cssSelector("button");
	private By invalidBox = By.id("invalid");
	private String loginUrl = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";

	public LoginFormPO(WebDriver driver) {
		super(driver);
		visit(loginUrl);
	}

	public BasePagePO with(String username, String password) {
		type(this.username, username);
		type(this.password, password);
		click(this.submit);

		if (getUrl().equals(this.loginUrl)) {
			return this;
		} else {
			return new LoginSuccessPO(driver);
		}
	}

	public boolean invalidBoxIsPresent() {
		return isIn(this.invalidBox);
	}
}
