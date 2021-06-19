package br.com.exemploapi.personapi.controller;

import br.com.exemploapi.personapi.dto.request.PessoaDTO;
import br.com.exemploapi.personapi.dto.response.MessageResponseDTO;
import br.com.exemploapi.personapi.exception.PessoaNotFoundException;
import br.com.exemploapi.personapi.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor(onConstructor_=@Autowired)
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.createPerson(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listAll() {
        return pessoaService.listAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable Long id) throws PessoaNotFoundException {
        return pessoaService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PessoaDTO personDTO) throws PessoaNotFoundException {
        return pessoaService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.delete(id);
    }
}
