package io.github.alana.download;

public class YouTubeDownloader {

    public static void main(String[] args) {
        String videoUrl = "https://www.youtube.com/watch?v=k6EQAOmJrbw";

        VideoDownloader downloader = new VideoDownloader();
        
        downloader.downloadAndConvertToMP3(videoUrl);
    }
}
