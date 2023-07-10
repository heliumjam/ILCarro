package tests;

import manager.TestNgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)

public class LoginTests extends TestBase {
@BeforeMethod
public void precondition(){
    System.out.println("lkjdfajlskdjf");
    if(app.getHelperUser().isLogged())
        app.getHelperUser().logout();
}

    @Test
    public void loginPositiveUser() {
//        User user = new User("domes7@mail.com","123456Aa$");
//        user.setName("domes7@mail.com");
//        user.setPassword("123456Aa$");
        User user = new User()
                .withEmail("domes7@mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLoggedSuccess());
    }


    @Test
    public void loginNegativeWrongEmail() {
        User user = new User()
                .withEmail("domesmail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoggedFailure());
    }
    @Test
    public void loginNegativeWrongEmail2() {
        User user = new User()
                .withEmail("domes@mail.com")
                .withPassword("123456Aa$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoggedFailure());
    }
@AfterMethod
public void postcondition(){
    if(app.getHelperUser().isLoggedSuccess() == true
    || app.getHelperUser().isLoggedFailure() == true);
    {
    app.getHelperUser().clickOkButton();
    }
}
}
