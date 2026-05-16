package api.tests;

import api.config.CredentialsConfig;
import api.services.LoginService;
import api.models.login.LoginResponse;
import api.utils.ApiResponse;
import api.client.AuthSession;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public abstract class BaseAuthenticatedTest {

    @BeforeSuite(alwaysRun = true)
    public void authenticate() {
        ApiResponse<LoginResponse> loginResponse = LoginService.postLogin(
                CredentialsConfig.EMAIL,
                CredentialsConfig.PASSWORD,
                CredentialsConfig.COMPANY_ID
        );

        Assert.assertNotNull(AuthSession.getSessionCookie(),
                "Login gagal: session cookie null!");
    }
}