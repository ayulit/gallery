package app.converter;

import app.dto.PersonDto;
import app.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter implements Converter<Person, PersonDto> {
    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setEmail(person.getEmail());
        personDto.setUsername(person.getUsername());
        return personDto;
    }
}
