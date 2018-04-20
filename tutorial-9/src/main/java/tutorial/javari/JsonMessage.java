package tutorial.javari;

/**
 * Represent Json Message.
 */
public class JsonMessage {
    private final String msgType;
    private final String message;

    private JsonMessage(String msgType, String message) {
        this.msgType = msgType;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMsgType() {
        return msgType;
    }

    public static JsonMessage getNotFoundMessage(int id) {
        return new JsonMessage("warning",
                "There is no animal with this id " + id + " !");
    }

    public static JsonMessage getDatabaseEmptyMessage() {
        return new JsonMessage("warning",
                "There is no animal in our records!");
    }

    public static JsonMessage getSuccessDeleteMessage() {
        return new JsonMessage("success",
                "The animal has been deleted!");
    }

    public static JsonMessage getSuccessAddMessage() {
        return new JsonMessage("success",
                "The animal has been added!");
    }

}
