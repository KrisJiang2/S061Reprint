package tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mapstruct.factory.Mappers;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.RequestBody;
import tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.mapper.UserControllerMapper;
import tw.com.firstbank.fcbcore.fir.service.example.application.in.user.api.GetUserRequestQuery;

import javax.validation.constraints.NotBlank;

/**
 * The type Get api json input.
 */
@Getter
@Setter
@ToString
public class PrintRequest implements RequestBody {

	private static final UserControllerMapper mapper = Mappers.getMapper(
		UserControllerMapper.class);

	@NotBlank
	@JsonProperty("email")
	@Schema(description = "聯絡信箱", example = "example@email.com")
	@NotBlank(message = "email 不得空白")
	private String contactEmail;

	/**
	 * Converts getUser json input from adapter to usecase.
	 *
	 * @return the getUser input
	 */
	@Override
	public GetUserRequestQuery toCommand() {
		return mapper.convertToGetUserRequestQuery(this);
	}
}
