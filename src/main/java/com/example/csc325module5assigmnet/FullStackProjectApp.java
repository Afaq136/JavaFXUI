package com.example.csc325module5assigmnet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FullStackProjectApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-background-color: #8b2b13;");  // Brown color
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> primaryStage.close());
        fileMenu.getItems().add(exitMenuItem);

        Menu editMenu = new Menu("Edit");
        Menu themeMenu = new Menu("Theme");
        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(e -> showAlert(Alert.AlertType.INFORMATION, "About", "Full Stack Project\nVersion 1.0"));
        helpMenu.getItems().add(aboutMenuItem);

        menuBar.getMenus().addAll(fileMenu, editMenu, themeMenu, helpMenu);

        // Create TableView
        TableView<String> tableView = new TableView<>();
        tableView.setPlaceholder(new Label("No content in table"));

        TableColumn<String, String> idColumn = new TableColumn<>("ID");
        TableColumn<String, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<String, String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<String, String> departmentColumn = new TableColumn<>("Department");
        TableColumn<String, String> majorColumn = new TableColumn<>("Major");
        TableColumn<String, String> emailColumn = new TableColumn<>("Email");

        tableView.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, departmentColumn, majorColumn, emailColumn);

        // Create VBox for input fields and buttons
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #7BBF6A;");  // Lime green color

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");
        TextField departmentField = new TextField();
        departmentField.setPromptText("Department");
        TextField majorField = new TextField();
        majorField.setPromptText("Major");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField imageURLField = new TextField();
        imageURLField.setPromptText("imageURL");

        Button clearButton = new Button("Clear");
        clearButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");  // Brown color with white text
        clearButton.setOnAction(e -> clearForm(lastNameField, departmentField, majorField, emailField, imageURLField));

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");  // Brown color with white text
        addButton.setOnAction(e -> addData(tableView, lastNameField, departmentField, majorField, emailField, imageURLField));

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");  // Brown color with white text
        deleteButton.setOnAction(e -> deleteData(tableView));

        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");  // Brown color with white text
        editButton.setOnAction(e -> editData(tableView, lastNameField, departmentField, majorField, emailField, imageURLField));

        vbox.getChildren().addAll(lastNameField, departmentField, majorField, emailField, imageURLField, clearButton, addButton, deleteButton, editButton);

        // Create ImageView for profile picture from local file
        ImageView imageView = new ImageView();
        try {
            String imagePath = getClass().getResource("/profile_picture.png").toExternalForm();
            if (imagePath != null) {
                imageView.setImage(new Image(imagePath));
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                System.out.println("Image loaded successfully.");
            } else {
                System.err.println("Image path is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to load image.");
        }

        // Create a VBox to hold the ImageView and set the background color to brown
        VBox imageContainer = new VBox();
        imageContainer.setStyle("-fx-background-color: #8B4513;"); // Brown color
        imageContainer.setPadding(new Insets(10));
        imageContainer.getChildren().add(imageView);

        // Create BorderPane and set the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(tableView);
        borderPane.setRight(vbox);
        borderPane.setLeft(imageContainer);  // Set the imageContainer to the left

        Scene scene = new Scene(borderPane, 800, 600);
        String css = getClass().getResource("/style.css").toExternalForm();
        if (css != null) {
            scene.getStylesheets().add(css);
        } else {
            System.err.println("CSS file not found.");
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("FSC CSC325 - Full Stack Project");
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm(TextField... textFields) {
        for (TextField textField : textFields) {
            textField.clear();
        }
    }

    private void addData(TableView<String> tableView, TextField... textFields) {
        // Add data to the table
        // This is a placeholder logic
        // You need to implement actual data addition logic here
        showAlert(Alert.AlertType.INFORMATION, "Add", "Data added successfully!");
    }

    private void deleteData(TableView<String> tableView) {
        // Delete selected data from the table
        // This is a placeholder logic
        // You need to implement actual data deletion logic here
        showAlert(Alert.AlertType.INFORMATION, "Delete", "Data deleted successfully!");
    }

    private void editData(TableView<String> tableView, TextField... textFields) {
        // Edit selected data in the table
        // This is a placeholder logic
        // You need to implement actual data editing logic here
        showAlert(Alert.AlertType.INFORMATION, "Edit", "Data edited successfully!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
