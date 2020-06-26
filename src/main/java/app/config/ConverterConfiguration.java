package app.config;

import app.converter.CustomConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ConverterConfiguration {
    private final Set<Converter<?, ?>> converters;
    private final CustomConversionService conversionService;

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        converters.forEach(conversionService::addConverter);
    }
}
