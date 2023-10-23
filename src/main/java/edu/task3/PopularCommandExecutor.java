package edu.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {

        if (maxAttempts < 1) {
            throw new IllegalArgumentException("Max attempts should be more than 0");
        }
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        int currentAttempt = 0;

        while (currentAttempt < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (ConnectionException ex) {
                currentAttempt++;
                if (currentAttempt >= maxAttempts) {
                    throw new ConnectionException(ex);
                }
            } catch (Exception exception) {
            throw new ConnectionException(exception);
            }
        }
    }
}
