package api.config;

public class CredentialsConfig {
    public static final String EMAIL = EnvConfig.EMAIL;
    public static final String PASSWORD = EnvConfig.PASSWORD;
    public static final String COMPANY_ID = EnvConfig.COMPANY_ID;

  static {
    if (EMAIL.isBlank() || PASSWORD.isBlank() || COMPANY_ID.isBlank()) {
      throw new IllegalStateException("Missing auth env vars");
    }
  }
}
