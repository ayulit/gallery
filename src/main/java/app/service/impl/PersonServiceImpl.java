package app.service.impl;

import app.dto.PersonDto;
import app.entity.Person;
import app.exception.PersonException;
import app.repository.PersonRepository;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ConversionService conversionService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ConversionService conversionService) {
        this.personRepository = personRepository;
        this.conversionService = conversionService;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonException("Person not found."));
        return conversionService.convert(person, PersonDto.class);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        return conversionService.convert(personRepository.save(person), PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).orElseThrow(()->new PersonException("Person not found."));

        person.setEmail(personDto.getEmail());
        person.setUserName(personDto.getUserName());

        return conversionService.convert(personRepository.save(person), PersonDto.class);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(()->new PersonException("Person not found."));
        personRepository.delete(person);
    }
}
