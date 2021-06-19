package br.com.exemploapi.personapi.service;

import br.com.exemploapi.personapi.dto.request.PessoaDTO;
import br.com.exemploapi.personapi.dto.response.MessageResponseDTO;
import br.com.exemploapi.personapi.entity.Pessoa;
import br.com.exemploapi.personapi.repository.PessoaRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.exemploapi.personapi.utils.PessoaUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessaoServiceTest {

    @Mock
    private PessoaRepositorio personRepository;

    @InjectMocks
    private PessoaService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PessoaDTO personDTO = createFakeDTO();
        Pessoa expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
