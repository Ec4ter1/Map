package domain.validator;

import domain.Utilizator;

public class ValidatorUtilizator implements Validator<Utilizator> {
    private static final ValidatorUtilizator instance=new ValidatorUtilizator();
    public static ValidatorUtilizator getInstance(){
        return instance;
    }
    private ValidatorUtilizator(){}
    @Override
    public void validate(Utilizator Obj) throws ValidationException {
        String errors="";
        if(Obj.getFirstName() == null || Obj.getLastName()==null || Obj.getEmail()==null){
            errors="First Name and Last Name are required";
        }
        if (Obj.getLastName().length()<3)
            errors+="Last name is too short!\n";
        if (Obj.getFirstName().length()<3)
            errors+="First name is too short!\n";
        if (!Obj.getEmail().matches(".{2,}[@].{2,}[.].{2,}"))
            errors+="Email is invalid!\n";

        if (!errors.isEmpty())
            throw new ValidationException(errors);
    }
}
