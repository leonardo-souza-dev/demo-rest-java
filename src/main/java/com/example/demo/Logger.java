package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Logger implements ILogger {
    @Override
    public void gravar(String mensagem) throws Exception {
        String foo = "bar";
    }
}