package com.autotest.api.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationsBase {

    public void comparaStatusCodeRetornado(int codeEsperado, int resposta) {
        assertEquals(codeEsperado, resposta);
    }
}