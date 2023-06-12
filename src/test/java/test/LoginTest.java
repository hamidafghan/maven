package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pos.LoginFormPO;
import pos.LoginSuccessPO;

public class LoginTest extends DriverLifecycleSetting {
	// commnet to push
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;

	@Test
	public void testLoginOK() {
		login = new LoginFormPO(driver);
		login.with("user", "user");

		// it should redirect to success page
		loginSuccess = new LoginSuccessPO(driver);
		assertTrue(loginSuccess.successBoxIsPresent());
	}

	@Test
	public void testWithInvalidDetails() {
		login = new LoginFormPO(driver);
		login.with("user", "wrong");
		assertTrue(login.invalidBoxIsPresent());
	}
}
