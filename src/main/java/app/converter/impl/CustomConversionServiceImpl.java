package app.converter.impl;

import app.converter.CustomConversionService;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomConversionServiceImpl extends GenericConversionService implements CustomConversionService {
}
