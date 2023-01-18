package tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.impl;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.RequestWrapper;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.ResponseWrapper;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.impl.BaseController;
import tw.com.firstbank.fcbcore.fcbframework.core.application.in.CommandBus;
import tw.com.firstbank.fcbcore.fcbframework.core.application.util.ApLogHelper;
import tw.com.firstbank.fcbcore.fcbframework.core.spring.config.SensitiveApi;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.api.*;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.mapper.UserControllerMapper;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.user.api.*;


/**
 * The type User in v1.
 */
@AllArgsConstructor
@RestController
public class ReprintControllerImpl extends BaseController implements ReprintControllerApi {

	private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class);

	private static final UserControllerMapper mapper = Mappers.getMapper(
		UserControllerMapper.class);

	private final CommandBus commandBus;

	/**
	 * Gets user detail.
	 *
	 * @param requestWrapper the email
	 * @return the getUser json output with newCore format
	 */
	@Override
	@PostMapping("/get/v1")
	public ResponseEntity<ResponseWrapper<GetUserResponse>> getUser(
		RequestWrapper<GetUserRequest> requestWrapper) {
		GetUserResponseQuery output = commandBus.handle(requestWrapper.toCommand());
		return this.makeResponseEntity(output, mapper::toGetUserResponse);
	}

	/**
	 * Creates user information.
	 *
	 * @param requestWrapper the createUser json input with newCore format
	 * @return the createUser json output with newCore format
	 */
	@Override
	@SensitiveApi
	@PostMapping("/create/v1")
	public ResponseEntity<ResponseWrapper<CreateUserResponse>> createUser(
		RequestWrapper<CreateUserRequest> requestWrapper) {
		CreateUserResponseCommand responseCommand = commandBus.handle(requestWrapper.toCommand());
		return this.makeResponseEntity(responseCommand, mapper::toCreateUserResponse);
	}
}
