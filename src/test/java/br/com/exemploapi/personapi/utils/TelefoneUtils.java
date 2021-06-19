package br.com.exemploapi.personapi.utils;

import br.com.exemploapi.personapi.dto.request.TelefoneDTO;
import br.com.exemploapi.personapi.entity.Telefone;
import br.com.exemploapi.personapi.enums.TipoTelefone;

public class TelefoneUtils {

    private static final String TEL_NUMERO = "1188888-9999";
    private static final TipoTelefone TEL_TIPO = TipoTelefone.CELULAR;
    private static final long TEL_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(TEL_NUMERO)
                .tipoTelefone(TEL_TIPO)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(TEL_ID)
                .numero(TEL_NUMERO)
                .tipoTelefone(TEL_TIPO)
                .build();
    }
}
