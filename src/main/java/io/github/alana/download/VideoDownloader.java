package io.github.alana.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VideoDownloader {

    public void downloadAndConvertToMP3(String videoUrl) {
        String command = "yt-dlp -f bestaudio --extract-audio --audio-format mp3 --audio-quality 0 " 
        + videoUrl;

        try {
            Process process = Runtime.getRuntime().exec(command);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Download and conversion to MP3 completed successfully!");
            } else {
                System.out.println("Error downloading and converting video.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }
}
