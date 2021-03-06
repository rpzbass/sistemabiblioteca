package mjv.devschool.sistemalivaria.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mjv.devschool.sistemalivaria.service.exceptions.AccessComunicationError;
import mjv.devschool.sistemalivaria.service.exceptions.DatabaseException;
import mjv.devschool.sistemalivaria.service.exceptions.EntityNotFoundExceptio;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFoundExceptio.class) //Informa ao manipular qual classe entregar responsavel pelo erro 
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundExceptio e, HttpServletRequest request){
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso não encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(DatabaseException.class) //Informa ao manipular qual classe entregar responsavel pelo erro 
	public ResponseEntity<StandardError> dbException(DatabaseException e, HttpServletRequest request){
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Data violation");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
		
	}
	
	@ExceptionHandler(AccessComunicationError.class) //Informa ao manipular qual classe entregar responsavel pelo erro 
	public ResponseEntity<StandardError> dbException(AccessComunicationError e, HttpServletRequest request){
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Failed comunication API");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
	
	
	
	
	
	
}
