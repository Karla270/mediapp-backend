package com.mitocode.config;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Anotación encargada de definir que la clase es una clase de configuración para el framework
public class MapperConfig {

	@Bean //Los Beans son objetos que maneja el contendor de spring
	public ModelMapper modelMapper() {
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
		return mapper;
	}
}
