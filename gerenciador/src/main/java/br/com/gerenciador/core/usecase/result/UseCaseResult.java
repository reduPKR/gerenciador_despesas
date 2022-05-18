package br.com.gerenciador.core.usecase.result;

public class UseCaseResult<T> {
    private final T result;
    private final UseCaseError error;

    public UseCaseResult(T result) {
        this.error = null;
        this.result = result;
    }

    public UseCaseResult(UseCaseError error) {
        this.result = null;
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public UseCaseError getError() {
        return error;
    }
}
