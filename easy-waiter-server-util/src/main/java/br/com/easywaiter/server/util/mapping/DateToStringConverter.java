package br.com.easywaiter.server.util.mapping;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.easywaiter.server.util.modelMapper.ConverterConfigurerSupport;

public class DateToStringConverter extends ConverterConfigurerSupport<Date, String> {

	@Override
	public Converter<Date, String> converter() {

		return new Converter<Date, String>() {

			@Override
			public String convert(MappingContext<Date, String> context) {

				if (context.getSource() != null) {

					try {

						Class<?> classePai = context.getMapping().getDestinationProperties().get(0).getInitialType();

						Field field = classePai
								.getDeclaredField(context.getMapping().getDestinationProperties().get(0).getName());

						if (field != null && field.isAnnotationPresent(JsonFormat.class)) {

							JsonFormat format = field.getAnnotation(JsonFormat.class);

							return new SimpleDateFormat(format.pattern()).format(context.getSource());
						}

						return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(context.getSource());

					} catch (Exception e) {
						return new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(context.getSource());
					}

				}
				return null;
			}

		};
	}

}
