package app.service.impl;

import app.dto.PersonDto;
import app.entity.Person;
import app.exception.PersonException;
import app.mapper.PersonMapper;
import app.repository.PersonRepository;
import app.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonException("Person not found."));
        return personMapper.personToPersonDto(person);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);
        return personMapper.personToPersonDto(personRepository.save(person));
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).orElseThrow(()->new PersonException("Person not found."));

        person.setEmail(personDto.getEmail());
        person.setUserName(personDto.getUserName());

        return personMapper.personToPersonDto(personRepository.save(person));
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(()->new PersonException("Person not found."));
        personRepository.delete(person);
    }
}
