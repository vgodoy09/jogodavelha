package com.jogadavelha.exception;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException {
	private static final long serialVersionUID = -4052880149437789855L;

	public enum ResponseCode {
		/*200*/
		OK(200, 0), 
		CREATED(201, 0), 
		/*300*/
		
		/*400*/
		BAD_REQUEST(400, 0), 
		
		/*401 Attendant*/
		UNAUTHORIZED(401,0),
		UNAUTHORIZED_ATTENDANT(401, 1),
		
		FORBIDDEN(403,0),
		
		NOT_FOUND(404, 0), 
		NOT_ACCEPTABLE(406, 0),
		
		USER_WIN(200, 100),
		
		/*500*/
		INTERNAL_SERVER_ERROR(500, 0), 
		NOT_IMPLEMENTED(501, 0),  
		
		BAD_DONATION_BETTER_DAY_SERVER(500, 305), 
		
		;private Integer httpStatus;
		private Integer internalCode;
		
		private ResponseCode(Integer httpStatus, Integer internalCode) {
			this.httpStatus = httpStatus;
			this.internalCode = internalCode;
		}
		
		public Integer getHttpStatus() {
			return this.httpStatus;
		}
		
		public Integer getInternalCode() {
			return this.internalCode;
		}
	}
	
	public Integer httpStatusValue;
	public Integer code;
	
	public ResourceException(ResponseCode responseCode, String message) {
		super(message);
		this.httpStatusValue = responseCode.getHttpStatus();
		this.code = responseCode.getInternalCode();
	}
	
	public ResourceException(HttpStatus httpStatus, Integer code, String message) {
		super(message);
		this.httpStatusValue = httpStatus.value();
		this.code = code;
	}

	public Integer getHttpStatusValue() {
		return httpStatusValue;
	}
	public Integer getCode() {
		return code;
	}

}
