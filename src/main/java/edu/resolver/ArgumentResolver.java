package edu.resolver;

import edu.model.Argument;
import edu.model.ArgumentType;
import java.util.ArrayList;
import java.util.List;

public class ArgumentResolver {

    private int currentPosition;
    private ArgumentType currentArgument;

    public ArgumentResolver() {
        currentPosition = 0;
        currentArgument = ArgumentType.PATH;
    }

    public List<Argument> resolve(String[] args) {
        if (args.length < 2 || !args[0].equals(ArgumentType.PATH.getArgument())) {
            throw new IllegalArgumentException("Arguments should firstly contain --path parameter");
        }

        List<Argument> resolvedArgs = new ArrayList<>();
        resolvedArgs.add(new Argument(ArgumentType.PATH, resolvePath(args)));

        do {
            switch (currentArgument) {
                case FORMAT -> resolvedArgs.add(new Argument(ArgumentType.FORMAT, resolveArgument(args)));
                case TO -> resolvedArgs.add(new Argument(ArgumentType.TO, resolveArgument(args)));
                case FROM -> resolvedArgs.add(new Argument(ArgumentType.FROM, resolveArgument(args)));
                default -> {
                }
            }

            if (currentPosition + 1 <= args.length - 1) {
                if (isArgument(args[++currentPosition])) {
                    continue;
                } else {
                    break;
                }
            }
        } while (currentPosition != args.length - 1);

        return resolvedArgs;
    }

    private String resolvePath(String[] args) {
        StringBuilder allPaths = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            if (!isArgument(args[i])) {
                allPaths.append(args[i]).append(" ");
                continue;
            }
            currentPosition = i;
            break;
        }
        return allPaths.toString().trim();
    }

    private String resolveArgument(String[] args) {
        if (currentPosition + 1 >= args.length) {
            throw new IllegalArgumentException("Empty argument for ".formatted(currentArgument.getArgument()));
        }
        return args[++currentPosition];
    }

    private boolean isArgument(String arg) {
        try {
            currentArgument = ArgumentType.findByArgument(arg);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
