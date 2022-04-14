@echo off
set path_to_fx="C:\Program Files\Java\javafx-sdk-18\lib"
javac --module-path %path_to_fx% --add-modules javafx.controls,javafx.fxml,javafx.graphics %1.java
java --module-path %path_to_fx% --add-modules javafx.controls,javafx.fxml,javafx.graphics %1.java
pause