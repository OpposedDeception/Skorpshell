package com.skorpshell.app;

import com.skorpshell.app.R;
import android.content.Intent;
import com.skorpshell.app.Shell;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button button;
    private EditText commandEditText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        
        commandEditText = findViewById(R.id.editText_command);
        button = findViewById(R.id.button_execute);
        
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText commandEditText = findViewById(R.id.editText_command);
                String command = commandEditText.getText().toString();
                String result = executeShellCommand(command);
                showToast(result);
            }
        });
    }
    private String executeShellCommand(String command) {
        showToast("Shell command execution started!");
        String result = Shell.executeShellCommand(command);
        EditText commandEditText = findViewById(R.id.editText_command);
        commandEditText.setText("");
        return result;
    }
    
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
