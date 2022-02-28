package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public void addChannel(Channel channel){
        channels.add(channel);
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path){
        try(BufferedReader br = Files.newBufferedReader(path)){
            br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                String []temp = line.split(";");
                channels.add(new Channel(temp[0],Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
            }

        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot open file for read!",ioe);
        }
    }

    public int calculateSumOfVideos(){
        return channels.stream()
                .map(Channel::getNumberOfVideos)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
