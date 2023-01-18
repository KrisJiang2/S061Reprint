package tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.api.*;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.out.repository.user.api.custom.UserSummaryCustomData;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.user.api.*;
import tw.com.firstbank.fcbcore.fir.service.example.domain.user.User;
import tw.com.firstbank.fcbcore.fir.service.example.domain.user.type.UserStatus;
import tw.com.firstbank.fcbcore.fir.service.example.domain.user.vo.Name;

/**
 * The interface Create api mapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReprintControllerMapper {

	CreateUserRequestCommand toCreateUserRequestCommand(CreateUserRequest source);

	ExpireUserRequestCommand toExpireUserRequestCommand(ExpireUserRequest source);

	GetUserRequestQuery convertToGetUserRequestQuery(GetUserRequest source);

	UpdateUserRequestCommand toUpdateUserRequestCommand(UpdateUserRequest source);

	CountFeeRequestCommand toCountFeeRequestCommand(CountFeeRequest source);

	CreateUserResponse toCreateUserResponse(CreateUserResponseCommand source);

	@Mapping(source = "users", target = "list")
	ExpireUserResponse toExpireUserResponse(ExpireUserResponseCommand source);

	@Mapping(source = "id", target = "targetId")
	ExpireUserResponse.UserDTO toExpireUserDTO(User source);

	UpdateUserResponse toUpdateUserResponse(UpdateUserResponseCommand source);

	CountFeeResponse toCountFeeResponse(CountFeeResponseCommand source);

	@Mapping(source = "users", target = "list")
	GetUserResponse toGetUserResponse(GetUserResponseQuery source);

	@Mapping(source = "name", target = "firstName", qualifiedByName = "firstName")
	@Mapping(source = "name", target = "lastName", qualifiedByName = "lastName")
	@Mapping(source = "contactEmail", target = "contact")
	@Mapping(source = "userInfoList", target = "list")
	GetUserResponse.UserDTO toUserDTO(User source);

	@Mapping(source = "summaries", target = "list")
	SummaryUserResponse toSummaryUserResponse(SummaryUserResponseQuery source);

	SummaryUserResponse.UserSummaryDTO toUserDTO(UserSummaryCustomData source);

	@Mapping(source = "userStatus", target = "status", qualifiedByName = "userStatus")
	SummaryUserRequestQuery toSummaryUserRequestQuery(SummaryUserRequest source);

	@Named("userStatus")
	default UserStatus toUserStatus(int value) {
		return UserStatus.fromValue(value);
	}

	@Named("firstName")
	default String toFirstName(Name name) {
		return name.getFirstName();
	}

	@Named("lastName")
	default String toLastName(Name name) {
		return name.getLastName();
	}

}
