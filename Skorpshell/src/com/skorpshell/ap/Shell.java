package com.skorpshell.app;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {
    public static String executeShellCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec("sh");
            DataOutputStream outputStream = new DataOutputStream(process.getOutputStream());
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            outputStream.writeBytes(command + "\n");
            outputStream.writeBytes("exit\n");
            outputStream.flush();

            String line;
            StringBuilder output = new StringBuilder();
            while ((line = inputStream.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();
            outputStream.close();
            inputStream.close();
            
            return output.toString();
            
        } catch (IOException | InterruptedException e) {
            return e.toString();
        }
    }
}
