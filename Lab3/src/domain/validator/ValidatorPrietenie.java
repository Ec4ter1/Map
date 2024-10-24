package domain.validator;

import domain.Prietenie;

public class ValidatorPrietenie implements Validator<Prietenie> {
    private static final ValidatorPrietenie instance=new ValidatorPrietenie();
    public static ValidatorPrietenie getInstance(){
        return instance;
    }
    private ValidatorPrietenie(){}

    @Override
    public void validate(Prietenie Obj) throws ValidationException {
        if(Obj.getUser1().getId().equals(Obj.getUser2().getId()))
            throw new ValidationException("FriendShip's user must have different ids");
    }

}
