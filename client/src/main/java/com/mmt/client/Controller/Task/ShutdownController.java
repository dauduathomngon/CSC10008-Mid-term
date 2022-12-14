package com.mmt.client.Controller.Task;

import com.mmt.client.Model.ClientModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.SplittableRandom;

public class ShutdownController implements Initializable {
    @FXML
    private TextField timeShutdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void shutDown(ActionEvent actionEvent) throws IOException {
        sendMsg("Shut Down");
    }

    @FXML
    private void onRestart(ActionEvent actionEvent) throws IOException {
        sendMsg("Restart");
    }

    @FXML
    private void logOff(ActionEvent actionEvent) throws IOException {
        sendMsg("Log Off");
    }

    private void sendMsg(String msg) throws IOException {
        String time = timeShutdown.getText().isEmpty() ? String.valueOf(0) : timeShutdown.getText();

        ClientModel.getOutput().writeUTF(msg);
        ClientModel.getOutput().writeUTF(time);
        ClientModel.getOutput().flush();
    }

}
