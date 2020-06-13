package app.converter;

import app.dto.PersonDto;
import app.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {
    @Override
    public Person convert(PersonDto personDto) {
        Person person = new Person();
        person.setEmail(personDto.getEmail());
        person.setUsername(personDto.getUsername());
        return person;
    }
}
