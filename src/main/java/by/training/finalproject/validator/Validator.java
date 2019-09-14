package by.training.finalproject.validator;

import javax.servlet.http.HttpServletRequest;

public interface Validator {
    boolean validate (HttpServletRequest request);
}
