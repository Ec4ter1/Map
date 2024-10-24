package domain.validator;

public interface Validator<T> {
    void validate(T Obj) throws ValidationException;
}
