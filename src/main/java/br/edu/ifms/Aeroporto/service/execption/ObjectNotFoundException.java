package br.edu.ifms.Aeroporto.service.execption;

public class ObjectNotFoundException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(msg, cause);
	}
	
}
