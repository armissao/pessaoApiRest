package br.com.exemploapi.personapi.dto.request;

import br.com.exemploapi.personapi.enums.TipoTelefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;
    @NotEmpty
    @Size(min = 13, max = 14)
    private String numero;
}
