package app.service;

import app.dto.PersonDto;

public interface PersonService {
    PersonDto getPersonById(Long id);
    PersonDto createPerson(PersonDto personDto);
    PersonDto updatePerson(PersonDto personDto);
    void deletePerson(Long id);
}
