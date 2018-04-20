package tutorial.javari;

/**
 * Represent Json Message.
 */
public class JsonMessage {
    private final String messageType;
    private final String messageContent;

    private JsonMessage(String messageType, String messageContent) {
        this.messageType = messageType;
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getMessageType() {
        return messageType;
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
