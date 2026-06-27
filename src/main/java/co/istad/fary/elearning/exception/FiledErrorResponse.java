package co.istad.fary.elearning.exception;

public record FiledErrorResponse(
        String filed,
        String reason
) {
}
