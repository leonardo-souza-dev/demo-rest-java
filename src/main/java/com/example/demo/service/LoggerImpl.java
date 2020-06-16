package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoggerImpl implements Logger {
    @Override
    public void gravar(String mensagem) throws Exception {
        String foo = "bar";
    }
}
