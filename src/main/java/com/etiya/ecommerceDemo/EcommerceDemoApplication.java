package com.etiya.ecommerceDemo;

import com.etiya.ecommerceDemo.core.exceptions.types.BusinessException;
import com.etiya.ecommerceDemo.core.utils.result.ErrorDataResult;
import com.etiya.ecommerceDemo.core.utils.result.ErrorResult;
import com.etiya.ecommerceDemo.core.utils.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class EcommerceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceDemoApplication.class, args);
    }
}
