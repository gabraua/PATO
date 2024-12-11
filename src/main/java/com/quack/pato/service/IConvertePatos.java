package com.quack.pato.service;

import java.util.List;

public interface IConvertePatos {
    <T> T obterDados (String json, Class<T> classe);
    
    <T> List<T> obterLista (String json, Class<T> classe);
    
}
