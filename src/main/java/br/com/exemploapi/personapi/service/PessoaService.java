package br.com.exemploapi.personapi.service;

import br.com.exemploapi.personapi.dto.request.PessoaDTO;
import br.com.exemploapi.personapi.dto.response.MessageResponseDTO;
import br.com.exemploapi.personapi.entity.Pessoa;
import br.com.exemploapi.personapi.exception.PessoaNotFoundException;
import br.com.exemploapi.personapi.mapper.PessoaMapper;
import br.com.exemploapi.personapi.repository.PessoaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_=@Autowired)
public class PessoaService {

    private PessoaRepositorio pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    public MessageResponseDTO createPerson(PessoaDTO personDTO) {
        Pessoa personToSave = pessoaMapper.toModel(personDTO);

        Pessoa savedPerson = pessoaRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Criado com ID ");
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> allPeople = pessoaRepository.findAll();
        return allPeople.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa person = verifyIfExists(id);

        return pessoaMapper.toDTO(person);
    }

    public void delete(Long id) throws PessoaNotFoundException {
        verifyIfExists(id);
        pessoaRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PessoaDTO personDTO) throws PessoaNotFoundException {
        verifyIfExists(id);

        Pessoa personToUpdate = pessoaMapper.toModel(personDTO);

        Pessoa updatedPerson = pessoaRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Atualizado com ID ");
    }

    private Pessoa verifyIfExists(Long id) throws PessoaNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
