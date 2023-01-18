package tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;
import lombok.ToString;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Get api json output.
 */
@ToString
@Setter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class GetReFundResponse implements ResponseBody {

	/**
	 * The api List.
	 */
	@JsonProperty(value = "list")
	List<UserDTO> list = new ArrayList<>();


	@ToString
	@Setter
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

	public static class UserDTO {

		@Schema(description = "UUID", example = "0136a826-82a4-493c-b0f2-de51b68ee4e4")
		@JsonProperty(value = "uuid")
		//@JsonInclude(JsonInclude.Include.NON_NULL)
		private String uuid;
		@Schema(description = "聯絡信箱", example = "test@mail.com")
		@JsonProperty(value = "contactEmail")
		private String contact;
		@Schema(description = "姓氏", example = "lee")
		@JsonProperty(value = "firstName")
		private String firstName;
		@Schema(description = "名字", example = "andy")
		@JsonProperty(value = "lastName")
		private String lastName;
		@Schema(description = "使用者狀態", example = "1")
		@JsonProperty(value = "status")
		private String status;

		@Schema(description = "使用者聯絡資訊")
		@JsonProperty(value = "list")
		private List<UserInfoDTO> list;

	}

	@ToString
	@Setter
	public static class UserInfoDTO {

		@Schema(description = "電話")
		@JsonProperty(value = "phone")
		private String tel;

	}
}