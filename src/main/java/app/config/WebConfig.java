package app.config;

import app.converter.CardDtoToCardConverter;
import app.converter.CardToCardDtoConverter;
import app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Autowired
    public WebConfig(TagRepository tagRepository, @Lazy ConversionService conversionService) {
        this.tagRepository = tagRepository;
        this.conversionService = conversionService;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(cardDto2cardConverter());
        registry.addConverter(card2cardDtoConverter());
    }


    @Bean
    public CardDtoToCardConverter cardDto2cardConverter() {
        return new CardDtoToCardConverter(tagRepository, conversionService);
    }

    @Bean
    public CardToCardDtoConverter card2cardDtoConverter() {
        return new CardToCardDtoConverter(conversionService);
    }
}
