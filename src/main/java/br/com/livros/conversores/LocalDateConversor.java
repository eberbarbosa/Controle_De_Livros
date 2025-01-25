package br.com.livros.conversores;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConversor implements AttributeConverter<LocalDate, Date> {
	
	@Override
	public Date convertToDatabaseColumn(LocalDate dataDaEntidade) {
		
		return(dataDaEntidade == null) ? null : Date.valueOf(dataDaEntidade);
		
	}
	
	public LocalDate convertToEntityAttribute(Date dataDoBancoDeDados) {
		
		return(dataDoBancoDeDados == null) ? null: dataDoBancoDeDados.toLocalDate();
	}

}
