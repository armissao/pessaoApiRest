package br.com.exemploapi.personapi.utils;

import br.com.exemploapi.personapi.dto.request.PessoaDTO;
import br.com.exemploapi.personapi.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String NOME = "Pedro";
    private static final String SOBRE_NOME = "Pedreira";
    private static final String CPF = "042.401.190-57";
    private static final long PESSOA_ID = 1L;
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(2010, 10, 1);

    public static PessoaDTO createFakeDTO() {

        return PessoaDTO.builder()
                .nome(NOME)
                .sobreNome(SOBRE_NOME)
                .cpf(CPF)
                .dataNascimento("04-04-2010")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nome(NOME)
                .sobreNome(SOBRE_NOME)
                .cpf(CPF)
                .dataNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }
}
