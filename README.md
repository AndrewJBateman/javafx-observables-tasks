# :zap: Java observables Tasks
 
* Java code to display list of employees when button pressed in FXML controller gridpane 
* **Note:** to open web links in a new window use: _ctrl+click on link_

![GitHub repo size](https://img.shields.io/github/repo-size/AndrewJBateman/javafx-observables-tasks?style=plastic)
![GitHub pull requests](https://img.shields.io/github/issues-pr/AndrewJBateman/javafx-observables-tasks?style=plastic)
![GitHub Repo stars](https://img.shields.io/github/stars/AndrewJBateman/javafx-observables-tasks?style=plastic)
![GitHub last commit](https://img.shields.io/github/last-commit/AndrewJBateman/javafx-observables-tasks?style=plastic)

## :page_facing_up: Table of contents

* [:zap: Angular Material Table](#zap-angular-material-table)
  * [:page_facing_up: Table of contents](#page_facing_up-table-of-contents)
  * [:books: General info](#books-general-info)
  * [:camera: Screenshots](#camera-screenshots)
  * [:signal_strength: Technologies](#signal_strength-technologies)
  * [:floppy_disk: Setup](#floppy_disk-setup)
  * [:computer: Code Examples](#computer-code-examples)
  * [:cool: Features](#cool-features)
  * [:clipboard: Status & To-Do List](#clipboard-status--to-do-list)
  * [:clap: Inspiration](#clap-inspiration)
  * [:envelope: Contact](#envelope-contact)

## :books: General info

* Code from Java Programming Masterclass Section 15-285 JavaFx background tasks in Java- see [:clap: Inspiration](#clap-inspiration) below
* Progress bar shown below list with text detail of data added using simple for loop
* Employee Service now separated
* Progress bar and Progress label binding to 

## :camera: Screenshots

N/A

## :signal_strength: Technologies

* [Java v11](https://www.java.com/en/)
* [JavaFX v11](https://www.jetbrains.com/help/idea/javafx.html#create-project) - now a Java Plugin
* [class Collections](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html) static methods that operate on or return collections.
* [interface ObservableList](https://docs.oracle.com/javase/10/docs/api/javafx/collections/ObservableList.html) - a list that allows you to track changes
* [JavaFX FXML](http://tutorials.jenkov.com/javafx/fxml.html) an XML format that enables you to compose JavaFX GUIs like web GUIs in HTML

## :floppy_disk: Setup

* Open folder in an IDE such as IntelliJ. Run  from `Main.java`

## :computer: Code Examples

* `Main.java` code to create a list observable then bind values to a FXML ListView

```java
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
```

## :cool: Features

* Progress label shows each name as it is added to the list then a 'list complete' message is displayed

## :clipboard: Status & To-Do List

* Status: Working
* To-Do: Nothing

## :clap: Inspiration

* [Udemy: Java Programming Masterclass for Software Developers](https://www.udemy.com/course/java-the-complete-java-developer-course/learn/lecture/3561816#overview)
* [SimpleTech TV: Fix JavaFX runtime components are missing and are required to run this application in IntelliJ IDEA](https://www.youtube.com/watch?v=pqbyQRACEgk)

## :file_folder: License

* N/A

## :envelope: Contact

* Repo created by [ABateman](https://www.andrewbateman.org), email: gomezbateman@yahoo.com
