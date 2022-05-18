package br.com.gerenciador.core.usecase.result;

public class UseCaseError {
    private final String message;
    private final Exception ex;

    public UseCaseError(String message, Exception ex) {
        this.message = message;
        this.ex = ex;
    }

    public String getMessage() {
        return message;
    }

    public Exception getEx() {
        return ex;
    }
}
