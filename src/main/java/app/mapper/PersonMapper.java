package app.mapper;

import app.dto.PersonDto;
import app.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(target = "email", source = "email")
    @Mapping(target = "userName", source = "userName")
    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);
}
