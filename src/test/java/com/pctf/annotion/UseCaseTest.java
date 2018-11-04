package com.pctf.annotion;

import com.pctf.annotation.UseCase;
import com.pctf.entity.Person;
import org.junit.Test;

public class UseCaseTest {

    @Test
    public void useCaseTest() {
        Class<Person> personClass = Person.class;
        UseCase useCase = personClass.getAnnotation(UseCase.class);
        System.out.println(useCase.id() + useCase.description());

    }

}
