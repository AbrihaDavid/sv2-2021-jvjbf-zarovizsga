package videos;

public class Channel {

    private String channelName;
    private int subscription;
    private int numberOfVideos;

    public Channel(String channel, int subscription, int numberOfVideos) {
        this.channelName = channel;
        this.subscription = subscription;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getSubscription() {
        return subscription;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
