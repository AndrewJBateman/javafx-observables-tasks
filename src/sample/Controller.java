package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

// Create a list observable then bind values to a FXML ListView
// Progress bar with text detail of data added
public class Controller {

    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {

                String[] names = {"Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                for(int i=0; i<6; i++) {
                    employees.add(names[i]);
                    updateMessage(names[i] + " added to the list");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                    updateMessage("list complete");
                }
                return employees;

            }
        };

        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        listView.itemsProperty().bind(task.valueProperty());
    }

    @FXML
    public void buttonPressed() {
        new Thread(task).start();
    }
}
