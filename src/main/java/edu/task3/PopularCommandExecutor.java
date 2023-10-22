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
        Connection connection = null;
        int currentAttempt = 0;

        while (currentAttempt < maxAttempts) {
            try {
                connection = manager.getConnection();
                connection.execute(command);
                return;
            } catch (Exception ex) {
                currentAttempt++;
                if (currentAttempt >= maxAttempts && ex instanceof ConnectionException) {
                    throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts", ex);
                }
            }
        }
    }
}
