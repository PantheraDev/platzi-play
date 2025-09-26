package com.platzi.platzi_play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayIAService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestión de Películas {{platform}}. Usa menos de 120 caracteres y hazlo con el estilo de platzi.
            """)
    String generateGreeting(@V("platform") String platform);
}