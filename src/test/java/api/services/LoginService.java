package api.services;

import api.client.AuthSession;
import api.client.GraphQlClient;
import api.models.login.LoginResponse;
import api.models.login.LoginVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class LoginService {

    public static ApiResponse<LoginResponse> postLogin(
            String usernameOrEmail,
            String password,
            String companyId) {
        String query = TestDataLoader.load("graphql/mutations/Login.graphql");
        LoginVariables variables = new LoginVariables(usernameOrEmail, password, companyId);

        Response response = GraphQlClient.execute(query, variables);
        String sid = response.getCookie("sid_b2b");
        if (sid != null) {
            AuthSession.setSessionCookie(sid);
        }

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(LoginResponse.class));
    }
}