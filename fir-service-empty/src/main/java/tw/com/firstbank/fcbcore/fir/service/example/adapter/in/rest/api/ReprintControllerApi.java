package tw.com.firstbank.fcbcore.fir.service.example.adapter.in.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.RequestWrapper;
import tw.com.firstbank.fcbcore.fcbframework.core.adapter.in.rest.api.ResponseWrapper;

import javax.validation.Valid;

/**
 * The interface User in v1.
 */
@RequestMapping("/na/fir/es/user")
@Validated
@Tag(name = "Reprint API", description = "提供補印功能")
public interface ReprintControllerApi {

	@Operation(summary = "取得User Summary資訊", description = "取得User Summary資訊")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "400", description = "Validation Fail", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))}),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))})})
	ResponseEntity<ResponseWrapper<SummaryUserResponse>> summaryUser(
		@Valid @RequestBody final RequestWrapper<SummaryUserRequest> requestWrapper);

	/**
	 * Gets api detail.
	 *
	 * @param requestWrapper the email
	 * @return the getUser json output with newCore format
	 */
	@Operation(summary = "取得User資訊", description = "取得User資訊")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "OK"),
		@ApiResponse(responseCode = "400", description = "Validation Fail", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))}),
		@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class))})})
	ResponseEntity<ResponseWrapper<PrintResponse>> getUser(
		@Valid @RequestBody final RequestWrapper<PrintRequest> requestWrapper);

}
