package by.training.finalproject.validator;

public class ValidatorFactory {
    private static ValidatorFactory instance = null;
    private final SignUpValidator signUpValidator = new SignUpValidator();
    private final SignInValidator signInValidator = new SignInValidator();

    private ValidatorFactory(){}

    public static ValidatorFactory getInstance() {
        if (instance == null) {
            instance = new ValidatorFactory();
        }
        return instance;
    }

    public SignUpValidator getSignUpValidator() {
        return signUpValidator;
    }

    public SignInValidator getSignInValidator() {
        return signInValidator;
    }
}
