package core.ics.utils;

import core.ics.exceptions.BusinessException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@SuperBuilder
public class ValidateParameter {

    private ValidateParameter(){}

    public static Long validate(String value){
        try {
            return Long.parseLong(value);
        }catch(NumberFormatException e){
            log.error("error {}", e.getMessage());
            throw new BusinessException(e.getMessage());
        }
    }
}
